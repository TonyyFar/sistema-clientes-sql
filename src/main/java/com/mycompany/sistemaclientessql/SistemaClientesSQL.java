package com.mycompany.sistemaclientessql;

import java.sql.*;
import javax.sql.*;
import javax.swing.JOptionPane;


public class SistemaClientesSQL {

    public static void main(String[] args) {
        
Connection con = Conexion.conectar();

        int opcion = 0;

        while (opcion != 7) {

            opcion = Sistema.menu();

            switch (opcion) {

                case 1:
                    Sistema.registrarCliente();
                    break;

                case 2:
                    Sistema.registrarPedido();
                    break;

                case 3:
                    Sistema.mostrarClientes();
                    break;

                case 4:
                    Sistema.mostrarPedidos();
                    break;

                case 5:
                    Sistema.verPedidosCliente();
                    break;

                case 6:
                    Sistema.eliminarCliente();
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }
        }
    }
}
    



