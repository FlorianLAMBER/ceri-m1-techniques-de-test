package fr.univavignon.pokedex.api;

import com.google.gson.JsonObject;

import java.io.IOException;

import static fr.univavignon.pokedex.api.getPokemonByIndex.getPokemonByIndexI;

public class PokemonFactory implements IPokemonFactory{
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            JsonObject pokemon = getPokemonByIndexI(index);
            if (pokemon != null) {
                System.out.println("Metadata Pokemon trouvé : " + pokemon.get("Nom").getAsString());

                return new Pokemon(index,pokemon.get("Nom").getAsString(),pokemon.get("Attaque").getAsInt(),
                        pokemon.get("Défense").getAsInt(),pokemon.get("Endurance").getAsInt(),cp,hp,dust,candy,pokemon.get("IV").getAsDouble());

            } else {
                System.out.println("MISSINGNO " + index);
                return new Pokemon(index, "MISSING NO",999, 999,999,cp,hp,dust,candy,15.0);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
        }
        return null;
    }
}
