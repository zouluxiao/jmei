package com.jmei.service.impl;

import java.util.List;
import com.jmei.bean.Gtype;
import com.jmei.dao.GtypeDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.GtypeExistException;
import com.jmei.exception.GtypeNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.GtypeService;
/**
 * @author �ӽ�
 * @date 2016-04-27
 **/
public class GtypeServiceImpl implements GtypeService {
	private  final String  KEY ="GtypeDAOImpl";
	public List<Gtype> searchGtypes() throws DAOException, GtypeNotExistException {
		        //1.��ȡDAO
	           	GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.��ѯ������Ʒ
				List<Gtype> list = dao.queryByAll();
				//3.�ж�list�Ƿ�Ϊ��
				if(list.size() == 0)
					throw new GtypeNotExistException("��Ʒ�����ڣ�");
				//4.������Ʒ��Ϣ
			    return list;
			}
	public Gtype searchGtypeByTid(int tid) throws DAOException,
			GtypeNotExistException {
		//1.��ȡDAO
		GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ������Ʒ
		Gtype g = dao.queryByTid(tid);
		//3.�ж���Ʒ�Ƿ�Ϊ��
		if(g == null)
			throw new GtypeNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return g;
	}
	public Gtype searchGtypeByTname(String tname) throws DAOException,
			GtypeNotExistException {
		//1.��ȡDAO
				GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.��ѯ������Ʒ
				Gtype g = dao.queryByTname(tname);
				//3.�ж���Ʒ�Ƿ�Ϊ��
				if(g == null)
					throw new GtypeNotExistException("��Ʒ�����ڣ�");
				//4.������Ʒ��Ϣ
			    return g;
			}
	public void addGtype(Gtype gtype) throws DAOException, GtypeExistException {
		//1.��ȡDAO
		GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.����id��ѯ��Ʒ����
		Gtype g = dao.queryByTid(gtype.getTid());
				//3.�ж���Ʒ�Ƿ���� ������ڲ����쳣
				if(g !=null)
					throw new GtypeExistException("��Ʒ�Ѵ���");
				//4.������Ʒ
				dao.inserGtype(gtype);
			}
	public void updateByGtypeInfo(int tid, String tname) throws DAOException,
			GtypeNotExistException {
		//1.��ȡDAO
		GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.���ݲ��ز�ѯ��Ʒ
		Gtype g = dao.queryByTid(tid);
				//3.�ж���Ʒ�Ƿ�Ϊ��
				if(g == null)
					throw new GtypeNotExistException("��Ʒ�����ڣ�");
			    //4.������Ʒ��Ϣ
				g.setTname(tname);
	}	
	public void removeGtype(int tid) throws DAOException,
			GtypeNotExistException {
		//1.��ȡDAO
		GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.����id��ѯ��Ʒ����
		Gtype g = dao.queryByTid(tid);
				//3.�ж�ac�Ƿ���� ������ڲ����쳣
				if(g ==null)
					throw new GtypeNotExistException("��Ʒ������");
				//4.������Ʒ��Ϣ
				dao.delete(tid);
			}
		}
