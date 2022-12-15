package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig<HttpSecurity, SecurityFilterChain> {
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.cors().disable().csrf().disable()
                .authorizeRequests()
                //.antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.POST,"/usuario").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/login").permitAll()
                .anyRequest().permitAll();
        return http.build();
    }
}

