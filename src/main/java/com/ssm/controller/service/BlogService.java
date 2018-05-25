package com.ssm.controller.service;

import com.ssm.controller.pojo.Blog;

import java.util.List;

/**
 * Created by zn on 2017/4/11.
 */
public interface BlogService {
    public int insertBlog(Blog blog);
    public List<Blog> selectBlog();
    public int deleteBlog(int id);
    public int updateBlog(Blog blog);
}
