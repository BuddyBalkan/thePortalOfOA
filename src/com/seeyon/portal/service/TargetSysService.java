package com.seeyon.portal.service;


import com.seeyon.portal.pojo.TargetSystem;

public interface TargetSysService {

    public TargetSystem queryByTargetSysId(Integer targetId);

    public TargetSystem queryByTargetSysName(String targetName);


}
