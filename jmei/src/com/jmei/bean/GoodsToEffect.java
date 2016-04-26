package com.jmei.bean;

import java.io.Serializable;

/**
 * @author 汤亮
 * @since 2016-04-23
 * 封装了数据表GoodsTOEffect
 *gid number(20),       --商品编号--
	eid number(20),		  --功效编号--
 */
public class GoodsToEffect implements Serializable{
	private Goods goods;
	private Effect effect;
	
	public GoodsToEffect() {
		// TODO Auto-generated constructor stub
	}

	public GoodsToEffect(Goods goods, Effect effect) {
		super();
		this.goods = goods;
		this.effect = effect;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((effect == null) ? 0 : effect.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
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
		GoodsToEffect other = (GoodsToEffect) obj;
		if (effect == null) {
			if (other.effect != null)
				return false;
		} else if (!effect.equals(other.effect))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsToEffect [goods=" + goods + ", effect=" + effect + "]";
	}
	
	
}
