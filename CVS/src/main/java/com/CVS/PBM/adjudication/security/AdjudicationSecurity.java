package com.CVS.PBM.adjudication.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AdjudicationSecurity {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	public AdjudicationSecurity(JwtAuthenticationFilter jwtAuthenticationFilter) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors(Customizer.withDefaults())// Enable CORS
        .csrf(AbstractHttpConfigurer::disable) // Disable CSRF
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/**",
            		"/swagger-ui/**", 
            		"/v3/api-docs",
            		"/v3/api-docs/swagger-config",
            		"/swagger-ui.html"
            		).permitAll() // Public endpoints
            .anyRequest().authenticated() // Secure all other endpoints
        	
        )
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		
		return http.build();
     
    }
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

	
//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//        .csrf(AbstractHttpConfigurer::disable)
//            .authorizeHttpRequests(auth -> auth
//                .anyRequest().permitAll() // Allow all requests
//            );
//        return http.build();
//    }

}
