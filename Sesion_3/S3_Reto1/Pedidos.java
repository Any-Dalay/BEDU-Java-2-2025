import java.util.Optional;

public class Pedidos {
    private String cliente;
    private String tipoEntrega;// "domicilio" o "local"
    private String telefono; // Puede ser null

    public Pedidos(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }
}