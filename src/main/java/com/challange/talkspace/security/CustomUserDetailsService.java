package com.challange.talkspace.security;

import com.challange.talkspace.model.User;
import com.challange.talkspace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

        private final UserService userService;

        @Override
        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            User user = userService.findByUserName(userName).orElseThrow(
                    () -> new UsernameNotFoundException("User not found !"));
            org.springframework.security.core.userdetails.User.UserBuilder userBuilder;
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUserName());
            userBuilder.password(user.getPassword());
            userBuilder.authorities(user.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName().name()))
                    .collect(Collectors.toList()))

//                    .roles(user.getRoles()
//                    .stream()
//                    .map(r -> r.getRoleName().name())
//                    .toArray(String[]::new))
            ;
            return userBuilder.build();

        }

}
