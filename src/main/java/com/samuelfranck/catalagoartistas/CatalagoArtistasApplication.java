package com.samuelfranck.catalagoartistas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samuelfranck.catalagoartistas.domain.Album;
import com.samuelfranck.catalagoartistas.domain.Artista;
import com.samuelfranck.catalagoartistas.domain.Musica;
import com.samuelfranck.catalagoartistas.repositories.AlbumRepository;
import com.samuelfranck.catalagoartistas.repositories.ArtistaRepository;
import com.samuelfranck.catalagoartistas.repositories.MusicaRepository;

@SpringBootApplication
public class CatalagoArtistasApplication implements CommandLineRunner {
	
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private MusicaRepository musicaRepository;
	@Autowired
	private ArtistaRepository artistaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CatalagoArtistasApplication.class, args);
		
		}

	@Override
	public void run(String... args) throws Exception {
		
		Musica m1 = new Musica(null, "Smooth Criminal", 250);
		Musica m2 = new Musica(null, "Biilie Jean", 300);
		Musica m3 = new Musica(null, "Beat it", 240);
		Musica m4 = new Musica(null, "We are the world", 390);
		
		Album alb1 = new Album(null, "Bad", 1987);
		Album alb2 = new Album(null, "Thriller", 1982);
		Album alb3 = new Album(null, "We are the world", 1985);
		
		Artista a1 = new Artista(null, "Michael Jackson", "USA");
		Artista a2 = new Artista(null, "Ray Charles", "USA");
		
		alb1.getMusicas().addAll(Arrays.asList(m1));
		alb2.getMusicas().addAll(Arrays.asList(m2, m3));
		alb3.getMusicas().addAll(Arrays.asList(m4));
		
		alb1.getParticipantes().addAll(Arrays.asList(a1));
		alb1.getParticipantes().addAll(Arrays.asList(a1));
		alb1.getParticipantes().addAll(Arrays.asList(a1,a2));

		m1.getAlbunsQueCompoe().addAll(Arrays.asList(alb1));
		m2.getAlbunsQueCompoe().addAll(Arrays.asList(alb2));
		m3.getAlbunsQueCompoe().addAll(Arrays.asList(alb2));
		m4.getAlbunsQueCompoe().addAll(Arrays.asList(alb3));
		
		m1.getAutores().addAll(Arrays.asList(a1));
		m2.getAutores().addAll(Arrays.asList(a1));
		m3.getAutores().addAll(Arrays.asList(a1));
		m4.getAutores().addAll(Arrays.asList(a1));
		
		m1.getInterpretes().addAll(Arrays.asList(a1));
		m2.getInterpretes().addAll(Arrays.asList(a1));
		m3.getInterpretes().addAll(Arrays.asList(a1));
		m4.getInterpretes().addAll(Arrays.asList(a1,a2));
		
		a1.getMusicasComoAutor().addAll(Arrays.asList(m1, m2, m3, m4));
		a1.getMusicasInterpretadas().addAll(Arrays.asList(m1, m2, m3, m4));
		a2.getMusicasInterpretadas().addAll(Arrays.asList(m4));
		
		a1.getAlbunsQueParticipa().addAll(Arrays.asList(alb1,alb2,alb3));
		a2.getAlbunsQueParticipa().addAll(Arrays.asList(alb3));
		
		albumRepository.saveAll(Arrays.asList(alb1,alb2,alb3));
		musicaRepository.saveAll(Arrays.asList(m1,m2,m3,m4));
		artistaRepository.saveAll(Arrays.asList(a1,a2));
		
		
	}
}