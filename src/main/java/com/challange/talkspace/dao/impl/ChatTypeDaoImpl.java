package com.challange.talkspace.dao.impl;

import com.challange.talkspace.exception.DataProcessingException;
import com.challange.talkspace.model.Role;
import com.challange.talkspace.dao.AbstractDao;
import com.challange.talkspace.dao.RoleDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(Role.RoleName roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> findRoleByNameQuery = session.createQuery(
                    "FROM Role WHERE roleName = :roleName", Role.class);
            findRoleByNameQuery.setParameter("roleName", roleName);
            return findRoleByNameQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with name " + roleName + " not found", e);
        }
    }
}
