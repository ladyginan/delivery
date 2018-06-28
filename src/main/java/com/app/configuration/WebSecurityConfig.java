package com.app.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan(basePackages = {"com.app"})
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    ;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/welcome").permitAll()
                .antMatchers("/getJson").permitAll()
                .antMatchers("/driverInfo").hasRole("DRIVER")
                .antMatchers("/driverLogin").hasRole("DRIVER")
                .antMatchers("/selectProfile").hasRole("DRIVER")
                .antMatchers("/driverPage").hasRole("DRIVER")
                .antMatchers("/drivers").hasRole("MANAGER")
                .antMatchers("/waggons").hasRole("MANAGER")
                .antMatchers("/cargoes").hasRole("MANAGER")
                .antMatchers("/status").hasRole("MANAGER")
                .antMatchers("/orders").hasRole("MANAGER")
                .antMatchers("/points").hasRole("MANAGER")
                .antMatchers("/cities").hasRole("MANAGER")
                .anyRequest().hasAnyRole("ADMIN", "MANAGER", "DRIVER")
                .and()
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .csrf().disable();
    }
}