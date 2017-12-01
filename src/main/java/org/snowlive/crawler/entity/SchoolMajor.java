package org.snowlive.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class For:
 *  专业设置
 *  信息采集网站:
 *  http://www.gaokaoq.com/college/view.html?id=1
 *  id为:college_id
 *
 * @auther: 尹振坤
 * @date: 17-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolMajor {
    private Integer id ;
    private String schoolName;//学校名
    private String type = "ESI";//学校id
    private String year = "2016";//统计年份
    private String focusMajor;//国家重点学科
    private String specialMajor;//特色学科
    private String labMajor;//国家重点实验室
    private String courseMajor;//一流学科

    @Override
    public String toString(){
        return "{id:"+id+
                ",schoolName:'" +schoolName+
                "',type:'" +type+
                "',year:'" +year+
                "',focusMajor:'" +focusMajor+
                "',specialMajor:'" +specialMajor+
                "',labMajor:'" +labMajor+
                "',courseMajor:'" +courseMajor+
                "'}";
    }

}
