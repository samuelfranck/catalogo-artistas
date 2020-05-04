package com.samuelfranck.catalagoartistas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samuelfranck.catalagoartistas.domain.Album;
import com.samuelfranck.catalagoartistas.services.AlbumService;

@RestController
@RequestMapping(value = "/albuns")
public class AlbumResource {
	
	@Autowired
	private AlbumService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Album obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
