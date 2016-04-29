package com.jmei.service.impl;

import java.util.List;
import com.jmei.bean.Buser;
import com.jmei.bean.Foreshow;
import com.jmei.dao.ForeshowDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.ForeshowExistException;
import com.jmei.exception.ForeshowNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.ForeshowService;
/**
 * @author �ӽ�
 * @date 2016-04-27
 **/
public class ForeshowServiceImpl implements ForeshowService {
	private  final String  KEY ="ForeshowDAOImpl";
	public List<Foreshow> searchForeshows() throws DAOException,
			ForeshowNotExistException {
		//1.��ȡDAO
		ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ������Ʒ
		List<Foreshow> list = dao.queryByAll();
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new ForeshowNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return list;
	}
	public Foreshow searchForeshowByForeid(int foreid) throws DAOException,
			ForeshowNotExistException {
		//1.��ȡDAO
		ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ������Ʒ
		Foreshow f = dao.queryByForeid(foreid);
		//3.�ж���Ʒ�Ƿ�Ϊ��
		if(f == null)
			throw new ForeshowNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return f;
	}
	public Foreshow searchForeshowByForepic(String forepic)
			throws DAOException, ForeshowNotExistException {
		//1.��ȡDAO
				ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.��ѯ������Ʒ
				Foreshow f = dao.queryByForepic(forepic);
				//3.�ж���Ʒ�Ƿ�Ϊ��
				if(f == null)
					throw new ForeshowNotExistException("��Ʒ�����ڣ�");
				//4.������Ʒ��Ϣ
			    return f;
			}
	public void addForeshow(Foreshow foreshow) throws DAOException,
			ForeshowExistException {
		//1.��ȡDAO
		ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.����id��ѯ��Ʒ����
		Foreshow f = dao.queryByForeid(foreshow.getForeid());
				//3.�ж���Ʒ�Ƿ���� ������ڲ����쳣
				if(f !=null)
					throw new ForeshowExistException("��Ʒ�Ѵ���");
				//4.������Ʒ
				dao.inserForeShow(foreshow);
			}
	public void updateByForeshowInfo(int foreid, String forepic, Buser bid)
			throws DAOException, ForeshowNotExistException {
		//1.��ȡDAO
		ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.���ݲ��ز�ѯ��Ʒ
		Foreshow f = dao.queryByForeid(foreid);
				//3.�ж���Ʒ�Ƿ�Ϊ��
				if(f == null)
					throw new ForeshowNotExistException("��Ʒ�����ڣ�");
			    //4.������Ʒ��Ϣ
				f.setForepic(forepic);
		        f.setBuser(bid);
				
			}
	public void updateByForeshowForepic(String forepicPath, int foreid)
			throws DAOException, ForeshowNotExistException {
		        //1.��ȡDAO
		        ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.���ݲ��ز�ѯ��Ʒ
		        Foreshow f = dao.queryByForeid(foreid);
				//3.�ж��Ƿ�Ϊ��
				if(f == null)
					throw new ForeshowNotExistException("��Ʒ�����ڣ�");
			    //4.������Ʒ��Ϣ
				f.setForepic(forepicPath);
				dao.updateForeShow(f);
			}
	public void removeForeshow(int foreid) throws DAOException,
			ForeshowNotExistException {
		        //1.��ȡDAO
		        ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.����id��ѯ��Ʒ����
		        Foreshow f = dao.queryByForeid(foreid);
				//3.�ж�ac�Ƿ���� ������ڲ����쳣
				if(f ==null)
					throw new ForeshowNotExistException("��Ʒ������");
				//4.������Ʒ��Ϣ
				dao.delete(foreid);
			}

}
