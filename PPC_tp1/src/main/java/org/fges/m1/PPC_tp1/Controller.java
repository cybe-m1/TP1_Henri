package org.fges.m1.PPC_tp1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController() 
@RequestMapping(path = "/personnes") 
public class Controller { 

	@Autowired
	Service servicePersonne;

	@GetMapping
	public List<Personne> getPersonnes() { 
		return servicePersonne.getList(); 
	} 

	@GetMapping("/{personneId}") 
	public Optional<Personne> getUser(@PathVariable("personneId") int personneId) { 
		return this.getPersonnes().stream().filter(personne -> personne.getId() == personneId).findFirst(); 
	}
	
	@PutMapping("/personnePut")
	public ResponseEntity<Personne> addPersonne(@RequestBody Personne p) {
		return servicePersonne.putPersonne(p);
	}
	
	@PostMapping("/personneUpdate")
	public ResponseEntity<Personne> updatePersonne(@RequestBody Personne p) {
		return servicePersonne.updatePersonne(p);
	}
	
	@DeleteMapping("/delete/{personneId}")
	public ResponseEntity<Personne> deletePersonne(@PathVariable("personneId") int personneId) {
		return servicePersonne.deletePersonne(personneId);
	}
}


