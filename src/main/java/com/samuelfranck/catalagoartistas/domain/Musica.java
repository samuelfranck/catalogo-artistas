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
public class Musica implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer duracao;
	
	@ManyToMany
	@JoinTable(name = "MUSICA_ALBUM",
		joinColumns = @JoinColumn(name="musica_id"),
		inverseJoinColumns = @JoinColumn(name="album_id")
	)
	private List<Album> albunsQueCompoe = new ArrayList<>();
	
	@ManyToMany(mappedBy="musicasInterpretadas")
	private List<Artista> interpretes = new ArrayList<>();
	
	@ManyToMany(mappedBy="musicasComoAutor")
	private List<Artista> autores = new ArrayList<>();
	
	public Musica() {
	}

	public Musica(Integer id, String nome, Integer duracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public List<Album> getAlbunsQueCompoe() {
		return albunsQueCompoe;
	}

	public void setAlbunsQueCompoe(List<Album> albunsQueCompoe) {
		this.albunsQueCompoe = albunsQueCompoe;
	}

	public List<Artista> getInterpretes() {
		return interpretes;
	}

	public void setInterpretes(List<Artista> interpretes) {
		this.interpretes = interpretes;
	}

	public List<Artista> getAutores() {
		return autores;
	}

	public void setAutores(List<Artista> autores) {
		this.autores = autores;
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
		Musica other = (Musica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
