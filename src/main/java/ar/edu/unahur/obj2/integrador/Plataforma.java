package ar.edu.unahur.obj2.integrador;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.integrador.Observer.Observable;
import ar.edu.unahur.obj2.integrador.Observer.Observador;
import ar.edu.unahur.obj2.integrador.Observer.PeliculaDTO;
import ar.edu.unahur.obj2.integrador.excepciones.SugereridaNoEncontradaException;

public class Plataforma implements Observable {
    Set<Pelicula> peliculas = new HashSet<>();
    Set<Usuario> usuarios = new HashSet<>();
    Set<Observador> observadores = new HashSet<>();

    void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        notificar(new PeliculaDTO(pelicula.getNombre(), pelicula.getGenero()));
    }

    void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    void sugerir() {
        peliculas.stream()
                .forEach(pelicula -> sugerirUnaPelicula(pelicula));
    }

    void sugerirUnaPelicula(Pelicula pelicula) {
        usuarios.stream()
                .filter(usuario -> usuario.aceptaSugerencia(pelicula) && !usuario.vistePelicula(pelicula))
                .forEach(usuario -> usuario.agregarSugerencia(pelicula));
    }

    @Override
    public void agregar(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void quitar(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar(PeliculaDTO peliculaDTO) {
        observadores.forEach(
                o -> o.actualizar(peliculaDTO));

    }

    public void presionaVerPeliculaAlAzar(Usuario usuario) {
        try {
            usuario.verPeliculaAlAzar();
        } catch (SugereridaNoEncontradaException e) {
            // Mostrariamos un lindo mensaje al usuario
            System.out.println(e.getMessage());
        }
    }
}
