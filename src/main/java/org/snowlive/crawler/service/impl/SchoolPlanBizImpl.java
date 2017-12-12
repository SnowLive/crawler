package org.snowlive.crawler.service.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.snowlive.crawler.entity.SchoolPlan;
import org.snowlive.crawler.mapper.SchoolInfoMapper;
import org.snowlive.crawler.mapper.SchoolPlanMapper;
import org.snowlive.crawler.pojo.PlanUrlInfo;
import org.snowlive.crawler.service.SchoolPlanBiz;
import org.snowlive.crawler.utils.JsoupDoubleAntiCrawlerUtil;
import org.snowlive.crawler.utils.PlanUtil;
import org.snowlive.crawler.utils.UUIDFactory;
import org.snowlive.crawler.utils.UrlUtil;
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

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;
    private int count = 0;
    private int id = 1;

    @Override
    public int saveSchoolPlan() {
//        i:3375 index:3376 count:1109
        int index;
        for (int i = 0; i < 3378; i++) {
            index = i + 1;
            Document doc = JsoupDoubleAntiCrawlerUtil.gethtml(UrlUtil.combinPlanURL(new PlanUrlInfo(index)));
            handlerDoc(doc, index);
            System.out.println("i:" + i + " index:" + index + " count:" + count);

//            if (i == 19) break;
        }

        return count;
    }


    private void handlerDoc(Document doc, int index) {

        SchoolPlan schoolPlan = new SchoolPlan();
        schoolPlan.setId(id);
        String schoolId = schoolInfoMapper.findSchoolIdById(index);
        if(schoolId==null) return;
        schoolPlan.setSchoolId(schoolId);
        schoolPlan.setSchoolPlanId(UUIDFactory.getUUID());

        // check doc.select().isempty?return:go ahead;
        Elements planEles = doc.select("div.sco_list tr");
        if(planEles.isEmpty()) return;
        planEles.remove(planEles.first());//去表头
        if (!planEles.first().select("td").text()
                .equals("未找到符合条件的数据，可能是该校在该省无招生或数据录入中")) {
            System.out.println("可以解析");
            // 数据的解析,解析成DataJson<PlanJson> plan
            // 1.顶部创建对象进行封装,需设置 id,schoolid,schooplanid,plan,usedplan
            schoolPlan.setYear("2017");
            // 2.设置plan planMajorJson
            schoolPlan.setPlan(PlanUtil.getMajorJson(new PlanUrlInfo(index)).toString());
            schoolPlan.setUsedPlan(PlanUtil.getUsedPlan(new PlanUrlInfo(index)).toString());
//        System.out.println(schoolPlan.getUsedPlan());
//        System.out.println(schoolPlan.getPlan());
        }
        // 数据添加
        id += schoolPlanMapper.insert(schoolPlan);
        count++;
    }


    @Override
    public int deleteAll() {
        return schoolPlanMapper.deleteAll();
    }
}
