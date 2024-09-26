
package Controlador;

import Modelo.Dentistas;
import Vista.VistaPacientes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author robbi
 */
public class ctrlControlador implements MouseListener{
    
    
    private Dentistas modelo;
    private VistaPacientes vista;
    
           //2- crear el constructor 
    public ctrlControlador(Dentistas Modelo, VistaPacientes Vista){
        this.modelo = Modelo;
        this.vista = Vista;
        
        Vista.btnAgregar.addMouseListener(this);
        Vista.btnActualizar.addMouseListener(this);
        Vista.btnLimpiar.addMouseListener(this);
        Vista.btnEliminar.addMouseListener(this);
        
        Modelo.Mostrar(Vista.jtbDentistas);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnAgregar){
            modelo.setNombre_Dentista(vista.txtNombre.getText());
            modelo.setEdad_Dentista(Integer.parseInt(vista.txtEdad.getText()));
            modelo.setPeso_Dentista(Integer.parseInt(vista.txtPeso.getText()));
            modelo.setCorreo_Dentista(vista.txtCorreo.getText());
            
            modelo.Guardar();
                    
            modelo.Mostrar(vista.jtbDentistas);
        }
        if (e.getSource() == vista.btnEliminar){
        modelo.Eliminar(vista.jtbDentistas);
        modelo.Mostrar(vista.jtbDentistas);
        }
        if (e.getSource() == vista.jtbDentistas){
        modelo.cargarDatosTabla(vista);
        }
        if (e.getSource() == vista.btnActualizar){
        modelo.setNombre_Dentista(vista.txtNombre.getText());
        modelo.setEdad_Dentista(Integer.parseInt(vista.txtEdad.getText()));
        modelo.setPeso_Dentista(Integer.parseInt(vista.txtPeso.getText()));
        modelo.setCorreo_Dentista(vista.txtCorreo.getText());
        
        modelo.Actualizar(vista.jtbDentistas);
        modelo.Mostrar(vista.jtbDentistas);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
