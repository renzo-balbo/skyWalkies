package com.mindhub.skywalkies.configurations;

import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.repositories.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebAuthorization extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    public ClientRespository clientRespository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clientEmail -> {
            Client client = clientRespository.findByEmail(clientEmail);

            if (client != null) {
                if (client.getEmail().contains("@skywalkies")){
                    return new User(client.getEmail(), client.getPassword(),
                            AuthorityUtils.createAuthorityList("ADMIN"));
                }else{
                    return new User(clientEmail, client.getPassword(),
                            AuthorityUtils.createAuthorityList("CLIENT"));}
            } else{
                throw new UsernameNotFoundException("Unknown email:"+clientEmail);
            }
        });
    }
    @Bean
    public PasswordEncoder passwordEncoder(){return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
