
package com.mycompany.sistemaclientessql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Sistema {
 
    public static int menu() {

        int opcion = 0;

        try {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "--- MENU ---\n"
                    + "1. Registrar Cliente\n"
                    + "2. Registrar Pedido\n"
                    + "3. Mostrar Clientes\n"
                    + "4. Mostrar Pedidos\n"
                    + "5. Ver pedidos de cliente\n"
                    + "6. Eliminar Cliente\n"
                    + "7. Salir"
            ));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }

        return opcion;
    }

    public static void registrarCliente() {

        try {

        int id = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese ID")
        );

        String nombre =
                JOptionPane.showInputDialog("Ingrese nombre");

        String apellido =
                JOptionPane.showInputDialog("Ingrese apellido");

        Connection con = Conexion.conectar();

        String sql =
                "INSERT INTO clientes(id,nombre,apellido)"
                + " VALUES(?,?,?)";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setString(3, apellido);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null,
                "Cliente registrado en SQL");

        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);
    }
    }

    public static void registrarPedido() {

        try {

            int idP = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese ID producto")
            );

            String nombreP = JOptionPane.showInputDialog(
                    "Ingrese nombre producto"
            );

            int cantidad = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese cantidad")
            );

            double precio = Double.parseDouble(
                    JOptionPane.showInputDialog("Ingrese precio")
            );

            int idCliente = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese ID cliente")
            );

          
        Connection con = Conexion.conectar();

        String sql =
                "INSERT INTO pedidos"
                + "(idPedido,producto,cantidad,precio,idCliente)"
                + " VALUES(?,?,?,?,?)";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, idP);
        ps.setString(2, nombreP);
        ps.setInt(3, cantidad);
        ps.setDouble(4, precio);
        ps.setInt(5, idCliente);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null,
                "Pedido registrado en SQL");

        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);
    }
}
              

    public static void mostrarClientes() {

       try{
           
            Connection con = Conexion.conectar();

        String sql = "SELECT * FROM clientes";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        String info = "";

        while (rs.next()) {

            info += "ID: " + rs.getInt("id")
                    + "\nNombre: " + rs.getString("nombre")
                    + "\nApellido: " + rs.getString("apellido")
                    + "\n----------------------\n";
        }

        JOptionPane.showMessageDialog(null, info);

        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);
    }
         
    }
       

       
    public static void mostrarPedidos() {

     try {

        Connection con = Conexion.conectar();

        String sql = "SELECT * FROM pedidos";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        String info = "";

        while (rs.next()) {

            info += "ID Pedido: "
                    + rs.getInt("idPedido")
                    + "\nProducto: "
                    + rs.getString("producto")
                    + "\nCantidad: "
                    + rs.getInt("cantidad")
                    + "\nPrecio: "
                    + rs.getDouble("precio")
                    + "\nID Cliente: "
                    + rs.getInt("idCliente")
                    + "\n----------------------\n";
        }

        JOptionPane.showMessageDialog(null, info);

        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);
    }
    }

    public static void verPedidosCliente() {

        try {

        int idCliente = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingrese ID cliente"
                )
        );

        Connection con = Conexion.conectar();

        String sql =
                "SELECT * FROM pedidos WHERE idCliente = ?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, idCliente);

        ResultSet rs = ps.executeQuery();

        String info = "";

        boolean encontrado = false;

        while (rs.next()) {

            encontrado = true;

            info += "ID Pedido: "
                    + rs.getInt("idPedido")
                    + "\nProducto: "
                    + rs.getString("producto")
                    + "\nCantidad: "
                    + rs.getInt("cantidad")
                    + "\nPrecio: "
                    + rs.getDouble("precio")
                    + "\n----------------------\n";
        }

        if (encontrado) {

            JOptionPane.showMessageDialog(null, info);

        } else {

            JOptionPane.showMessageDialog(null,
                    "Cliente sin pedidos");
        }

        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);
    }
        
      }

    public static void eliminarCliente(){
 try {

        int idEliminar = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingrese ID cliente a eliminar"
                )
        );

        Connection con = Conexion.conectar();

        String sql =
                "DELETE FROM clientes WHERE id = ?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, idEliminar);

        int eliminado = ps.executeUpdate();

        if (eliminado > 0) {

            JOptionPane.showMessageDialog(null,
                    "Cliente eliminado");

        } else {

            JOptionPane.showMessageDialog(null,
                    "Cliente no encontrado");
        }

        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error: " + e);
    }
}
   }

