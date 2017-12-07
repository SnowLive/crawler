package org.snowlive.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.sql.Timestamp;

/**
 * Class For:
 * 学校招生章程
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolGuide {
    private Integer id;
    @NotBlank(message = "学校Id不能")
    private String schoolId;//学校id
    @NotBlank(message = "招生章程事务Id不能")
    private String schoolGuideId;//招生章程事务id
    @NotBlank(message = "标题不能")
    private String title="";//标题
    @NotBlank(message = "内容不能")
    private String content="";//内容
    private String type = "ESI";//类型
    private String year = "2017";//当前招生章程年份
    @NotBlank(message = "往期招生章程")
    private String usedGuide = "{\"state\": \"1\",\"count\": \"0\",\"data\": []}";//往期招生章程
    private int state = 1;//状态
    private Timestamp publishTime;//发布时间
    private Timestamp createTime;//创建时间
    private Timestamp updateTime;//更新id

    @Override
    public String toString() {
        return "{id:" + id +
                ",schoolId:'" + schoolId +
                "'\n,schoolGuideId:'" + schoolGuideId +
                "'\n,title:'" + title +
                "'\n,content:'" + content +
                "'\n,type:'" + type +
                "'\n,year:'" + year +
                "'\n,usedGuide:'" + usedGuide +
                "'\n,state:'" + state +
                "'\n,createTime:'" + createTime +
                "'\n,updateTime:'" + updateTime +
                "'}";
    }

}
