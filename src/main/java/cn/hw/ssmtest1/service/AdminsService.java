package cn.hw.ssmtest1.service;

import cn.hw.ssmtest1.common.ResPage;
import cn.hw.ssmtest1.dto.AdminPageDto;
import cn.hw.ssmtest1.entity.Admins;
import org.apache.ibatis.annotations.Param;

public interface AdminsService {
    Admins getById(Long id);

    Admins handleLogin(String username,String password);

    ResPage<Admins> getPage(AdminPageDto adminPageDto);


    boolean removeAdmin(Integer id);

    boolean updateAdmins(Admins admins);

    boolean addAdmin(Admins admin);

    Admins selectByUsername(String username);
}
