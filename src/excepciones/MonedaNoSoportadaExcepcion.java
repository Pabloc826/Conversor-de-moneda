package excepciones;

public class MonedaNoSoportadaExcepcion extends RuntimeException {
    private String mensaje;

    public MonedaNoSoportadaExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return this.mensaje;
    }
}
