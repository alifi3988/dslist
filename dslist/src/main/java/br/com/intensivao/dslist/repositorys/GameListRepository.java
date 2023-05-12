package br.com.intensivao.dslist.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.intensivao.dslist.entities.GameList;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long>{

}
