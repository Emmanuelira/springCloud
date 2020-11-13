package com.atv.produtos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosService ps;
	
	@PostMapping
	public ResponseEntity<Produtos> salvar(@RequestBody Produtos p) {
		ps.salvar(p);
		return new ResponseEntity<Produtos>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Produtos>> listarProduto() {
		return new ResponseEntity<List<Produtos>>(ps.listarProduto(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produtos>> getProduto(@PathVariable int id) {
		return new ResponseEntity<Optional<Produtos>>(ps.getProduto(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produtos> modificar(@RequestBody Produtos prod, @PathVariable int id) {
		ps.modificar(prod, id);
		return new ResponseEntity<Produtos>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produtos> deletarPorId(@PathVariable int id) {
		ps.deletarPorId(id);
		return new ResponseEntity<Produtos>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Produtos> deletarAll() {
		ps.deletarTodos();
		return new ResponseEntity<Produtos>(HttpStatus.OK);
	}
}

