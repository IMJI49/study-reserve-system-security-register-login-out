package com.choongang.studyreservesystem.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/","/login/**").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/my/**").hasAnyRole("ADMIN","USER")
						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/loginProc")
						.defaultSuccessUrl("/",true)
						.permitAll())
				.logout(lg -> lg
						.logoutUrl("/logout")
						.logoutSuccessUrl("/"))
				.csrf(auth -> auth.disable())
				.sessionManagement(session -> session
						.maximumSessions(1)
						.maxSessionsPreventsLogin(true))
				.sessionManagement(fix -> fix
						.sessionFixation().changeSessionId())
//				.httpBasic(Customizer.withDefaults())
				;
		return httpSecurity.build();
	}

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }

//    @Bean
//    RoleHierarchy roleHierarchy() {
//
//        return RoleHierarchyImpl.fromHierarchy("""
//                ROLE_C > ROLE_B
//                ROLE_B > ROLE_A
//                """);
//    }
//    @Bean
//    RoleHierarchy roleHierarchy() {
//
//        return RoleHierarchyImpl.withRolePrefix("접두사_")
//                .role("C").implies("B")
//                .role("B").implies("A")
//                .build();
//    }
}
