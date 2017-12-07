package org.snowlive.crawler.utils;

import com.xiaoleilu.hutool.http.Header;
import com.xiaoleilu.hutool.http.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Random;

/**
 * Class For:
 * Jsoup 获取远程网站的数据
 * <p>
 * 当数据有时：
 * 原始数据的排版方式不一定，有两种：
 * 1.div.the_eva p
 * 2.div.the_eva td
 * 3. div.the_eva p 1 所有数据均存放在p中
 * 没有时：
 * “”
 * 每个学校的专业信息大致有三种排版，
 * 1.div.the_ev分别保存数据
 * 2.div.the_eva td
 * 3.div.the_eva p 包含所有
 * 4."div.the_eva p span"
 *
 * @auther: 尹振坤
 * @date: 17-12-3
 */
public class SchoolMajorDownLoadUtil {

    private static final String USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0";
    private static final String COOKIE = "UM_distinctid=15f620b167d0-0f5b9099fc89a2-72236751-100200-15f620b167e297; " +
            "CNZZDATA1255363830=60405890-1509173276-null%7C1509190370; " +
            "Hm_lvt_fd9bf00761167d2e9689ba3d37779881=1509191205,1509192604,1509192609,1509192629; " +
            "PHPSESSID=jk4iimib1banqqeuvbmuog0ee6; Hm_lpvt_fd9bf00761167d2e9689ba3d37779881=1509192680; " +
            "w_phone=d76bpypD9w0f3s1vRktAhAKyDIsXY1Y4uIfTEQHKuOkdWYeBInaZow; " +
            "w_password=9846nRmCLVnd59BUsj%2FMRXsdQItv91%2FO6Db2l2v%2BJmH4d4JVM3GGIt2Py2U; " +
            "w_tobe=2f6aw%2FNH5kurzjK0CbGdvTNKlYQGoFQL6TVhyOs; " +
            "w_liulan=1%2C%E5%8C%97%E4%BA%AC%E5%A4%A7%E5%AD%A6%2Ccollege2%2F5948cbfc5b57c.jpg*568%2C%E5%AE%9C%E6%98%A5%E5%AD%A6%E9%99%A2%2Ccollege2%2F5948cc5a34f25.jpg*569%2C%E8%82%87%E5%BA%86%E5%AD%A6%E9%99%A2%2Ccollege2%2F5948cc5a34f63.jpg";
    public static final String[] selectMod = new String[]{"div.the_eva p", "div.the_eva td", "div.the_eva p span", "div.the_eva td span"};

    /**
     * 请求url获取html结果集
     * 获取不同页面不同排版的专业集合。
     * @param urlArray urlArray集合
     * @return
     */
    public static String[] getInfo(String[] urlArray) {
        String ip = "181" + "." + new Random().nextInt(254) + "." + new Random().nextInt(254) + "." + new Random().nextInt(254);
        String htmlArray[] = new String[urlArray.length];

        if (urlArray.length != urlArray.length) return null;
        for (int i = 0; i < urlArray.length; i++) {
            htmlArray[i] = HttpRequest.get(urlArray[i])
                    .header(Header.USER_AGENT, USER_AGENT)
                    .header(Header.COOKIE, COOKIE)
                    .header("X-Forwarded-For", ip)
                    .header("Cache-Control", "max-age=0")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .execute().body();
        }
        return htmlArray;
    }

    /**
     * 解析html结果返回majorStr集
     *
     * @param htmlArray
     * @return
     */
    public static String[] getMajor(String[] htmlArray) {
        if (htmlArray.length != 4) return null;

        String[] majorArray = new String[4];
        StringBuffer tempMajor = new StringBuffer();
        //jsoup 转换html
        Document doc;//top
        Elements majors;//div.the_eva p
        for (int i = 0; i < 4; i++) {
            doc = Jsoup.parse(htmlArray[i]);
            majors = getRightSelect(doc);
            System.out.println("major :" + majors.size());
            if (majors.size() == 0) {//不存在数据
                majorArray[i] = "";
                continue;
            }
            if (majors.size() == 1) {//存在数据，统统放在1个<p>中,' '分开
                tempMajor.append((majors.first().ownText()).replace(" ", ","));
                majorArray[i] = tempMajor.toString();
                tempMajor = new StringBuffer();
                continue;
            }
            for (Element major : majors) {
                if (!(major.ownText()).equals(""))
                    tempMajor.append(major.ownText() + ",");
            }
            if (tempMajor.length() > 1 && tempMajor.charAt(tempMajor.length() - 1) == ',')
                tempMajor.deleteCharAt(tempMajor.length() - 1);
            majorArray[i] = tempMajor.toString();
            tempMajor = new StringBuffer();
        }
        return majorArray;
    }

    public static String[] getMajorDivStr(String[] htmlArray) {
        String[] majorDivResult = new String[4];
        if (htmlArray.length != 4) return null;
        Document doc = null;
        Elements majorDiv = null;
        int i = 0;
        for (String html : htmlArray) {
            //1.解析html
            doc = Jsoup.parse(html);
            //2.select
            majorDiv = doc.select("div.the_eva");
//            System.out.println(majorDiv);
            //3.存储
            majorDivResult[i++] = majorDiv.toString();
        }

        return majorDivResult;
    }

    /**
     * 获取正确的select结果
     * 存在不同类型选择器
     * div.the_eva p
     * div.the_eva td
     * div.the_eva p 1
     * div.the_eva span
     *
     * @param doc
     * @return
     */
    private static Elements getRightSelect(Document doc) {
        Elements majors = doc.select(SchoolMajorDownLoadUtil.selectMod[0]);
        Elements majors1 = doc.select(SchoolMajorDownLoadUtil.selectMod[1]);
        Elements majors2 = doc.select(SchoolMajorDownLoadUtil.selectMod[2]);
        majors = majors.size() > majors1.size() ? majors : majors1;
        majors = majors.size() == majors2.size() ? majors2 : majors;
        return majors;
    }


}
