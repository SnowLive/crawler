package org.snowlive.crawler.test.info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.service.SchoolMajorBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MajorInfo {
    @Autowired
    SchoolMajorBiz schoolMajorBiz;

    @Test
    public void getMajorInfo(){
    }

}
