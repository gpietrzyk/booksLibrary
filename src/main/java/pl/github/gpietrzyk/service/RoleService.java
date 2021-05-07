package pl.github.gpietrzyk.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.gpietrzyk.domain.Role;
import pl.github.gpietrzyk.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor

@Transactional
@Service
public class RoleService {
    private final RoleRepository roleRepository;


    public Role findRoleById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role findRoleByName(String name){
        return roleRepository.findByRoleName(name);
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public List<Role> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }
}
