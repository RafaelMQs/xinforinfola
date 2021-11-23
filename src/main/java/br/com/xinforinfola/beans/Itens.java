package br.com.xinforinfola.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_item")
public class Itens {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome", length = 50)
	private String nome;
	
	@Column(name="quantidade", length = 20)
	private int quantidade;
	
	@Column(name="urlImg", length = 200)
	private String urlImg;

//	GETS E SETS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	@Override
	public String toString() {
		return "Itens [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", urlImg=" + urlImg + "]";
	}
	
}
