package org.snowlive.crawler.service.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.snowlive.crawler.entity.SchoolGuide;
import org.snowlive.crawler.mapper.SchoolGuideMapper;
import org.snowlive.crawler.pojo.DataJson;
import org.snowlive.crawler.pojo.UsedGuide;
import org.snowlive.crawler.service.SchoolGuideBiz;
import org.snowlive.crawler.utils.JsonStrUtil;
import org.snowlive.crawler.utils.JsoupDoubleAntiCrawlerUtil;
import org.snowlive.crawler.utils.UUIDFactory;
import org.snowlive.crawler.utils.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Class For:
 * 学校招生章程.
 * 具体实现逻辑
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
@Service
public class SchoolGuideBizImpl implements SchoolGuideBiz {

    private int count = 0;
    private static final String URL_GAOKAOQ = "http://www.gaokaoq.com";

    @Autowired
    private SchoolGuideMapper schoolGuideMapper;

    @Override
    public int saveSchoolGuide() {
        //todo attention delete
//        System.out.println("已删除数据条数:" + schoolGuideMapper.deleteAll());
        String url;
        int index;
//        for (int i = 0; i < 3500; i++) {
//        i:733 index:734 count:23
        for (int i = 734; i < 3500; i++) {
//        for (int i = 1383; i < 3500; i++) {

            index = i + 1;
            url = "http://www.gaokaoq.com/college/guide/id/" + index + ".html";
            Document doc = JsoupDoubleAntiCrawlerUtil.gethtml(url);
            handleDoc(doc, index);
            System.out.println("i:" + i + " index:" + index + " count:" + count);
        }
        return count;
    }

    /**
     * 数据处理.
     *
     * @param doc
     */
    private void handleDoc(Document doc, int index) {
        if (doc.select("ul.guide-list.left").isEmpty()) return;
        //1.创建整体对象,分别讲可以直接封装的数据进行封装.
        SchoolGuide schoolGuide = new SchoolGuide();
        schoolGuide.setId(index);
        schoolGuide.setSchoolId(String.valueOf(index));
        schoolGuide.setSchoolGuideId(UUIDFactory.getUUID());
        // 仍需设置 title,content,usedGuide,publishTime
        /**
         * 1.获取第一个元素
         */
        Elements ulList = doc.select("ul.guide-list.left li.clearfix");
        if (!ulList.isEmpty()) {
            //保存当年招生章程.
            Element currentGuideEle = ulList.first();
            schoolGuide.setTitle(JsonStrUtil.replaceSpcialChar(currentGuideEle.select("a").text()));
            schoolGuide.setPublishTime(Timestamp.valueOf(currentGuideEle.select("span").text()));
            schoolGuide.setContent(JsoupDoubleAntiCrawlerUtil.getContent("div.the_eva",
                    UrlUtil.addPrefix(URL_GAOKAOQ, currentGuideEle.select("a").attr("href"))));
            ulList.remove(currentGuideEle);
            // 2.select 获取需要解析的专业.
            schoolGuide.setUsedGuide(praseUsedGuide(ulList));
        }
//        System.out.println(schoolGuide.getUsedGuide());//todo print usedguide
        //3.数据保存.
        count += schoolGuideMapper.insert(schoolGuide);
    }

    /**
     * 获取datajson数据
     *
     * @param ulList
     * @return
     */
    private String praseUsedGuide(Elements ulList) {
        DataJson<UsedGuide> dataJson = new DataJson<UsedGuide>();
        if (ulList.isEmpty()) return "{}";
        List<UsedGuide> usedGuideList = new ArrayList<UsedGuide>(ulList.size());
        UsedGuide tempGuide = null;
        for (Element cGuideEle : ulList) {
            tempGuide = new UsedGuide();
            tempGuide.setTitle(JsonStrUtil.replaceSpcialChar(cGuideEle.select("a").text()));
            tempGuide.setPublishTime(Timestamp.valueOf(cGuideEle.select("span").text()));
            tempGuide.setContent(JsoupDoubleAntiCrawlerUtil.getContent("div.the_eva",
                    UrlUtil.addPrefix(URL_GAOKAOQ, cGuideEle.select("a").attr("href"))));
            usedGuideList.add(tempGuide);
        }
        dataJson.setData(usedGuideList);
        return dataJson.toString();
    }
}
