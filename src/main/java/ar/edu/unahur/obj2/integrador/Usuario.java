package ar.edu.unahur.obj2.integrador;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.integrador.excepciones.SugereridaNoEncontradaException;
import ar.edu.unahur.obj2.integrador.perfiles.Perfilable;

public class Usuario {
    private final String email;
    private Perfilable perfilCinefilo;
    private String idiomaConfigurado;
    Set<Pelicula> sugerenciasAceptadas = new HashSet<>();
    Set<Pelicula> peliculasVistas = new HashSet<>();

    public Usuario(String email, Perfilable perfilCinefilo, String idiomaConfigurado) {
        this.email = email;
        this.perfilCinefilo = perfilCinefilo;
        this.idiomaConfigurado = idiomaConfigurado;
    }

    public void setPerfilCinefilo(Perfilable perfilCinefilo) {
        this.perfilCinefilo = perfilCinefilo;
    }

    public void setIdiomaConfigurado(String idiomaConfigurado) {
        this.idiomaConfigurado = idiomaConfigurado;
    }

    public String getEmail() {
        return email;
    }

    public Perfilable getPerfilCinefilo() {
        return perfilCinefilo;
    }

    public String getIdiomaConfigurado() {
        return idiomaConfigurado;
    }

    public Set<Pelicula> getSugerenciasAceptadas() {
        return sugerenciasAceptadas;
    }

    public Set<Pelicula> getPeliculasVistas() {
        return peliculasVistas;
    }

    public void verPeliculaAlAzar() throws SugereridaNoEncontradaException {
        peliculasVistas.add(
                sugerenciasAceptadas.stream()
                        .findAny()
                        .orElseThrow(
                                () -> new SugereridaNoEncontradaException("No tenes sugeridas aún")));

    }

    public void agregarSugerencia(Pelicula pelicula) {
        sugerenciasAceptadas.add(pelicula);
    }

    public Boolean aceptaSugerencia(Pelicula pelicula) {
        return perfilCinefilo.aceptaSugerencia(pelicula);
    }

    public Boolean vistePelicula(Pelicula pelicula) {
        return peliculasVistas.contains(pelicula);
    }
}
