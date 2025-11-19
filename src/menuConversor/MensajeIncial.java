package menuConversor;

public class MensajeIncial {
    String mensaje =
            """
            *************************
            Que desea convertir:
            1- ARS (Pesos)
            2- USD (Dolar)
            3- BRL (Real)
            4- EUR (Euro)
            5- GBP (Libra)
            6- JPY (Yen)
            0- Salir
            
            *************************
            """;

    public String getMensajeInicial() {
        return this.mensaje;
    }

    public static class SegundoMensaje {
        public final String segundoMensaje =
                """
                ¿A cual moneda la quieres convertir?
                1- ARS (Pesos)
                2- USD (Dolar)
                3- BRL (Real)
                4- EUR (Euro)
                5- GBP (Libra)
                6- JPY (Yen)
                """;

        public String getSegundoMensaje() {
            return this.segundoMensaje;
        }
    }

    public static class TercerMensaje {
        public final String tercerMesnaje = """
                ¿Cual es el monto que deseas convertir?
                """;

        public String getTercerMesnaje() {
            return this.tercerMesnaje;
        }
    }
}
