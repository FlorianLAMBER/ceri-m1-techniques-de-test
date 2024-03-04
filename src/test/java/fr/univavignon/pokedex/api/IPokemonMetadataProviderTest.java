package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokemonMetadata;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProviderMock;

    @Before
    public void setUp() throws PokedexException {
        pokemonMetadataProviderMock = mock(IPokemonMetadataProvider.class);
        PokemonMetadata expectedMetadata = new PokemonMetadata(1, "Bulbizarre", 45, 49, 49);
        when(pokemonMetadataProviderMock.getPokemonMetadata(1)).thenReturn(expectedMetadata);
    }


    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata expectedMetadata = new PokemonMetadata(1, "Bulbizarre", 45, 49, 49);
        PokemonMetadata actualMetadata = pokemonMetadataProviderMock.getPokemonMetadata(1);

        assertEquals(expectedMetadata.getIndex(), actualMetadata.getIndex());
        assertEquals(expectedMetadata.getName(), actualMetadata.getName());
        assertEquals(expectedMetadata.getAttack(), actualMetadata.getAttack());
        assertEquals(expectedMetadata.getDefense(), actualMetadata.getDefense());
        assertEquals(expectedMetadata.getStamina(), actualMetadata.getStamina());
    }
}
