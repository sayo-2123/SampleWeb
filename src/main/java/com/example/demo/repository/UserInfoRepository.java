package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserInfo;
/**
 * ユーザー情報テーブルDAO
 */

//引数はUserInfoの一つ目loginIdの型に合わせる
public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

}
