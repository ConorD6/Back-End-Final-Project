package pokedex.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pokedex.controller.model.MoveData;
import pokedex.controller.model.PokemonData;
import pokedex.controller.model.TrainerData;
import pokedex.dao.MoveDao;
import pokedex.dao.PokemonDao;
import pokedex.dao.TrainerDao;
import pokedex.entity.Move;
import pokedex.entity.Pokemon;
import pokedex.entity.Trainer;

@Service
public class PokedexService {

	@Autowired
	private PokemonDao pokemonDao;
	
	@Autowired
	private TrainerDao trainerDao;
	
	@Autowired
	private MoveDao moveDao;
	
	@Transactional(readOnly = false)
	public TrainerData saveTrainer(TrainerData trainerData) {
		Long trainerId = trainerData.getTrainerId();
		Trainer trainer = findOrCreateTrainer(trainerId);
		
		copyTrainerFields(trainer, trainerData);
		return new TrainerData(trainerDao.save(trainer));
	}
	
	private void copyTrainerFields(Trainer trainer, TrainerData trainerData) {
		trainer.setTrainerId(trainerData.getTrainerId());
		trainer.setName(trainerData.getTrainerName());
		trainer.setRegion(trainerData.getRegion());
	}
	
	private Trainer findOrCreateTrainer(Long trainerId) {
		if(Objects.isNull(trainerId)) {
			return new Trainer();
		} else {
			return findTrainerById(trainerId);
		}
	}
	private Trainer findTrainerById(Long trainerId) {
		return trainerDao.findById(trainerId)
				.orElseThrow(() -> new NoSuchElementException(
						"Trainer with ID=" + trainerId + " was not found."));
	}

	@Transactional(readOnly = false)
	public PokemonData savePokemon(Long trainerId, PokemonData pokemonData) {
		Trainer trainer = findTrainerById(trainerId);
		Long pokemonId = pokemonData.getPokemonId();
		Pokemon pokemon = findOrCreatePokemon(pokemonId);
		
		if (pokemonData.getName() != null) {
	        pokemon.setName(pokemonData.getName());
	    }
	    if (pokemonData.getType() != null) {
	        pokemon.setType(pokemonData.getType());
	    }
	    if (pokemonData.getBaseStats() != null) {
	        pokemon.setBaseStats(pokemonData.getBaseStats());
	    }
	    if (pokemonData.getEvolutionStage() != null) {
	        pokemon.setEvolutionStage(pokemonData.getEvolutionStage());
	    }
	    
		pokemon.setTrainer(trainer);
		 if (!trainer.getPokemonList().contains(pokemon)) {
		        trainer.getPokemonList().add(pokemon); 
		    }
		
		return new PokemonData(pokemonDao.save(pokemon));
	}
	
	
	
	private void copyPokemonFields(Pokemon pokemon, PokemonData pokemonData) {
		pokemon.setPokemonId(pokemonData.getPokemonId());
		pokemon.setName(pokemonData.getName());
		pokemon.setType(pokemonData.getType());
		pokemon.setBaseStats(pokemonData.getBaseStats());
		pokemon.setEvolutionStage(pokemonData.getEvolutionStage());
	}

	private Pokemon findOrCreatePokemon(Long pokemonId) {
		if(Objects.isNull(pokemonId)) {
			return new Pokemon();
		} else {
			return findPokemonById(pokemonId);
		}
	}

	private Pokemon findPokemonById(Long pokemonId) {
		return pokemonDao.findById(pokemonId)
				.orElseThrow(() -> new NoSuchElementException(
				"Pokemon with ID=" + pokemonId + " was not found."));
	}
	 public Move findMoveById(Long moveId) {
	        Optional<Move> optionalMove = moveDao.findById(moveId);
	        return optionalMove.orElseThrow(() -> new NoSuchElementException("Move not found with ID: " + moveId));
	    }
	
	@Transactional(readOnly = true)
	public PokemonData retrievePokemonForTrainer(Long trainerId, Long pokemonId) {
	    Pokemon pokemon = findPokemonById(pokemonId);
	    if (pokemon.getTrainer() == null || !pokemon.getTrainer().getTrainerId().equals(trainerId)) {
            throw new NoSuchElementException("This Pokémon does not belong to the specified trainer.");
        }
            return new PokemonData(pokemon);
	}
	
	@Transactional(readOnly = true)
	public TrainerData retrieveTrainerById(Long trainerId) {
		return new TrainerData(findTrainerById(trainerId));
	}
	
	@Transactional(readOnly = false)
	public void deleteTrainerById(Long trainerId) {
		Trainer trainer = findTrainerById(trainerId);
		for (Pokemon pokemon : trainer.getPokemonList()) {
	        pokemon.setTrainer(null);
	    }
		trainerDao.delete(trainer);
	}

	@Transactional(readOnly = false)
	public MoveData saveMove(MoveData moveData) {
	    Move move = new Move();
	    move.setMoveId(moveData.getMoveId());
	    move.setName(moveData.getName());
	    move.setType(moveData.getType());
	    move.setPower(moveData.getPower());
	    move.setAccuracy(moveData.getAccuracy());
	    return new MoveData(moveDao.save(move));
	}
	
	 @Transactional(readOnly = true)
	    public List<TrainerData> retrieveAllTrainers() {
	        List<Trainer> trainers = trainerDao.findAll();
	        List<TrainerData> trainerDataList = new LinkedList<>();

	        for (Trainer trainer : trainers) {
	            trainerDataList.add(new TrainerData(trainer));
	        }

	        return trainerDataList;
	    }
	
	 @Transactional(readOnly = false)
	 public void removePokemonFromTrainer(Long trainerId, Long pokemonId) {
	     Trainer trainer = findTrainerById(trainerId); 
	     Pokemon pokemon = findPokemonById(pokemonId); 

	     if (!trainer.getPokemonList().contains(pokemon)) {
	         throw new NoSuchElementException("This Pokémon does not belong to the specified trainer.");
	     }

	     trainer.getPokemonList().remove(pokemon); 
	     pokemon.setTrainer(null);

	     pokemonDao.save(pokemon); 
	     trainerDao.save(trainer); 
	 }
	 @Transactional(readOnly = true)
	 public PokemonData retrievePokemonById(Long pokemonId) {
	     return new PokemonData(findPokemonById(pokemonId));
	 }
	
	@Transactional(readOnly = true)
	public List<PokemonData> retrieveAllPokemon() {
	    List<Pokemon> pokemonList = pokemonDao.findAll();
	    List<PokemonData> pokemonDataList = new ArrayList<>();
	    for (Pokemon pokemon : pokemonList) {
	        pokemonDataList.add(new PokemonData(pokemon));
	    }
	    return pokemonDataList;
	}
	@Transactional(readOnly = true)
	public MoveData retrieveMoveById(Long moveId) {
	    Move move = findMoveById(moveId);
	    return new MoveData(move);
	}
	
	@Transactional(readOnly = true)
	public List<MoveData> retrieveAllMoves() {
	    List<Move> moveList = moveDao.findAll();
	    List<MoveData> moveDataList = new ArrayList<>();
	    for (Move move : moveList) {
	        moveDataList.add(new MoveData(move));
	    }
	    return moveDataList;
	}
	
}
