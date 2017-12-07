package org.snowlive.crawler.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.snowlive.crawler.entity.ProxyIP;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Class For:
 *  切换代理,获取document
 *
 * @auther: 尹振坤
 * @date: 17-12-2
 */
public class JsoupProxyUtils {

    public static Document getDocByJsoup(String ip,int port,String href){
        Document doc = null;
        try {
            //设置代理
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));

            //链接
            URL url = new URL(href);
            HttpsURLConnection urlcon = (HttpsURLConnection)url.openConnection(proxy);
            urlcon.connect();         //获取连接

            BufferedReader buffer = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            StringBuffer bs = new StringBuffer();
            String l = null;

            while((l=buffer.readLine())!=null){
                bs.append(l);
            }
            System.out.println(bs.toString());
            doc = Jsoup.parse(bs.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;

    }
    //获取文件中的代理
    public static List<ProxyIP> getProxyIp() throws IOException {
        List<ProxyIP> ipList = new ArrayList<ProxyIP>();
        FileReader fr = new FileReader(new File("/home/snowlive/WorkPlace/IDEA/snowlive-crawler/src/main/resources/proxy.txt"));
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        ProxyIP ipTmp = null;
        String strs[] = new String[2];
        while (str != null) {
            str = br.readLine();
            if (str != null) {
                strs = str.split(":");
                ipTmp = new ProxyIP(strs[0], strs[1]);
                ipList.add(ipTmp);
            }
        }
//        ipList.forEach(ip -> System.out.println(ip.toString()));
        return ipList;
    }
}
