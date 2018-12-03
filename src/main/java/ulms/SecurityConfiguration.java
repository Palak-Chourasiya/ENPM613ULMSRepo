package ulms;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import ulms.login.controllers.UserLoginLogoutServiceInterface;
import ulms.login.models.LoginEntity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserLoginLogoutServiceInterface loginService;

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
		Iterable<LoginEntity> alllogins = loginService.getAllLogins();
		
		Collection<UserDetails> users = new ArrayList<UserDetails>();
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		for (LoginEntity login : alllogins) {
			
			users.add(User.withUsername(login.getUserName()).password(encoder.encode(login.getPassword())).roles(login.getAccount().getRole().getRole()).build());
		}
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(users);
        manager.createUser(User.withUsername("user").password(encoder.encode("user")).roles("USER").build());
        return manager;
	}
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

    	httpSecurity
        .authorizeRequests()
        .antMatchers("/", "/login**", "/static/**", "/images/**", "/styles/**", "/components/error/**").permitAll()
        // All remaining paths…
        .anyRequest()
        // ...require user to at least be authenticated
        .authenticated()
        .and()
        // And if a user needs to be authenticated...
        .formLogin()
        .loginPage("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        //.loginProcessingUrl("/ulms")
        .defaultSuccessUrl("/ulms",true)
        .failureUrl("/login?error=true")
        .and()
        // If user isn't authorised to access a path...
        //.exceptionHandling()
        // ...redirect them to /403
        //.accessDeniedPage("/403")
        //.and()
        // And if the user needs to logout...
        .logout()
        // ...redirect them to /logout
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login?logout")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
		.permitAll();

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