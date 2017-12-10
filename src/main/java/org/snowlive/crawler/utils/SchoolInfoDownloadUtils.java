package org.snowlive.crawler.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Class For:
 *      json数据数据
 * @auther: 尹振坤
 * @date: 17-11-22
 */
public class SchoolInfoDownloadUtils {

    /**
     * 下载schools sort info
     * @param path url路径
     * @return schools sort info json (String)
     */
    public static String download(String path) {
        // 创建一个字符串缓冲对象
        StringBuffer sbf = new StringBuffer();
        try {
            // 将 地址字符串转换成URL对象
            URL url = new URL(path);
            // 通过url的open方法 打开链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // GET POST
            // 将请求形式设置为 GET
            conn.setRequestMethod("GET");
            // 将读取超时时间设置为 3s
            conn.setReadTimeout(3000);
            // 将连接超时时间设置为 3s
            conn.setConnectTimeout(3000);
            // 设置连接请求的浏览器标识
            conn.setRequestProperty(
                    "User-agent",
                    "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");
            // 发起请求连接
            conn.connect();
            // 得到服务器返回的字节流
            InputStream is = conn.getInputStream();// 字节流
            // 字节流---字符流----字符串
            // 将字节流逐渐包装成 缓冲字符流 并把字符编码设置为UTF-8
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "UTF-8"));
            // 定义每次读取一行的String对象
            String strRead = null;
            // 循环读取数据 每次读取一行 并把读到的数据交给sbf
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            // 关闭流的连接
            reader.close();
            // 断开链接
            conn.disconnect();

            // 将从服务器得到的String数据返回
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sbf.toString();
    }
}
