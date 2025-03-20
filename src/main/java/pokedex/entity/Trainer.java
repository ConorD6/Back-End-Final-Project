package pokedex.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Trainer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainerId;
	private String name;
	private String region;
	
	
	@OneToMany(mappedBy = "trainer", orphanRemoval = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Pokemon> pokemonList = new HashSet<>();
	
	public void addPokemon(Pokemon pokemon) {
		if (pokemonList.size() < 6) {
			pokemonList.add(pokemon);
			pokemon.setTrainer(this);
		} else {
			throw new IllegalStateException("A Trainer can only have up to 6 Pokemon.");
		}
	}
}
