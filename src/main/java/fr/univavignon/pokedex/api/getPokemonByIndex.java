package fr.univavignon.pokedex.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class getPokemonByIndex {
    public static JsonObject getPokemonByIndexI(int index) throws IOException {
        JsonParser parser = new JsonParser();
        JsonArray pokemonsArray = parser.parse(new FileReader("src/main/java/fr/univavignon/pokedex/api/pokemonDB.json")).getAsJsonArray();

        for (JsonElement element : pokemonsArray) {
            JsonObject pokemon = element.getAsJsonObject();
            int pokemonIndex = pokemon.get("Index").getAsInt();
            if (pokemonIndex == index) {
                return pokemon;
            }
        }
        return null;
    }
}
