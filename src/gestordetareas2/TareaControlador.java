/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordetareas2;

import java.util.List;

public class TareaControlador {
    private final TareaServicio tareaServicio;

    public TareaControlador(TareaServicio tareaServicio) {
        this.tareaServicio = tareaServicio;
    }

    public void agregarTarea(String id, String descripcion) {
        Tarea tarea = new Tarea(id, descripcion);
        tareaServicio.agregarTarea(tarea);
    }

    public List<Tarea> obtenerTareas() {
        return tareaServicio.listarTareas();
    }
}