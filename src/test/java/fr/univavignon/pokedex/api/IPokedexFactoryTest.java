package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {
    private IPokedexFactory IPokedexFactoryyMock;
    private IPokedex IPokedexMock;

    @Before
    public void setUp() {
        IPokedexFactoryyMock = new PokedexFactory();
        //IPokedexMock = mock(IPokedex.class);
        //when(IPokedexMock.size()).thenReturn(0);
        //when(IPokedexFactoryyMock.createPokedex(any(),any())).thenReturn(IPokedexMock);
    }


    @Test
    public void IPokedexFactoryTestTest() throws PokedexException {
        IPokedexMock = IPokedexFactoryyMock.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        assertEquals(IPokedexMock.size(), 0);
    }
}
