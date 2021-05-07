package pl.github.gpietrzyk.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.github.gpietrzyk.domain.Role;
import pl.github.gpietrzyk.service.RoleService;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("app/roles")
public class RoleController {
    private final RoleService roleService;



    @GetMapping("/all")
    public ResponseEntity<List<Role>> findAllRoles(){
        List<Role> roles = roleService.findAllRoles();
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable("id") Integer id){
        Role role = roleService.findRoleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(role);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Role> findRoleByName(@PathVariable("name") String name){
        Role role = roleService.findRoleByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(role);
    }

    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        Role tempRole = roleService.findRoleByName(role.getRoleName());
        if(tempRole == null ) {
            roleService.addRole(role);
        }
        return ResponseEntity.status(HttpStatus.OK).body(role);
    }
}
