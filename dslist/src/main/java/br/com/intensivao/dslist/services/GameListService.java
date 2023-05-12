package br.com.intensivao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intensivao.dslist.dto.GameListDTO;
import br.com.intensivao.dslist.entities.GameList;
import br.com.intensivao.dslist.projections.GameMinProjection;
import br.com.intensivao.dslist.repositorys.GameListRepository;
import br.com.intensivao.dslist.repositorys.GameRepository;
import jakarta.transaction.Transactional;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public List<GameListDTO> findAll(){
		List<GameList> result = repository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	//alteração da lista
	@Transactional
	public void move(Long listId, int sorceIndex, int destinationIndex) {
		
		//retornando os jogos de acordo com a lista passada
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		//removendo o desejado da lista
		var obj = list.remove(sorceIndex);
		
		//add no index desejado
		list.add(destinationIndex, obj);
		
		//não precisamos realizar a modificação do BD através da lista de todos os campos
		//Mas sim, somente dos campos entre sorceIndex e destinationIndex
		
		//verificando o maior e o menor para ser def min e max
		int min = sorceIndex < destinationIndex ? sorceIndex : destinationIndex;
		int max = sorceIndex < destinationIndex ? destinationIndex : sorceIndex;
		
		for(int i = min; i< max; i++) {
			repository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
	
	

}
