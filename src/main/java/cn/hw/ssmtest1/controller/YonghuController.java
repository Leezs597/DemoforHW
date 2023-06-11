package cn.hw.ssmtest1.controller;

import cn.hw.ssmtest1.common.Res;
import cn.hw.ssmtest1.common.ResPage;
import cn.hw.ssmtest1.dto.AdminPageDto;
import cn.hw.ssmtest1.dto.LoginDto;
import cn.hw.ssmtest1.dto.YonghuPageDto;
import cn.hw.ssmtest1.entity.Admins;
import cn.hw.ssmtest1.entity.Yonghu;
import cn.hw.ssmtest1.service.AdminsService;
import cn.hw.ssmtest1.service.YonghuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/yonghu")
public class YonghuController {

    @Resource
    private YonghuService yonghuService;

    @PostMapping("/getYonghuList")
    public ResPage<Yonghu> getYonghuList(@RequestBody YonghuPageDto yonghuPageDto){
        ResPage<Yonghu> resPage = yonghuService.getPage(yonghuPageDto);
        return resPage;
    }

    // 定义get接口 /removeAdmin
    @GetMapping("/removeYonghu")
    // RequestParam 请求中的参数 id
    public Res<Boolean> remove(@RequestParam("id") Integer id){
        // 在service层中 定义新的方法removeAdmin参数是id
        boolean remove = yonghuService.removeYonghu(id);
        // 给前端返回的结果
        Res<Boolean> res = new Res<>();
        res.setData(remove);
        return res;
    }

    // 根据id获取用户信息
    @GetMapping("/getById")
    public Res<Yonghu> getById(@RequestParam("id") Integer id){
        Yonghu yonghu = yonghuService.getById(Long.valueOf(id));
        Res<Yonghu> res = new Res<>();
        res.setData(yonghu);
        return res;
    }

    @PostMapping("/update")
    public Res<Boolean> update(@RequestBody Yonghu yonghu){
        boolean update = yonghuService.updateYonghu(yonghu);
        // 给前端返回的结果
        Res<Boolean> res = new Res<>();
        res.setData(update);
        return res;
    }

    @RequestMapping ("/add")
    public Res<Boolean> add(@RequestBody Yonghu yonghu){
        Yonghu yonghus = yonghuService.selectByUsername(yonghu.getYonghuming());
        Res<Boolean> res = new Res<>();
        if (Objects.nonNull(yonghus)){
            res.setCode(1);
            res.setMessage("用户已存在");
            return res;
        }
        boolean add = yonghuService.addYonghu(yonghu);
        // 给前端返回的结果
        res.setData(add);
        return res;
    }
}
