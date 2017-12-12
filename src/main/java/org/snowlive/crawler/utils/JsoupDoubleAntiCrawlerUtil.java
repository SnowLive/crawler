package org.snowlive.crawler.utils;

import com.xiaoleilu.hutool.http.Header;
import com.xiaoleilu.hutool.http.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

/**
 * Class For:
 * 采用ip欺骗方式进行jsoup数据爬取的jsoup工具.
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
public class JsoupDoubleAntiCrawlerUtil {

    private static final String USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0";
    private static final String COOKIE = "PHPSESSID=m44d8hrohbuo4k1meemdomfl36; w_upp=76c4OrYqK9%2BDhilXfB2WgNg9NOTpgoC6T5traajFkMBW4wgBD%2BGr9g-3a40vPXOdIJPjFCfqMeQl4qoYf4pqDD6QJxdFVvFkGoPA5%2FK979IiHiunw-e0623i25If1dlQUj6F2ZlwR4mCaTUbrCW75kH5w; Hm_lvt_fd9bf00761167d2e9689ba3d37779881=1512636021,1512648667,1512651407,1512733426; Hm_lpvt_fd9bf00761167d2e9689ba3d37779881=1512735915;Host:www.gaokaoq.com";

    /**
     * 请求url获取html结果集
     * 获取不同页面不同排版的专业集合。
     *
     * @param url 链接
     * @return
     */
    public static Document gethtml(String url) {
        String ip = IpUtil.getRandomIp();
        if (url.equals("")) return null;
        String result = "";
        try {
            result = HttpRequest.get(url)
                    .header(Header.USER_AGENT, USER_AGENT)
                    .header(Header.COOKIE, COOKIE)
                    .header("X-Forwarded-For", ip)
                    .header("Cache-Control", "max-age=0")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .execute().body();
        } catch (Exception e) {
            System.out.println("发送请求失败:" + e.getMessage());
        }
        System.out.println("jdac:"+result.substring(0, 2));
        return Jsoup.parse(result);
    }

    /**
     * 通过url ,selectMod 进行resultStr返回.
     *
     * @param url
     * @param selectMod
     * @return
     */
    public static String getContent(String selectMod, String url) {
//        return gethtml(url).select(selectMod).text().replace("\\","\\\\").replace("\"","\\\"");
//        return gethtml(url).select(selectMod).text();
        return JsonStrUtil.replaceSpcialChar(gethtml(url).select(selectMod).text());
    }

    public static Elements getElements(String selectMod, String url) {
        return gethtml(url).select(selectMod);
    }

    @Test
    public void test() {
        System.out.println(getContent("div.the_eva", "http://www.gaokaoq.com/college/guideview/id/1/rid/22254.html"));
    }


}
