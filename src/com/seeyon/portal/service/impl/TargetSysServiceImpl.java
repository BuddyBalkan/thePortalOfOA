package com.seeyon.portal.service.impl;

import com.seeyon.portal.service.TargetSysService;
import com.seeyon.portal.pojo.TargetSystem;
import com.seeyon.portal.spadeSSO.TargetSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TargetSysServiceImpl implements TargetSysService {

    @Autowired
    private TargetSystemRepository repository;


    @Override
    public TargetSystem queryByTargetSysId(Integer targetId) {
        return repository.findTargetSystemByTargetSys(targetId);
    }

    @Override
    public TargetSystem queryByTargetSysName(String targetName) {
        return repository.findTargetSystemByTargetSysName(targetName);
    }
}
