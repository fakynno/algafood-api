package com.algaworks.algafood.jpa.formapagamento;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class InclusaoFormaPagamentoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository pagamentoRepository = applicationContext
				.getBean(FormaPagamentoRepository.class);
		
		FormaPagamento formaPagamento1 = new FormaPagamento();
		formaPagamento1.setNome("QR Code Mercado Pago");
		
		FormaPagamento formaPagamento2 = new FormaPagamento();
		formaPagamento2.setNome("Google Pay");
		
		pagamentoRepository.salvar(formaPagamento1);
		pagamentoRepository.salvar(formaPagamento2);
		
	}

}
