package com.algaworks.algafood.jpa.formapagamento;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository pagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		List<FormaPagamento> formasDePagamento = pagamentoRepository.listar();
		
		System.out.print("Formas de pagamento: \n");
		
		formasDePagamento.forEach(
				(formaPagto) -> System.out.printf("- %s \n", 
						formaPagto.getNome()));
		
	}

}
