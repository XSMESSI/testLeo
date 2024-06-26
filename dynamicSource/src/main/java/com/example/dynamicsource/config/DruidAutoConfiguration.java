package com.example.dynamicsource.config;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName DruidAutoConfiguration
 * @Description:
 * @Author: xushen
 * @CreateDate: 2024/5/22 11:11
 * @Version: 1.0
 */
@Configuration
public class DruidAutoConfiguration {

    @Autowired
    DynamicDataSourceProvider dynamicDataSourceProvider;

    /**
     * spring容器启动时将DynamicDataSource  bean对象注入到容器中
     * @return
     */
    @Bean
    DynamicDataSource dynamicDataSource() {
        return new DynamicDataSource(dynamicDataSourceProvider);
    }

    /**
     * 去除数据源监控页面的广告
     * 去除 Druid 监控页面的阿里广告
     * @param properties
     * @return
     */
    @Bean
    @ConditionalOnProperty(name = "spring.datasource.druid.statViewServlet.enabled", havingValue = "true")
    public FilterRegistrationBean removeDruidFilterRegistrationBean(DruidStatProperties properties) {
        // 获取web监控页面的参数
        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
        // 提取common.js的配置路径
        String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");
        // 创建filter进行过滤
        Filter filter = new Filter() {
            @Override
            public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                    throws IOException, ServletException {
                String text = Utils.readFromResource("support/http/resources/js/common.js");
                text = text.replace("this.buildFooter();", "");
                response.getWriter().write(text);
            }

            @Override
            public void destroy() {
            }
        };
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }
}

