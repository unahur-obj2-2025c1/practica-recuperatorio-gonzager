package ar.edu.unahur.obj2.integrador.perfiles;

import ar.edu.unahur.obj2.integrador.Pelicula;

public class PerfilModerno implements Perfilable {
    private Integer minimo;

    public PerfilModerno(Integer minimo) {
        this.minimo = minimo;
    }

    @Override
    public Boolean aceptaSugerencia(Pelicula pelicula) {
        return pelicula.getAnioEstreno() >= minimo;
    }

}
