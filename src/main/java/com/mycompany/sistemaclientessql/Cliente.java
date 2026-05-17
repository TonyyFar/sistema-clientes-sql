
package com.mycompany.sistemaclientessql;


public class Cliente {
    
    private int idC;
private String nombre;
private String apellido;
   
    
  public Cliente(int idC, String nombre, String apellido) {
        this.idC = idC;
        this.nombre = nombre;
        this.apellido = apellido;
  }
  
   public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
  
}
