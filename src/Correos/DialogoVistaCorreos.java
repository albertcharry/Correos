/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correos;

/**
 *
 * @author Jorge Duran
 * @author Albert Charry
 */

import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DialogoVistaCorreos extends JDialog{
    
    JPanel panel;
    JTable tablaCorreo;
    
    private DefaultTableModel dtm;
    private VentanaPrincipal ventana;
    public DialogoVistaCorreos(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setSize(300, 300);
        setTitle("Dialogo Vista Personas");
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("CORREOS"));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
        
        dtm = new DefaultTableModel();
        tablaCorreo = new JTable(dtm);
        
        Object[] columna = {"CORREO"};
        for (Object columna1 : columna) {
            dtm.addColumn(columna1);
        }        
        
        
        JScrollPane scrollPane = new JScrollPane(tablaCorreo);
        scrollPane.setBounds(30, 30, 240, 50);
        panel.add(scrollPane);
    }
    
    public void actualizarTablaCorreo() {
         List<Correo> lista = this.ventana.getPanel2().getListaCorreo();
         for (Correo correo : lista) {
             Object[] fila = {correo.getCorreo().toString()};
             dtm.addRow(fila);
        }
    }
}


