package com.example.springboot_springsecurity.config;

import com.example.springboot_springsecurity.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @date 2020/10/24 - 9:57
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService  userDatailService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，但是功能页只能有权限的人能访问
        //如果没有指定资源的权限，则这个资源没人可以被所有人访问
        //权限拦截是根据请求路劲，而非资源路劲。
        http.authorizeRequests()
                .antMatchers("/").permitAll() // "/"根目录下的资源所有人能访问
                .antMatchers("/level1/**").hasRole("vip1") // "/level1"下的所有文件只有VIP1级别的用户可以访问
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

       //开启功能，如果没有权限，就跳转到登录页
        http.formLogin().loginPage("/toLogin");  //指定我们自己写的登录页
//开启注销功能,指定注销访问首页
        http.logout().logoutSuccessUrl("/");

        //关闭csrf功能
        http.csrf().disable();   //开启可能导出登出失败
        //开启记住我功能
        http.rememberMe().rememberMeParameter("rember");  //自定义接收参数
    }
    //认证
    //密码编码 PasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
             //从内存中读                //设置加密方式不然会报错
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zsh").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()   //and用于拼接用户
                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip1","vip2","vip3");


    auth.userDetailsService(userDatailService)   //从数据库中读
            .passwordEncoder(passwordEncoder());
    }

}
