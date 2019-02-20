package com.gersen.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gersen.pontointeligente.api.entities.Lancamento;
import com.gersen.pontointeligente.api.repositories.LancamentoRepository;
import com.gersen.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lançamentos para o funcionário ID {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}
	
	@Cacheable("lancamentoPorId") // é o mesmo nome que está no ehcache.xml
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando um lançamento pelo ID {}", id);
//		return Optional.ofNullable(this.lancamentoRepository.findById(id));
		  return this.lancamentoRepository.findById(id);
	}
	
	@CachePut("lancamentoPorId") // quando houver alguma alteração na consulta do lançamento, haverá uma substituição 
	                             // cache anterior, por esse,e assim  sucessivamente, sempre que houver uma alteração.
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo o lançamento: {}", lancamento);
		// não precisa do optional porque no "persistir" sempre terá um lançamento.
		// senão gerará uma exception.
		return this.lancamentoRepository.save(lancamento);
	}
	
	public void remover(Long id) {
		log.info("Removendo o lançamento ID {}", id);
		// tipo void não tem optional
		this.lancamentoRepository.deleteById(id);
	}

}
