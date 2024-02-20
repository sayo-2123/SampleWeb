package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.UrlConst;
/**
 * メニューコントローラー
 */
@Controller
public class MenuController {
	/**
	 * 初期表示
	 * 
	 * @return 表示画面
	 */

	@GetMapping(UrlConst.MENU)
		public String view() {
			return "menu";
		}
}
