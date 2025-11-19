package interfaces;

import com.google.gson.Gson;
import conversores.MonedasParaConvertir;
import conversores.TasaDeConversiones;
import excepciones.InvocacionDeMetodoExcepcion;
import excepciones.MonedaNoSoportadaExcepcion;
import http.ClienteHttp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface PasajeRecordNumero {
    static double mostrarTasas (String base, String destino){
        ClienteHttp direccion = new ClienteHttp();
        String json = direccion.obtenerDatos("https://v6.exchangerate-api.com/v6/acbb957209feeb26d704408e/latest/"+base);
        Gson gson = new Gson();
        MonedasParaConvertir monedas = gson.fromJson(json, TasaDeConversiones.class).conversionRates();

        for (Method metodo : MonedasParaConvertir.class.getDeclaredMethods()) {
            if (metodo.getParameterCount() == 0 && metodo.getReturnType() == double.class) {
                String nombre = metodo.getName();
                double valor = 0;
                try {
                    valor = (double) metodo.invoke(monedas);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new InvocacionDeMetodoExcepcion("Error al invocar el método: " + metodo.getName(), e);
                }
            }
        }

        try{
            Method metodo = MonedasParaConvertir.class.getDeclaredMethod(destino);
            return (double) metodo.invoke(monedas);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new MonedaNoSoportadaExcepcion("No se pudo obtener la tasa para: " + destino + e);
        }
    }
}
