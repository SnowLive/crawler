package org.snowlive.crawler.test.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.entity.SchoolMajor;
import org.snowlive.crawler.mapper.SchoolMajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Class For:
 *  测试lombok
 *
 * @auther: 尹振坤
 * @date: 17-11-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLombok {

    @Autowired
    SchoolMajorMapper schoolMajorMapper;

    @Test
    public void letTestLomBok() {
        SchoolMajor schoolMajor = new SchoolMajor();
        schoolMajor.setId(1);
        schoolMajor.setCourseMajor("计科");
        schoolMajor.setSchoolName("河北工程大学");
        schoolMajor.setType("ESi");
        schoolMajor.setFocusMajor("计科");
        schoolMajor.setYear("2016");
        schoolMajor.setSpecialMajor("jike");
        schoolMajor.setLabMajor("jikeshiyanshi");
        System.out.println(schoolMajor.toString());
//        int result = schoolMajorMapper.insert(schoolMajor);
//        System.out.println(result);

    }
}
