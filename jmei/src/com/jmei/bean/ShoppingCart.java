package com.jmei.bean;

import java.util.List;

public class ShoppingCart {
	private List<Goods> GoodsCart;
	private double sum;
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public ShoppingCart(List<Goods> goodsCart, double sum) {
		super();
		GoodsCart = goodsCart;
		this.sum = sum;
	}

	public List<Goods> getGoodsCart() {
		return GoodsCart;
	}

	public void setGoodsCart(List<Goods> goodsCart) {
		GoodsCart = goodsCart;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	//1.�����Ʒ�����ﳵ
	public void addCart(Goods p){
		GoodsCart.add(p);
		sum += p.getPrice();
	}
	
	//2.�Ƴ���Ʒ
	public void removeGoods(Goods p){
		GoodsCart.remove(p);
		sum -= p.getPrice();
	}
	
	//3.��չ��ﳵ
	public void clearAll(){
		GoodsCart.clear();
		sum = 0.0;
	}
}
