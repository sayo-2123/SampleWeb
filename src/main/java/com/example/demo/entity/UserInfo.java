package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
//どのTableとリンクしているか表す
@Table(name = "user_info")
//getter,setterのかわり
@Data
public class UserInfo {
	//	PKを示す@iD
	@Id
	//	tblのカラム名とentityのフィール名が異なるため@Columnで紐づけを行う
	@Column(name = "login_id")
	private String loginId;
	private String password;

}
