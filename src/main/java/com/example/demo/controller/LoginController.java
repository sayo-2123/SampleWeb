package com.example.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.var;

/**
 * ログイン Controller
 * 
 */
@Controller
@RequiredArgsConstructor
public class LoginController {
	
	/** ログイン画面 service */

	private final LoginService service;
	
	/** PasswordEncoder*/
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */

	@GetMapping("/login")
	public String view(Model model, LoginForm form) {

		return "login";
	}
	
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@PostMapping("/login")
	public String login(Model model, LoginForm form) {
		var userInfo = service.searchUserById(form.getLoginId());
		var isCorrectUserAuth = userInfo.isPresent()
				&& passwordEncoder.matches(form.getPassword(), userInfo.get().getPassword());
		if (isCorrectUserAuth) {
			return "redirect:/menu";
		} else {
			//TODO エラーメッセージはプロパティファイルで管理する
			model.addAttribute("errorMsg", "ログインIDとパスワードの組み合わせが間違っています。");
			return "login";
		}
	}
}
