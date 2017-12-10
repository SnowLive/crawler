package org.snowlive.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Class For:
 * 学校招生计划
 *
 * @auther: 尹振坤
 * @date: 17-12-9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolPlan {
    private Integer id;
    private Integer schoolId;

    private String schoolPlanId;

    private String type = "ESI";
    private String year = "2017";
    private String plan;
    private String usedPlan;
    private int state = 1;
    private Timestamp createTime;
    private Timestamp updateTime;
}
