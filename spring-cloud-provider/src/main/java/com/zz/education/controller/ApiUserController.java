package com.zz.education.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.zz.education.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourui
 */
@RestController
@RequestMapping(value = "/api/user")
public class ApiUserController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User view(@PathVariable int id) {
		//Thread.sleep(50000);
		User user = new User();
		user.setId(id);
		user.setName("服务1，来自Provider");
		user.setCreateTime(new Date());
		logger.info("请求接口返回：{}", user);
		return user;
	}

}
