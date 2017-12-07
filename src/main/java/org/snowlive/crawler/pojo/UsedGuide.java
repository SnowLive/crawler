package org.snowlive.crawler.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.sql.Timestamp;

/**
 * Class For:
 * 往期学校招生章程
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsedGuide {

    @NotBlank(message = "标题不能为空")
    private String title = "";
    private String content = "";
    private Timestamp publishTime ;


    @Override
    public String toString() {
        return "{" +
                "\"title\":\"" + title + '\"' +
                ", \"content\":\"" + content + '\"' +
                ", \"publishTime\":\"" + publishTime + '\"' +
                '}';
    }
}
