package br.com.intensivao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intensivao.dslist.dto.GameListDTO;
import br.com.intensivao.dslist.entities.GameList;
import br.com.intensivao.dslist.repositorys.GameListRepository;
import jakarta.transaction.Transactional;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	@Transactional
	public List<GameListDTO> findAll(){
		List<GameList> result = repository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

}
