package io.github.educastrob.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("producao", "homologacao");
		builder.lazyInitialization(true);

		builder.run(args);

		// contexto da aplicação já iniciada:
		ConfigurableApplicationContext applicationContext = builder.context();
		// var produtoRepository = applicationContext.getBean("produtoRepository");

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Application Name: " + applicationName);

		ExemploValue value1 = applicationContext.getBean(ExemploValue.class);
		value1.printVariavel();
		AppProperties value2 = applicationContext.getBean(AppProperties.class);
		System.out.println(value2.getValor1());
	}
}