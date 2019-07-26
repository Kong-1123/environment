package com.xdmd.environment.company.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("code")
public class CodeController {

    @PostMapping("checkCode")
    public void Code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        //创建一个图片，图片的学名叫做画布。
        //画布必须有高和宽以及图片类型
        int width = 120;//宽
        int height = 40;//高

        //第一次参数是宽，第二个参数是高，第三个参数是指图片类型：固定
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //开始画图必须有画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色
        g.setColor(Color.white);
        //画一个矩形的白色背景
        g.fillRect(0, 0, width, height);
        //设置画笔颜色
        g.setColor(Color.red);
        //画矩形的边框,坐标从0开始绘制边框
        g.drawRect(0, 0, width - 1, height - 1);
        //设置需要显示的字母shift+ctrl+x是大写shift+ctrl+y是小写
        String data = "ABCDEFGHIJKLMNOPQISTUVWXYZabcdefghijklmnopqistuvwxyz";
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        //连续填充4个字母到图片中
        for (int i = 1; i <= 4; i++) {
            //设置字母颜色
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            //设置字母的字体，样式，大小
            g.setFont(new Font("宋体", Font.BOLD, 30));

            //获取随机的字母或者数字
            String str= data.charAt(r.nextInt(data.length()))+"";
            //第一个参数是要绘制到图片上的字母，第二个参数字母所在的横坐标，第三个参数是纵坐标
            g.drawString(str, 10 + (i - 1) * 27, 30);

            sb.append(str);
        }

        //设置干扰线
        for (int i = 1; i <= 10; i++) {
            //两点连成一直线，每一个点都有一个坐标x1和y1代表起点的坐标，x2和y2代表终点的坐标
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
            //设置线条的颜色
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        }

        //把验证码存到cookie中
        Cookie cookie = new Cookie("check",sb.toString());
        cookie.setPath("/");
        cookie.setMaxAge(60);
        response.addCookie(cookie);


        //有了图片就需要将图片响应出去
        //第一个参数是图片对象，第二个参数是图片类型,第三个参数是输出方式：使用字节流
        ImageIO.write(image, "jpg", response.getOutputStream());

    }
}
