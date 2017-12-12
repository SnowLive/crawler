package org.snowlive.crawler.utils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.snowlive.crawler.pojo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class For:
 * 招生计划工具类
 *
 * @auther: 尹振坤
 * @date: 17-12-10
 */
public class PlanUtil {
    public static final int CURRENT_YEAR = 2017;

    /**
     * 获取往期招生计划
     *
     * @param planUrlInfo url链接参数封装类
     * @return 顶级used封装, 格式可参考`dataFile/resultDemo/school-plan.json`文件
     */
    public static DataJson<PlanYearJson> getUsedPlan(PlanUrlInfo planUrlInfo) {
        DataJson<PlanYearJson> dataTop = new DataJson<PlanYearJson>();
        PlanYearJson yearJson;
        List<PlanYearJson> yearJsonList = new ArrayList<>(3);
        for (int year = 2015; year < CURRENT_YEAR; year++) {
            planUrlInfo.setYear(year);
            yearJson = new PlanYearJson(year, getMajorJson(planUrlInfo));
            yearJsonList.add(yearJson);
        }
        dataTop.setCount(yearJsonList.size());
        dataTop.setData(yearJsonList);
        return dataTop;
    }

    /**
     * get 招生计划major层数据
     *
     * @param planUrlInfo
     * @return
     */
    public static PlanMajorJson getMajorJson(PlanUrlInfo planUrlInfo) {
        PlanMajorJson majorPlan = new PlanMajorJson();

        planUrlInfo.setType(1);//type 1 文科
        majorPlan.setLiberal(getMajorData(planUrlInfo));

        planUrlInfo.setType(2);//type 2 理科
        majorPlan.setScience(getMajorData(planUrlInfo));

        return majorPlan;
    }

    /**
     * get major 的liberal或science
     *
     * @param planUrlInfo
     * @return
     */
    private static DataJson<PlanJson> getMajorData(PlanUrlInfo planUrlInfo) {
        DataJson<PlanJson> datajson = new DataJson<>();

        List<PlanJson> planList = getPlanList(planUrlInfo);
        datajson.setData(planList);
        if (planList == null) {
            System.out.println("planlist is null");
            System.exit(0);
        }

        datajson.setCount(planList.size());
        return datajson;
    }

    /**
     * get major's liberal's data(liset<PlanJson>)
     *
     * @param planUrlInfo
     * @return
     */
    private static List<PlanJson> getPlanList(PlanUrlInfo planUrlInfo) {

        List<PlanJson> planList = new ArrayList<>();

        Document doc = JsoupDoubleAntiCrawlerUtil.gethtml(UrlUtil.combinPlanURL(planUrlInfo));
        while (true) {

            //数据预处理
            Elements planEles = doc.select("div.sco_list tr");//具体数据
            planEles.remove(planEles.first());//去表头
            if (planEles.first().select("td").text()
                    .equals("未找到符合条件的数据，可能是该校在该省无招生或数据录入中")){
                System.out.println("未找到符合条件的数据，可能是该校在该省无招生或数据录入中");
                break;
            }
            //数据获取
            planList.addAll(getPlanJson(planEles));//获取数据
            //判断当前页面是否有a.next,没有就break;,有,就p+=1, 重新请求结果.
            if (doc.select("a.next").isEmpty()) break;
            planUrlInfo.setP(planUrlInfo.getP() + 1);
            doc = JsoupDoubleAntiCrawlerUtil.gethtml(UrlUtil.combinPlanURL(planUrlInfo));
        }
        //充值p
        planUrlInfo.setP(1);

        return planList;

    }

    private static List<PlanJson> getPlanJson(Elements planEles) {
        List<PlanJson> planJsonList = new ArrayList<>(20);
        PlanJson planJson = null;
        Elements planTdEle;
        String numberTemp = "";
        for (Element planEleAttr : planEles) {
            planTdEle = planEleAttr.select("td");
            planJson = new PlanJson();
            planJson.setMajor_name(JsonStrUtil.replaceSpcialChar(planTdEle.get(0).ownText()));
            planJson.setPlan_type(planTdEle.get(1).ownText());
            planJson.setCollege_system(planTdEle.get(2).ownText());
            planJson.setBatch(planTdEle.get(3).ownText());
            numberTemp = planTdEle.get(4).ownText();
            planJson.setPlan_count(Integer.parseInt(numberTemp.equals("--") ? "0" : numberTemp));
            planJson.setCost(planTdEle.get(5).ownText());
            planJsonList.add(planJson);
        }
        return planJsonList;
    }

    public void testGetPlanJson() {
        Elements planEles = JsoupDoubleAntiCrawlerUtil.getElements("div.sco_list tr", UrlUtil.combinPlanURL(new PlanUrlInfo()));
        planEles.remove(planEles.first());//去表头
        if (planEles.first().select("td").text()
                .equals("未找到符合条件的数据，可能是该校在该省无招生或数据录入中")) return;
        getPlanJson(planEles);
    }

    public void testgetPlanList() {
        List<PlanJson> dataList = getPlanList(new PlanUrlInfo());
        dataList.forEach(data -> {
            System.out.println(data);
        });
    }

    public void testGetMajorJson() {
        System.out.println(getMajorJson(new PlanUrlInfo()));
    }


    public void testGetUsedPlan() {
        System.out.println(getUsedPlan(new PlanUrlInfo()));
    }

    @Test
    public void testdataJson(){
        DataJson dataJson = new DataJson<PlanJson>();
        dataJson.setData(new ArrayList());
        System.out.println(dataJson);
    }


}
