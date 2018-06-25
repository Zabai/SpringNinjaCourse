package com.zarmas.ninjabackend.service.implementation;

import com.zarmas.ninjabackend.entity.UserRole;
import com.zarmas.ninjabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("UserServiceImplementation")
public class UserServiceImplementation implements UserDetailsService {
    @Autowired
    @Qualifier("UserRepository")
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.zarmas.ninjabackend.entity.User user = userRepository.findByUsername(username);
        return buildUser(user, buildAuthorities(user.getUserRoles()));
    }

    private User buildUser(com.zarmas.ninjabackend.entity.User user, List<GrantedAuthority> authorityList) {
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorityList);
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(userRole -> authorities.add(new SimpleGrantedAuthority(userRole.getRole())));
        return new ArrayList<>(authorities);
    }
}
