package principal;

import conversores.ListaCodigos;
import conversores.MainConversor;
import historial.CosasParaConvertir;
import historial.ManejoHistorial;
import menuConversor.MensajeIncial;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        MensajeIncial mensaje = new MensajeIncial();
        MensajeIncial.SegundoMensaje segundoMensaje = new MensajeIncial.SegundoMensaje();
        MensajeIncial.TercerMensaje tercerMensaje = new MensajeIncial.TercerMensaje();
        List<String> codigos = ListaCodigos.obtenerCodigos();
        ManejoHistorial historial = new ManejoHistorial();

        while(true){
            System.out.println(mensaje.getMensajeInicial());
            int base = teclado.nextInt();
            if (base == 0){
                System.out.println("¡Gracias por utilizar nuestros servicios. Hasta la proxima!");
                break;
            }

            if (base < 1 || base > codigos.size()){
                System.out.println("Opción inválida, elige una de las opciones.");
                continue;
            }
            String monedaBase = codigos.get(base - 1);

            String monedaDestino;
            do {
                System.out.println(segundoMensaje.getSegundoMensaje());
                int destino = teclado.nextInt();
                monedaDestino = codigos.get(destino - 1);
                if (monedaBase.equals(monedaDestino)){
                    System.out.println("La moneda base y la elegida para convertir son iguales. No hay conversión.");
                }
            }while (monedaDestino.equals(monedaBase));

            System.out.println(tercerMensaje.getTercerMesnaje());
            double monto = teclado.nextDouble();

            MainConversor conversor = new MainConversor();
            double resultado = conversor.convertir(monedaBase, monedaDestino, monto);



            System.out.println("El total de " + monedaBase + ", convertidos a " +  monedaDestino + " es igual a: " + resultado);
            String fecha = LocalDate.now().toString();
            CosasParaConvertir nueva = new CosasParaConvertir(monedaBase, monedaDestino, monto, resultado, fecha);
            historial.agregarConversion(nueva);
        }
        historial.guardarHistorial();
        historial.mostrarHistorial();
        System.out.println("Sistema finalizado.");
    }
}
