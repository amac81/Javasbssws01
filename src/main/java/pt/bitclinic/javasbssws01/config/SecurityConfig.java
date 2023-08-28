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
	
	@Bean
	UserDetailsManager userDetailsManager(DataSource dataSource) { 
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> 
			configurer
				.requestMatchers(HttpMethod.GET, "/api").permitAll()
			    .requestMatchers(HttpMethod.GET, "/api/clients").hasRole("EMPLOYEE")
			    .requestMatchers(HttpMethod.GET, "/api/clients/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/clients").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/clients/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/clients/**").hasRole("ADMIN")
				
				.requestMatchers(HttpMethod.GET, "/api/products").hasRole("EMPLOYEE")
			    .requestMatchers(HttpMethod.GET, "/api/products/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/products").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
				
				.requestMatchers(HttpMethod.GET, "/api/categories").hasRole("EMPLOYEE")
			    .requestMatchers(HttpMethod.GET, "/api/categories/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/categories").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/categories/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/categories/**").hasRole("ADMIN")
				
				.requestMatchers(HttpMethod.GET, "/api/orders").hasRole("EMPLOYEE")
			    .requestMatchers(HttpMethod.GET, "/api/orders/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/orders").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/orders/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/orders/**").hasRole("ADMIN")
			);

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
