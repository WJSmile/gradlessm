package com.ssm.controller.pojo;

public class Blog {
    public Integer id;
    public String BlogName;
    public String BlogContest;

    public Blog(){

    }
    public Blog(String blogName, String blogContest,int id) {
        BlogName = blogName;
        BlogContest = blogContest;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return BlogName;
    }

    public void setBlogName(String blogName) {
        BlogName = blogName;
    }

    public String getBlogContest() {
        return BlogContest;
    }

    public void setBlogContest(String blogContest) {
        BlogContest = blogContest;
    }
}
