package fr.univavignon.pokedex.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
/**
 * Récupère le Pokémon à partir de son index dans le Pokédex.
 */
public class PokemonFetcher {
    /**
     * Récupère le Pokémon à partir de son index dans le Pokédex.
     *
     * @param index L'index du Pokémon à récupérer.
     * @return L'objet JsonObject représentant le Pokémon trouvé, ou null s'il n'est pas trouvé.
     * @throws IOException Si une erreur d'entrée-sortie se produit lors de la lecture du fichier JSON.
     */
    public static JsonObject getPokemonByIndex(int index) throws IOException {
        // Crée un parseur JSON
        JsonParser parser = new JsonParser();

        // Lit le fichier JSON contenant les données des Pokémon
        JsonArray pokemonsArray = parser.parse(new FileReader("src/main/java/fr/univavignon/pokedex/api/pokemonDB.json")).getAsJsonArray();

        // Parcours la liste des Pokémon
        for (JsonElement element : pokemonsArray) {
            JsonObject pokemon = element.getAsJsonObject();
            int pokemonIndex = pokemon.get("Index").getAsInt();

            // Vérifie si l'index du Pokémon correspond à l'index recherché
            if (pokemonIndex == index) {
                // Retourne le Pokémon trouvé
                return pokemon;
            }
        }

        // Aucun Pokémon trouvé pour cet index, retourne null
        return null;
    }
}