package com.jmei.bean;

import java.io.Serializable;

/**
 * @author 汤亮
 * @since 2016-04-23
 * 对数据表的goodsToType的封装
 *	gid number(20),       --商品编号--
	tid number(20),		  --类型编号-
 */
public class GoodsToType implements Serializable{
	private Goods goods;
	private Gtype type;
	
	public GoodsToType() {
		// TODO Auto-generated constructor stub
	}

	public GoodsToType(Goods goods, Gtype type) {
		super();
		this.goods = goods;
		this.type = type;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Gtype getType() {
		return type;
	}

	public void setType(Gtype type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsToType other = (GoodsToType) obj;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsToType [goods=" + goods + ", type=" + type + "]";
	}
	
	
}
