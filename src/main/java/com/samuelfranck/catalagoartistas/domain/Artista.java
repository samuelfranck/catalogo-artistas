package com.samuelfranck.catalagoartistas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String Nacionalidade;
	
	@ManyToMany
	@JoinTable(name="ARTISTA_ALBUM",
	joinColumns = @JoinColumn(name = "artista_id"),
	inverseJoinColumns = @JoinColumn(name = "album_id")
	)
	private List<Album> albunsQueParticipa = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="AUTORES_MUSICAS",
	joinColumns = @JoinColumn(name="artista_id"),
	inverseJoinColumns = @JoinColumn(name="musica_id")
	)
	private List<Musica> musicasComoAutor = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="INTERPRETES_MUSICAS",
	joinColumns = @JoinColumn(name="artista_id"),
	inverseJoinColumns = @JoinColumn(name="musica_id")
	)
	private List<Musica> musicasInterpretadas = new ArrayList<>();

	public Artista() {
	}

	public Artista(Integer id, String nome, String nacionalidade) {
		super();
		this.id = id;
		this.nome = nome;
		Nacionalidade = nacionalidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return Nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		Nacionalidade = nacionalidade;
	}
	
	public List<Album> getAlbunsQueParticipa() {
		return albunsQueParticipa;
	}

	public void setAlbunsQueParticipa(List<Album> albunsQueParticipa) {
		this.albunsQueParticipa = albunsQueParticipa;
	}

	public List<Musica> getMusicasInterpretadas() {
		return musicasInterpretadas;
	}

	public void setMusicasInterpretadas(List<Musica> musicasInterpretadas) {
		this.musicasInterpretadas = musicasInterpretadas;
	}
	
	public List<Musica> getMusicasComoAutor() {
		return musicasComoAutor;
	}

	public void setMusicasComoAutor(List<Musica> musicasComoAutor) {
		this.musicasComoAutor = musicasComoAutor;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
