import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    private String nombre;
    private Set<Provincia> provincias = new HashSet<>();
    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProvincia(Provincia provincia) {
        provincias.add(provincia);
    }
    @Override
    public String toString() {
        return "Pais{" + "nombre='" + nombre + '\'' + '}';
    }
}
