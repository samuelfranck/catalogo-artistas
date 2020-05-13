package com.samuelfranck.catalagoartistas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelfranck.catalagoartistas.domain.Album;
import com.samuelfranck.catalagoartistas.repositories.AlbumRepository;
import com.samuelfranck.catalagoartistas.services.execptions.ObjectNotFoundException;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository repo;
	
	public Album find(Integer id) {
		Optional<Album> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: Id:" + id 
				+ ",Tipo: " + Album.class.getName()));
	}
	
	public Album insert(Album obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
