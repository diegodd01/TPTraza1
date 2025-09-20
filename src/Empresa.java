import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
    private int id;
    private String nombre;
    private String razonSocial;
    private String logo;
    private Integer cuit;
    private Set<Sucursal> sucursales = new HashSet<>();
    public Empresa(int id,String nombre, String razonSocial, String logo, Integer cuit) {
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.logo = logo;
        this.cuit = cuit;

    }
    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }
    @Override
    public String toString(){
        return "Empresa{"+"id="+id+"nombre"+nombre+'\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", cuil='" + cuit + '\'' +
                ", sucursales=" + sucursales +
                '}';
    }

}
