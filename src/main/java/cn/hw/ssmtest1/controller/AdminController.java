package cn.hw.ssmtest1.controller;

import cn.hw.ssmtest1.common.Res;
import cn.hw.ssmtest1.common.ResPage;
import cn.hw.ssmtest1.dto.AdminPageDto;
import cn.hw.ssmtest1.dto.LoginDto;
import cn.hw.ssmtest1.entity.Admins;
import cn.hw.ssmtest1.service.AdminsService;
import cn.hw.ssmtest1.service.impl.AdminsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminsService adminsService;

    @PostMapping("/login")
    public Res<Admins> login(@RequestBody LoginDto loginDto){
        Res<Admins> res = new Res<>();
        Admins admins = adminsService.handleLogin(loginDto.getUsername(), loginDto.getPassword());
        if (Objects.isNull(admins)){
            res.setCode(-1);
            res.setMessage("用户名或密码错误");
            res.setData(null);
            return res;
        }
        res.setData(admins);
        return res;
    }

    @PostMapping("/getAdminsList")
    public ResPage<Admins> getAdminsList(@RequestBody AdminPageDto adminPageDto){
        ResPage<Admins> resPage = adminsService.getPage(adminPageDto);
        return resPage;
    }

    // 定义get接口 /removeAdmin
    @GetMapping("/removeAdmin")
    // RequestParam 请求中的参数 id
    public Res<Boolean> remove(@RequestParam("id") Integer id){
        // 在service层中 定义新的方法removeAdmin参数是id
        boolean remove = adminsService.removeAdmin(id);
        // 给前端返回的结果
        Res<Boolean> res = new Res<>();
        res.setData(remove);
        return res;
    }

    // 根据id获取管理员信息
    @GetMapping("/getById")
    public Res<Admins> getById(@RequestParam("id") Integer id){
        Admins admins = adminsService.getById(Long.valueOf(id));
        Res<Admins> res = new Res<>();
        res.setData(admins);
        return res;
    }

    @PostMapping("update")
    public Res<Boolean> update(@RequestBody Admins admins){
        boolean update = adminsService.updateAdmins(admins);
        // 给前端返回的结果
        Res<Boolean> res = new Res<>();
        res.setData(update);
        return res;
    }

    @PostMapping("add")
    public Res<Boolean> add(@RequestBody Admins admin){
        Admins admins = adminsService.selectByUsername(admin.getUsername());
        Res<Boolean> res = new Res<>();
        if (Objects.nonNull(admins)){
            res.setCode(1);
            res.setMessage("用户已存在");
            return res;
        }
        boolean add = adminsService.addAdmin(admin);
        // 给前端返回的结果
        res.setData(add);
        return res;
    }
}
