package org.snowlive.crawler.test;

import com.xiaoleilu.hutool.http.Header;
import com.xiaoleilu.hutool.http.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.snowlive.crawler.utils.UrlUtil;

import java.util.Random;

/**
 * Class For: 借鉴
 *
 * @auther: 尹振坤
 * @date: 17-12-2
 */
public class NewTest {

    private static final String USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0";
    private static final String COOKIE = "UM_distinctid=15f620b167d0-0f5b9099fc89a2-72236751-100200-15f620b167e297; CNZZDATA1255363830=60405890-1509173276-null%7C1509190370; Hm_lvt_fd9bf00761167d2e9689ba3d37779881=1509191205,1509192604,1509192609,1509192629; PHPSESSID=jk4iimib1banqqeuvbmuog0ee6; Hm_lpvt_fd9bf00761167d2e9689ba3d37779881=1509192680; w_phone=d76bpypD9w0f3s1vRktAhAKyDIsXY1Y4uIfTEQHKuOkdWYeBInaZow; w_password=9846nRmCLVnd59BUsj%2FMRXsdQItv91%2FO6Db2l2v%2BJmH4d4JVM3GGIt2Py2U; w_tobe=2f6aw%2FNH5kurzjK0CbGdvTNKlYQGoFQL6TVhyOs; w_liulan=1%2C%E5%8C%97%E4%BA%AC%E5%A4%A7%E5%AD%A6%2Ccollege2%2F5948cbfc5b57c.jpg*568%2C%E5%AE%9C%E6%98%A5%E5%AD%A6%E9%99%A2%2Ccollege2%2F5948cc5a34f25.jpg*569%2C%E8%82%87%E5%BA%86%E5%AD%A6%E9%99%A2%2Ccollege2%2F5948cc5a34f63.jpg";

    public void testMajor() {
        for (int i = 0; i < 598; i++) {
            int index = i + 1;
            String ip = "181" + "." + new Random().nextInt(254) + "." + new Random().nextInt(254) + "." + new Random().nextInt(254);
            String url = "http://www.gaokaoq.com/college/focusmajor/id/" + index + ".html";
            String html = HttpRequest.get(url)
                    .header(Header.USER_AGENT, USER_AGENT)
                    .header(Header.COOKIE, COOKIE)
                    .header("X-Forwarded-For", ip)
                    .header("Cache-Control", "max-age=0")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .execute().body();
            handleHtml_name(html);
        }

    }

    public void testGuide() {
        String ip = "181" + "." + new Random().nextInt(254) + "." + new Random().nextInt(254) + "." + new Random().nextInt(254);
        String url = "http://www.gaokaoq.com/college/guide/id/1263.html";
        String html = HttpRequest.get(url)
                .header(Header.USER_AGENT, USER_AGENT)
                .header(Header.COOKIE, COOKIE)
                .header("X-Forwarded-For", ip)
                .header("Cache-Control", "max-age=0")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .execute().body();
        handleHtml_test(html);
//        handleHtml_content(html);
    }




    /**
     * 获取名称
     *
     * @param html
     */
    private void handleHtml_name(String html) {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("div.the_eva");
        elements.forEach(element -> {
            System.out.println(element.ownText());
        });

    }

    public void handleHtml_test(String html) {
        Document doc = Jsoup.parse(html);
        Elements ulList = doc.select("ul.guide-list.left li.clearfix");
        System.out.println(ulList.size());
        ulList.forEach(ul -> {
            System.out.print(ul.select("a").text());
            System.out.print(ul.select("a").attr("href"));
            System.out.println(ul.select("span").text());
        });
    }

    public void handleHtml_content(String html) {
        Document doc = Jsoup.parse(html);
        Elements contentList = doc.select("div.the_eva");
        System.out.println(contentList.text());
    }



}
