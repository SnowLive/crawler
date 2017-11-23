package org.snowlive.crawler.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.snowlive.crawler.entity.Result;
import org.snowlive.crawler.entity.SchoolResult;
import org.snowlive.crawler.mapper.SchoolResultMapper;
import org.snowlive.crawler.utils.MyJsonTools;
import org.snowlive.crawler.utils.SchoolInfoDownloadUtils;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-23
 */
public class SortCrawlerApp {

    public static void main(String[] args) {

        List<Result> sortSchools = new ArrayList<>(10);
        String Url = "http://www.gaokaoq.com/rank/moreList?data=1&type=1&p=";
        String info ;
        for (int i = 1; i < 10; i++) {
            info = SchoolInfoDownloadUtils
                    .download(Url+i);
            if(!info.equals("")){
                Result result = MyJsonTools.string2JSON(info);
                sortSchools.add(result);
            }
        }
        for (Result res : sortSchools) {
            for (SchoolResult school :
                    res.getData()) {

                System.out.print("学校id："+school.getId());
                System.out.print("\t学校名称:"+school.getName());
                System.out.println("\t学校排名："+school.getRank());
            }
        }
        //数据的解析
        Reader reader = null;
        int result_num = 0;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SchoolResultMapper schoolResultMapper = sqlSession.getMapper(SchoolResultMapper.class);
        for (Result res : sortSchools) {
            for (SchoolResult school : res.getData()) {
                result_num+=schoolResultMapper.insert(school);
                System.out.print("插入数据数："+result_num+"   ");
                System.out.print("学校名称:"+school.getName());
                System.out.println("\t学校排名："+school.getRank());
            }
        }

        System.out.println("insert success num :"+ result_num);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("END");
    }
}
