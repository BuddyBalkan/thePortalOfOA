package com.seeyon.portal.spadeSSO;


import com.seeyon.portal.pojo.TargetSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetSystemRepository extends CrudRepository<TargetSystem, Integer> {

    public TargetSystem findTargetSystemByTargetSys(Integer id);

    public TargetSystem findTargetSystemByTargetSysName(String name);
}
