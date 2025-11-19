package excepciones;

import java.io.Serializable;

public class InvocacionDeMetodoExcepcion extends RuntimeException {

    public InvocacionDeMetodoExcepcion(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
}
