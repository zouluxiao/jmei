package com.jmei.service.impl;

import java.util.List;
import com.jmei.bean.Buser;
import com.jmei.bean.Mad_rush;
import com.jmei.dao.Mad_rushDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.Mad_rushExistException;
import com.jmei.exception.Mad_rushNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.Mad_rushService;
/**
 * @author �ӽ�
 * @date 2016-04-27
 **/
public class Mad_rushServiceImpl implements Mad_rushService {
	private  final String  KEY ="Mad_rushDAOImpl";
	public List<Mad_rush> searchMad_rushs() throws DAOException,
			Mad_rushNotExistException {
		//1.��ȡDAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ������Ʒ
		List<Mad_rush> list = dao.queryByAll();
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new Mad_rushNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return list;
	}
	public Mad_rush searchMad_rushByMadid(int madid) throws DAOException,
			Mad_rushNotExistException {
		//1.��ȡDAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ������Ʒ
		Mad_rush m = dao.queryByMadid(madid);
		//3.�ж���Ʒ�Ƿ�Ϊ��
		if(m == null)
			throw new Mad_rushNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return m;
	}

	public Mad_rush searchMad_rushByAcpic(String madpic) throws DAOException,
			Mad_rushNotExistException {
		//1.��ȡDAO
				Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
				//2.��ѯ������Ʒ
				Mad_rush m = dao.queryByMadpic(madpic);
				//3.�ж���Ʒ�Ƿ�Ϊ��
				if(m == null)
					throw new Mad_rushNotExistException("��Ʒ�����ڣ�");
				//4.������Ʒ��Ϣ
			    return m;
			}

	public void addMad_rush(Mad_rush mad_rush) throws DAOException,
			    Mad_rushExistException {
		        //1.��ȡDAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
				//2.����id��ѯ��Ʒ����
		Mad_rush m = dao.queryByMadid(mad_rush.getMadid());
				//3.�ж���Ʒ�Ƿ���� ������ڲ����쳣
				if(m !=null)
					throw new Mad_rushExistException("��Ʒ�Ѵ���");
				//4.������Ʒ
				dao.inserMad_rush(mad_rush);
			}
	public void updateByMad_rushInfo(int madid, String madpic, Buser bid)
			throws DAOException, Mad_rushNotExistException {
		        //1.��ȡDAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
				//2.���ݲ��ز�ѯ��Ʒ
		Mad_rush m = dao.queryByMadid(madid);
				//3.�ж���Ʒ�Ƿ�Ϊ��
				if(m == null)
					throw new Mad_rushNotExistException("��Ʒ�����ڣ�");
			    //4.������Ʒ��Ϣ
				m.setMadpic(madpic);
		        m.setBuser(bid);
				
			}
	public void updateByMad_rushMadpic(String madpicPath, int madid)
			throws DAOException, Mad_rushNotExistException {
	     //1.��ȡDAO
			Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
					//2.���ݲ��ز�ѯ��Ʒ
			Mad_rush m = dao.queryByMadid(madid);
					//3.�ж���Ʒ�Ƿ�Ϊ��
					if(m == null)
						throw new Mad_rushNotExistException("��Ʒ�����ڣ�");
				    //4.������Ʒ��Ϣ
					m.setMadpic(madpicPath);
			        m.setMadid(madid);
					
				}
	public void removeMad_rush(int madid) throws DAOException,
			Mad_rushNotExistException {
		//1.��ȡDAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
				//2.����id��ѯ��Ʒ����
		Mad_rush m = dao.queryByMadid(madid);
				//3.�ж�ac�Ƿ���� ������ڲ����쳣
				if(m ==null)
					throw new Mad_rushNotExistException("��Ʒ������");
				//4.������Ʒ��Ϣ
				dao.delete(madid);
}
	}
