package com.example.quienvaapp.ui.Dto;

public class ListaMandaditosDTO {
    private String id;

    public String getImagenMandaditos() {
        return imagenMandaditos;
    }

    public void setImagenMandaditos(String imagenMandaditos) {
        this.imagenMandaditos = imagenMandaditos;
    }

    private String imagenMandaditos;
    private String nombre;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
