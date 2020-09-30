package com.algaworks.algafood.jpa.formapagamento;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class BuscaFormaPagamentoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository pagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		Optional<FormaPagamento> formaPagamento = pagamentoRepository.findById(5L);
		
		System.out.printf("Forma de pagamento: %s(%s)", formaPagamento.get().getId(), formaPagamento.get().getNome());
	}

}
