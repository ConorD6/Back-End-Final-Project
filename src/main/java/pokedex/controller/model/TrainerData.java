package pokedex.controller.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.NoArgsConstructor;
import pokedex.entity.Trainer;

@Data
@NoArgsConstructor	
public class TrainerData {

	private Long trainerId;
	private String trainerName;
	private String region;
	private Set<PokemonData> pokemon = new HashSet<>();
	private Set<PokemonData> pokemonTeam = new HashSet<>();
	
	public TrainerData(Trainer trainer) {
		trainerId = trainer.getTrainerId();
		trainerName = trainer.getName();
		region = trainer.getRegion();
		
		pokemon = trainer.getPokemonList()
				.stream()
				.distinct()
				.map(PokemonData::new)
				.collect(Collectors.toSet());
		
	}
	
}
