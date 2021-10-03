package com.lovezhan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lovezhan.bean.MyUser;
import com.lovezhan.service.MyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private MyUserService myUserServiceImpl;

    @GetMapping("/user/{id}")
    public MyUser queryUserById(@PathVariable("id") Long id){

        // 分页测试
        Page<MyUser> basePage = new Page<>(2, 2);
        Page<MyUser> page = myUserServiceImpl.page(basePage, null);
        log.info("记录总数：{}", page.getTotal());
        log.info("分页内容：{}", page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());

        return myUserServiceImpl.getById(id);
    }


    @GetMapping("/user/advice")
    public void testControllerAdvice() {
        int a = 1/0;
        System.out.println(a);
    }

}
