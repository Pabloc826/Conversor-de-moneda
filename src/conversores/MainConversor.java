package conversores;

import interfaces.PasajeRecordNumero;

public class MainConversor {
    public double convertir(String base, String destino, double monto){
        double tasa = PasajeRecordNumero.mostrarTasas(base, destino);
        return monto * tasa;
    }

}
