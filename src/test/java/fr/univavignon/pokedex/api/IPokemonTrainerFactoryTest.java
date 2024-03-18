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
        IPokemonTrainerFactoryMock = new PokemonTrainerFactory();
        PokemonTrainerMock = IPokemonTrainerFactoryMock.createTrainer("Cynthia",MYSTIC,new PokedexFactory());

        //teamMystic = MYSTIC;
        //pokedexFactoryMock = new PokedexFactory();

        //when(PokemonTrainerMock.getName()).thenReturn("Cynthia");
        //when(PokemonTrainerMock.getTeam()).thenReturn(MYSTIC);
        //when(IPokemonTrainerFactoryMock.createTrainer("Cynthia", teamMystic, pokedexFactoryMock)).thenReturn(PokemonTrainerMock);
    }



    @Test
    public void IPokemonTrainerFactoryTest() throws PokedexException {
        PokemonTrainerMock = IPokemonTrainerFactoryMock.createTrainer("Cynthia",MYSTIC,new PokedexFactory());
        assertEquals(PokemonTrainerMock.getName(), "Cynthia");
        assertEquals(PokemonTrainerMock.getTeam(), MYSTIC);
    }
}
