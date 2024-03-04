package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static fr.univavignon.pokedex.api.Team.MYSTIC;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory IPokemonTrainerFactoryMock;
    private PokemonTrainer PokemonTrainerMock;
    private Team teamMystic;
    private IPokedexFactory pokedexFactoryMock;

    @Before
    public void setUp() {
        IPokemonTrainerFactoryMock = mock(IPokemonTrainerFactory.class);
        PokemonTrainerMock = mock(PokemonTrainer.class);
        teamMystic = MYSTIC;
        pokedexFactoryMock = mock(IPokedexFactory.class);

        when(PokemonTrainerMock.getName()).thenReturn("Cynthia");
        when(PokemonTrainerMock.getTeam()).thenReturn(MYSTIC);
        when(IPokemonTrainerFactoryMock.createTrainer("Cynthia", teamMystic, pokedexFactoryMock)).thenReturn(PokemonTrainerMock);
    }



    @Test
    public void IPokemonTrainerFactoryTest() throws PokedexException {
        PokemonTrainer PokemonTrainerMockIII= IPokemonTrainerFactoryMock.createTrainer("Cynthia",teamMystic,pokedexFactoryMock);
        assertEquals(PokemonTrainerMockIII.getName(), "Cynthia");
        assertEquals(PokemonTrainerMockIII.getTeam(), MYSTIC);
    }
}
