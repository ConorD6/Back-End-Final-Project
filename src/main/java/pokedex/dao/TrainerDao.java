package pokedex.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pokedex.entity.Trainer;

@Repository
public interface TrainerDao extends JpaRepository<Trainer, Long> {
	Optional<Trainer> findByName(String name);
}
