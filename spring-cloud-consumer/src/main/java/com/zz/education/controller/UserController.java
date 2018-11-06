
package com.zz.education.controller;

import com.zz.education.fegin.IUserFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;

import javax.annotation.Resource;

/**
 * @author zhourui
 */
@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController {

	@Resource
	private IUserFegin iUserFegin;

	@HystrixCommand(fallbackMethod = "getFallback",
			commandProperties = @HystrixProperty(
					name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY,
					value = "THREAD"))
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable(value = "id") int id) {
		//throw new RuntimeException();
		return iUserFegin.view1(id);
	}

	public String getFallback(int id) {
		System.out.println("调用远程接口异常，返回自定义信息");
		return "自定义信息";
	}
}
