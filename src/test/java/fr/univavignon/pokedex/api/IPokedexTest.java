package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {
    private IPokedex IPokedexTestMock;

    @Before
    public void setUp() throws PokedexException {
        IPokedexTestMock = new Pokedex();
        IPokedexTestMock.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,56));
        IPokedexTestMock.addPokemon(new Pokemon(1, "Bulbizarre2", 127, 127, 90, 613, 64, 4000, 4,56));
        /*
        when(IPokedexTestMock.size()).thenReturn(2);
        Pokemon expectedPokemon =
                new Pokemon(1, "Bulbizarre", 45, 49, 49, 0, 0, 0, 0,0);
        when(IPokedexTestMock.getPokemon(1)).thenReturn(expectedPokemon);

        when(IPokedexTestMock.getPokemons()).thenReturn(List.of(new Pokemon(1, "Bulbizarre", 45, 49, 49, 0, 0, 0, 0,0),
                new Pokemon(2, "CloneClonique", 45, 49, 49, 0, 0, 0, 0,0)));

        Comparator<Pokemon> nameComparator = PokemonComparators.INDEX;
        when(IPokedexTestMock.getPokemons(nameComparator)).thenReturn(List.of(new Pokemon(1, "Bulbizarre", 45, 49, 49, 0, 0, 0, 0,0),
                new Pokemon(2, "CloneClonique", 45, 49, 49, 0, 0, 0, 0,0)));
        */

    }


    @Test
    public void getPokemonsOrderedTest(){
        Comparator<Pokemon> nameComparator = PokemonComparators.INDEX;
        List <Pokemon> poke= IPokedexTestMock.getPokemons(nameComparator);
        assertEquals(poke.get(0).getIndex(),0);
        assertEquals(poke.get(1).getIndex(),1);
    }



    @Test
    public void IPokedexTestTest() {
        List <Pokemon> poke= IPokedexTestMock.getPokemons();
        //on peut faire plein de assert ici si on veut
        assertEquals(poke.get(0).getHp(),64);
        assertEquals(poke.get(1).getHp(),64);
    }

    @Test
    public void sizeTest(){
        assertEquals(IPokedexTestMock.size(),2);
    }

    @Test
    public void IndexGetTest() throws PokedexException {
        Pokemon expectedPokemon =
                new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,56);

        assertEquals(IPokedexTestMock.getPokemon(0).getIndex(), expectedPokemon.getIndex());
        assertEquals(IPokedexTestMock.getPokemon(0).getName(), expectedPokemon.getName());
        assertEquals(IPokedexTestMock.getPokemon(0).getAttack(), expectedPokemon.getAttack());
        assertEquals(IPokedexTestMock.getPokemon(0).getDefense(), expectedPokemon.getDefense());
        assertEquals(IPokedexTestMock.getPokemon(0).getStamina(), expectedPokemon.getStamina());
    }
}
