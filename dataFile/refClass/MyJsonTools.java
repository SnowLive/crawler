package com.isport.utils;

import android.content.Context;
import com.isport.entity.News;
import com.isport.entity.NewsResults;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snowlive on 17-7-12.
 */

public class MyJsonTools {
    /**
     * 从assets文件中读取json数据并返回
	 * 获取热门城市名字
     * @param context 上下文
     * @return 返回城市名字 String
     */
    public static String getAssetsNews(Context context,String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream ips = context.getAssets().open(fileName);
            BufferedReader bips = new BufferedReader(new InputStreamReader(ips,
                    "UTF-8"));
            String line = null;
            while ((line = bips.readLine()) != null) {
                sb.append(line);
            }
            bips.close();
            ips.close();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sb.toString();
    }
	/**
	 * json解析
	 * 获取热门城市名字
     * 
     */
	public static NewsResults string2JSON(String news_str){
        NewsResults newsResults = new NewsResults();
        List<News> newsList = new ArrayList<News>();

        try {
            //进入到JSON文件中
            JSONObject jsob_top = new JSONObject(news_str);
            newsResults.setError_code(jsob_top.getInt("error_code"));
            newsResults.setReason(jsob_top.getString("reason"));
            {
                error_code:,
                reson:{}
            }

            //找到result对象
            JSONObject jsob_result = jsob_top.optJSONObject("result");

            newsResults.getResult().setStat(jsob_result.getString("stat"));

            JSONArray jsoy_data = jsob_result.getJSONArray("data");
            //循环取出数据
            for(int i = 0; i<jsoy_data.length(); i++){
                JSONObject obj = (JSONObject)jsoy_data.opt(i);
                News tnews = new News();
                tnews.setUniquekey(obj.optString("uniquekey"));
                tnews.setTitle(obj.optString("title"));
                tnews.setDate(obj.optString("date"));
                tnews.setCategory(obj.optString("catagory"));
                tnews.setAuthor_name(obj.getString("author_name"));
                tnews.setUrl(obj.getString("url"));
                tnews.setThumbnail_pic_s(obj.getString("thumbnail_pic_s"));
                newsList.add(tnews);
            }
            newsResults.getResult().setData(newsList);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsResults;

    }




}

