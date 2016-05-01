package com.jmei.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.bean.GoodsToType;
import com.jmei.dao.GoodsDAO;
import com.jmei.dao.GoodsToEffectDAO;
import com.jmei.dao.GoodsToTypeDAO;
import com.jmei.dao.impl.GoodsDAOImpl;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoSuchGoodsException;
import com.jmei.factory.DAOFactory;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.GoodsServices;

public class GoodsServicesImpl implements GoodsServices {
	private final static String Goods_KEY = "GoodsDAOImpl";
	private final static String GoodsToEffect_KEY = "GoodsToEffectDAOImpl";
	private final static String GoodsToType_KEY = "GoodsToTypeDAOImpl";

	/**
	 * �����Ʒ
	 * @param goods �����Ʒ��
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException �����Ʒ������
	 */
	public void addGoods(Goods goods) throws DAOException, NoSuchGoodsException {
		//����DAO����
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		if(goods == null){
			throw new NoSuchGoodsException("�������ƷΪ��");
		}
		goodsdao.insertGoods(goods);
	}

	/**
	 * ͨ����Ʒ���ɾ����Ʒ
	 * @param gid ��Ʒ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û����������Ʒ
	 */
	public void deleteGoods(int gid) throws DAOException, NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		goodsdao.deleteGoods(gid);
	}

	/**
	 * ������Ʒ
	 * @param goods ������Ʒ�ķ�װ��
	 * @throws DAOException ���ݿ��쳣
	 */
	public void updateGoods(Goods goods) throws DAOException, NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		if(goods == null){
			throw new NoSuchGoodsException("�����ֵΪ��");
		}
		goodsdao.updateGoods(goods);
	}

	
	/**
	 * ��ѯ��Ʒ
	 * @param name ��Ʒ������
	 * @return ��Ʒ�Ķ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByName(String name) throws DAOException,
			NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = goodsdao.queryGoodsByPname(name);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("û���ҵ���Ӧ��Ʒ");
		}
		return list;
	}

	/**
	 * ͨ����ҵ��Ų�ѯ��Ʒ
	 * @param bid ��ҵ���
	 * @return ��Ʒ����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByBid(int bid) throws DAOException,
			NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = goodsdao.queryGoodsByBid(bid);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("û���ҵ���Ӧ��Ʒ");
		}
		return list;
	}

	/**
	 * ͨ����ҵ���Ʋ�ѯ��Ʒ
	 * @param bname ��ҵ����
	 * @return ��Ʒ����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByBname(String bname) throws DAOException,
			NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = goodsdao.queryGoodsByBname(bname);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("û���ҵ���Ӧ��Ʒ");
		}
		return list;
	}

	/**
	 * ͨ����Ʒ��Ų�ѯ��Ʒ
	 * @param pid ��Ʒ���
	 * @return ��Ʒ�Ķ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByPid(int pid) throws DAOException,
			NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = goodsdao.queryGoodsByPid(pid);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("û���ҵ���Ӧ��Ʒ");
		}
		return list;
	}

	/**
	 * ͨ����Ʒ���Ͳ�ѯ��Ʒ
	 * @param type ��Ʒ���͵����飨��Ŷ�����ͣ�
	 * @param list ��ɸѡ�ļ���
	 * @return ��Ʒ���͵Ķ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByType(String type,List list)
			throws DAOException, NoSuchGoodsException {
		if(type == null ){
			return list;
		}
		if(list == null){
			throw new NoSuchGoodsException("��Ʒ�б��ѿ�");
		}
		//���弯�ϱ���ɸѡ������Goods��
		ArrayList<Goods> alist = new ArrayList<Goods>();
		//����service
		GoodsToTypeDAO gtype =  (GoodsToTypeDAO) DAOFactory.newInstance(GoodsToType_KEY);
		//ͨ��Goods�����ҳ���Ӧ��GoodsToType��
		for(int i = 0 ; i < list.size(); i++){
			Goods g = (Goods) list.get(i);
			ArrayList<GoodsToType> tlist = (ArrayList<GoodsToType>) gtype.queryGoodsToTypeBygid(g.getGid());
			for(GoodsToType t: tlist){
				if(type.equals(t.getType().getTname())){
					alist.add(g);
					break;
				}
			}
			
		}
		return alist;
	}

	/**
	 * ͨ����Ʒ�Ĺ�Ч��ѯ��Ʒ
	 * @param effect ��Ʒ�Ĺ�Ч���飨
	 * @param list ��ɸѡ�ļ���
	 * @return ��Ʒ���󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByEffect(String effect,List list)
			throws DAOException, NoSuchGoodsException {
		if(effect == null){
			return list;
		}
		if(list == null){
			throw new NoSuchGoodsException("��Ʒ�б��ѿ�");
		}
		//���ɸѡ�����Ʒ�Ķ���
		ArrayList<Goods> alist = new ArrayList<Goods>();
		//��������ݿ⽻����dao����
		GoodsToEffectDAO dao = (GoodsToEffectDAO) DAOFactory.newInstance(GoodsToEffect_KEY);
		//���Ҵ�ɸѡ���ϵĹ�Ч����
		for(int i=0;i<list.size();i++){
			Goods g = (Goods) list.get(i);
			List<GoodsToEffect> glist = dao.queryGoodsToEffectBygid(g.getGid());
			if(glist != null && glist.size() > 0){
				for(GoodsToEffect ef:glist){
					if(effect.equals(ef.getEffect().getEname())){
						alist.add(g);
					}
				}
			}
		}
		return alist;
	}

	/**
	 * ͨ����Ʒ�ı�Ų�ѯ��Ʒ�Ĺ�Ч
	 * @param gid ��Ʒ�ı��
	 * @return ������Ʒ�Ĺ�Ч���󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<GoodsToEffect> searchGoodsToEffectByGid(int gid)
			throws DAOException, NoSuchGoodsException {
		GoodsToEffectDAO goodsdao = (GoodsToEffectDAO) DAOFactory.newInstance(GoodsToEffect_KEY);
		ArrayList<GoodsToEffect> list = new ArrayList<GoodsToEffect>();
		list = (ArrayList<GoodsToEffect>) goodsdao.queryGoodsToEffectBygid(gid);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("û���ҵ���Ʒ");
		}
		return list;
	}

	/**
	 * ͨ����Ʒ�ı�Ų�ѯ��Ʒ������
	 * @param gid ��Ʒ�ı��
	 * @return ������Ʒ�����Ͷ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<GoodsToType> searchGoodsToTypeByGid(int gid)
			throws DAOException, NoSuchGoodsException {
		GoodsToTypeDAO goodsdao = (GoodsToTypeDAO) DAOFactory.newInstance(GoodsToType_KEY);
		ArrayList<GoodsToType> list = new ArrayList<GoodsToType>();
		list = (ArrayList<GoodsToType>) goodsdao.queryGoodsToTypeBygid(gid);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("û���ҵ���Ʒ");
		}
		return list;
	}

	/**
	 * ͨ��������ѯ��Ʒ
	 * @param num ��Ʒ������
	 * @return ������Ʒ���󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByNumber(int num) throws DAOException,
			NoSuchGoodsException {
		GoodsDAOImpl goodsdao = (GoodsDAOImpl) DAOFactory.newInstance(Goods_KEY);
		ArrayList<Goods> list = new ArrayList<Goods>();
		list = (ArrayList<Goods>) goodsdao.queryGoodsByNumber(num);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("û���ҵ���Ʒ");
		}
		return list;
	}

	/**
	 * ����Ʒ������������
	 * @param list ��Ʒ�ļ���
	 * @return ���������ĵ���Ʒ����
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> orderBySaleVol(List list) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		
		Collections.sort(list,new Comparator<Goods>() {

			public int compare(Goods o1, Goods o2) {
				return o2.getSale_val() - o1.getSale_val();
			}
		});
		
		return list;
	}

	/**
	 * ���ϼ�ʱ��������
	 * @param list ��Ʒ���϶���
	 * @return ������Ʒ�������ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> orderByUptime(List list) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		Collections.sort(list, new Comparator<Goods>() {

			@Override
			public int compare(Goods o1, Goods o2) {
				return o1.getUptime().compareTo(o2.getUptime());
			}
		});
		return list;
			
	}

	/**
	 * ���۸�������
	 * @param list ��Ʒ�ļ���
	 * @return ������Ʒ�����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> orderByPriDesc(List list) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		
		Collections.sort(list,new Comparator<Goods>() {

			public int compare(Goods o1, Goods o2) {
				return (int) (o2.getPrice() - o1.getPrice());
			}
		});
		
		return list;
	}

	/**
	 * ���۸���������
	 * @param list ��Ʒ�ļ���
	 * @return ������Ʒ�����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> orderByPriAsc(List list) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		
		Collections.sort(list,new Comparator<Goods>() {

			public int compare(Goods o1, Goods o2) {
				return (int) (o1.getPrice() - o2.getPrice());
			}
		});
		
		return list;
	}

	/**
	 * ����Ʒ�۸�β�ѯ��Ʒ
	 * @param list ��Ʒ�ļ���
	 * @param low �۸�����
	 * @param high �۸�����
	 * @return ������Ʒ�����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ 
	 */
	public List<Goods> searchByPriArea(List list,int low,int high) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		Iterator<Goods> it = list.iterator();
		while(it.hasNext()){
			Goods goods = it.next();
			if(goods.getPrice() < low || goods.getPrice() > high){
				it.remove();
			}
		}
		return list;
	}

	/**
	 * ͨ����Ʒ�����Ʋ�ѯ��Ʒ
	 * @param pname ��Ʒ������
	 * @return ������Ʒ�Ķ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByPname(String pname) throws DAOException,
			NoSuchGoodsException {
		if(pname == null){
			throw new NoSuchGoodsException("�����ֵΪ��");
		}
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> goodslist = dao.queryGoodsByPname(pname);
		if(goodslist == null || goodslist.size() == 0){
			throw new NoSuchGoodsException("û���ҵ�������Ʒ");
		}
		return goodslist;
	}
	
	/**
	 * ͨ��gid�ҳ���Ʒ��������Ʒ����ϸ����
	 * @param gid ��Ʒ�ı��
	 * @param Detail ���º����Ʒ����ϸ����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByDetail(String detail)
			throws DAOException,NoSuchGoodsException {
		if(detail == null){
			throw new NoSuchGoodsException("û�������Ʒ");
		}
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = dao.queryGoodsByDetail(detail);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("û���ҵ���Ҫ�ҵ���Ʒ");
		}
		return list;
	}

	/**
	 * ������Ʒ��������+1��
	 * @param gid �����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addSaleVol(int gid) throws DAOException, NoSuchGoodsException {
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		Goods goods = dao.queryGoodsByGid(gid);
		if(goods == null){
			throw new NoSuchGoodsException("û���ҵ��ö���");
		}
		dao.addGoodsSaleVol(gid);
		
	}

	/**
	 * ������Ʒ���ղأ�+1��
	 * @param gid �����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addColVol(int gid) throws DAOException, NoSuchGoodsException {
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		Goods goods = dao.queryGoodsByGid(gid);
		if(goods == null){
			throw new NoSuchGoodsException("û���ҵ��ö���");
		}
		dao.addGoodsColVol(gid);
		
	}
	
	/**
	 * ��ѯ��Ʒͨ����Ʒ���
	 * @param gid �����
	 * @return Goods ��Ʒ����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public Goods searchGoodsByGid(int gid)
			throws DAOException,NoSuchGoodsException {
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		Goods goods = dao.queryGoodsByGid(gid);
		if(goods == null){
			throw new NoSuchGoodsException("û���ҵ�����Ʒ");
		}
		return goods;
	}

	/**
	 * ����Ʒ��Ų�����Ʒ��Ӧ�Ĺ�Ч
	 * @param gid ��Ʒ���
	 * @return ��Ʒ��Ӧ��Ч�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 *//*
	public List<GoodsToEffect> searchGoodsToEffectBygid(int gid) 
			throws DAOException,NoSuchGoodsException {
		GoodsToEffectDAO dao = (GoodsToEffectDAO) DAOFactory.newInstance(GoodsToEffect_KEY);
		List<GoodsToEffect> glist = dao.queryGoodsToEffectBygid(gid);
		if(glist == null){
			throw new NoSuchGoodsException("û���ҵ������Ч����Ʒ");
		}
		return glist;
	}
	
	*//**
	 * ����Ʒ�ı�Ų�ѯ��Ʒ��Ӧ������
	 * @param gid ��Ʒ�ı��
	 * @return ��Ʒ��Ӧ���͵ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 *//*
	public List<GoodsToType> searchGoodsToTypeBygid(int gid) 
			throws DAOException,NoSuchGoodsException {
		GoodsToTypeDAO dao = (GoodsToTypeDAO) DAOFactory.newInstance(GoodsToEffect_KEY);
		List<GoodsToType> glist = dao.queryGoodsToTypeBygid(gid);
		if(glist == null){
			throw new NoSuchGoodsException("û���ҵ�������͵���Ʒ");
		}
		return glist;
	}*/
}
