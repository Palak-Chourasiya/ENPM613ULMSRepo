package ulms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user")
          .password("user")
          .roles("USER");
    }
    */
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        manager.createUser(User.withUsername("user").password(encoder.encode("user")).roles("USER").build());
        return manager;
	}
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	/***************
    	httpSecurity
        .httpBasic().and()
        .authorizeRequests()
        .antMatchers("/", "/#!/login").hasRole("USER")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/")
        .loginProcessingUrl("/login")
		.permitAll();
    	***************/
    	
        //httpSecurity.authorizeRequests().antMatchers("/**").permitAll();
    	/*
    	httpSecurity.httpBasic().disable();
    	httpSecurity.httpBasic().and()
                    .logout().and()
                    .authorizeRequests()
                    .antMatchers("/index.html", "/", "/login").permitAll()
                    .anyRequest().authenticated();
        */
    	
    	/*
    	httpSecurity.csrf().disable()
    	            .authorizeRequests()
    	            .antMatchers("/app/**", "/images/**", "index.html", "/components/login/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                       .loginPage("/")
                       .permitAll();
        */
    	
    	
    	//https://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/html5/#csrf-include-csrf-token-ajax
        //httpSecurity.csrf().disable();
    }

}