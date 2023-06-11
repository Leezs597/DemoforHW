package cn.hw.ssmtest1.service;

import cn.hw.ssmtest1.common.ResPage;
import cn.hw.ssmtest1.dto.AdminPageDto;
import cn.hw.ssmtest1.dto.YonghuPageDto;
import cn.hw.ssmtest1.entity.Admins;
import cn.hw.ssmtest1.entity.Yonghu;
import org.apache.ibatis.annotations.Param;

public interface YonghuService {
    Yonghu getById(Long id);

    Yonghu handleLogin(String username, String password);


    ResPage<Yonghu> getPage(YonghuPageDto YonghuPageDto);


    boolean removeYonghu(Integer id);

    boolean updateYonghu(Yonghu yonghu);

    boolean addYonghu(Yonghu yonghu);

    Yonghu selectByUsername(String username);

    Yonghu selectByYhUsername(String username);
}
