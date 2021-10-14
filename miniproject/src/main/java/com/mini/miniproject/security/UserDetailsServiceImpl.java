package com.mini.miniproject.security;

import com.mini.miniproject.model.User;
import com.mini.miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("들어옴");
        System.out.println(username);
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));

        System.out.println(user);

        return new UserDetailsImpl(user);
    }
}



