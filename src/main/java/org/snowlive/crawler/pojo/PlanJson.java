package org.snowlive.crawler.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class For: 招生计划 json数据
 *  PlanJson(major_name,plan_type,college_system,plan_count,cost,batch)
 *
 * @auther: 尹振坤
 * @date: 17-12-9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanJson {

    private String major_name;//专业名称
    private String plan_type;//计划类型
    private String college_system;//大学学制
    private int plan_count = 0;//招生人数
    private String cost ;//学费
    private String batch ;//批次

    @Override
    public String toString() {
        return "{\"major_name\":\"" + major_name + '\"' +
                ", \"plan_type\":\"" + plan_type + '\"' +
                ", \"college_system\":\"" + college_system + '\"' +
                ", \"plan_count\":" + plan_count +
                ", \"cost\":\"" + cost + '\"' +
                ", \"batch\":\"" + batch + '\"' +
                '}';
    }
}
