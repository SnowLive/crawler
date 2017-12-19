package org.snowlive.crawler.test.test.test;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.snowlive.crawler.utils.JsoupDoubleAntiCrawlerUtil;

/**
 * Class For: 借鉴
 *
 * @auther: 尹振坤
 * @date: 17-12-2
 */
public class NewTest {

    @Test
    public void test(){
        Document doc = JsoupDoubleAntiCrawlerUtil.gethtml("http://www.gaokaoq.com/college/plan/id/1.html");
        System.out.println(doc.select(".e_name").text().replace("关注",""));
    }
}
