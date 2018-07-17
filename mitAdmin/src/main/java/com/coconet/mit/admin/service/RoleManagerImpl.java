package com.coconet.mit.admin.service;

import com.coconet.mit.appService.service.RoleService;
import com.coconet.mit.commons.model.Role;
import com.coconet.mit.dbService.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Prithu on 22-03-2017.
 */
@Service
@Transactional
public class RoleManagerImpl implements RoleManager{
    @Autowired
    private RoleService roleService;

    @Override
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
