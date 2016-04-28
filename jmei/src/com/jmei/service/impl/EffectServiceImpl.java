package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Effect;
import com.jmei.dao.EffectDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.EffectExistException;
import com.jmei.exception.EffectNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.EffectService;
/**
 * EffectService�ӿ�ʵ����
 * @since 2016-04-27
 * @author ����
 * **/
public class EffectServiceImpl implements EffectService {
	private  final String  KEY ="EffectDAOImpl";
	//��ӹ�Ч
	public void addEffect(Effect effect) throws DAOException,
			EffectExistException {
		//1.��ȡDAO
		EffectDAO dao = (EffectDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯ��Ч
		Effect e = dao.queryById(effect.getEid());
		//3.�ж�e�Ƿ���� ������ڲ����쳣
		if(e !=null)
			throw new EffectExistException("��Ч�Ѵ���");
		//4.���빦Ч��Ϣ
		dao.insertEffect(effect);		
	}

	//ɾ����Ч
	public void removeEffect(int eid) throws DAOException,
			EffectNotExistException {
		//1.��ȡDAO
		EffectDAO dao = (EffectDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯ��Ч����
		Effect e = dao.queryById(eid);
		//3.�ж�e�Ƿ���� ������ڲ����쳣
		if(e ==null)
			throw new EffectNotExistException("��Ч������");
		//4.ɾ����Ч��Ϣ
		dao.deleteEffect(eid);
	}

	//���¹�Ч��Ϣ
	public void updateByEffectInfo(int eid, String ename) throws DAOException,
			EffectNotExistException {
		//1.��ȡDAO
		EffectDAO dao = (EffectDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯ��Ч
		Effect e = dao.queryById(eid);
		//3.�ж�e�Ƿ�Ϊ��
		if(e == null)
			throw new EffectNotExistException("��Ч�����ڣ�");
	    //4.���¹�Ч��Ϣ
		e.setEname(ename);
		dao.updateEffect(e);
	}

	//��ѯ���й�Ч
	public List<Effect> searchAllEffect() throws DAOException,
			EffectNotExistException {
		//1.��ȡDAO
		EffectDAO dao = (EffectDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ���й�Ч
		List<Effect> list = dao.queryAllEffect();
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new EffectNotExistException("��Ч�����ڣ�");
		//4.���ع�Ч��Ϣ
	    return list;
	}

}
