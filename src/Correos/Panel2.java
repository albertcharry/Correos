/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correos;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import Correos.Correo;

/**
 *
 * @author Jorge Duran
 * @author Albert Charry
 */
public class Panel2 extends JPanel implements ActionListener{
    
    private JLabel LCorreo;
    private JTextField JTNombre;;
    private VentanaPrincipal ventana;
    private JButton Guardar;
    
    private List<Correo> listaCorreo;
    private Correo correo;
    public Panel2(VentanaPrincipal ventana) {
         
        this.ventana = ventana; 
         setBorder(BorderFactory.createTitledBorder("CORREO"));
         setLayout(null);
         listaCorreo = new ArrayList<Correo>();
         
         LCorreo = new JLabel("Correo: ");
         LCorreo.setBounds(30, 30, 100, 20);
         add(LCorreo);
         
         JTNombre = new JTextField();
         JTNombre.setBounds(140, 30, 150, 20);
         add(JTNombre);
         
         Guardar = new JButton("Guardar");
         Guardar.setBounds(140, 50, 150, 20);
         Guardar.addActionListener(this);
         add(Guardar);  
         
        setBackground( Color.WHITE );
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
         if(validarDatosCorreo(JTNombre.getText())){ 
             correo = new Correo(JTNombre.getText());
             JOptionPane.showMessageDialog(this, "email valido", "guardado", JOptionPane.INFORMATION_MESSAGE);
             LCorreo.setForeground(Color.GREEN);
             listaCorreo.add(correo);
             JTNombre.requestFocus();
             vaciarDatos();
       }else{
             JOptionPane.showMessageDialog(this, "email invalido", "intente de nuevo", JOptionPane.INFORMATION_MESSAGE);
             LCorreo.setForeground(Color.RED);
             JTNombre.requestFocus();
         }
    }
    private boolean validarDatosCorreo(String Correo) {
        Pattern pat = null;
        Matcher mat = null;
        
        pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        mat = pat.matcher(Correo);
        
        if(mat.find()){
            return true;
        }else {
            return false;
        }
        
    }
    
    
    public List<Correo> getListaCorreo() {
        return listaCorreo;
    }
    
    private void vaciarDatos() {
    JTNombre.setText("");
    
    }
         
    
     
    }
    
    
    
    
    
    
    

