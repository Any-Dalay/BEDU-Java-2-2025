class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    public void ajustarCosto(int costoAdicional) {
        System.out.println("✅ Orden " + codigo + " ajustada con costo adicional de $" + costoAdicional);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }
}