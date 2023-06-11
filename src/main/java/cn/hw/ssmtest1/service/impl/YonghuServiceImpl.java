package cn.hw.ssmtest1.service.impl;

import cn.hw.ssmtest1.common.ResPage;
import cn.hw.ssmtest1.dto.YonghuPageDto;
import cn.hw.ssmtest1.entity.Admins;
import cn.hw.ssmtest1.entity.Yonghu;
import cn.hw.ssmtest1.mapper.YonghuMapper;
import cn.hw.ssmtest1.service.YonghuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YonghuServiceImpl implements YonghuService {

    @Resource
    private YonghuMapper yonghuMapper;

    @Override
    public Yonghu getById(Long id) {
        return yonghuMapper.selectByPrimaryKey(id);
    }

    @Override
    public Yonghu handleLogin(String username, String password) {
        return yonghuMapper.getYonghuByUsernameAndPwd(username, password);
    }

    @Override
    public ResPage<Yonghu> getPage(YonghuPageDto yonghuPageDto) {
        // 开启分页 参数是 1.当前页数 2.一页展示多少数据，一定放到查询语句的前面
        PageHelper.startPage(yonghuPageDto.getPage(),yonghuPageDto.getLimit());
        // 去查询数据id 相当于 limit X,Y
        List<Yonghu> yonghu = yonghuMapper.selectByKeyword(yonghuPageDto.getKeyword());
        // 要用PageInfo获取当前查询的总条数,可能会用到其他数据，，，
        PageInfo<Yonghu> pageInfo = new PageInfo<>(yonghu);
        long total = pageInfo.getTotal();
        // 创建给前端返回的数据
        ResPage<Yonghu> resPage = new ResPage<>();
        resPage.setCount(total);
        resPage.setData(yonghu);
        return resPage;
    }

    @Override
    public boolean removeYonghu(Integer id) {
        // mapper层，根据id删除数据  int -> Long
        int i = yonghuMapper.deleteByPrimaryKey(Long.valueOf(id));
        return i > 0;
    }

    @Override
    public boolean updateYonghu(Yonghu yonghu) {
        int i = yonghuMapper.updateByPrimaryKeySelective(yonghu);
        return i > 0;
    }

    @Override
    public boolean addYonghu(Yonghu yonghu) {
        int i = yonghuMapper.insertSelective(yonghu);
        return i > 0;
    }

    @Override
    public Yonghu selectByYhUsername(String username) {
        return yonghuMapper.selectByselectByUsername(username);
    }
    @Override
    public Yonghu  selectByUsername(String username) {
        return yonghuMapper.selectByselectByUsername(username);
    }

}
