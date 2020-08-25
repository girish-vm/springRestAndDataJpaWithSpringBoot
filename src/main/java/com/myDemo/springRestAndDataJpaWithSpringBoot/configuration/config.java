/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author gimanjun
 *
 */
@EnableJpaRepositories(basePackages = "com.myDemo.springRestAndDataJpaWithSpringBoot.repository")
@Configuration
@EnableCaching
public class config {

	 @Bean
	    public EhCacheCacheManager getEhCacheManager(){
	        return new EhCacheCacheManager(getEhCacheFactory().getObject());
	    }
	    @Bean
	    public EhCacheManagerFactoryBean getEhCacheFactory(){
	        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
	        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
	        factoryBean.setShared(true);
	        return factoryBean;
	    }
	
}
