package com.example.demo1.config;

import com.example.demo1.model.ApplicationPermission;
import com.example.demo1.model.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo1.model.ApplicationPermission.*;
import static com.example.demo1.model.ApplicationRole.ADMIN;
import static com.example.demo1.model.ApplicationRole.USER;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MyAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                /*.antMatchers(HttpMethod.GET,"/management/**").hasAnyAuthority(MANAGEMENT_READ.getPermission(),USER_READ.getPermission())
                .antMatchers(HttpMethod.POST,"/management/**").hasAnyAuthority(MANAGEMENT_WRITE.getPermission())*/
                .antMatchers("/user/**").hasAnyRole(ADMIN.name(),USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        //.authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails sheebaUser = User.builder()
                .username("sheeba")
                .password(passwordEncoder.encode("password"))
                //.roles(USER.name()) //ROLE_USER
                .authorities(USER.getAuthorities())
                .build();

        UserDetails keerthiUser = User.builder()
                .username("keerthi")
                .password(passwordEncoder.encode("password"))
                //.roles(USER.name())
                .authorities(USER.getAuthorities())
                .build();

        UserDetails abishekUser = User.builder()
                .username("abishek")
                .password(passwordEncoder.encode("password123"))
                //.roles(ADMIN.name())
                .authorities(ADMIN.getAuthorities())
                .build();

        return new InMemoryUserDetailsManager(sheebaUser, keerthiUser, abishekUser);

    }
}
