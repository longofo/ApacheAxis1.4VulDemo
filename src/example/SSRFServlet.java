package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SSRFServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";


        try {
            String urlStr = req.getParameter("url");
            URL turl = new URL(urlStr);
            URL url = new URL(String.format("%s://%s:%s", turl.getProtocol(), turl.getHost(), turl.getPort()));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int status = conn.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            resp.getWriter().println("Status: " + status);
            resp.getWriter().println("Content:" + result);
        } catch (Exception e) {
            resp.getWriter().println("发送GET请求出现异常" + e);
            e.printStackTrace();
        }
    }
}
