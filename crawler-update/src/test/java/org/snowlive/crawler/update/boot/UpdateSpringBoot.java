package org.snowlive.crawler.update.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.update.service.SchoolMajorBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UpdateSpringBoot {

    @Autowired
    private SchoolMajorBiz schoolMajorBiz;

    @Test
    public void test(){
        System.out.println("total update record count:"+schoolMajorBiz.updateMajor());

    }

}
