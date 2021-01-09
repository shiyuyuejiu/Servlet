package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hds")
public class headersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置头信息，告诉浏览器我回送的数据编码是utf-8的
//        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
//        resp.getOutputStream().write("设置头信息解决中文乱码问题".getBytes("UTF-8"));

        //获取到servletOutputStream对象
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        //使用meta标签模拟http消息头，告诉浏览器回送数据的编码和格式
        servletOutputStream.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
        servletOutputStream.write("使用html的标签模拟一个http消息头解决中文乱码问题".getBytes("UTF-8"));

    }
}
