package com.cos.securityex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.securityex01.model.User;

// JpaRepository 를 상속하면 자동 컴퍼넌트 스캔 됨 (기본 crud 들고 있음)
public interface UserRepository extends JpaRepository<User, Integer> {

	//Jpa Naming 전략(naming을 적으면 그에 맞는 쿼리가 생김)
	// SELECT * FROM user WHERE username = 1?
	User findByUsername(String username);
	
	//Jpa Naming 패턴에 없을 경우 하단과 같이 생성 가능
//	@Query(value = "select * from user", nativeQuery = true)
//	User find마음대로();
}
