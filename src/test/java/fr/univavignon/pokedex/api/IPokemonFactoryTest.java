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
        pokemonFactoryMock = mock(IPokemonFactory.class);
        Pokemon expectedPokemon = new Pokemon(1, "Bulbizarre", 45, 49, 49, 0, 0, 0, 0,0);
        when(pokemonFactoryMock.createPokemon(1, 45, 49, 49,0)).thenReturn(expectedPokemon);
    }

    @Test
    public void testCreatePokemon() {
        Pokemon expectedPokemon = new Pokemon(1, "Bulbizarre", 45, 49, 49, 0, 0, 0, 0,0);

        Pokemon actualPokemon = pokemonFactoryMock.createPokemon(1, 45, 49, 49,0);

        assertEquals(expectedPokemon.getDust(), actualPokemon.getDust());
        assertEquals(expectedPokemon.getHp(), actualPokemon.getHp());
        assertEquals(expectedPokemon.getIndex(), actualPokemon.getIndex());
        assertEquals(expectedPokemon.getName(), actualPokemon.getName());
        assertEquals(expectedPokemon.getAttack(), actualPokemon.getAttack());
        assertEquals(expectedPokemon.getDefense(), actualPokemon.getDefense());
        assertEquals(expectedPokemon.getStamina(), actualPokemon.getStamina());
    }
}
