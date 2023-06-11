package cn.hw.ssmtest1.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 管理员
 * @TableName admins
 */
@Data
public class Admins implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 帐号
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    private static final long serialVersionUID = 1L;
}