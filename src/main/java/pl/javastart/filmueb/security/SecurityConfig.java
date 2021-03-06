package pl.javastart.filmueb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void confiAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from user where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/banner.png").permitAll()
                .antMatchers("/registration/*").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/moderator/*").hasRole("MODERATOR")
                .antMatchers("/users/*").hasRole("MODERATOR")
                .antMatchers("/users").hasRole("USER")

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and();
    }
}