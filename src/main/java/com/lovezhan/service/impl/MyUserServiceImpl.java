package com.lovezhan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lovezhan.bean.MyUser;
import com.lovezhan.mapper.MyUserMapper;
import com.lovezhan.service.MyUserService;
import org.springframework.stereotype.Service;

@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUser> implements MyUserService {



}
