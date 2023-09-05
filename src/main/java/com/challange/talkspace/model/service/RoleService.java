package com.challange.talkspace.model.service;

import com.challange.talkspace.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
