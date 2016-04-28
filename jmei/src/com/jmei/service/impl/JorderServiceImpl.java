package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Jorder;
import com.jmei.dao.JorderDAO;
import com.jmei.dao.impl.JorderDAOImpl;
import com.jmei.exception.DAOException;
import com.jmei.exception.JorderHasNotExist;
import com.jmei.exception.JorderIsNotExist;
import com.jmei.exception.JorderIsNull;
import com.jmei.exception.JorderNotExist;
import com.jmei.factory.DAOFactory;
import com.jmei.service.JorderService;
/**
 * ʵ��JorderService�ӿڵ���
 * @author ���
 * @since 2016-04-27
 *
 */

public class JorderServiceImpl implements JorderService {
	
	private final static String JORDER_DAO_KEY = "JorderDAOImpl";
	
	@Override
	public List<Jorder> searchAllOrder(int jid) throws DAOException,
			JorderNotExist {
		//1.��������UserDAOImpl����
		JorderDAO jorderDAO = (JorderDAO)DAOFactory.newInstance(JORDER_DAO_KEY);
		//���ò�ѯ���ж�������
		List<Jorder> list = jorderDAO.queryAllOrder(jid);
		//�ж��û������Ƿ�Ϊ��
		if(list.size() == 0)
			throw new JorderNotExist("���û�û�ж���!");
		return list;
	}

	@Override
	public List<Jorder> queryOrderByIs_Val(int jid, int is_val)
			throws DAOException, JorderHasNotExist {
		//1.��������UserDAOImpl����
		JorderDAO jorderDAO = (JorderDAO)DAOFactory.newInstance(JORDER_DAO_KEY);
		//���ò�ѯ���ж�������
		List<Jorder> list = jorderDAO.queryOrderByIs_Val(jid, is_val);
		//�ж��Ƿ��ж���
		if(list.size() == 0)
			throw new JorderHasNotExist("û�ж���!");
		return list;
	}

	@Override
	public void addJorder(Jorder jorder) throws DAOException,JorderIsNull {
		//1.��������UserDAOImpl����
		JorderDAO jorderDAO = (JorderDAO)DAOFactory.newInstance(JORDER_DAO_KEY);
		//�ж�jorder�Ƿ�Ϊ��
		if(jorder == null){
			throw new JorderIsNull("����Ϊ��!");
		}
		//������Ӷ�������
		jorderDAO.addJorder(jorder);
	}

	@Override
	public void updateIs_valByJid(int orid, int is_val) throws DAOException,JorderIsNotExist {
		//1.��������UserDAOImpl����
		JorderDAOImpl jorderDAO = (JorderDAOImpl)DAOFactory.newInstance(JORDER_DAO_KEY);
		//���ò�ѯ��������
		Jorder jorder = jorderDAO.queryJorderByOrid(orid);
		//�ж��Ƿ��иö���
		if(jorder == null)
			throw new JorderIsNotExist("����������");
		//�����޸Ķ���״̬����
		jorderDAO.updateIs_valByJid(orid, is_val);
	}

}
