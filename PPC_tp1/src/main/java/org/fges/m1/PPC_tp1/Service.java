package org.fges.m1.PPC_tp1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public class Service {
	
	private ArrayList<Personne> personnes = new ArrayList<Personne>() {
		private static final long serialVersionUID = 1L;

		{
			add(new Personne(1, "Katrine","Makarova"));
			add(new Personne(2, "Henri","Boulnois"));
			add(new Personne(3, "Mona","Lisa"));
		}
		};
	
	public ResponseEntity<Personne> putPersonne(Personne p) {
		personnes.add(p);
		return ResponseEntity.ok(p);
	}
	
	public ResponseEntity<Personne> updatePersonne(Personne p) {
		this.deletePersonne(p.getId());
		return this.putPersonne(p);
	}
	
	public ResponseEntity<Personne> deletePersonne(int id) {
		Personne oldPersonne = personnes.stream().filter(personne -> personne.getId() == id).findFirst().get();
		personnes.remove(oldPersonne);
		return ResponseEntity.ok(oldPersonne);
	}
	
	public List<Personne> getList() {
		return this.personnes;
	}

}
