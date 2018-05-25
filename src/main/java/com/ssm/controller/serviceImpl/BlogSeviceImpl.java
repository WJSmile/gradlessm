package com.ssm.controller.serviceImpl;

import com.ssm.controller.mapper.BlogMapper;
import com.ssm.controller.pojo.Blog;
import com.ssm.controller.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zn on 2017/4/11.
 */

@Service
public class BlogSeviceImpl implements BlogService {

    @Resource
    private BlogMapper userDao;

    @Override
    public int insertBlog(Blog blog) {
        return userDao.insertBlog(blog);
    }

    @Override
    public List<Blog> selectBlog() {
        return userDao.selectBlog();
    }

    @Override
    public int deleteBlog(int id) {
        return userDao.deleteBlog(id);
    }

    @Override
    public int updateBlog(Blog blog) {
        return userDao.updateBlog(blog);
    }
}
