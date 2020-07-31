package com.cos.securityex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.securityex01.model.User;

// JpaRepository 를 상속하면 자동 컴퍼넌트 스캔 됨 (기본 crud 까지 다 들고 있음)
public interface UserRepository extends JpaRepository<User, Integer> {

}
