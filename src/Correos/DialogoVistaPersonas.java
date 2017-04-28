/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correos;

import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Duran
 * @author Albert Charry
 */
public class DialogoVistaPersonas extends JDialog{
    
    JPanel panel;
    JTable tablaArtista;
    
    private DefaultTableModel dtm;
    private VentanaPrincipal ventana;
    public DialogoVistaPersonas(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setSize(300, 300);
        setTitle("Dialogo Vista Personas");
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("PERSONAS"));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
        
        dtm = new DefaultTableModel();
        tablaArtista = new JTable(dtm);
        
        Object[] columna = {"Nombre", "Genero"};
        for (Object columna1 : columna) {
            dtm.addColumn(columna1);
        }        
        
        
        JScrollPane scrollPane = new JScrollPane(tablaArtista);
        scrollPane.setBounds(30, 30, 240, 50);
        panel.add(scrollPane);
    }
    
    public void actualizarTabla() {
         List<Persona> lista = this.ventana.getPanel1().getListaArtista();
         for (Persona artista : lista) {
             Object[] fila = {artista.getNombre(), artista.getGenero().toString()};
             dtm.addRow(fila);
        }
    }
}
