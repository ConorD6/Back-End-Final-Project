--Insert Pokemon
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Bulbasaur', 'Grass', 318, '1');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Ivysaur', 'Grass', 405, '2');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Venusaur', 'Grass', 525, '3');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Charmander', 'Fire', 309, '1');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Charmeleon', 'Fire', 405, '2');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Charizard', 'Fire', 534, '3');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Squirtle', 'Water', 314, '1');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Wartortle', 'Water', 405, '2');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Blastoise', 'Water', 530, '3');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Caterpie', 'Bug', 195, '1');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Metapod', 'Bug', 205, '2');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Butterfree', 'Bug', 395, '3');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Weedle', 'Bug', 195, '1');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Kakuna', 'Bug', 205, '2');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Beedrill', 'Bug', 395, '3');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Pidgey', 'Normal', 251, '1');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Pidgeotto', 'Normal', 349, '2');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Pidgeot', 'Normal', 479, '3');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Rattata', 'Normal', 253, '1');
INSERT INTO pokemon (name, type, base_stats, evolution_stage) VALUES ('Raticate', 'Normal', 413, '2');

--Insert Move
INSERT INTO move (name, type, power, accuracy) VALUES ('Tackle', 'Normal', 40, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Vine Whip', 'Grass', 45, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('SolarBeam', 'Grass', 120, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Razor Leaf', 'Grass', 55, 95);
INSERT INTO move (name, type, power, accuracy) VALUES ('Scratch', 'Normal', 40, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Ember', 'Fire', 40, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Flamethrower', 'Fire', 90, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Fly', 'Flying', 90, 95);
INSERT INTO move (name, type, power, accuracy) VALUES ('Bubble', 'Water', 40, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Water Gun', 'Water', 40, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Hydro Pump', 'Water', 110, 80);
INSERT INTO move (name, type, power, accuracy) VALUES ('Bite', 'Dark', 60, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('String Shot', 'Bug', 0, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Harden', 'Normal', 0, 0);
INSERT INTO move (name, type, power, accuracy) VALUES ('Confusion', 'Psychic', 50, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Sleep Powder', 'Bug', 0, 75);
INSERT INTO move (name, type, power, accuracy) VALUES ('Poison Sting', 'Poison', 15, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Twinneedle', 'Bug', 25, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Rage', 'Normal', 20, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Gust', 'Flying', 40, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Quick Attack', 'Normal', 40, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Wing Attack', 'Flying', 60, 100);
INSERT INTO move (name, type, power, accuracy) VALUES ('Hyper Fang', 'Normal', 80, 90);


-- Bulbasaur's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Bulbasaur'), (SELECT move_id FROM move WHERE name = 'Tackle'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Bulbasaur'), (SELECT move_id FROM move WHERE name = 'Vine Whip'));

-- Ivysaur's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Ivysaur'), (SELECT move_id FROM move WHERE name = 'Tackle'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Ivysaur'), (SELECT move_id FROM move WHERE name = 'Vine Whip'));

-- Venusaur's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Venusaur'), (SELECT move_id FROM move WHERE name = 'SolarBeam'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Venusaur'), (SELECT move_id FROM move WHERE name = 'Razor Leaf'));

-- Charmander's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Charmander'), (SELECT move_id FROM move WHERE name = 'Scratch'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Charmander'), (SELECT move_id FROM move WHERE name = 'Ember'));

-- Charmeleon's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Charmeleon'), (SELECT move_id FROM move WHERE name = 'Flamethrower'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Charmeleon'), (SELECT move_id FROM move WHERE name = 'Scratch'));

-- Charizard's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Charizard'), (SELECT move_id FROM move WHERE name = 'Flamethrower'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Charizard'), (SELECT move_id FROM move WHERE name = 'Fly'));

-- Squirtle's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Squirtle'), (SELECT move_id FROM move WHERE name = 'Tackle'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Squirtle'), (SELECT move_id FROM move WHERE name = 'Bubble'));

-- Wartortle's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Wartortle'), (SELECT move_id FROM move WHERE name = 'Bite'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Wartortle'), (SELECT move_id FROM move WHERE name = 'Water Gun'));

-- Blastoise's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Blastoise'), (SELECT move_id FROM move WHERE name = 'Hydro Pump'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Blastoise'), (SELECT move_id FROM move WHERE name = 'Bite'));

-- Caterpie's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Caterpie'), (SELECT move_id FROM move WHERE name = 'Tackle'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Caterpie'), (SELECT move_id FROM move WHERE name = 'String Shot'));

-- Metapod's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Metapod'), (SELECT move_id FROM move WHERE name = 'Harden'));

-- Butterfree's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Butterfree'), (SELECT move_id FROM move WHERE name = 'Confusion'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Butterfree'), (SELECT move_id FROM move WHERE name = 'Sleep Powder'));

-- Weedle's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Weedle'), (SELECT move_id FROM move WHERE name = 'Poison Sting'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Weedle'), (SELECT move_id FROM move WHERE name = 'String Shot'));

-- Kakuna's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Kakuna'), (SELECT move_id FROM move WHERE name = 'Harden'));

-- Beedrill's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Beedrill'), (SELECT move_id FROM move WHERE name = 'Twinneedle'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Beedrill'), (SELECT move_id FROM move WHERE name = 'Rage'));

-- Pidgey's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Pidgey'), (SELECT move_id FROM move WHERE name = 'Tackle'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Pidgey'), (SELECT move_id FROM move WHERE name = 'Gust'));

-- Pidgeotto's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Pidgeotto'), (SELECT move_id FROM move WHERE name = 'Gust'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Pidgeotto'), (SELECT move_id FROM move WHERE name = 'Quick Attack'));

-- Pidgeot's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Pidgeot'), (SELECT move_id FROM move WHERE name = 'Wing Attack'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Pidgeot'), (SELECT move_id FROM move WHERE name = 'Quick Attack'));

-- Rattata's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Rattata'), (SELECT move_id FROM move WHERE name = 'Tackle'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Rattata'), (SELECT move_id FROM move WHERE name = 'Quick Attack'));

-- Raticate's move
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Raticate'), (SELECT move_id FROM move WHERE name = 'Hyper Fang'));
INSERT INTO pokemon_move (pokemon_id, move_id) VALUES ((SELECT pokemon_id FROM pokemon WHERE name = 'Raticate'), (SELECT move_id FROM move WHERE name = 'Quick Attack'));