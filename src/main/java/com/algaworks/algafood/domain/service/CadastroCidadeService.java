package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	// import de Estado pra adicionar na busca
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		// pegando o ID de estado
		Long estadoId = cidade.getEstado().getId();
		
		// fazendo a busca pelo ID juntamente com o
		// tratamento caso não seja encontrado
		Estado estado = estadoRepository.findById(estadoId)
						.orElseThrow(() -> new EntidadeNaoEncontradaException(
							String.format("Não existe cadastro de estado com código %d", estadoId)));			
		
		cidade.setEstado(estado);
		
		return cidadeRepository.save(cidade);
	}
	
	public void remover(Long cidadeId) {
		
		try {
			
			cidadeRepository.deleteById(cidadeId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cidade com código %d", cidadeId));			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
		}
	}
	
}
