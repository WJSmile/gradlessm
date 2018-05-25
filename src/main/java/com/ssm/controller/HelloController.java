package com.ssm.controller;

import com.ssm.controller.pojo.Basic;
import com.ssm.controller.pojo.Blog;
import com.ssm.controller.service.BlogService;
import com.ssm.controller.utils.GsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;


@Controller
public class HelloController {

    @Resource
    BlogService blogService;

    @ResponseBody
    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public String greeting(@RequestBody Map<String,Object> map ) {
        if (map.get("user")==null||map.get("pwd")==null){
            return GsonUtils.createGsonString(new Basic(0,"用户名或密码不能为空"));
        }
           blogService.insertBlog(new Blog(map.get("user").toString(),map.get("pwd").toString(),0));
        return GsonUtils.createGsonString(new Basic(0,"添加成功"));
    }


    @ResponseBody
    @RequestMapping(value = "/getblog", method = RequestMethod.POST)
    public String getBlog() {
        return GsonUtils.createGsonString(blogService.selectBlog());
    }


    @ResponseBody
    @RequestMapping(value = "/deleteblog", method = RequestMethod.POST)
    public String deleteBlog(@RequestBody Map<String,Object> map ) {

        if (map.get("id")==null){
            return GsonUtils.createGsonString(new Basic(0,"参数不能为空"));
        }
        blogService.deleteBlog((int)map.get("id"));
        return GsonUtils.createGsonString(new Basic(0,"删除成功"));
    }

    @ResponseBody
    @RequestMapping(value = "/updateblog", method = RequestMethod.POST)
    public String updateBlog(@RequestBody Map<String,Object> map ) {

        if (map.get("id")==null){
            return GsonUtils.createGsonString(new Basic(0,"参数不能为空"));
        }
        blogService.updateBlog(new Blog(map.get("BlogName").toString(),map.get("BlogContest").toString(),(int)map.get("id")));
        return GsonUtils.createGsonString(new Basic(0,"修改成功"));
    }
}
