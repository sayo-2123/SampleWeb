package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
//どのTableとリンクしているか表す
@Table(name = "user_info")
//getter,setterのかわり
@Data
public class UserInfo {

	/** ログインID */
	@Id
	//	tblのカラム名とentityのフィール名が異なるため@Columnで紐づけを行う
	@Column(name = "login_id")
	private String loginId;
	
	/** パスワード */
	private String password;

}
