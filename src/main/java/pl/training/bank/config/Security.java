package pl.training.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.training.bank.user.UserService;
import pl.training.bank.user.User;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select login,password,enabled from users where login = ?")
                .authoritiesByUsernameQuery("select login,role from users where login = ?");
                //.inMemoryAuthentication()
                //.withUser("maria").password(passwordEncoder.encode("123")).roles("ADMIN");
    }

    @PostConstruct
    public void init() {
        User user = new User("maria", "123", "ROLE_ADMIN");
        userService.addUser(user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/**").hasRole("ADMIN")
                .and()
                    //.httpBasic();
                    .formLogin()
                        .loginPage("/login.html")
                        .permitAll()
                .and()
                    .logout()
                        .logoutSuccessUrl("/login.html")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout.html"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
