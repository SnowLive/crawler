package org.snowlive.crawler.update.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.update.entity.master.SchoolMajor;
import org.snowlive.crawler.update.mapper.crawler.IdCollegeCrawlerMapper;
import org.snowlive.crawler.update.mapper.master.SchoolMajorMapper;
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
public class TestSprintBoot {

    @Autowired
    private IdCollegeCrawlerMapper idCollegeCrawlerMapper;

    @Autowired
    private SchoolMajorMapper schoolMajorMapper;

    @Test
    public void test(){
        SchoolMajor major = new SchoolMajor();
        major.setSchoolId("snowlive");
        major.setId(1);
        schoolMajorMapper.updateSchoolId(major);
    }

}
