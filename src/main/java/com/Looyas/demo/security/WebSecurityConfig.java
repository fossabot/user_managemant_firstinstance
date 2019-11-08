//package com.Looyas.demo.security;
//
//import com.Looyas.demo.security.jwt.JwtAuthEntryPoint;
//import com.Looyas.demo.security.jwt.JwtAuthTokenFilter;
//import com.Looyas.demo.services.impl.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        prePostEnabled = true
//)
//public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private JwtAuthEntryPoint unauthorizedHandler;
//
//    @Bean
//    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
//        return new JwtAuthTokenFilter();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder ) throws Exception {
////      AuthenticationManagerBuilder auth = null;
//        authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
////        auth.inMemoryAuthentication()
////                .withUser("john")
////                .password("123")
////                .roles("ADMIN");
//    }
//
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    //    The configure(HttpSecurity) method defines which URL paths should be secured and which should not.
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        Specifically, the "/" and "/auth" paths are configured to not require any authentication. All other paths must be authenticated.
//        http.cors().and().csrf().disable().
//                authorizeRequests()
//                .antMatchers("/", "/auth/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
////        auth.inMemoryAuthentication()
////                .passwordEncoder(encoder)
////                .withUser("spring")
////                .password(encoder.encode("secret"))
////                .roles("USER");
////    }
//
//}