package pokedex.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pokedex.entity.Pokemon;

@Repository
public interface PokemonDao extends JpaRepository<Pokemon, Long> {
	Optional<Pokemon> findByTrainer_TrainerIdAndPokemonId(Long trainerId, Long pokemonId);
}
