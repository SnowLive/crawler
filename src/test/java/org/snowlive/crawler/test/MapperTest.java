package org.snowlive.crawler.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.entity.SchoolGuide;
import org.snowlive.crawler.entity.SchoolMajor;
import org.snowlive.crawler.entity.SchoolPlan;
import org.snowlive.crawler.mapper.SchoolGuideMapper;
import org.snowlive.crawler.mapper.SchoolMajorMapper;
import org.snowlive.crawler.mapper.SchoolPlanMapper;
import org.snowlive.crawler.mapper.TestJsonMapper;
import org.snowlive.crawler.pojo.*;
import org.snowlive.crawler.utils.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    private SchoolMajorMapper schoolMajorMapper;

    @Autowired
    private SchoolGuideMapper schoolGuideMapper;

    @Autowired
    private SchoolPlanMapper schoolPlanMapper;

    @Autowired
    private TestJsonMapper testJsonMapper;


    @Test
    public void testSchoolPlanMapper() {

        schoolPlanMapper.deleteAll();

        SchoolPlan schoolPlan = new SchoolPlan();
        schoolPlan.setId(1);
        schoolPlan.setSchoolId(1);
        schoolPlan.setSchoolPlanId(UUIDFactory.getUUID());

        //datajson->yearjson->major->datajson->planjson
        //        {data:[{year,major:{liberal,science:{data:[]
        PlanJson planJsonObj = new PlanJson();
        planJsonObj.setMajor_name("snowlive");
        planJsonObj.setPlan_type("统招");
        planJsonObj.setPlan_count(12);
        planJsonObj.setCollege_system("四年制");
        planJsonObj.setBatch("本特");

        List<PlanJson> planJsonList = new ArrayList<PlanJson>(20);//最底部数据

        //添加数据
        planJsonList.add(planJsonObj);


        DataJson<PlanJson> planJsonMajors = new DataJson<>();
        planJsonMajors.setCount(1);
        planJsonMajors.setData(planJsonList);

        //set major
        PlanMajorJson planMajorJson = new PlanMajorJson();

        planMajorJson.setLiberal(planJsonMajors);//set 文科
        planMajorJson.setScience(planJsonMajors);//set 理科

        schoolPlan.setPlan(planJsonObj.toString());

        DataJson<PlanYearJson> planYear = new DataJson<>();
        List<PlanYearJson> planYearList = new ArrayList<>();
        PlanYearJson planYearJson = new PlanYearJson();
        planYearJson.setYear("2017");
        planYearJson.setMajor(planMajorJson);

        planYearList.add(planYearJson);
        planYear.setData(planYearList);
        planYear.setCount(1);
        schoolPlan.setUsedPlan(planYear.toString());
        System.out.println(planYear.toString());

        schoolPlanMapper.insert(schoolPlan);
    }


    public void testSchoolMajorMapper() {
        SchoolMajor major = new SchoolMajor(1, "schoolid", "snowlive",
                "snowlive", "snowlive", "snowlive", "snowlive", "snowlive",
                "snowlive", "snowlive", "{}", 1, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        System.out.println(major);
        schoolMajorMapper.insert(major);

    }

    public void testSchoolGuideMapper() {
        SchoolGuide schoolGuide = new SchoolGuide();
        schoolGuide.setId(2);
        schoolGuide.setSchoolGuideId("1");
        schoolGuide.setSchoolId("1");
        schoolGuide.setTitle("snowlive");
        schoolGuide.setContent("snowlive");
        schoolGuide.setPublishTime(new Timestamp(System.currentTimeMillis()));

        List<String> usedGuideList = new ArrayList<String>(8);
        usedGuideList.add("{\"snowlive\":\"snowlive\"}");
        usedGuideList.add("{\"snowlive\":\"snowlive\"}");
        usedGuideList.add("{\"snowlive\":\"snowlive\"}");
        usedGuideList.add("{\"snowlive\":\"snowlive\"}");
        usedGuideList.add("{\"snowlive\":\"snowlive\"}");
        usedGuideList.add("{\"snowlive\":\"snowlive\"}");
        usedGuideList.add("{\"snowlive\":\"snowlive\"}");
        usedGuideList.add("{\"snowlive\":\"snowlive\"}");
        System.out.println(usedGuideList);
        System.out.println(usedGuideList.toString());
        //可上传json格式setUsedGuide("{\"snowlive\":\"snowlive\"}")
        schoolGuide.setUsedGuide(usedGuideList.toString());
        System.out.println(schoolGuideMapper.insert(schoolGuide));
        ;
    }

    public void testJson() {
        //创建dataJson 存储usedGuide;
        DataJson<UsedGuide> dataJson = new DataJson<UsedGuide>();
        List<UsedGuide> usedGuideList = new ArrayList<UsedGuide>(8);
        usedGuideList.add(new UsedGuide("snowlive", "snowlive", Timestamp.valueOf("2017-10-10 12:12:12")));
        dataJson.setData(usedGuideList);
        dataJson.setCount(usedGuideList.size());

        //核心添加数据区域.
        SchoolGuide schoolGuide = new SchoolGuide();
        schoolGuide.setId(2);
        schoolGuide.setSchoolGuideId("1");
        schoolGuide.setSchoolId("1");
        schoolGuide.setTitle("snowlive");
        schoolGuide.setContent("snowlive");
        schoolGuide.setUsedGuide(dataJson.toString());

        System.out.println(dataJson);
        schoolGuide.setPublishTime(new Timestamp(System.currentTimeMillis()));

        schoolGuideMapper.insert(schoolGuide);
    }
}