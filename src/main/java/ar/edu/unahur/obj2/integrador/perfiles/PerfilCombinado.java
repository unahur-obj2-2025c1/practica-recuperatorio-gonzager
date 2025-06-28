package ar.edu.unahur.obj2.integrador.perfiles;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.integrador.Pelicula;

public class PerfilCombinado implements Perfilable {

    List<Perfilable> perfiles = new ArrayList<>();

    public PerfilCombinado(List<Perfilable> perfiles) {
        this.perfiles = perfiles;
    }

    @Override
    public Boolean aceptaSugerencia(Pelicula pelicula) {
        return perfiles.stream().anyMatch(perfil -> perfil.aceptaSugerencia(pelicula));
    }

}
