package ar.edu.unahur.obj2.integrador.perfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.integrador.Pelicula;

public class PerfilCombinadoTest {

    Pelicula peli = new Pelicula("Drama", 2003, "Español");

    @Test
    void testAceptaSugerenciaTodos() {

        Perfilable combinado = new PerfilCombinado(Arrays.asList(
                new PerfilModerno(2000),
                new PerfilGenero(Arrays.asList("Terror", "Drama", "Policial"))));

        assertTrue(combinado.aceptaSugerencia(peli));
    }

    @Test
    void testAceptaSugerenciaPorMinimo() {

        Perfilable combinado = new PerfilCombinado(Arrays.asList(
                new PerfilModerno(2000),
                new PerfilGenero(Arrays.asList("Terror", "Comedia", "Policial"))));

        assertTrue(combinado.aceptaSugerencia(peli));
    }

    @Test
    void testAceptaSugerenciaPorGenero() {

        Perfilable combinado = new PerfilCombinado(Arrays.asList(
                new PerfilModerno(2010),
                new PerfilGenero(Arrays.asList("Terror", "Drama", "Policial"))));

        assertTrue(combinado.aceptaSugerencia(peli));
    }

    @Test
    void testNoAceptaSugerencia() {

        Perfilable combinado = new PerfilCombinado(Arrays.asList(
                new PerfilModerno(2010),
                new PerfilGenero(Arrays.asList("Terror", "Comedia", "Policial"))));

        assertFalse(combinado.aceptaSugerencia(peli));
    }
}
