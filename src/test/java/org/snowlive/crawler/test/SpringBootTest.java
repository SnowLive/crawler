package org.snowlive.crawler.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.service.SchoolGuideBiz;
import org.snowlive.crawler.service.SchoolIndependentBiz;
import org.snowlive.crawler.service.SchoolMajorBiz;
import org.snowlive.crawler.service.SchoolPlanBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-29
 */
@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {

    @Autowired
    private SchoolMajorBiz schoolMajorBiz;

    @Autowired
    private SchoolGuideBiz schoolGuideBiz;

    @Autowired
    private SchoolPlanBiz schoolPlanBiz;

    @Autowired
    private SchoolIndependentBiz schoolIndependentBiz;


    public void testGetHTML(){
        System.out.println("共添加完成数据:"+ schoolMajorBiz.saveMajorSetting());
    }


    public void testGuide(){
//        System.out.println("已删除数据条数:" + schoolGuideBiz.deleteAll());
//        System.out.println("共添加完成数据:"+ schoolGuideBiz.saveSchoolGuide());
        System.out.println("共更新id数为:"+ schoolGuideBiz.updateSchoolId());
    }

    public void testMajor(){
        System.out.println("共更新major数:"+schoolMajorBiz.updateSchoolId());
    }

    public void savePlan(){
//        System.out.println("共删除数据:"+schoolPlanBiz.deleteAll());
        System.out.println("共添加完成数据:"+schoolPlanBiz.saveSchoolPlan());
    }

    @Test
    public void saveIndependent(){
//        System.out.println("共删除数据:"+schoolIndependentBiz.deleteAll());
        System.out.println("共添加数据:"+schoolIndependentBiz.insertIndependent());
    }





}
