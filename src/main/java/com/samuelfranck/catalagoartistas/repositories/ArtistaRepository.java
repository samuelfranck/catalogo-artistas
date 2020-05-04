package com.samuelfranck.catalagoartistas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.samuelfranck.catalagoartistas.domain.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
	
	

}
