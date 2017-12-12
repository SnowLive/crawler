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
    private int id = 738;


    @Override
    public int insertIndependent() {

        String url;
        int index;
        for (int i = 737; i < 3500; i++) {
            index = i + 1;
            url = UrlUtil.combinIndependentURL(index);
            handlerDoc(JsoupDoubleAntiCrawlerUtil.gethtml(url), index);
            System.out.println("i:" + i + " index:" + index + " count:" + count);
        }
        return count;
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
        Elements info = doc.select("div.the_eva");
        if (info.isEmpty()) return;
        SchoolIndependent schoolIndependent = new SchoolIndependent();
        schoolIndependent.setId(id);
        String schoolId = schoolInfoMapper.findSchoolIdById(index);
        schoolId = schoolId==null?String.valueOf(index):schoolId;
        schoolIndependent.setSchoolId(schoolId);
        schoolIndependent.setSchoolIndependentId(UUIDFactory.getUUID());
        schoolIndependent.setIndependent(info.text());
        count += schoolIndependentMapper.insert(schoolIndependent);
        id += 1;
    }
}
