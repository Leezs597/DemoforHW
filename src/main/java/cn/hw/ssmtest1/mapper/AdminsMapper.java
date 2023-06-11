package cn.hw.ssmtest1.mapper;

import cn.hw.ssmtest1.entity.Admins;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Entity cn.hw.ssmtest1.entity.Admins
 */
@Mapper
@Component
public interface AdminsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Admins record);

    int insertSelective(Admins record);

    Admins selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admins record);

    int updateByPrimaryKey(Admins record);

    Admins getAdminsByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

    List<Admins> selectByKeyword(@Param("keyword") String keyword);

    Admins selectByUsername(@Param("username") String username);
}
