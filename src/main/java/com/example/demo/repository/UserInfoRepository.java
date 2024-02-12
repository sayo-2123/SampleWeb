package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserInfo;
/**
 * ユーザー情報テーブルDAO
 */
@Repository
//引数はUserInfoの一つ目loginIdの型に合わせる
public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

}
