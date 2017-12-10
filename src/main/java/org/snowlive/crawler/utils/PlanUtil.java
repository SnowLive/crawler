package org.snowlive.crawler.utils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.snowlive.crawler.pojo.DataJson;
import org.snowlive.crawler.pojo.PlanJson;
import org.snowlive.crawler.pojo.PlanMajorJson;
import org.snowlive.crawler.pojo.PlanUrlInfo;

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
    public static DataJson<PlanJson> getMajorData(PlanUrlInfo planUrlInfo) {
        DataJson<PlanJson> datajson = new DataJson<>();

        List<PlanJson> planList = getPlanList(planUrlInfo);

        datajson.setData(planList);
        datajson.setCount(planList.size());
        return datajson;
    }

    /**
     * get major's liberal's data(liset<PlanJson>)
     *
     * @param planUrlInfo
     * @return
     */
    public static List<PlanJson> getPlanList(PlanUrlInfo planUrlInfo) {

        List<PlanJson> planList = new ArrayList<>();

        Document doc = JsoupDoubleAntiCrawlerUtil.gethtml(UrlUtil.combinPlanURL(planUrlInfo));
        //1.判断有没有 a.text
        //1.1 存在,获取完成之后,p加一,获取doc.select,
        while(true){

            //数据预处理
            Elements planEles = doc.select("div.sco_list tr");//具体数据
            planEles.remove(planEles.first());//去表头
            if (planEles.first().select("td").text()
                    .equals("未找到符合条件的数据，可能是该校在该省无招生或数据录入中")) return null;
            //数据获取
            planList.addAll(getPlanJson(planEles));//获取数据
            //判断当前页面是否有a.next,没有就break;,有,就p+=1, 重新请求结果.
            if(doc.select("a.next").isEmpty()) break;
            planUrlInfo.setP(planUrlInfo.getP()+1);
            doc = JsoupDoubleAntiCrawlerUtil.gethtml(UrlUtil.combinPlanURL(planUrlInfo));
        }

        return planList;

    }

    public static List<PlanJson> getPlanJson(Elements planEles) {
        List<PlanJson> planJsonList = new ArrayList<>(20);
        PlanJson planJson = null;
        Elements planTdEle;
        for (Element planEleAttr : planEles) {
            planTdEle = planEleAttr.select("td");
            planJson = new PlanJson();
            planJson.setMajor_name(planTdEle.get(0).ownText());
            planJson.setPlan_type(planTdEle.get(1).ownText());
            planJson.setCollege_system(planTdEle.get(2).ownText());
            planJson.setBatch(planTdEle.get(3).ownText());
            planJson.setPlan_count(Integer.parseInt(planTdEle.get(4).ownText()));
            planJson.setCost(Double.parseDouble(planTdEle.get(5).ownText()));
            planJsonList.add(planJson);
        }

//        planJsonList.forEach(plan -> {
//            System.out.println(plan);
//        });

        return planJsonList;
    }

//    @Test
    public void test() {
        Elements planEles = JsoupDoubleAntiCrawlerUtil.getElements("div.sco_list tr", UrlUtil.combinPlanURL(new PlanUrlInfo()));
        planEles.remove(planEles.first());//去表头
        if (planEles.first().select("td").text()
                .equals("未找到符合条件的数据，可能是该校在该省无招生或数据录入中")) return;
        getPlanJson(planEles);
    }

//    @Test
    public void test1(){
        List<PlanJson> dataList = getPlanList(new PlanUrlInfo());
        dataList.forEach(data->{
            System.out.println(data);
        });
    }
    @Test
    public void test2(){
        System.out.println(getMajorJson(new PlanUrlInfo()));
    }


}
