package br.com.intensivao.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.intensivao.dslist.dto.GameDTO;
import br.com.intensivao.dslist.dto.GameMinDTO;
import br.com.intensivao.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	
	@Autowired
	private GameService service;
	
	//buscando todos os dados da table
	@GetMapping
	public List<GameMinDTO> findAll(){
		return service.findAll();
	}
	
	///buscar dado da tabela pelo ID
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){
		var result = service.findById(id);
		return result;
	}
	

}
