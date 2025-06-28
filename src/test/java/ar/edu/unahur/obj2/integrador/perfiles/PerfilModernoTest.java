package ar.edu.unahur.obj2.integrador.perfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.integrador.Pelicula;

public class PerfilModernoTest {

    Pelicula peli = new Pelicula("Drama", 2003, "Español");

    @Test
    void testAceptaSugerencia() {
        Perfilable perfilModerno = new PerfilModerno(2000);
        assertTrue(perfilModerno.aceptaSugerencia(peli));
    }

    @Test
    void testNoAceptaSugerencia() {
        Perfilable perfilModerno = new PerfilModerno(2010);
        assertFalse(perfilModerno.aceptaSugerencia(peli));
    }
}
