package com.lic.config.security;

import com.lic.model.AppUser;
import com.lic.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optional=appUserRepository.findAppUserByUsername(username);
        if(optional.isPresent()){
            return null;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found");
        }

    }
}
