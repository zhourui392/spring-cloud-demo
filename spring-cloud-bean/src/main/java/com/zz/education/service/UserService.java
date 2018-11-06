package com.zz.education.service;

import com.zz.education.bean.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface UserService {

	@RequestMapping(value = "/api/user/find/{id}", method = RequestMethod.GET)
	User find(@PathVariable(value = "id") int id);
}
