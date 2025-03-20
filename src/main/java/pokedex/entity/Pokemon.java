package pokedex.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pokemonId;
	private String name;
	private String type;
	private Integer baseStats;
	private String evolutionStage;
	
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Trainer trainer;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable (name = "pokemon_move", 
			joinColumns = @JoinColumn(name = "pokemon_id"),
			inverseJoinColumns = @JoinColumn(name = "move_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Move> moves = new HashSet<>();
}
