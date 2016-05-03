package com.jmei.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class verifyServlet extends HttpServlet {

	private static int imageLength = 4;// ��֤��λ��

	private static int imageWidth = 60;// ͼƬ���

	private static int imageheight = 20;// ͼƬ�߶�

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Pragma", "No-cache");

		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		// 1.���ڴ��д���һ��ͼƬ
		BufferedImage img = new BufferedImage(imageWidth, imageheight,
				BufferedImage.TYPE_INT_RGB);
		// 2.��ȡ����
		Graphics g = img.getGraphics();
		// ���������
		Random randon = new Random();
		// ���ñ�����ɫ
		g.setColor(getRandColor(200, 250));

		g.fillRect(0, 0, imageWidth, imageheight);

		// ��������
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		// ���߿�
		g.setColor(new Color(20, 20, 20));
		g.drawRect(0, 0, imageWidth - 1, imageheight - 1);

		// �������������
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = randon.nextInt(imageWidth);
			int y = randon.nextInt(imageheight);
			int xl = randon.nextInt(12);
			int yl = randon.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// ���������֤��
		String sRand = "";
		for (int i = 0; i < imageLength; i++) {
			String rand = String.valueOf(randon.nextInt(10));
			sRand += rand;
			// ����֤����ʾ��ͼƬ��
			g.setColor(new Color(20 + randon.nextInt(110), 20 + randon
					.nextInt(110), 20 + randon.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 16);
		}
		//req.getSession().getAttribute("check");
		req.getSession().setAttribute("check", sRand);
		// ͼ����Ч
		g.dispose();
		// ��������������
		OutputStream os = resp.getOutputStream();

		ImageIO.write(img, "jpg", os);

	}

	private Color getRandColor(int i, int j) {
		Random randon = new Random();
		if (i > 255) {
			i = 255;
		}
		if (j > 255) {
			j = 255;
		}
		int r = i + randon.nextInt(j - i);
		int g = i + randon.nextInt(j - i);
		int b = i + randon.nextInt(j - i);
		return new Color(r, g, b);
	}

}
