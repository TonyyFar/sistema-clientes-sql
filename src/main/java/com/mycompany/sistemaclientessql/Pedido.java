
package com.mycompany.sistemaclientessql;


public class Pedido {
 
    private int idP;
 private String nombreP;
 private int cantidad;
 private double precio;

 private Cliente cliente; 
 
 public Pedido(int idP, String nombreP, int cantidad, double precio, Cliente cliente){
            this.idP = idP;
            this.nombreP = nombreP;
            this.cantidad = cantidad;
            this.precio = precio;
            
            this.cliente = cliente;
 }
 
 
 public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getnombreP() {
        return nombreP;
    }

    public void setProducto(String producto) {
        this.nombreP = nombreP;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public Cliente getCliente(){
        return cliente;
        
    }
}
