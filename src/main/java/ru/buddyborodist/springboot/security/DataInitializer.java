package ru.buddyborodist.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.buddyborodist.springboot.dao.RoleRepository;
import ru.buddyborodist.springboot.dao.UserRepository;
import ru.buddyborodist.springboot.model.Role;
import ru.buddyborodist.springboot.model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataInitializer {
    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void createRoles(){
        Role roleAdmin = new Role();
        Role roleUser = new Role();
        roleAdmin.setName("ADMIN");
        roleUser.setName("USER");

        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        roleRepository.saveAll(roles);
    }

    @PostConstruct
    public void createUser(){
        Role roleAdmin = roleRepository.getRoleByName("ADMIN");
        Role roleUser = roleRepository.getRoleByName("USER");

        User user = new User();
        user.setRoles(Set.of(roleAdmin, roleUser));
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("123"));
        userRepository.save(user);
    }
}
