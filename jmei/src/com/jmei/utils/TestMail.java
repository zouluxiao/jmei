package com.jmei.utils;

public class TestMail {
	public static void main(String[] args) {
		String smtp = "smtp.163.com";// smtp������
		String from = "18274803901@163.com";// �ʼ���ʾ����
		String to = "854590736@qq.com";// �ռ��˵��ʼ���ַ����������ʵ��ַ
		String copyto = "";// �������ʼ���ַ
		String subject = "�����ʼ�";// �ʼ�����
		String content = "��ã�����Java���������ʼ������ٿ���������";// �ʼ�����
		String username = "18274803901@163.com";// ��������ʵ���˻���
		String password = "ghfu,2541";// ����������
		Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password);
	}
}
