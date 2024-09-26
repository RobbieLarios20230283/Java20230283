package Modelo;

import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Vista.VistaPacientes;

public class Dentistas {
    private String UUID_Dentista;
    private String Nombre_Dentista;
    private int Edad_Dentista;
    private int Peso_Dentista;
    private String Correo_Dentista;
    
    public String getUUID_Dentista() {
        return UUID_Dentista;
    }

    public void setUUID_Dentista(String UUID_Dentista) {
        this.UUID_Dentista = UUID_Dentista;
    }

    public String getNombre_Dentista() {
        return Nombre_Dentista;
    }

    public void setNombre_Dentista(String Nombre_Dentista) {
        this.Nombre_Dentista = Nombre_Dentista;
    }

    public int getEdad_Dentista() {
        return Edad_Dentista;
    }

    public void setEdad_Dentista(int Edad_Dentista) {
        this.Edad_Dentista = Edad_Dentista;
    }

    public int getPeso_Dentista() {
        return Peso_Dentista;
    }

    public void setPeso_Dentista(int Peso_Dentista) {
        this.Peso_Dentista = Peso_Dentista;
    }

    public String getCorreo_Dentista() {
        return Correo_Dentista;
    }

    public void setCorreo_Dentista(String Correo_Dentista) {
        this.Correo_Dentista = Correo_Dentista;
    }
    

    
    
    public void Guardar() {
        Connection conexion = ClaseConexion.getConexion();
        try {
            PreparedStatement addDentista = conexion.prepareStatement("INSERT INTO tbDentista(UUID_Dentista, Nombre_Dentista, Edad_Dentista, Peso_Dentista, Correo_Dentista) VALUES (?, ?, ?, ?, ?)");

            addDentista.setString(1, UUID.randomUUID().toString());
            addDentista.setString(2, getNombre_Dentista());
            addDentista.setInt(3, getEdad_Dentista());
            addDentista.setInt(4, getPeso_Dentista());
            addDentista.setString(5, getCorreo_Dentista());
 
            //Ejecutar la consulta
            addDentista.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    

public void Mostrar(JTable tabla) {
 
        Connection conexion = ClaseConexion.getConexion();
 
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
 
        modeloDeDatos.setColumnIdentifiers(new Object[]{"UUID_Dentista", "Nombre_Dentista", "Edad_Dentista ", "Peso_Dentista","Correo_Dentista"});
 
        try {
 
            //Creamos un Statement
 
            Statement statement = conexion.createStatement();
 
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
 
            ResultSet rs = statement.executeQuery("SELECT * FROM tbDentista");
 
            //Recorremos el ResultSet
 
            while (rs.next()) {
 
                //Llenamos el modelo por cada vez que recorremos el resultSet
 
                modeloDeDatos.addRow(new Object[]{rs.getString("UUID_Dentista"),
 
                    rs.getString("Nombre_Dentista"),
 
                    rs.getInt("Edad_Dentista"),
                    
                    rs.getInt("Peso_Dentista"),
 
                    rs.getString("Correo_Dentista")});
 
            }
 
            //Asignamos el nuevo modelo lleno a la tabla
 
            tabla.setModel(modeloDeDatos);
 
        } catch (Exception e) {
 
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
 
        }
 
    }
 
   public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
 
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteDentista = conexion.prepareStatement("delete from tbDentista where UUID_Dentista = ?");
            deleteDentista.setString(1, miId);
            deleteDentista.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }

    public class Eliminar {

        public Eliminar() {
        }
    }
    
            public void cargarDatosTabla(VistaPacientes vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbDentistas.getSelectedRow();
 
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUID_Dentista = vista.jtbDentistas.getValueAt(filaSeleccionada, 0).toString();
            String Nombre_Dentista = vista.jtbDentistas.getValueAt(filaSeleccionada, 1).toString();
            String Edad_Dentista = vista.jtbDentistas.getValueAt(filaSeleccionada, 2).toString().toString();
            String Peso_Dentista = vista.jtbDentistas.getValueAt(filaSeleccionada, 3).toString().toString();
            String Correo_Dentista = vista.jtbDentistas.getValueAt(filaSeleccionada, 4).toString();
 
            // Establece los valores en los campos de texto
            vista.txtNombre.setText(Nombre_Dentista);
            vista.txtEdad.setText(Edad_Dentista);
            vista.txtPeso.setText(Peso_Dentista);
            vista.txtCorreo.setText(Correo_Dentista);
        }
    }
            
           public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                //Ejecutamos la Query
                PreparedStatement updateDentista = conexion.prepareStatement("update tbDentista set Nombre_Dentista = ?,Edad_Dentista = ?, Peso_Dentista = ?, Correo_Dentista = ? where UUID_Dentista = ?");
                updateDentista.setString(1, getNombre_Dentista());
                updateDentista.setInt(2, getEdad_Dentista());
                updateDentista.setInt(3, getPeso_Dentista());
                updateDentista.setString(4, getCorreo_Dentista());
                updateDentista.setString(5, miUUId);
                updateDentista.executeUpdate();
 
            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }

    
    
}

