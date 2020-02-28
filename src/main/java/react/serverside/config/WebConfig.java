package react.serverside.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Spring MVC 활성화
@ComponentScan(basePackages = "react.serverside") // component-scan 범위 지정
public class WebConfig implements WebMvcConfigurer {
	/**
	 * viewResolver 설정
	 * 
	 * @return
	 * @author fixalot
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// DispatcherServlet이 고정적인 리소스들에 대한 요청을 자신이 직접 처리하지 않고 서블릿 컨테이너의 디폴트 서블릿 전달을 요청한다.
		configurer.enable();
	}
}
