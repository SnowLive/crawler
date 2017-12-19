package org.snowlive.crawler.test.test.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.service.SchoolIndependentBiz;
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
    private SchoolIndependentBiz schoolIndependentBiz;
    @Test
    public void updateGuide() {
        System.out.println("total delete info count:"+schoolIndependentBiz.deleteAll());
        System.out.println("total update info count:" + schoolIndependentBiz.insertIndependent());
    }



}
