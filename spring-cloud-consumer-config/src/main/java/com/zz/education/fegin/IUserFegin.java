package com.zz.education.fegin;

import com.zz.education.fegin.config.FeignConfiguration;
import com.zz.education.fegin.fallback.FeignFallback;
import com.zz.education.service.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhourui
 */
@FeignClient(value = "spring-cloud-provider",
		configuration = FeignConfiguration.class,
		fallback= FeignFallback.class)
public interface IUserFegin extends UserService {
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
	String view1(@PathVariable(name = "id") int id);
}
