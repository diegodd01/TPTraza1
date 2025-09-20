import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Crear País
        Pais argentina = new Pais("Argentina");
        //Provincias
        Provincia bsas = new Provincia("Buenos Aires",argentina);
        Provincia cordoba = new Provincia("Córdoba", argentina);
        // Localidades y domicilios en Buenos Aires
        Localidad caba = new Localidad("CABA", bsas);
        Domicilio domCaba = new Domicilio("Av. Corrientes", 1234, 1001, caba);

        Localidad laPlata = new Localidad("La Plata", bsas);
        Domicilio domLaPlata = new Domicilio("Calle 50", 789, 1900, laPlata);
        // Localidades y domicilios en Córdoba
        Localidad cordobaCapital = new Localidad("Córdoba Capital", cordoba);
        Domicilio domCordoba = new Domicilio("Av. Colón", 500, 5000, cordobaCapital);

        Localidad carlosPaz = new Localidad("Villa Carlos Paz", cordoba);
        Domicilio domCarlosPaz = new Domicilio("San Martín", 99, 5152, carlosPaz);
        // Sucursales
        Sucursal suc1 = new Sucursal(1, "Sucursal CABA", LocalTime.of(9, 0), LocalTime.of(18, 0), true, domCaba);
        Sucursal suc2 = new Sucursal(2, "Sucursal La Plata", LocalTime.of(9, 0), LocalTime.of(18, 0), false, domLaPlata);
        Sucursal suc3 = new Sucursal(3, "Sucursal Córdoba Capital", LocalTime.of(9, 0), LocalTime.of(18, 0), false, domCordoba);
        Sucursal suc4 = new Sucursal(4, "Sucursal Carlos Paz", LocalTime.of(9, 0), LocalTime.of(18, 0), false, domCarlosPaz);
        // Empresas
        Empresa emp1 = new Empresa(101,"Empresa 1", "Empresita SA", "Empresita SA", 20-12345678-9);
        emp1.agregarSucursal(suc1);
        emp1.agregarSucursal(suc2);

        Empresa emp2 = new Empresa(102,"Empresa 2", "Tech SA", "Tech SA", 30-87654321-2);
        emp2.agregarSucursal(suc3);
        emp2.agregarSucursal(suc4);

        Set<Empresa> empresas = new HashSet<>();
        empresas.add(emp1);
        empresas.add(emp2);

        // a) Mostrar todas las empresas
        System.out.println("=== Todas las empresas ===");
        empresas.forEach(System.out::println);

        // b) Buscar una empresa por su ID
        System.out.println("\n=== Buscar empresa por ID (101) ===");
        empresas.stream().filter(e -> e.getId() == 101).forEach(System.out::println);

        // c) Buscar una empresa por nombre
        System.out.println("\n=== Buscar empresa por nombre (Empresa Dos) ===");
        empresas.stream().filter(e -> e.getNombre().equals("Empresa Dos")).forEach(System.out::println);

        // d) Actualizar los datos de una empresa por su ID
        System.out.println("\n=== Actualizar CUIL de Empresa 101 ===");
        empresas.stream().filter(e -> e.getId() == 101).findFirst().ifPresent(e -> e.setCuit(20-99999999-9));
        empresas.forEach(System.out::println);

        // e) Eliminar una empresa buscando por su ID
        System.out.println("\n=== Eliminar Empresa con ID 102 ===");
        empresas.removeIf(e -> e.getId() == 102);
        empresas.forEach(System.out::println);
    }
}