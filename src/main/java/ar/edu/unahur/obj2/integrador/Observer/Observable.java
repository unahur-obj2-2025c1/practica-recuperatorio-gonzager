package ar.edu.unahur.obj2.integrador.Observer;

public interface Observable {
    void agregar(Observador observador);

    void quitar(Observador observador);

    void notificar(PeliculaDTO peliculaDTO);
}
