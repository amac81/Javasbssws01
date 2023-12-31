package pt.bitclinic.javasbssws01.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	
	// Add support for JDBC
	
	/*@Bean
	UserDetailsManager userDetailsManager(DataSource dataSource) { 
		return new JdbcUserDetailsManager(dataSource);
	}*/
	
	//JDBC authentication - Custom Tables
	
	@Bean
	UserDetailsManager userDetailsManager(DataSource dataSource) { 
		JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource); 
		
		theUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
		theUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
		
		return theUserDetailsManager;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> 
			configurer
				.requestMatchers(HttpMethod.GET, "/api").permitAll()
			    .requestMatchers(HttpMethod.GET, "/api/clients", "/api/products", "/api/categories", "/api/orders").hasRole("EMPLOYEE")
			    .requestMatchers(HttpMethod.GET, "/api/clients/**", "/api/products/**", "/api/categories/**", "/api/orders/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/clients", "/api/products", "/api/categories", "/api/orders").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/clients/**", "/api/products/**", "/api/categories/**", "/api/orders/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/clients/**", "/api/products/**", "/api/categories/**", "/api/orders/**").hasRole("ADMIN"));

		// Use HTTP basic authentication
		http.httpBasic(Customizer.withDefaults());

		// Disable CSRF protection
		http.csrf(csrf -> csrf.disable());
		
		/*
		 * Cross-Site Request Forgery (CSRF) is an attack that forces authenticated
		 * users to submit a request to a Web application against which they are 
		 * currently authenticated. CSRF attacks exploit the trust a Web application has
		 * in an authenticated user.
		 *
		 * In general CSRF protection is not required for stateless REST API's that use
		 * POST, PUT, DELETE, and/or PATCH.
		 *
		 */
		return http.build();
	}
	
	
	
	/*@Bean
	InMemoryUserDetailsManager userDetailsManager() {
		UserDetails jonh = User.builder().username("jonh").password("{noop}test123").roles("EMPLOYEE").build();

		UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails susan = User.builder().username("susan").password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(jonh, mary, susan);
	}*/
}
