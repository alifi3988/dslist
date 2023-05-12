package br.com.intensivao.dslist.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.intensivao.dslist.dto.GameDTO;
import br.com.intensivao.dslist.dto.GameMinDTO;
import br.com.intensivao.dslist.repositorys.GameRepository;
import jakarta.transaction.Transactional;


@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional
	public List<GameMinDTO> findAll(){
		return repository.findAll().stream().map(x -> new GameMinDTO(x)).toList();		
	}
	
	@Transactional
	public GameDTO findById(Long id) {
		System.out.println("ID: " + id);
		var game = repository.findById(id).get();
		System.out.println(game.toString());
		return new GameDTO(game);
	}
	
	
	@Transactional
	public List<GameMinDTO> findByList(Long listId){
		return repository.searchByList(listId).stream().map(x -> new GameMinDTO(x)).toList();
	}
}
