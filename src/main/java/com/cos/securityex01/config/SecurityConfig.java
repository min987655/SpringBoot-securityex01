package com.cos.securityex01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // IoC에 Bean(빈) 을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션 (이하로 필요 체인들을 오버라이딩하여 사용)
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소 접근시 권한 및 인증을 미리 체그하겠음.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user/**","/admin/**") // 해당 주소만 잠그고 나머지 다 열어 놓음
			.authenticated()
			.anyRequest()
			.permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/loginProc"); // 해당 주소로 들어오면 로긴 페이지로 감.
	}
}
