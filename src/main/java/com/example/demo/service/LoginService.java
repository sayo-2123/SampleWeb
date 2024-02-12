package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面 Service
 */
@Service
@RequiredArgsConstructor
public class LoginService {
	/** ユーザー情報テーブルDAO */
	private final UserInfoRepository repository;

	/**
	 * ユーザー検索テーブル 検索結果
	 * 
	 * @param loginId ログインID
	 * @return ユーザー情報テーブルを主キー検索した結果(1件)
	 */
	public Optional<UserInfo> searchUserById(String loginId) {
		return repository.findById(loginId);
	}

}
