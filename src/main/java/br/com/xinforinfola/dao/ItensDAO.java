package br.com.xinforinfola.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.xinforinfola.beans.Itens;

public interface ItensDAO extends CrudRepository<Itens, Integer>{
	public Itens findById(int id);
}
