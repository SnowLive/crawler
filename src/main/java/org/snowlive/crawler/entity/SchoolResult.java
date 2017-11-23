package org.snowlive.crawler.entity;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-22
 */
public class SchoolResult {
    //id
    private Integer id = null;
    //名次
    private Integer rank = null;
    //学校id
    private Integer college_id = null;
    //所在地
    private String city = null;
    //世界排名前1%学科数
    private Integer subject_a = null;
    //世界排名
    private Integer work_rank = null;
    //sci论文数
    private Integer sci = null;
    //院校名称
    private String name = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCollege_id() {
        return college_id;
    }

    public void setCollege_id(Integer college_id) {
        this.college_id = college_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSubject_a() {
        return subject_a;
    }

    public void setSubject_a(Integer subject_a) {
        this.subject_a = subject_a;
    }

    public Integer getWork_rank() {
        return work_rank;
    }

    public void setWork_rank(Integer work_rank) {
        this.work_rank = work_rank;
    }

    public Integer getSci() {
        return sci;
    }

    public void setSci(Integer sci) {
        this.sci = sci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SchoolResult{" +
                "id:" + id +
                ", rank:" + rank +
                ", college_id:" + college_id +
                ", city:'" + city + '\'' +
                ", subject_a:" + subject_a +
                ", work_rank:" + work_rank +
                ", sci:" + sci +
                ", name:'" + name + '\'' +
                '}';
    }
}
