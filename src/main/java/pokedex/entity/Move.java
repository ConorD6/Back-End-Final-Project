package pokedex.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Move {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "move_id")
	private Long moveId;
	private String name;
	private String type;
	private Integer power;
	private Integer accuracy;
	
	@ManyToMany(mappedBy = "moves")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Pokemon> pokemonList = new HashSet<>();
}
