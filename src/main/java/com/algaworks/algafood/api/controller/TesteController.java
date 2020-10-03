package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.infrastructure.repository.spec.RestauranteComFreteGratisSpec;
import com.algaworks.algafood.infrastructure.repository.spec.RestauranteComNomeSemelhanteSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

@RestController
@RequestMapping("/teste")
public class TesteController {
    
    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhasPorNome(String nome) {
        return cozinhaRepository.findTodasByNomeContaining(nome);
    }

    @GetMapping("/cozinhas/unica-por-nome")
    public List<Cozinha> cozinhaPorNome(String nome) {
        return cozinhaRepository.findByNomeContaining(nome);
    }

    @GetMapping("/cozinhas/exists")
    public boolean cozinhaExists(String nome) {
        return cozinhaRepository.existsByNome(nome);
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
                return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
           }


    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorTaxaFrete(String nome, Long cozinhaId) {
                return restauranteRepository.consultarPorNome(nome, cozinhaId);
           }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> restaurantesPorTaxaFrete(String nome) {            
            return restauranteRepository.findFirstRestauranteByNomeContaining(nome);            
        }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> restaurantesTop2PorNome(String nome) {            
            return restauranteRepository.findTop2ByNomeContaining(nome);            
        }

    @GetMapping("/restaurantes/por-nome-e-frete")
    public List<Restaurante> restaurantesPorNomeFrete(String nome,
                    BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {            
            return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);            
        }

    @GetMapping("/restaurantes/count-por-cozinha")
    public int restaurantesCountPorCozinha(Long cozinhaId) {            
            return restauranteRepository.countByCozinhaId(cozinhaId);            
        }

    @GetMapping("/restaurantes/com-frete-gratis")
    public List<Restaurante> restaurantesComFreteGratis(String nome) {
        var comFreteGratis = new RestauranteComFreteGratisSpec();
        var comNomeSemelhante = new RestauranteComNomeSemelhanteSpec(nome);

        return restauranteRepository.findAll(comFreteGratis.and(comNomeSemelhante));
    }
}
