package com.zz.education.controller;

import java.util.Date;

import com.zz.education.bean.User;
import com.zz.education.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhourui
 */
@RestController
public class FeignApiUserController implements UserService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public User find(@PathVariable int id) {
		User user = new User();
		user.setId(id);
		user.setName("服务2");
		user.setCreateTime(new Date());
		logger.info("请求接口返回：{}", user);
		return user;
	}

}
