package AVAProject.AVA.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new ClientServiceConfigImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getDaoAuthProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());

		return daoAuthenticationProvider;
	}
	@Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(Arrays.asList(getDaoAuthProvider()));
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getDaoAuthProvider());
    }
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoAuthProvider());
	}
	*/

    @Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
			.requestMatchers("/admin/**")
			.hasRole("ADMIN")
			.requestMatchers("/client/**")
			.hasRole("USER")
			.requestMatchers("/**")
			.permitAll().and()
			.formLogin()
			.loginPage("/signin")
			.loginProcessingUrl("/Login")
			.defaultSuccessUrl("/client/").and().csrf().disable();

		return http.build();
	}

}