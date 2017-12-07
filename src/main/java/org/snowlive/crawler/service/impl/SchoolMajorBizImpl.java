package org.snowlive.crawler.service.impl;

import com.xiaoleilu.hutool.http.Header;
import com.xiaoleilu.hutool.http.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.snowlive.crawler.entity.SchoolMajor;
import org.snowlive.crawler.mapper.SchoolMajorMapper;
import org.snowlive.crawler.service.SchoolMajorBiz;
import org.snowlive.crawler.utils.SchoolMajorDownLoadUtil;
import org.snowlive.crawler.utils.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-1
 */
@Service("SchoolMajorBiz")
public class SchoolMajorBizImpl implements SchoolMajorBiz {

    private static final String USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0";
    private static final String COOKIE = "UM_distinctid=15f620b167d0-0f5b9099fc89a2-72236751-100200-15f620b167e297; CNZZDATA1255363830=60405890-1509173276-null%7C1509190370; Hm_lvt_fd9bf00761167d2e9689ba3d37779881=1509191205,1509192604,1509192609,1509192629; PHPSESSID=jk4iimib1banqqeuvbmuog0ee6; Hm_lpvt_fd9bf00761167d2e9689ba3d37779881=1509192680; w_phone=d76bpypD9w0f3s1vRktAhAKyDIsXY1Y4uIfTEQHKuOkdWYeBInaZow; w_password=9846nRmCLVnd59BUsj%2FMRXsdQItv91%2FO6Db2l2v%2BJmH4d4JVM3GGIt2Py2U; w_tobe=2f6aw%2FNH5kurzjK0CbGdvTNKlYQGoFQL6TVhyOs; w_liulan=1%2C%E5%8C%97%E4%BA%AC%E5%A4%A7%E5%AD%A6%2Ccollege2%2F5948cbfc5b57c.jpg*568%2C%E5%AE%9C%E6%98%A5%E5%AD%A6%E9%99%A2%2Ccollege2%2F5948cc5a34f25.jpg*569%2C%E8%82%87%E5%BA%86%E5%AD%A6%E9%99%A2%2Ccollege2%2F5948cc5a34f63.jpg";
    private static int count = 0;

    @Autowired
    private SchoolMajorMapper schoolMajorMapper;

    @Override
    public String getPage(String url) {
        String ip = "";
        String html = "";
        while (html.equals("")) {
            //1.生成随机ip
            ip = "181" + "." + new Random().nextInt(254) + "." + new Random().nextInt(254) + "." + new Random().nextInt(254);
            //请求结果
            html = HttpRequest.get(url)
                    .header(Header.USER_AGENT, USER_AGENT)
                    .header(Header.COOKIE, COOKIE)
                    .header("X-Forwarded-For", ip)
                    .header("Cache-Control", "max-age=0")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .execute().body();
        }
        return html;

    }

    @Override
    public int saveMajorSetting() {
        String[] url = new String[4];//重点、特色、重点实验室、一流学科
        String[] htmlArray = new String[4];//结果
        //解析成功
//        i:2237 index:2238 count:1693 3377
//534
        for (int i = 1; i < 3500; i++) {
            int index = i + 1;
            url[0] = "http://www.gaokaoq.com/college/focusmajor/id/" + index + ".html";
            url[1] = "http://www.gaokaoq.com/college/specialmajor/id/" + index + ".html";
            url[2] = "http://www.gaokaoq.com/college/labmajor/id/" + index + ".html";
            url[3] = "http://www.gaokaoq.com/college/coursemajor/id/" + index + ".html";
            htmlArray = SchoolMajorDownLoadUtil.getInfo(url);
            System.out.print("i:" + i + " index:" + index+ " count:" + count);
//            handleHtml(htmlArray,index);//解析过的数据处理
            handleHtmlWithDiv(htmlArray, index);
//            if(i==20) break;
        }
        return count;
    }
    //重点、特色、重点实验室、一流学科


    //数据的解析1
    private void handleHtml(String[] htmlArray, int schoolId) {
        String[] majors = SchoolMajorDownLoadUtil.getMajor(htmlArray);
        dataDeal(htmlArray, majors, schoolId);
        System.out.println("解析成功");
    }

    //不解析,直接打印div
    private void handleHtmlWithDiv(String[] htmlArray, int schoolId) {
        String[] majors = SchoolMajorDownLoadUtil.getMajorDivStr(htmlArray);
        dataDeal(htmlArray, majors, schoolId);
        System.out.println("解析成功");
    }

    /**
     * 公共数据处理
     *  需要进行数据添加的数据,
     *  id,schoolid,schoolmajorid, focusmajor,specialmajor,labmajor,coursemajor,
     * @param htmlArray
     * @param majors
     * @param schoolId
     */
    private void dataDeal(String[] htmlArray, String[] majors, int schoolId) {
        //jsoup 转换html
        Document doc = Jsoup.parse(htmlArray[0]);
        //解析学校名称
        Element schoolName = doc.select("div.e_name").first();
        //todo 删除学校名打印
        if(doc.select("div.the_eva").isEmpty()) return;//数据为空返回
        System.out.println(schoolName.ownText());
        if (majors == null) System.exit(0);
        // 创建学校对象
        SchoolMajor schoolMajor = new SchoolMajor();
        schoolMajor.setId(schoolId);
        schoolMajor.setSchoolId(String.valueOf(schoolId));
        schoolMajor.setSchoolMajorId(UUIDFactory.getUUID());
        schoolMajor.setSchoolName(schoolName.ownText());
        schoolMajor.setFocusMajor(majors[0]);
        schoolMajor.setSpecialMajor(majors[1]);
        schoolMajor.setLabMajor(majors[2]);
        schoolMajor.setCourseMajor(majors[3]);
        count += schoolMajorMapper.insert(schoolMajor);
    }


}
