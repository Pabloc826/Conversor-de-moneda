package historial;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManejoHistorial{
    private final List<CosasParaConvertir> historial;
    private final String archivo = "historial.json";
    private final Gson gson = new Gson();

    public ManejoHistorial() {
        File archivoHistorial = new File(archivo);
        if (archivoHistorial.exists()) {
            archivoHistorial.delete();
        }
        this.historial = new ArrayList<>();
    }

    public void agregarConversion (CosasParaConvertir cosasParaConvertir){
        historial.add(cosasParaConvertir);
    }

    public void guardarHistorial(){
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial" + e.getMessage());;
        }
    }
    public List<CosasParaConvertir> getHistorial() {
        return historial;
    }

    private List<CosasParaConvertir> cargarHistorial(){
        try(FileReader reader = new FileReader(archivo)){
            Type tipoLista = new TypeToken<List<CosasParaConvertir>>(){}.getType();
            return gson.fromJson(reader, tipoLista);
        }catch (IOException e){
            return new ArrayList<>();
        }
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()){
            System.out.println("No hay conversiones registradas");
            return;
        }
        for (CosasParaConvertir conversion : historial) {
            System.out.println("------------------------------");
            System.out.println("Fecha: " + conversion.fecha());
            System.out.println("Conversión: " + conversion.monedaBase() + "--->" + conversion.monedaDestino());
            System.out.println("Monto original: " + conversion.montoOriginal());
            System.out.println("Monto convertido: " + conversion.montoConvertido());
            System.out.println("------------------------------");
        }
    }
}
