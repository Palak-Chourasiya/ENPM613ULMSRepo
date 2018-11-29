package ulms;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user")
          .password("password")
          .roles("USER");
    }
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
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
        httpSecurity.csrf().disable();
    }

}