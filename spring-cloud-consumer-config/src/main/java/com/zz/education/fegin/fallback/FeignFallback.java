package com.zz.education.fegin.fallback;

import com.zz.education.bean.User;
import com.zz.education.fegin.IUserFegin;
import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements IUserFegin {

	@Override
	public User find(int id) {
		return null;
	}
	
	@Override
	public String view1(int id) {
		System.out.println("调用远程接口异常，返回自定义信息");
		return "system error";
	}
}
