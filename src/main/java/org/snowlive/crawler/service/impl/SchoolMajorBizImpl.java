package org.snowlive.crawler.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.snowlive.crawler.entity.SchoolMajor;
import org.snowlive.crawler.service.SchoolMajorBiz;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Class For:
 * jsoup 爬取数据
 *
 * @auther: 尹振坤
 * @date: 17-12-1
 */
@Service("SchoolMajorBiz")
public class SchoolMajorBizImpl implements SchoolMajorBiz {

    @Override
    public List<SchoolMajor> getSchoolMajorList() {
        Document doc = null;
        try {
            doc = Jsoup.connect("www.gaokaoq.com/college/focusmajor/id/1").get();
        } catch (IOException e) {
            System.out.println("data read exception");
        }
        System.out.println(doc);

        return null;
    }

    @Override
    public int insertSchoolMajorList(List<SchoolMajor> schoolMajorList) {
        return 0;
    }
}
