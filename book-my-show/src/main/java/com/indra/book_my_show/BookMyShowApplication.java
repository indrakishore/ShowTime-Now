package com.indra.book_my_show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookMyShowApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.addContextCustomizers(context -> {
			context.addLifecycleListener(event -> {
				if (event.getType().equals(org.apache.catalina.Lifecycle.AFTER_START_EVENT)) {
					try {
						Class<?> aprLifecycleListenerClass = Class.forName("org.apache.tomcat.jni.Library");
						aprLifecycleListenerClass.getMethod("initialize").invoke(null);
					} catch (Throwable t) {
						// ignore APR lifecycle initialization error
					}
				}
			});
		});
		return factory;
	}

}
