package com.samuelfranck.catalagoartistas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.samuelfranck.catalagoartistas.domain.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
	
	

}
