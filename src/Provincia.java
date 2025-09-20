import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Provincia {
    private String nombre;
    private Pais pais;
    private Set<Localidad> localidades = new HashSet<>();
    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
        pais.agregarProvincia(this);
    }
    public void agregarLocalidad(Localidad localidad) {
        localidades.add(localidad);
    }
    @Override
    public String toString() {
        return "Provincia{" + "nombre='" + nombre + '\'' + ", pais=" + pais.getNombre() + '}';
    }
}
