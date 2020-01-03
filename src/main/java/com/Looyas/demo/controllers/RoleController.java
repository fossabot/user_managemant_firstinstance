package com.Looyas.demo.controllers;

import com.Looyas.demo.models.Role;
import com.Looyas.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    //add user
    @PostMapping("/addrole")
    public Role addRole(@RequestBody Role role) {
        return (roleService.add(role));
    }
}
