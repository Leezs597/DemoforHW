package cn.hw.ssmtest1.entity;

import java.io.Serializable;

/**
 * 用户
 * @TableName yonghu
 */
public class Yonghu implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户名
     */
    private String yonghuming;

    /**
     * 密码
     */
    private String mima;

    /**
     * 姓名
     */
    private String xingming;

    /**
     * 性别
     */
    private String xingbie;

    /**
     * 手机
     */
    private String shouji;

    /**
     * 邮箱
     */
    private String youxiang;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     */
    public String getYonghuming() {
        return yonghuming;
    }

    /**
     * 用户名
     */
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming;
    }

    /**
     * 密码
     */
    public String getMima() {
        return mima;
    }

    /**
     * 密码
     */
    public void setMima(String mima) {
        this.mima = mima;
    }

    /**
     * 姓名
     */
    public String getXingming() {
        return xingming;
    }

    /**
     * 姓名
     */
    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    /**
     * 性别
     */
    public String getXingbie() {
        return xingbie;
    }

    /**
     * 性别
     */
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    /**
     * 手机
     */
    public String getShouji() {
        return shouji;
    }

    /**
     * 手机
     */
    public void setShouji(String shouji) {
        this.shouji = shouji;
    }

    /**
     * 邮箱
     */
    public String getYouxiang() {
        return youxiang;
    }

    /**
     * 邮箱
     */
    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Yonghu other = (Yonghu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getYonghuming() == null ? other.getYonghuming() == null : this.getYonghuming().equals(other.getYonghuming()))
            && (this.getMima() == null ? other.getMima() == null : this.getMima().equals(other.getMima()))
            && (this.getXingming() == null ? other.getXingming() == null : this.getXingming().equals(other.getXingming()))
            && (this.getXingbie() == null ? other.getXingbie() == null : this.getXingbie().equals(other.getXingbie()))
            && (this.getShouji() == null ? other.getShouji() == null : this.getShouji().equals(other.getShouji()))
            && (this.getYouxiang() == null ? other.getYouxiang() == null : this.getYouxiang().equals(other.getYouxiang()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getYonghuming() == null) ? 0 : getYonghuming().hashCode());
        result = prime * result + ((getMima() == null) ? 0 : getMima().hashCode());
        result = prime * result + ((getXingming() == null) ? 0 : getXingming().hashCode());
        result = prime * result + ((getXingbie() == null) ? 0 : getXingbie().hashCode());
        result = prime * result + ((getShouji() == null) ? 0 : getShouji().hashCode());
        result = prime * result + ((getYouxiang() == null) ? 0 : getYouxiang().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", yonghuming=").append(yonghuming);
        sb.append(", mima=").append(mima);
        sb.append(", xingming=").append(xingming);
        sb.append(", xingbie=").append(xingbie);
        sb.append(", shouji=").append(shouji);
        sb.append(", youxiang=").append(youxiang);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}