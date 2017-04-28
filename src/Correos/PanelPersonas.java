/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jorge Duran
 * @author Albert Charry
 */
public class PanelPersonas extends JPanel implements ActionListener{
  
    JButton BVista;
    private DialogoVistaPersonas dialog;
    private VentanaPrincipal ventana;
    
    
    public PanelPersonas(VentanaPrincipal ventana) {
         this.ventana = ventana;
         setBorder(BorderFactory.createTitledBorder("General"));
         setLayout(null);
         
         BVista = new JButton("Ver Personas");
         BVista.setFont(new Font("Serif", Font.BOLD, 18));
         BVista.addActionListener(this);
         BVista.setBounds(130, 10, 150, 20);
         add(BVista);
         
       
        setBackground( Color.WHITE );
         
         dialog = new DialogoVistaPersonas(this.ventana);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.actualizarTabla();
        dialog.setVisible(true);
        
    }
    
    
    
}
