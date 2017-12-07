package org.snowlive.crawler.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.service.SchoolGuideBiz;
import org.snowlive.crawler.service.SchoolMajorBiz;
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


//    @Test
    public void testGetHTML(){
        System.out.println("共添加完成数据:"+ schoolMajorBiz.saveMajorSetting());
    }
    @Test
    public void testGuide(){
        System.out.println("共添加完成数据:"+ schoolGuideBiz.saveSchoolGuide());
    }


}
