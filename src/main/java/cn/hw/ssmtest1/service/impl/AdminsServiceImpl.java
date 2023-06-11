package cn.hw.ssmtest1.service.impl;

import cn.hw.ssmtest1.common.ResPage;
import cn.hw.ssmtest1.dto.AdminPageDto;
import cn.hw.ssmtest1.dto.LoginDto;
import cn.hw.ssmtest1.entity.Admins;
import cn.hw.ssmtest1.mapper.AdminsMapper;
import cn.hw.ssmtest1.service.AdminsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminsServiceImpl implements AdminsService {

    @Resource
    private AdminsMapper adminsMapper;

    @Override
    public Admins getById(Long id) {
        return adminsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admins handleLogin(String username, String password) {
        return adminsMapper.getAdminsByUsernameAndPwd(username, password);
    }

    @Override
    public ResPage<Admins> getPage(AdminPageDto adminPageDto) {
        // 开启分页 参数是 1.当前页数 2.一页展示多少数据，一定放到查询语句的前面
        PageHelper.startPage(adminPageDto.getPage(),adminPageDto.getLimit());
        // 去查询数据id 相当于 limit X,Y
        List<Admins> admins = adminsMapper.selectByKeyword(adminPageDto.getKeyword());
        // 要用PageInfo获取当前查询的总条数,可能会用到其他数据，，，
        PageInfo<Admins> pageInfo = new PageInfo<>(admins);
        long total = pageInfo.getTotal();
        // 创建给前端返回的数据
        ResPage<Admins> resPage = new ResPage<>();
        resPage.setCount(total);
        resPage.setData(admins);
        return resPage;
    }

    @Override
    public boolean removeAdmin(Integer id) {
        // mapper层，根据id删除数据  int -> Long
        int i = adminsMapper.deleteByPrimaryKey(Long.valueOf(id));
        return i > 0;
    }

    @Override
    public boolean updateAdmins(Admins admins) {
        int i = adminsMapper.updateByPrimaryKeySelective(admins);
        return i > 0;
    }

    @Override
    public boolean addAdmin(Admins admin) {
        int i = adminsMapper.insertSelective(admin);
        return i > 0;
    }

    @Override
    public Admins selectByUsername(String username) {
        return adminsMapper.selectByUsername(username);
    }
}
