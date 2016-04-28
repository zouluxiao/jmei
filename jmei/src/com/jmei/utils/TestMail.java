package com.jmei.utils;

public class TestMail {
	public static void main(String[] args) {
		String smtp = "smtp.163.com";// smtp服务器
		String from = "18274803901@163.com";// 邮件显示名称
		String to = "854590736@qq.com";// 收件人的邮件地址，必须是真实地址
		String copyto = "";// 抄送人邮件地址
		String subject = "测试邮件";// 邮件标题
		String content = "你好！这是Java程序发来的邮件，东少卡，哈哈哈";// 邮件内容
		String username = "18274803901@163.com";// 发件人真实的账户名
		String password = "ghfu,2541";// 发件人密码
		Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password);
	}
}
