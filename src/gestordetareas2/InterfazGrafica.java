/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordetareas2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazGrafica extends JFrame {
    private final TareaControlador tareaControlador;
    private final DefaultListModel<String> modeloLista;
    private final JList<String> listaTareas;
    private final JTextField campoDescripcion;

    public InterfazGrafica(TareaControlador tareaControlador) {
        this.tareaControlador = tareaControlador;
        this.modeloLista = new DefaultListModel<>();
        this.listaTareas = new JList<>(modeloLista);
        this.campoDescripcion = new JTextField(20);
        inicializar();
    }

    private void inicializar() {
        setLayout(new BorderLayout());

        // Panel para agregar tareas
        JPanel panelAgregar = new JPanel();
        panelAgregar.add(new JLabel("Descripción:"));
        panelAgregar.add(campoDescripcion);
        JButton botonAgregar = new JButton("Agregar Tarea");
        panelAgregar.add(botonAgregar);
        add(panelAgregar, BorderLayout.NORTH);

        // Lista de tareas
        add(new JScrollPane(listaTareas), BorderLayout.CENTER);

        // Acción del botón agregar
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = campoDescripcion.getText();
                if (!descripcion.isEmpty()) {
                    String id = String.valueOf(System.currentTimeMillis()); // Generar un ID único
                    tareaControlador.agregarTarea(id, descripcion);
                    actualizarListaTareas();
                    campoDescripcion.setText("");
                } else {
                    JOptionPane.showMessageDialog(InterfazGrafica.this, "La descripción no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Cargar tareas al iniciar
        actualizarListaTareas();
    }

    private void actualizarListaTareas() {
        modeloLista.clear();
        List<Tarea> tareas = tareaControlador.obtenerTareas();
        for (Tarea tarea : tareas) {
            modeloLista.addElement(tarea.getDescripcion() + (tarea.isCompletada() ? " (Completada)" : ""));
        }
    }
}
