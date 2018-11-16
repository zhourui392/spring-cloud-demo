package com.zz.education.controller;

import com.zz.education.fegin.IUserFegin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhourui
 */
@RestController
@RequestMapping(value = "/feign/user")
public class FeignUserController {

	@Resource
	private IUserFegin iUserFegin;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable(value = "id") int id) {
		return iUserFegin.view1(id);
	}
}
