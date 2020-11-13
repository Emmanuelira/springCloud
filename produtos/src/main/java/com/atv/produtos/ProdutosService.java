package com.atv.produtos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutosRepository pr;
	
	//POST
	public void salvar(Produtos p) {
		pr.save(p);
	}
	
	//GET GERAL
	public List<Produtos> listarProduto(){
		return pr.findAll();
	}
	
	//GET ESP
	public Optional<Produtos> getProduto(int id) {
		return pr.findById(id);
	}
		
	//PUT
	public void modificar(Produtos prod, int id) {
		Optional<Produtos> p = pr.findById(id);
		if(p.isPresent()) {
			p.get().setNome(prod.getNome());
			pr.save(p.get());
		}		
	}
	
	//DELETE POR ID
	public void deletarPorId(int id) {
		pr.deleteById(id);
	}
	
	//DELETE GERAL
	public void deletarTodos() {
		pr.deleteAll();
	}
	
}
