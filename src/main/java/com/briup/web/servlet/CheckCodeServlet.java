package com.briup.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        //1.创建一个对象，在内存中图片(验证码的图片对象)
        int width = 80;
        int height = 30;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();//画笔对象
        //设置填充颜色为灰色
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = r.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);
            sb.append(ch);
            //2.3写验证码
            g.drawString(ch + "", width / 5 * i, height / 2);
        }
        String checkCode_ssesion = sb.toString();
        //将验证码存入session
        request.getSession().setAttribute("checkCode_ssesion", checkCode_ssesion);

        //2.4设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体大小
        g.setFont(new Font("黑体", Font.BOLD, 24));
        
        //向图片上写验证码
        g.drawString(checkCode_ssesion, 15, 25);
        
        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
