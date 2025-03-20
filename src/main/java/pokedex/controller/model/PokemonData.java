package pokedex.controller.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.NoArgsConstructor;
import pokedex.entity.Move;
import pokedex.entity.Pokemon;

@Data
@NoArgsConstructor
public class PokemonData {

	private Long pokemonId;
//	private Long trainerId;
	private String name;
	private String type;
	private Integer baseStats;
	private String evolutionStage;
	private Set<MoveData> moves = new HashSet<>();
	
	public PokemonData(Pokemon pokemon) {
		pokemonId = pokemon.getPokemonId();
		//trainerId = (pokemon.getTrainer() != null) ? pokemon.getTrainer().getTrainerId() : null;
		name = pokemon.getName();
		type = pokemon.getType();
		baseStats = pokemon.getBaseStats();
		evolutionStage = pokemon.getEvolutionStage();
		
		for (Move move : pokemon.getMoves()) {
			moves.add(new MoveData(move));
		}
	}
	
	 public List<String> getMoveNames() {
	        return moves.stream()
	                    .map(MoveData::getName)
	                    .collect(Collectors.toList());
	    }
}
