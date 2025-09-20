public class Domicilio {
    private String calle;
    private int numero;
    private int cp;
    private Localidad localidad;
    public Domicilio(String calle, int numero, int cp, Localidad localidad) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
        localidad.agregarDomicilio(this);
    }
    @Override
    public String toString() {
        return calle + " " + numero + " (" + localidad.getNombre() + ")";
    }
}
