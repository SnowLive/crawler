package org.snowlive.crawler.service.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.snowlive.crawler.entity.SchoolIndependent;
import org.snowlive.crawler.mapper.SchoolIndependentMapper;
import org.snowlive.crawler.mapper.SchoolInfoMapper;
import org.snowlive.crawler.service.SchoolIndependentBiz;
import org.snowlive.crawler.utils.JsoupDoubleAntiCrawlerUtil;
import org.snowlive.crawler.utils.UUIDFactory;
import org.snowlive.crawler.utils.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-12
 */
@Service
public class SchoolIndependentBizImpl implements SchoolIndependentBiz {


    @Autowired
    private SchoolIndependentMapper schoolIndependentMapper;

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    private int count = 0;
    //    i:736 index:737 count:737
    private int id = 1;


    @Override
    public int insertIndependent() {
        handlerInfo(0,3410);
        return count;
    }

    private void handlerInfo(int start,int end) {
        String url;
        int index;
        for (int i = start; i < end; i++) {
            index = i + 1;
            url = UrlUtil.combinIndependentURL(index);
            handlerDoc(JsoupDoubleAntiCrawlerUtil.gethtml(url), index);
            System.out.println("i:" + i + " index:" + index + " count:" + count);
        }
    }


    @Override
    public int deleteAll() {
        return schoolIndependentMapper.deleteAll();
    }


    /**
     * 事务处理方法
     *
     * @param doc Document.
     */
    private void handlerDoc(Document doc, int index) {
        //1.跳转到其他页面了,则select('div.the_eva').isempty,return;
        String schoolName = doc.select(".e_name").text().replace("关注", "");
        System.out.println("schoolName:"+schoolName);
        String schoolId = schoolInfoMapper.findSchoolIdByName(schoolName);
        System.out.println(schoolId);

        Elements info = doc.select("div.the_eva");

        if (info.isEmpty()) return;
        SchoolIndependent schoolIndependent = new SchoolIndependent();

        schoolIndependent.setId(id);
        schoolIndependent.setSchoolId(schoolId);
        schoolIndependent.setSchoolIndependentId(UUIDFactory.getUUID());

        schoolIndependent.setIndependent(info.toString());
        count += schoolIndependentMapper.insert(schoolIndependent);
        id += 1;
    }
}
