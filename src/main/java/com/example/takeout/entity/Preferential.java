package com.example.takeout.entity;

import java.io.Serializable;

/**
 * preferential
 * @author 
 */
public class Preferential implements Serializable {
    /**
     * 优惠表的主键
     */
    private Integer preferentialId;

    /**
     * 优惠描述信息
     */
    private String preferentialDescribe;

    /**
     * 商品表的外键
     */
    private Integer goodsId;

    /**
     * 比率
     */
    private Integer ratio;

    private static final long serialVersionUID = 1L;

    public Integer getPreferentialId() {
        return preferentialId;
    }

    public void setPreferentialId(Integer preferentialId) {
        this.preferentialId = preferentialId;
    }

    public String getPreferentialDescribe() {
        return preferentialDescribe;
    }

    public void setPreferentialDescribe(String preferentialDescribe) {
        this.preferentialDescribe = preferentialDescribe;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
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
        Preferential other = (Preferential) that;
        return (this.getPreferentialId() == null ? other.getPreferentialId() == null : this.getPreferentialId().equals(other.getPreferentialId()))
            && (this.getPreferentialDescribe() == null ? other.getPreferentialDescribe() == null : this.getPreferentialDescribe().equals(other.getPreferentialDescribe()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getRatio() == null ? other.getRatio() == null : this.getRatio().equals(other.getRatio()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPreferentialId() == null) ? 0 : getPreferentialId().hashCode());
        result = prime * result + ((getPreferentialDescribe() == null) ? 0 : getPreferentialDescribe().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getRatio() == null) ? 0 : getRatio().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", preferentialId=").append(preferentialId);
        sb.append(", preferentialDescribe=").append(preferentialDescribe);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", ratio=").append(ratio);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}