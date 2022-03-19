package com.intuitbrains.service.company;

import com.intuitbrains.dao.company.RoleRepository;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.model.company.Role;
import com.intuitbrains.model.company.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Employee findUserByEmailId(String emailId) {
        return employeeRepository.findByEmailId(emailId);
    }

    public void saveUser(Employee user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        employeeRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

        Employee user = employeeRepository.findByEmailId(emailId);
        if (user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Employee user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), authorities);
    }
}
