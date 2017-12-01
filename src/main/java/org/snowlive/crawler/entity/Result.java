package org.snowlive.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-22
 *
 * 这里采用lombok注解进行getter\setter\constructor实现.
 * `@Data` 注解实现getter/setter/tostring方法的实现.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Integer status = 0;
    private String msg = "error";
    private List<SchoolResult> data = new ArrayList<SchoolResult>(20);

    @Override
    public String toString() {
        return "Result{" +
                "status:" + status +
                ", msg:'" + msg + '\'' +
                ", data:" + data +
                '}';
    }
}
