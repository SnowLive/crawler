package org.snowlive.crawler.service.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.snowlive.crawler.entity.SchoolPlan;
import org.snowlive.crawler.mapper.SchoolPlanMapper;
import org.snowlive.crawler.pojo.PlanUrlInfo;
import org.snowlive.crawler.service.SchoolPlanBiz;
import org.snowlive.crawler.utils.JsoupDoubleAntiCrawlerUtil;
import org.snowlive.crawler.utils.PlanUtil;
import org.snowlive.crawler.utils.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-10
 */
@Service
public class SchoolPlanBizImpl implements SchoolPlanBiz {

    @Autowired
    private SchoolPlanMapper schoolPlanMapper;
    private int count = 0;
    private int id = 1;


    @Override
    public int saveSchoolPlan() {

        int index;
        String url;
        for (int i = 0; i < 3500; i++) {
            index = i + 1;
            url = "`http://www.gaokaoq.com/college/plan?id={college_id}&city_id={default-city_id}&type={major_type}&year={year}`";
            Document doc = JsoupDoubleAntiCrawlerUtil.gethtml(url);
            handlerDoc(doc, index);
            System.out.println("i:" + i + " index:" + index + " count:" + count);
        }

        return count;
    }


    private void handlerDoc(Document doc, int index) {
        // check doc.select().isempty?return:go ahead;
        Elements planEles = doc.select("div.sco_list tr");
        planEles.remove(planEles.first());//去表头
        if (planEles.first().select("td").text()
                .equals("未找到符合条件的数据，可能是该校在该省无招生或数据录入中")) return;
        // 数据的解析,解析成DataJson<PlanJson> plan
        // 1.顶部创建对象进行封装,需设置 id,schoolid,schooplanid,plan,usedplan
        SchoolPlan schoolPlan = new SchoolPlan();
        schoolPlan.setId(id);
        schoolPlan.setSchoolId(index);
        schoolPlan.setSchoolPlanId(UUIDFactory.getUUID());
        schoolPlan.setYear("2017");
        // 2.设置plan planMajorJson
        schoolPlan.setPlan(PlanUtil.getMajorJson(new PlanUrlInfo(index)).toString());
        schoolPlan.setUsedPlan(PlanUtil.getUsedPlan(new PlanUrlInfo(index)).toString());
        // 数据添加
        id += schoolPlanMapper.insert(schoolPlan);
    }


    @Override
    public int deleteAll() {
        return schoolPlanMapper.deleteAll();
    }
}