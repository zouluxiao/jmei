package com.jmei.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.dao.PicDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.PicExistException;
import com.jmei.exception.PicNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.PicService;

public class PicServiceImpl implements PicService {
	private  final String  KEY ="PicDAOImpl";

	//����ͼƬ
	public void addPic(Pic pic) throws DAOException, PicExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯͼƬ
		Pic p = dao.queryPicByPicid(pic.getPicid());
		//3.�ж�p�Ƿ���� ������ڲ����쳣
		if(p !=null)
			throw new PicExistException("ͼƬ�Ѵ���");
		//4.����ͼƬ��Ϣ
		dao.insertPic(pic);
	}

	//ɾ������ͼƬ
	public void removeAllPic() throws DAOException, PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> p = dao.queryAllPic();
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new PicNotExistException("ͼƬ������");
		//4.ɾ��ͼƬ��Ϣ
		dao.deleteAllPic();
	}

	//����idɾ��ͼƬ
	public void removePicByPicid(int picid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		Pic p = dao.queryPicByPicid(picid);
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new PicNotExistException("ͼƬ������");
		//4.ɾ��ͼƬ��Ϣ
		dao.deletePicByPicid(picid);
	}

	//����ͼƬ��ɾ��ͼƬ
	public void removeAllPicByName(String picname) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> p = dao.queryPicByPicname(picname);
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new PicNotExistException("ͼƬ������");
		//4.ɾ��ͼƬ��Ϣ
		dao.deleteAllPicByName(picname);
	}

	//���ݿ����ɾ��ͼƬ
	public void removeGoodsAllPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> p = dao.queryPicByGid(goods);
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new PicNotExistException("ͼƬ������");
		//4.ɾ��ͼƬ��Ϣ
		dao.deleteGoodsAllPic(goods);
	}

	//���ݿ����ɾ������СͼƬ
	public void removeGoodsAllSmaPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> p = dao.queryAllSmaPicByGid(goods);
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new PicNotExistException("ͼƬ������");
		//4.ɾ��ͼƬ��Ϣ
		dao.deleteGoodsAllSmaPic(goods);
	}

	//���ݿ����ɾ����������ͼƬ
	public void removeGoodsAllMidPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> p = dao.queryAllMidPicByGid(goods);
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new PicNotExistException("ͼƬ������");
		//4.ɾ��ͼƬ��Ϣ
		dao.deleteGoodsAllMidPic(goods);
	}

	//���ݿ����ɾ��������ƫͼƬ
	public void removeGoodsAllMibPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> p = dao.queryAllMibPicByGid(goods);
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new PicNotExistException("ͼƬ������");
		//4.ɾ��ͼƬ��Ϣ
		dao.deleteGoodsAllMibPic(goods);
	}

	//���ݿ����ɾ�����д���ͼƬ
	public void removeGoodsAllBigPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> p = dao.queryAllBigPicByGid(goods);
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new PicNotExistException("ͼƬ������");
		//4.ɾ��ͼƬ��Ϣ
		dao.deleteGoodsAllBigPic(goods);
	}

	//����ͼƬ��Ϣ
	public void updatePic(int picid,String picname,Goods gid,int flag) throws DAOException, PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯͼƬ
		Pic pic = dao.queryPicByPicid(picid);
		//3.�ж�list�Ƿ�Ϊ��
		if(pic == null)
			throw new PicNotExistException("��Ʒ�����ڣ�");
	    //4.����ͼƬ��Ϣ
		pic.setPicpname(picname);
		pic.setGid(gid);
		pic.setFlag(flag);
	}

	//��ѯ����ͼƬ
	public List<Pic> searchAllPic() throws DAOException, PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> list = dao.queryAllPic();
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//����Id��ѯͼƬ
	public Pic searchPicByPicid(int picid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		Pic p = dao.queryPicByPicid(picid);
		//3.�ж�list�Ƿ�Ϊ��
		if(p == null)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return p;
	}

	//����ͼƬ����ѯͼƬ
	public List<Pic> searchPicByPicname(String picname) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> list = dao.queryPicByPicname(picname);
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//���ݿ���Ų�ѯͼƬ
	public List<Pic> searchPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> list = dao.queryPicByGid(gid);
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//���ݿ���Ų�ѯС��ͼƬ
	public List<Pic> searchAllSmaPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> list = dao.queryAllSmaPicByGid(gid);
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//���ݿ���Ų�ѯ����ͼƬ
	public List<Pic> searchAllMidPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> list = dao.queryAllMidPicByGid(gid);
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//���ݿ���Ų�ѯ��ƫͼƬ
	public List<Pic> searchAllMibPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> list = dao.queryAllMibPicByGid(gid);
		//3.�ж�list�Ƿ�Ϊ��
		//if(list.size() == 0)
		//	throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//���ݿ���Ų�ѯ����ͼƬ
	public List<Pic> searchAllBigPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<Pic> list = dao.queryAllMibPicByGid(gid);
		//3.�ж�list�Ƿ�Ϊ��
	/*	if(list.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");*/
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//������Ʒ����Ų�ѯС��ͼƬ������ͼƬ
	public List<List<Pic>> searchAllSmaMidPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllSmaPicByGid(gid);
		List<Pic> list2 = dao.queryAllMidPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.�ж�list�Ƿ�Ϊ��
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//������Ʒ����Ų�ѯС��ͼƬ����ƫͼƬ
	public List<List<Pic>> searchAllSmaMibPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllSmaPicByGid(gid);
		List<Pic> list2 = dao.queryAllMibPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.�ж�list�Ƿ�Ϊ��
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//������Ʒ����Ų�ѯС��ͼƬ�ʹ���ͼƬ
	public List<List<Pic>> searchAllSmaBigPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllSmaPicByGid(gid);
		List<Pic> list2 = dao.queryAllBigPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.�ж�list�Ƿ�Ϊ��
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//������Ʒ����Ų�ѯ����ͼƬ����ƫͼƬ
	public List<List<Pic>> searchAllMidMibPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllMidPicByGid(gid);
		List<Pic> list2 = dao.queryAllMibPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.�ж�list�Ƿ�Ϊ��
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//������Ʒ����Ų�ѯ����ͼƬ�ʹ���ͼƬ
	public List<List<Pic>> searchAllMidBigPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllMidPicByGid(gid);
		List<Pic> list2 = dao.queryAllBigPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.�ж�list�Ƿ�Ϊ��
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

	//������Ʒ����Ų�ѯ��ƫͼƬ�ʹ���ͼƬ
	public List<List<Pic>> searchAllMibBigPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.��ȡDAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.��ѯͼƬ
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllMibPicByGid(gid);
		List<Pic> list2 = dao.queryAllBigPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.�ж�list�Ƿ�Ϊ��
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("ͼƬ�����ڣ�");
		//4.����ͼƬ��Ϣ
	    return list;
	}

}
