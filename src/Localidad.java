import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Localidad {
    private String nombre;
    private Provincia provincia;
    private Set<Domicilio> domicilios = new HashSet<>();
    public Localidad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
        provincia.agregarLocalidad(this);
    }
    public void agregarDomicilio(Domicilio domicilio) {
        domicilios.add(domicilio);
    }
    @Override
    public String toString() {
        return "Localidad{" + "nombre='" + nombre + '\'' + ", provincia=" + provincia.getNombre() + '}';
    }
}
