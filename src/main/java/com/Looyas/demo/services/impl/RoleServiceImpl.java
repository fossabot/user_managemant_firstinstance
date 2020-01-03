package com.Looyas.demo.services.impl;

import com.Looyas.demo.models.Role;
import com.Looyas.demo.repositories.RoleRepository;
import com.Looyas.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role user) {
        return roleRepository.save(user);
    }
}