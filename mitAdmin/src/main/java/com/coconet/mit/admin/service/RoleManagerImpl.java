package com.coconet.mit.admin.service;

import com.coconet.mit.admin.dao.RoleDao;
import com.coconet.mit.admin.model.Role;
import com.coconet.mit.admin.repository.RoleRepository;
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
    private RoleDao roleDao;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
