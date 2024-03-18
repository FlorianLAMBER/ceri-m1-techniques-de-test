package fr.univavignon.pokedex.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

import static fr.univavignon.pokedex.api.getPokemonByIndex.getPokemonByIndexI;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        try {
            JsonObject pokemon = getPokemonByIndexI(index);
            if (pokemon != null) {
                System.out.println("Pokemon trouvé : " + pokemon.get("Nom").getAsString());
                return new PokemonMetadata(index, pokemon.get("Nom").getAsString(),pokemon.get("Attaque").getAsInt(),
                        pokemon.get("Défense").getAsInt(),pokemon.get("Endurance").getAsInt());

            } else {
                System.out.println("MISSINGNO " + index);
                return new PokemonMetadata(index, "MISSING NO",999, 999,999);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
        }
        return null;
    }



}
