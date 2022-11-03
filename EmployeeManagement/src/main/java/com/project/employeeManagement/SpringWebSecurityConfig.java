package com.project.employeeManagement;

import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.employeeManagement.repository.UserRepo;
import com.project.employeeManagement.entity.Role;
import com.project.employeeManagement.repository.RoleRepo;
import com.project.employeeManagement.service.MyUserDetailsService;
import com.project.employeeManagement.entity.User;

@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	DataSource dataSource;

	@Autowired
	private LoginSuccessHandler handler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetailsService());
		dao.setPasswordEncoder(encoder());
		return dao;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/directory/edit-employee", "/directory/delete", "/directory/save",
						"/directory/add-employee", "/api/user/addUser", "/api/user/save", "/api/user/edit",
						"/api/user/delete", "/api/role/addRole", "/api/role/save", "/api/role/fetchAllRoles",
						"/api/user/fetchAllUsers", "/dashboard")
				.hasRole("ADMIN").antMatchers( "/directory/403").hasAnyRole("USER", "ADMIN")
				.antMatchers("/directory/employees").authenticated().and().formLogin().successHandler(handler).permitAll();
		http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Autowired
	private RoleRepo role;
	@Autowired
	private UserRepo user;
	
	@Bean
	public void addData()
	{
		Role r1 = new Role();
		r1.setName("ROLE_USER");
		r1.setId(1);
		Role r2 = new Role();
		r2.setId(2);
		r2.setName("ROLE_ADMIN");
		role.save(r1);
		role.save(r2);
		
		User u1 = new User("user", encoder().encode("user"), Set.of(r1));
		User u2 = new User("admin", encoder().encode("admin"), Set.of(r1, r2));
		
		user.save(u1);
		user.save(u2);
	}
}