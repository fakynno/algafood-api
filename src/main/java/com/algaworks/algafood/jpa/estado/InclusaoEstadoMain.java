package com.algaworks.algafood.jpa.estado;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class InclusaoEstadoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);
		
		Estado estado1 = new Estado();
		estado1.setNome("Bahia");
		
		Estado estado2 = new Estado();
		estado2.setNome("Distrito Federal");
		
		Estado estado3 = new Estado();
		estado3.setNome("Mato Grosso");
		
		estadoRepository.salvar(estado1);
		estadoRepository.salvar(estado2);
		estadoRepository.salvar(estado3);
		
		System.out.printf("estados adicionados");
		
	}

}
