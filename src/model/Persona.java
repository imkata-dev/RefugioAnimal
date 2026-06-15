package model;

public abstract class Persona {
    protected String rut;
    protected String nombre;
    protected String telefono;

    public Persona(String rut, String nombre, String telefono){
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getRut() {return rut;}
    public String getNombre() {return nombre;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}



}

