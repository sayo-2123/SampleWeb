package com.example.demo.service;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constant.AuthorityKind;
import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面 Service
 */
@Service
@RequiredArgsConstructor
public class SignupService {
	/** ユーザー情報テーブルDAO */
	private final UserInfoRepository repository;

	/** Dozer Mapper*/
	private final Mapper mapper;

	/** PasswordEncoder*/
	private final PasswordEncoder passwordEncoder;

	/**
	 * ユーザー検索テーブル 新規登録
	 * 
	 * @param 入力情報
	 * @return (ユーザー情報Entity)、すでに同じユーザIDで登録がある場合はEmpty
	 */
	public Optional<UserInfo> resistUserInfo(SignupForm form) {
		var userInfoExistedOpt = repository.findById(form.getLoginId());
		if (userInfoExistedOpt.isPresent()) {
			return Optional.empty();
		}

		var userInfo = mapper.map(form, UserInfo.class);
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		userInfo.setPassword(encodedPassword);
		userInfo.setAuthority(AuthorityKind.ITEM_WATCHER.getAuthorityKind());

		return Optional.of(repository.save(userInfo));
	}

}
