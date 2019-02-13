package com.gersen.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gersen.pontointeligente.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Transactional(readOnly = true) // essa anotacao ajuda na performance, quando for só consulta
	Empresa findByCnpj(String cnpj);

}
	