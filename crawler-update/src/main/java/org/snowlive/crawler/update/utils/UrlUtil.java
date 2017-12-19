package org.snowlive.crawler.update.utils;

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

    public static String combinPlanURL(int collegeId, int cityId, int type, int year, int p) {
        return "http://www.gaokaoq.com/college/plan?" +
                "id=" + collegeId + "&city_id=" + cityId +
                "&type=" + type + "&year=" + year + "&p=" + p;
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

}
