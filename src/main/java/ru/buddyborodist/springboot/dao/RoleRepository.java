package ru.buddyborodist.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.buddyborodist.springboot.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByName(String name);
}
