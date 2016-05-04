package com.jmei.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * ���ﳵ�� ��װ����
 * @author ����
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
	
	//1.�����Ʒ�����ﳵ
	public void addCart(Goods p){
		goodsCart.add(p);
		sum += p.getPrice();
	}
	
	//2.�Ƴ���Ʒ
	public void removeGoods(Goods p){
		goodsCart.remove(p);
		sum -= p.getPrice();
	}
	
	//3.��չ��ﳵ
	public void clearAll(){
		goodsCart.clear();
		sum = 0.0;
	}
}
