package com.cos.securityex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // IoC에 Bean(빈) 을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션 (이하로 필요 체인들을 오버라이딩하여 사용)
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소 접근시 권한 및 인증을 미리 체그하겠음.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean // IoC 등록(메서드를 IoC에 등록, 리턴 있어야 함)
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // csrf-token 비활성화
		http.authorizeRequests()
			.antMatchers("/user/**","/admin/**") // 해당 주소만 잠그고 나머지 다 열어 놓음
			.authenticated()
			.anyRequest()
			.permitAll()
		.and()
			.formLogin() // form으로만 날림
			.loginPage("/login")
			.loginProcessingUrl("/loginProc") // 해당 주소로 들어오면 로긴 페이지로 감.
			.defaultSuccessUrl("/"); 
	}
}
