package com.algaworks.algafood.jpa.permissao;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

public class InclusaoPermissaoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		Permissao permissao = new Permissao();
		permissao.setNome("alterar");
		permissao.setDescricao("permite alterar um dado existente no banco");
		
		permissaoRepository.salvar(permissao);
		
		System.out.printf("Registro incluído");
		
	}

}
