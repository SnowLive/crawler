package org.snowlive.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolResult {
    //id
    private Integer id = null;
    //名次
    private Integer rank = null;
    //学校id
    private Integer college_id = null;
    //所在地
    private String city = null;
    //世界排名前1%学科数
    private Integer subject_a = null;
    //世界排名
    private Integer work_rank = null;
    //sci论文数
    private Integer sci = null;
    //院校名称
    private String name = null;

    @Override
    public String toString() {
        return "SchoolResult{" +
                "id:" + id +
                ", rank:" + rank +
                ", college_id:" + college_id +
                ", city:'" + city + '\'' +
                ", subject_a:" + subject_a +
                ", work_rank:" + work_rank +
                ", sci:" + sci +
                ", name:'" + name + '\'' +
                '}';
    }
}
