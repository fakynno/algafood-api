package com.algaworks.algafood.jpa.restaurante;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();		
		restaurante1.setNome("Thai Gourmet");
		restaurante1.setTaxaFrete(new BigDecimal(4));
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Thai-Thay good-food");
		restaurante2.setTaxaFrete(new BigDecimal(4.5));
		
		restauranteRepository.save(restaurante1);
		restauranteRepository.save(restaurante2);
	}

}
