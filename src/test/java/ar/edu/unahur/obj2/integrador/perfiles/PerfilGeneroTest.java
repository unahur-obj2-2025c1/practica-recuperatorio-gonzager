package ar.edu.unahur.obj2.integrador.perfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.integrador.Pelicula;

public class PerfilGeneroTest {

    Pelicula peli = new Pelicula("Drama", 2003, "Español");

    @Test
    void testAceptaSugerencia() {
        List<String> generos = Arrays.asList("Terror", "Drama", "Policial");
        Perfilable perfilDeGenero = new PerfilGenero(generos);
        assertTrue(perfilDeGenero.aceptaSugerencia(peli));
    }

    @Test
    void testNoAceptaSugerencia() {
        List<String> generos = Arrays.asList("Terror", "Comedia", "Policial");
        Perfilable perfilDeGenero = new PerfilGenero(generos);
        assertFalse(perfilDeGenero.aceptaSugerencia(peli));
    }

}
