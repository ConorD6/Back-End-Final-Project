package pokedex.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pokedex.controller.model.MoveData;
import pokedex.controller.model.PokemonData;
import pokedex.controller.model.TrainerData;
import pokedex.service.PokedexService;

@RestController
@RequestMapping("/pokedex")
@Slf4j
public class PokedexController {

	@Autowired
	private PokedexService pokedexService;
	
	@PostMapping("/trainer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TrainerData addTrainer(@RequestBody TrainerData trainerData) {
	    log.info("Adding new Trainer: {}", trainerData);
	    return pokedexService.saveTrainer(trainerData);
	}

	@PutMapping("/trainer/{trainerId}")
	public TrainerData updateTrainer(@PathVariable Long trainerId, @RequestBody TrainerData trainerData) {
	    trainerData.setTrainerId(trainerId);
	    log.info("Updating trainer {}", trainerData);
	    return pokedexService.saveTrainer(trainerData);
	}

	@PostMapping("/trainer/{trainerId}/pokemon")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PokemonData addPokemonToTrainer(@PathVariable Long trainerId, @RequestBody PokemonData pokemonData) {
	    log.info("Adding Pokemon ID={} to trainer with ID={}", pokemonData, trainerId);
	    return pokedexService.savePokemon(trainerId, pokemonData);
	}

	@PostMapping("/move")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MoveData addMove(@RequestBody MoveData moveData) {
	    log.info("Adding new Move: {}", moveData);
	    return pokedexService.saveMove(moveData);
	}

	@GetMapping("/trainer")
	public List<TrainerData> getAllTrainers() {
	    log.info("Retrieving all trainers");
	    return pokedexService.retrieveAllTrainers();
	}

	@GetMapping("/trainer/{trainerId}")
	public TrainerData getTrainerById(@PathVariable Long trainerId) {
	    log.info("Retrieving trainer with ID={}", trainerId);
	    return pokedexService.retrieveTrainerById(trainerId);
	}

	@GetMapping("/trainer/{trainerId}/pokemon/{pokemonId}")
	public PokemonData getPokemonForTrainer(@PathVariable Long trainerId, @PathVariable Long pokemonId) {
	    log.info("Retrieving Pokemon with ID={} for Trainer with ID={}", pokemonId, trainerId);
	    return pokedexService.retrievePokemonForTrainer(trainerId, pokemonId);
	}
	
	@GetMapping("/pokemon")
	public ResponseEntity<List<PokemonData>> getAllPokemon() {
	    List<PokemonData> pokemonDataList = pokedexService.retrieveAllPokemon();
	    return ResponseEntity.ok(pokemonDataList);
	}
	
	@GetMapping("/pokemon/{id}")
	public ResponseEntity<PokemonData> getPokemonById(@PathVariable Long id) {
	    PokemonData pokemonData = pokedexService.retrievePokemonById(id);
	    return ResponseEntity.ok(pokemonData);
	}

	@DeleteMapping("/trainer/{trainerId}")
	public Map<String, String> deleteTrainerById(@PathVariable Long trainerId) {
	    log.info("Deleting trainer with ID={}", trainerId);
	    pokedexService.deleteTrainerById(trainerId);
	    return Map.of("message", "Trainer with ID=" + trainerId + " deleted.");
	}
	
	@DeleteMapping("/{trainerId}/pokemon/{pokemonId}")
    public ResponseEntity<Void> removePokemonFromTrainer(
        @PathVariable Long trainerId, 
        @PathVariable Long pokemonId
    ) {
        try {
            pokedexService.removePokemonFromTrainer(trainerId, pokemonId);
            return ResponseEntity.noContent().build(); // Return HTTP 204 No Content when successful
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return HTTP 404 if not found
        }
}
}