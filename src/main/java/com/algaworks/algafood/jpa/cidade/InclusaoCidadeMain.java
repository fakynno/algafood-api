package com.algaworks.algafood.jpa.cidade;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class InclusaoCidadeMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		Cidade cidade1 = new Cidade();
		cidade1.setNome("Ourinhos");
		
		Cidade cidade2 = new Cidade();
		cidade2.setNome("Campo Grande");
		
		cidadeRepository.salvar(cidade1);
		cidadeRepository.salvar(cidade2);
		
		System.out.printf("cadastrado com sucesso");
		
	}

}
