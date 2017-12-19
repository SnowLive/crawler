package org.snowlive.crawler.update.entity.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Class For:
 *  gaokao.school_sort
 * @auther: 尹振坤
 * @date: 17-12-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolSort {
    private Integer id;
    private String schoolId;
    private String schoolSortId;
    private String schoolName;
    private String type="ESI";
    private String year="2017";
    private Integer rank;
    private Integer worldRank;
    private String city;
    private Integer topSubjectNum;
    private Integer sciNum;
    private String info="{}";
    private int state;
    private Timestamp createTime;
    private Timestamp updateTime;


}
