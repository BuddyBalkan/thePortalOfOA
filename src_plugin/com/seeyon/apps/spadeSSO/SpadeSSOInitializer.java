package com.seeyon.apps.spadeSSO;

import com.seeyon.ctp.common.AbstractSystemInitializer;

public class SpadeSSOInitializer extends AbstractSystemInitializer {

    @Override
    public void destroy(){
        System.out.println("销毁了SpadeSSO模块");
    }

    @Override
    public void initialize(){
        System.out.println("初始化SpadeSSO模块");
    }

}
