package org.snowlive.crawler.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snowlive.crawler.entity.SchoolGuide;
import org.snowlive.crawler.entity.SchoolMajor;
import org.snowlive.crawler.mapper.SchoolGuideMapper;
import org.snowlive.crawler.mapper.SchoolMajorMapper;
import org.snowlive.crawler.mapper.TestJsonMapper;
import org.snowlive.crawler.pojo.DataJson;
import org.snowlive.crawler.pojo.UsedGuide;
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
    private TestJsonMapper testJsonMapper;

    //    @Test
    public void testSchoolMajorMapper() {
        SchoolMajor major = new SchoolMajor(1, "schoolid", "snowlive",
                "snowlive", "snowlive", "snowlive", "snowlive", "snowlive",
                "snowlive", "snowlive", "{}", 1, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        System.out.println(major);
        schoolMajorMapper.insert(major);

    }

    //    @Test
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

    /**
     * datajson is ok!
     */
//    @Test
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

    @Test
    public void testJsoninsert() {

        //创建dataJson 存储usedGuide;
        //第十条录取规则：执行教育部和各省制定的录取政策和有关规定。 第十一条报考艺术类专业的考生，专业成绩以所在省统考成绩为准。考生文化考试和专业考试成绩均上线的情况下，按专业成绩从高分到低分择优录取；专业成绩相同时，按文考成绩从高分到低分择优录取。 第十二条执行各省制定的加分和降分录取政策。 第十三条体检限制：各专业考生的体检均按教育部等有关部门制定的《普通高等学校招生体检工作指导意见》执行。服装系、纺织系要求色觉正常，手脚功能正常。如有身体条件不符合所报读专业要求的，可调整到相近的专业录取。 第十四条各专业招生均不设男、女生比例的限制。 第十五条外语语种不限。   第六章录取查询 第十六条录取的新生将在招生所在省、市、自治区高招办网站网站和我校网站（http://www.qzfzfz.com/zsw.asp?id=29）上公布，最终录取结果以收到的录取通知书为准。   第七章收费标准 第十七条2015年我校各专业学费收费标准，按物价主管部门批准{闽价费[2011]270号（根据闽政2012上调）}及学校最终确定公布标准执行，退费办法按闽价〔2006〕费154号文件执行。   第八章学历文凭 第十八条颁发证书校名：泉州纺织服装职业学院 。 第十九条学历证书种类：对在校修满教学计划规定课程学分的学生，颁发给普通高等学校全日制专科毕业证书。毕业证书可在中国高等教育学生信息网上查询认证。    第九章奖、助学金的设定 第二十条根据国家有关规定，实行奖学金制度，符合条件的优秀学生可享受国家奖学金8000元/年、国家励志奖学金5000元/年；符合条件的贫困生、特困生可享受国家助学金，每人每月可领取250、400元，一年按10个月计算。 第二十一条学院为经济困难的学生提供学生勤工俭学岗位。 第二十二条学院纺织染整类、服装加工与管理类、酒店管理类的困难学生，由合作企业提供学费资助（需签定三方协议）。 第二十三条新生入学时，贫困生可在生源地申请办理生源地信用助学贷款，按国家政策由考生生源地负责解决。   第十章附  则 第二十四条本章程如有与国家和省有关部门制定的政策相抵触之处，以国家和省有关部门制定的政策为准。 第二十五条本章程由泉州纺织服装职业学院负责解释。 第二十六条联系方式 联系人：林老师、刘老师 联系电话：0595-88718066 投诉电话：0595-88738066 传    真：0595-88701679 网    址：http://www.qzfzfz.com 咨询QQ： 626064513、110979338 邮    箱：626064513@qq.com  
        String str = "{\n" +
                "      \"content\": \"教育部备案的具有独立颁发高等教育文凭资格和具有鲜明办学特色的全日制普通高等院校，面向全国招生。学院坐落于国务院首批历史文化名城、中国首个东亚文化之都、海上丝绸之路起点、\"\n" +
                "}";

        //核心添加数据区域.
        SchoolGuide schoolGuide = new SchoolGuide();
        schoolGuide.setId(2);
        schoolGuide.setSchoolGuideId("1");
        schoolGuide.setSchoolId("1");
        schoolGuide.setTitle("snowlive");
        schoolGuide.setContent("snowlive");
        schoolGuide.setUsedGuide(str);
        System.out.println(str);
        schoolGuide.setPublishTime(new Timestamp(System.currentTimeMillis()));
        schoolGuideMapper.deleteAll();
        schoolGuideMapper.insert(schoolGuide);


    }

}