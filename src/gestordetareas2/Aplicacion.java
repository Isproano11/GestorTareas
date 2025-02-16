/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordetareas2;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;

public class Aplicacion {
    public static void main(String[] args) {
        // Conectar a la base de datos MongoDB
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase baseDatos = mongoClient.getDatabase("gestor_tareas");

        // Crear el repositorio, servicio y controlador
        TareaRepositorio tareaRepositorio = new TareaRepositorio(baseDatos);
        TareaServicio tareaServicio = new TareaServicio(tareaRepositorio);
        TareaControlador tareaControlador = new TareaControlador(tareaServicio);

        // Crear la interfaz gráfica
        InterfazGrafica interfazGrafica = new InterfazGrafica(tareaControlador);
        interfazGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfazGrafica.setSize(400, 300);
        interfazGrafica.setVisible(true);
    }
}
