package com.challange.talkspace.model.service.impl;

import com.challange.talkspace.model.Role;
import com.challange.talkspace.model.service.RoleService;
import com.challange.talkspace.repository.RoleRepository;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.findByRoleName(Role.RoleName.valueOf(roleName));
    }
}