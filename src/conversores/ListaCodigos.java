package conversores;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListaCodigos {
    private static final List<String> ordenDeseado = List.of("ARS", "USD", "BRL", "EUR", "GBP", "JPY");

    public static List<String> obtenerCodigos(){
        return ordenDeseado;
    }
}
