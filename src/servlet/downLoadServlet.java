package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/photoDL")
public class downLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到资源的路径
        String path = this.getServletContext().getRealPath("/jpg/1.jpg");
        //读取资源
        FileInputStream fileInputStream = new FileInputStream(path);
        //获取到文件名,路径在电脑上保存是\\形式的。
        String filename = path.substring(path.lastIndexOf("\\" + 1));
        //设置消息头，告诉浏览器，我要下载1.png这个图片
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        //把读取到的资源写给浏览器
        int len = 0;
        byte[] bytes = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len=fileInputStream.read(bytes))>0) {
            outputStream.write(bytes,0,len);
        }
        //关闭资源
        outputStream.close();
        fileInputStream.close();
    }
}
