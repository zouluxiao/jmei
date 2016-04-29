package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Activity;
import com.jmei.bean.Buser;
import com.jmei.dao.ActivityDAO;
import com.jmei.exception.ActivityExistException;
import com.jmei.exception.ActivityNotExistException;
import com.jmei.exception.DAOException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.ActivityService;
/**
 * @author �ӽ�
 * @date 2016-04-27
 **/
public class ActivityServiceImpl implements ActivityService {
	private  final String  KEY ="ActivityDAOImpl";
	
	public List<Activity> searchActivitys() throws DAOException,
			ActivityNotExistException {
                //1.��ȡDAO
		 ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ������Ʒ
		List<Activity> list = dao.queryByAll();
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new ActivityNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return list;
	}
		
	public Activity searchActivityByAcid(int acid) throws DAOException,
			ActivityNotExistException {
		//1.��ȡDAO
		 ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ������Ʒ
		Activity ac = dao.queryByAcid(acid);
		//3.�ж���Ʒ�Ƿ�Ϊ��
		if(ac == null)
			throw new ActivityNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return ac;
	}

	public Activity searchActivityByAcpic(String acpic) throws DAOException,
			ActivityNotExistException {
		//1.��ȡDAO
		 ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.��ѯ������Ʒ
		Activity ac = dao.queryByAcpic(acpic);
		//3.�ж�list�Ƿ�Ϊ��
		if(ac == null)
			throw new ActivityNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return ac;
	}

	public void addActivity(Activity activity) throws DAOException,
			ActivityExistException {
		//1.��ȡDAO
		ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯ��Ʒ����
		Activity ac = dao.queryByAcid(activity.getAcid());
		//3.�ж���Ʒ�Ƿ���� ������ڲ����쳣
		if(ac !=null)
			throw new ActivityExistException("��Ʒ�Ѵ���");
		//4.������Ʒ
		dao.inserActivity(activity);
	}
	public void updateByActivityInfo(int acid, String acpic, Buser bid)
			throws DAOException, ActivityNotExistException {
		//1.��ȡDAO
		ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.���ݲ��ز�ѯ��Ʒ
		Activity ac = dao.queryByAcid(acid);
		//3.�ж���Ʒ�Ƿ�Ϊ��
		if(ac == null)
			throw new ActivityNotExistException("��Ʒ�����ڣ�");
	    //4.������Ʒ��Ϣ
		ac.setAcpic(acpic);
        ac.setBuser(bid);
		
	}
	public void updateByActivityAcpic(String acpicPath, int acid)
			throws DAOException, ActivityNotExistException {
		//1.��ȡDAO
		ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.���ݲ��ز�ѯ��Ʒ
		Activity ac = dao.queryByAcid(acid);
		//3.�ж��Ƿ�Ϊ��
		if(ac == null)
			throw new ActivityNotExistException("��Ʒ�����ڣ�");
	    //4.������Ʒ��Ϣ
		ac.setAcpic(acpicPath);
		dao.updateActivity(ac);
	}
	public void removeActivity(int acid) throws DAOException,
			ActivityNotExistException {
		//1.��ȡDAO
		ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯ��Ʒ����
		Activity ac = dao.queryByAcid(acid);
		//3.�ж�ac�Ƿ���� ������ڲ����쳣
		if(ac ==null)
			throw new ActivityNotExistException("��Ʒ������");
		//4.������Ʒ��Ϣ
		dao.delete(acid);
	}
}
