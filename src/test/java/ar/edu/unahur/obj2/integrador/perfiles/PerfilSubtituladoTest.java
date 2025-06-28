package ar.edu.unahur.obj2.integrador.perfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.integrador.Pelicula;

public class PerfilSubtituladoTest {
    Pelicula peli = new Pelicula("Drama", 2003, "Español");

    @BeforeEach
    void setUp() {
        peli.quitarSubtitulos();
    }

    @Test
    void testAceptaSugerencia() {
        Perfilable perfilSubTitulo = new PerfilSubtitulado();
        peli.agregarSubtitulo("Español");
        peli.agregarSubtitulo("Ingles");
        assertTrue(perfilSubTitulo.aceptaSugerencia(peli));
    }

    @Test
    void testNoAceptaSugerenciaPorNoTenerSubtitulos() {
        Perfilable perfilSubTitulo = new PerfilSubtitulado();
        assertFalse(perfilSubTitulo.aceptaSugerencia(peli));
    }

    @Test
    void testNoAceptaSugerenciaPorTenerSubTitulosQueNoSonDelIdiomaOriginal() {
        Perfilable perfilSubTitulo = new PerfilSubtitulado();
        peli.agregarSubtitulo("Ingles");
        assertFalse(perfilSubTitulo.aceptaSugerencia(peli));
    }

}
