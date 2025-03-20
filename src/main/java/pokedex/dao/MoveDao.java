package pokedex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pokedex.entity.Move;

@Repository
public interface MoveDao extends JpaRepository<Move, Long> {
	Move findByName(String Name);
}
