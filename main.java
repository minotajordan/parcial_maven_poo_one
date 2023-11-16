/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p1;
import static spark.Spark.*;
import com.google.gson.Gson;

import java.util.LinkedList;

/**
 *
 * @author JMINOTA
 */
public class main {

    public static void main(String[] args) {
        
        /*
        * Esto nos sirve para generar un formato json para retornar la data del array
        * sin tener que acomodarla bonita de manera manual
        */
        Gson gson = new Gson();
        
        LinkedList <Vehiculo> automoviles = new LinkedList<>();
        
        // Automovil creado por defecto
        Automovil auto = new Automovil(4, "Mazda", "3", "ZYX987");
        automoviles.add(auto);
        
        Motocicleta moto = new Motocicleta(600, "Honda", "CBR600", "XYZ789");
        
        
        
        // Definir endpoints
        
        // Por defecto 
        get("/motocicleta", (req, res) -> {
            res.type("application/json");
            return gson.toJson(moto);
        });
        
        // Listado de automovile
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
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
            
            // No olvidar convertir en integer los string numericos que llegan por url
            int numeroPuertas = Integer.parseInt(req.params(":numeroPuertas"));

            // Crear un nuevo automóvil y agregarlo al parqueadero
            Automovil nuevoAuto = new Automovil(numeroPuertas, marca, modelo,placa);
            automoviles.add(nuevoAuto);

            return gson.toJson(nuevoAuto);
        });
        
    }
}
