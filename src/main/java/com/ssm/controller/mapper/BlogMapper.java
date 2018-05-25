package com.ssm.controller.mapper;

import com.ssm.controller.pojo.Blog;

import java.util.List;

public interface BlogMapper {
    public int insertBlog(Blog blog);
    public List<Blog> selectBlog();
    public int deleteBlog(int id);
    public int updateBlog(Blog blog);
}
