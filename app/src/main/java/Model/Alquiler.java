package Model;

import java.sql.Date;
import java.time.LocalDate;


public class Alquiler {
    private int idAlquiler;
    private double precio;
    private Date fechaInicio;
    private Date fechaFin;
    private Inquilino inquilino;
    private Inmueble inmueble;

    public Alquiler(int idAlquiler, double precio, Date fechaInicio, Date fechaFin, Inquilino inquilino, Inmueble inmueble) {

        this.idAlquiler = idAlquiler;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }


    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
}
