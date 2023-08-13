package com.challange.talkspace;

import com.challange.talkspace.model.ChatType;
import com.challange.talkspace.model.Role;
import com.challange.talkspace.service.ChatTypeService;
import com.challange.talkspace.service.RoleService;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final ChatTypeService chatTypeService;

    public DataInitializer(RoleService roleService, ChatTypeService chatTypeService) {
        this.roleService = roleService;
        this.chatTypeService = chatTypeService;
    }

    @PostConstruct
    public void inject() {
        //Roles
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);

        //ChatTypes
        ChatType chatTypePrivate = new ChatType();
        chatTypePrivate.setChatTypeName(ChatType.ChatTypeName.PRIVATE);
        chatTypeService.add(chatTypePrivate);
        ChatType chatTypeGroup = new ChatType();
        chatTypeGroup.setChatTypeName(ChatType.ChatTypeName.GROUP);
        chatTypeService.add(chatTypeGroup);
    }
}
