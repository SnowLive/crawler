package org.snowlive.crawler.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.snowlive.crawler.entity.Result;
import org.snowlive.crawler.entity.SchoolResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Class For:json 解析工具
 *
 * @auther: 尹振坤
 * @date: 17-11-22
 */
public class MyJsonTools {

    public static Result string2JSON(String news_str){
        Result schoolResult = new Result();
        List<SchoolResult> schools = new ArrayList<SchoolResult>(20);
        try {
            //进入到JSON文件中
            JSONObject jsob_top = new JSONObject(news_str);
            schoolResult.setStatus(jsob_top.getInt("status"));
            schoolResult.setMsg(jsob_top.optString("msg"));

            JSONArray jsoy_data = jsob_top.getJSONArray("data");
            JSONObject obj = null;
            SchoolResult school = null;
            //循环取出数据
            for(int i = 0; i<jsoy_data.length(); i++){
                obj = (JSONObject)jsoy_data.opt(i);
                school = new SchoolResult();
                school.setId(Integer.parseInt(obj.optString("id")));
                school.setRank(Integer.parseInt(obj.optString("rank")));
                school.setCollege_id(Integer.parseInt(obj.optString("college_id")));
                school.setCity(obj.optString("city"));
                school.setSubject_a(Integer.parseInt(obj.optString("subject_a")));
                school.setWork_rank(Integer.parseInt(obj.optString("work_rank")));
                school.setSci(Integer.parseInt(obj.optString("sci")));
                school.setName(obj.optString("name"));
                schools.add(school);
            }
            schoolResult.setData(schools);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return schoolResult;

    }



}
