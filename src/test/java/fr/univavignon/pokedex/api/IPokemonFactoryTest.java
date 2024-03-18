package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactoryMock;

    @Before
    public void setUp() {
        pokemonFactoryMock = new PokemonFactory();
        Pokemon expectedPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,56);
        //when(pokemonFactoryMock.createPokemon(1, 45, 49, 49,0)).thenReturn(expectedPokemon);
    }

    @Test
    public void testCreatePokemon() {
        Pokemon expectedPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,56);

        Pokemon actualPokemon = pokemonFactoryMock.createPokemon(0, 613, 64, 4000,4);

        assertEquals(expectedPokemon.getDust(), actualPokemon.getDust());
        assertEquals(expectedPokemon.getHp(), actualPokemon.getHp());
        assertEquals(expectedPokemon.getIndex(), actualPokemon.getIndex());
        assertEquals(expectedPokemon.getName(), actualPokemon.getName());
        assertEquals(expectedPokemon.getAttack(), actualPokemon.getAttack());
        assertEquals(expectedPokemon.getDefense(), actualPokemon.getDefense());
        assertEquals(expectedPokemon.getStamina(), actualPokemon.getStamina());
    }
}
