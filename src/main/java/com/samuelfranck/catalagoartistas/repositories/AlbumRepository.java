package com.samuelfranck.catalagoartistas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.samuelfranck.catalagoartistas.domain.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
	
	

}
