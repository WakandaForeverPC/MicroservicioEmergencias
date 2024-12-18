package com.proyecto.microservicioemergencias.model;

public class Alerta {
    private String mensaje;
    private int x;
    private int y;

    public Alerta(String mensaje, int x, int y) {
        this.mensaje = mensaje;
        this.x = x;
        this.y = y;

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}