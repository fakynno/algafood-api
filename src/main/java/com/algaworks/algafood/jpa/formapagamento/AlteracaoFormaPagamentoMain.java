package com.algaworks.algafood.jpa.formapagamento;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class AlteracaoFormaPagamentoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository pagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setId(1L);
		formaPagamento.setNome("Pagar com sangue");
		
		pagamentoRepository.salvar(formaPagamento);
		
		System.out.printf("Forma de pagamento [%s] incluída com sucesso!", formaPagamento.getNome());
		
	}

}
