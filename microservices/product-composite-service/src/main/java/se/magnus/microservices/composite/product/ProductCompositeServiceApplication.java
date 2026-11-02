package se.magnus.microservices.composite.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.JacksonJsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.json.JsonMapper;

@SpringBootApplication
@ComponentScan("se.magnus")
public class ProductCompositeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				ProductCompositeServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		JsonMapper mapper = JsonMapper.builder()
				.enable(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)
				.build();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters()
				.add(0, new JacksonJsonHttpMessageConverter(mapper));

		return restTemplate;
	}
}