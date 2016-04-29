package com.jmei.service;
import java.util.List;

import com.jmei.bean.Activity;
import com.jmei.bean.Buser;
import com.jmei.exception.ActivityExistException;
import com.jmei.exception.ActivityNotExistException;
import com.jmei.exception.DAOException;
/**
 * @author �ӽ�
 * @since 2016-04-27
 * ��ѡ����service�ӿ�
 */
public interface ActivityService {

	/**
	 * ��ȡ���е���Ʒ
	 * @return ��Ʒ�ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws ActivityNotExistException ��Ʒ�������쳣
	 */
	public List<Activity> searchActivitys()throws DAOException,ActivityNotExistException;
	/**
	 * ������Ʒ��� ��ȡ��Ʒ
	 * @param acid ��Ʒ���
	 * @throws DAOException ���ݿ��쳣
	 * @throwsActivityNotExistException ��Ʒ�������쳣
	 */
	public Activity searchActivityByAcid(int acid)throws DAOException,ActivityNotExistException;
	
	/**
	 * ������ƷͼƬ ��ȡ��Ʒ
	 * @param acpic ��Ʒ���
	 * @throws DAOException ���ݿ��쳣
	 * @throwsActivityNotExistException ��Ʒ�������쳣
	 */
	public Activity searchActivityByAcpic(String acpic)throws DAOException,ActivityNotExistException;

	/**
	 * �����Ʒ 
	 * @param activity ��Ʒ��Ϣ
	 * @throws DAOException ���ݿ��쳣
	 * @throws ActivityExistException  ��Ʒ�����쳣
	 */
	public void addActivity(Activity activity)throws DAOException,ActivityExistException;
	
    /**
     * �޸���Ʒ��Ϣ
     * @param acid ��Ʒ�ı��
     * @param acpic ��Ʒ��ͼƬ
     * @param bid ��Ʒ����ҵ
     * @throws DAOException ���ݿ��쳣
	 * @throws ActivityNotExistException  ��Ʒ�������쳣
     */
	public void updateByActivityInfo(int acid,String acpic,Buser bid)throws DAOException,ActivityNotExistException;
	
	/**
	 * �޸���Ʒ��ͼƬ
	 * @param acpicPath ͼƬ��·��
	 * @param acid  ��Ʒ��id
	 * @throws DAOException ���ݿ��쳣
	 * @throws ActivityNotExistException  ��Ʒ�������쳣
	 */
	public void updateByActivityAcpic(String acpicPath,int acid)throws DAOException,ActivityNotExistException;
	
	
	
	/**
	 * ɾ����Ʒ
	 * @param acid  ��Ʒ��id
	 * @throws DAOException ���ݿ��쳣
	 * @throws ProductNotExistException  ��Ʒ�������쳣
	 */
	public void removeActivity(int acid)throws DAOException,ActivityNotExistException;
	
}
