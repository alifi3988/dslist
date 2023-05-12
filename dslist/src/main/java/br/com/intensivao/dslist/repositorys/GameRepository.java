package br.com.intensivao.dslist.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.intensivao.dslist.entities.Game;
import br.com.intensivao.dslist.projections.GameMinProjection;


@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	
	
	@Query(
			nativeQuery = true,
			value = """
					SELECT G.id, G.title, G.game_year AS "year", G.img_url AS "imagem", G.short_description AS "descricao", B.position
					FROM tb_games G
					INNER JOIN tb_belonging B ON G.id = B.game_id
					WHERE B.list_id = :listId 
					ORDER BY B.position;
					""")
	
	List<GameMinProjection> searchByList(Long listId);
	

}
