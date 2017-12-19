package org.snowlive.crawler.update.entity.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Class For:
 * 专业设置
 * 信息采集网站:
 * http://www.gaokaoq.com/college/view.html?id=1
 * id, school_id, school_major_id,type, year,
 * focus_major,special_major,lab_major,course_major,
 * info,state,create_time,update_time
 *
 * @auther: 尹振坤
 * @date: 17-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolMajor {

    private Integer id;
    private String schoolId;//学校id
    private String schoolMajorId;//major事务id
    private String type = "ESI";//类型
    private String year = "2016";//统计年份
    private String focusMajor;//国家重点学科
    private String specialMajor;//特色学科
    private String labMajor;//国家重点实验室
    private String courseMajor;//一流学科
    private String info="{}";//备用信息
    private int state = 1;//状态
    private Timestamp createTime;//创建时间
    private Timestamp updateTime;//更新id

    @Override
    public String toString() {
        return "{id:" + id +
                ",schoolId:'" + schoolId +
                "',type:'" + type +
                "',year:'" + year +
                "',focusMajor:'" + focusMajor +
                "',specialMajor:'" + specialMajor +
                "',labMajor:'" + labMajor +
                "',courseMajor:'" + courseMajor +
                "',info:'" + info +
                "',state:'" + state +
                "',createTime:'" + createTime +
                "',updateTime:'" + updateTime +
                "'}";
    }

}
