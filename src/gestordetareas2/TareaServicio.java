/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordetareas2;

import java.util.List;

public class TareaServicio {
    private final TareaRepositorio tareaRepositorio;

    public TareaServicio(TareaRepositorio tareaRepositorio) {
        this.tareaRepositorio = tareaRepositorio;
    }

    public void agregarTarea(Tarea tarea) {
        tareaRepositorio.guardarTarea(tarea);
    }

    public List<Tarea> listarTareas() {
        return tareaRepositorio.obtenerTareas();
    }
}