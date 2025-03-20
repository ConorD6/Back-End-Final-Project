package pokedex.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pokedex.entity.Move;

@Data
@NoArgsConstructor
public class MoveData {

	private Long moveId;
	private String name;
	private int power;
	private int accuracy;
	private String type;
	
	public MoveData(Move move) {
		moveId = move.getMoveId();
		name = move.getName();
		power = move.getPower();
		accuracy = move.getAccuracy();
		type = move.getType();
		
	}
}
