package com.challange.talkspace.service.impl;

import com.challange.talkspace.model.Role;
import com.challange.talkspace.repository.RoleRepository;
import com.challange.talkspace.service.RoleService;
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
        return roleRepository.findByRoleName(Role.RoleName.valueOf(roleName).toString());
    }
}
