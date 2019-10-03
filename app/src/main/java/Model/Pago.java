package Model;

import java.time.LocalDate;
import java.util.Date;

public class Pago {
    private int idPago;
    private int nroPago;
    private Alquiler alquiler;
    private Date fecha;
    private double importe;

    public Pago(int idPago, int nroPago, Alquiler alquiler, Date fecha, double importe) {
        this.idPago = idPago;
        this.nroPago = nroPago;
        this.alquiler = alquiler;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
