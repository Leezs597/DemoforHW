package cn.hw.ssmtest1.mapper;

import cn.hw.ssmtest1.entity.Yonghu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 李志帅
* @description 针对表【yonghu(用户)】的数据库操作Mapper
* @createDate 2023-06-10 16:01:49
* @Entity cn.hw.ssmtest1.entity.Yonghu
*/
public interface YonghuMapper {

    Yonghu selectByselectByUsername(String username) ;

    int deleteByPrimaryKey(Long id);

    int insert(Yonghu record);

    int insertSelective(Yonghu record);

    Yonghu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Yonghu record);

    int updateByPrimaryKey(Yonghu record);

    Yonghu getYonghuByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

    List<Yonghu> selectByKeyword(@Param("keyword") String keyword);

    Yonghu selectByYhUsername(@Param("yonghuming") String username);
}
