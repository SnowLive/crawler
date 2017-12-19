package org.snowlive.crawler.utils;

import org.junit.jupiter.api.Test;
import org.snowlive.crawler.pojo.PlanUrlInfo;

/**
 * Class For:
 * url 处理工具
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
public class UrlUtil {

    public static String addPrefix(String prefix, String relaurl) {
        return prefix + relaurl;
    }

    @Deprecated
    public static String combinPlanURL(int collegeId, int cityId, int type, int year, int p) {
        return "http://www.gaokaoq.com/college/plan?" +
                "id=" + collegeId + "&city_id=" + cityId +
                "&type=" + type + "&year=" + year + "&p=" + p;
    }

    public static String combinPlanURL(PlanUrlInfo urlInfo) {
        return "http://www.gaokaoq.com/college/plan?" +
                "id=" + urlInfo.getId() + "&city_id=" + urlInfo.getCity_id() +
                "&type=" + urlInfo.getType() + "&year=" + urlInfo.getYear() + "&p=" + urlInfo.getP();
    }

    public static String combinIndependentURL(int urlInfo) {
        return "http://www.gaokaoq.com/college/zzzs/id/" + urlInfo + ".html";
    }

    public static String combinGuideURL(int id) {
        return "http://www.gaokaoq.com/college/guide/id/" + id + ".html";
    }
    public static String combinGaoKaoqURL(int id){
        return "http://www.gaokaoq.com/college/view/id/"+id;
    }


    @Test
    public void testURL() {
        System.out.println(UrlUtil.combinPlanURL(1, 1, 1, 1, 1));
        System.out.println(UrlUtil.combinPlanURL(new PlanUrlInfo(1, 1, 1, 1, 1)));
    }

}
