package br.com.unicuritiba.interface_jogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unicuritiba.interface_jogo.models.Jogo;


public interface JogoRepository 
	extends JpaRepository<Jogo, Long>{
	
}
