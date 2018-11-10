package com.zz.education.fegin.config;

import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import feign.Feign;
import feign.Logger;
import feign.Target;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Method;

//@Configuration
public class FeignConfiguration {
	
	@Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
	}

	/*@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}*/

	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		class RcSetterFactory implements SetterFactory {
			@Override
			public Setter create(Target<?> target, Method method) {
				String groupKey = target.name();
				String commandKey = method.getName();
				return Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
						.andCommandKey(HystrixCommandKey.Factory.asKey(commandKey));
			}
		}
		return HystrixFeign.builder().setterFactory(new RcSetterFactory());
		// return Feign.builder();
	}

}
