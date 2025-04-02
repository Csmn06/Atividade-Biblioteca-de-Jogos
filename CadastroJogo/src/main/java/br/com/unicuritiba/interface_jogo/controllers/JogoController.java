package br.com.unicuritiba.interface_jogo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.unicuritiba.interface_jogo.models.Jogo;
import br.com.unicuritiba.interface_jogo.repositories.JogoRepository;

@RestController
public class JogoController {

	@Autowired
	JogoRepository repository;

	@GetMapping("/jogo")
	public ResponseEntity<List<Jogo>> getJogo() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/jogo")
	public ResponseEntity<Jogo> saveJogo(@RequestBody Jogo jogo) {
		Jogo jogoSalvo = repository.save(jogo);
		return ResponseEntity.ok(jogoSalvo);

	}

	@DeleteMapping("/jogo/{id}")
	public void removeJogos(@PathVariable long id) {
		repository.deleteById(id);

	}
	@PutMapping ("/jogo/{id}")
	public ResponseEntity<Jogo> updateJogo(@PathVariable long id, @RequestBody Jogo jogo){
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
	}
	jogo.setId(id);
	Jogo updatedJogo = repository.save(jogo);
	return ResponseEntity.ok(updatedJogo);
	
}
}
