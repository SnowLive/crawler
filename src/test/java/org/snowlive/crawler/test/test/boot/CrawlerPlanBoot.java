package org.snowlive.crawler.test.test.boot;

import com.xiaoleilu.hutool.http.Header;
import com.xiaoleilu.hutool.http.HttpRequest;
import org.junit.runner.RunWith;
import org.snowlive.crawler.common.GaoKaoqWebInfo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerPlanBoot {
    String url = "http://www.gaokaoq.com/college/plan/id/1.html";

    @org.junit.Test
    public void test() {
            String ip = "181" + "." + new Random().nextInt(254) + "." + new Random().nextInt(254) + "." + new Random().nextInt(254);
            String html = HttpRequest.get(url)
                    .header(Header.USER_AGENT, GaoKaoqWebInfo.USER_AGENT)
                    .header(Header.COOKIE, GaoKaoqWebInfo.COOKIE)
                    .header("X-Forwarded-For", ip)
                    .header("Cache-Control", "max-age=0")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .execute().body();
        System.out.println(html);
    }
}
