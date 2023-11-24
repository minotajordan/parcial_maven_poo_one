/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package error;
import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.Calendar;

import java.util.LinkedList;

/**
 *
 * @author JMINOTA
 */
public class soporte_taller {

    public static void main(String[] args) {
        
        /*
        * Esto nos sirve para generar un formato json para retornar la data del array
        * sin tener que acomodarla bonita de manera manual
        */
        Gson gson = new Gson();
        
        LinkedList <Vehiculo> automoviles = new LinkedList<Vehiculo>();
        LinkedList <Vehiculo> motos = new LinkedList<Vehiculo>();
        
        int valorHoraAuto = 2000;
        
        // Automovil creado por defecto
        Automovil auto = new Automovil(4, "Mazda", "3", "ZYX987", 12, 0);
        automoviles.add(auto);
        
        Motocicleta moto = new Motocicleta(600, "Honda", "CBR600", "XYZ789", 11, 0);
        motos.add(moto);
        
        // Por defecto 
        get("/motocicleta", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });
        
        // Listado de automovile
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            LinkedList <Vehiculo> temporalAutomoviles = new LinkedList<>();
            
            for (Vehiculo vehiculo : automoviles) {
                if(vehiculo.getHoraSalida() != 0){
                    temporalAutomoviles.add(vehiculo);
                }
            }
            
            return gson.toJson(temporalAutomoviles);
        });
        
        get("/motocicleta", (req, res) -> {
            res.type("application/json");
            LinkedList <Vehiculo> temporalMotos = new LinkedList<>();
            
            for (Vehiculo vehiculo : motos) {
                if(vehiculo.getHoraSalida() != 0){
                    temporalMotos.add(vehiculo);
                }
            }
            
            return gson.toJson(temporalMotos);
        });
        

        
        // Guardar automovil
        // endpoint GET para agregar un automóvil
        get("/agregarAutomovil/:marca/:modelo/:placa/:numeroPuertas", (req, res) -> {
            
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");
            
            
            for (Vehiculo vehiculo : automoviles) {
                if(vehiculo.getPlaca().equalsIgnoreCase(placa)){
                    return gson.toJson(null);
                }
            }
            
            // No olvidar convertir en integer los string numericos que llegan por url
            int numeroPuertas = Integer.parseInt(req.params(":numeroPuertas"));

            // Crear un nuevo automóvil y agregarlo al parqueadero
            Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);
            
            Automovil nuevoAuto = new Automovil(numeroPuertas, marca, modelo,placa, hour, 0);
            automoviles.add(nuevoAuto);

            return gson.toJson(nuevoAuto);
        });
        
        
        get("/reproteAutomoviles", (req, res) -> {
            res.type("application/json");
            LinkedList <Vehiculo> temporalAutomoviles = new LinkedList<>();
            String reporte = "";
            
            for (Vehiculo vehiculo : automoviles) {
                if(vehiculo.getHoraSalida() != 0){
                    reporte +=
                            " Placa: "+ vehiculo.getPlaca() +
                            " Ingreso: " + vehiculo.getHoraIngreso() +
                            " Salida: " + vehiculo.getHoraSalida() +
                            " Ganancia: " + ( vehiculo.getHoraSalida() - vehiculo.getHoraIngreso()) * valorHoraAuto;
                } else {
                    reporte +=
                            " Placa: "+ vehiculo.getPlaca() +
                            " Ingreso: " + vehiculo.getHoraIngreso() +
                            " Salida: " + vehiculo.getHoraSalida() +
                            " Ganancia: Aun aquí";
                }
            }
            
            return gson.toJson(temporalAutomoviles);
        });
        
        
    }
}
