package com.jmei.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 购物车的 封装对象
 * @author 汤亮
 * @since 2016-05-02
 *
 */
public class ShoppingCart implements Serializable{
	private List<Goods> goodsCart = new ArrayList<Goods>();;
	private double sum = 0.00;
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public ShoppingCart(List<Goods> goodsCart, double sum) {
		super();
		this.goodsCart = goodsCart;
		this.sum = sum;
	}

	public List<Goods> getGoodsCart() {
		return goodsCart;
	}

	public void setGoodsCart(List<Goods> goodsCart) {
		this.goodsCart = goodsCart;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	//1.添加商品到购物车
	public void addCart(Goods p){
		goodsCart.add(p);
		sum += p.getPrice();
	}
	
	//2.移除商品
	public void removeGoods(Goods p){
		goodsCart.remove(p);
		sum -= p.getPrice();
	}
	
	//3.清空购物车
	public void clearAll(){
		goodsCart.clear();
		sum = 0.0;
	}
}
