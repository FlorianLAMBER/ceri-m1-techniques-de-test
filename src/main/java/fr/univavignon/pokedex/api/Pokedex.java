package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    List<Pokemon> pokedexList = new ArrayList<>();
    @Override
    public int size() {
        return pokedexList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokedexList.add(pokemon);
        return pokedexList.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokedexList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokedexList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokedexList);
        sortedPokemons.sort(order);
        return Collections.unmodifiableList(sortedPokemons);
    }





    //weird
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return null;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return null;
    }
}
