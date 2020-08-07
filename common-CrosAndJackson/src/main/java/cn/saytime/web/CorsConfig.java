//package cn.saytime.web;
//
//import com.uih.uplus.common.properties.CorsProperties;
//import lombok.extern.uih.log.UIHLog;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * @Auther: yinhua.wu
// * @Date: 2019/11/28 20:55
// * @Description:
// */
//@UIHLog
//@Configuration
//@EnableConfigurationProperties({
//        CorsProperties.class,
//})
//public class CorsConfig {
//    /**
//     * CORS跨域设置
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean corsFilter(CorsProperties corsProperties) {
//        logger.log("0x8002000000000000","corsProperties:{}", corsProperties);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        // 跨域配置
//        corsConfiguration.setAllowedOrigins(corsProperties.getAllowedOrigins());
//        corsConfiguration.setAllowedHeaders(corsProperties.getAllowedHeaders());
//        corsConfiguration.setAllowedMethods(corsProperties.getAllowedMethods());
//        corsConfiguration.setAllowCredentials(corsProperties.isAllowCredentials());
//        corsConfiguration.setExposedHeaders(corsProperties.getExposedHeaders());
//        corsConfiguration.setMaxAge(corsConfiguration.getMaxAge());
//
//        source.registerCorsConfiguration(corsProperties.getPath(), corsConfiguration);
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        bean.setEnabled(corsProperties.isEnable());
//        return bean;
//    }
//}
