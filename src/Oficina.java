import java.time.LocalDateTime;

public class Oficina {

    int numeroCabina;
    Empleado empleado;
    LocalDateTime dateTime;

    public Oficina(int numeroCabina) {
        this.numeroCabina = numeroCabina;
        this.empleado = null;
        this.dateTime = LocalDateTime.now();
    }

    public int getNumeroCabina() {
        return numeroCabina;
    }

    public void setNumeroCabina(int numeroCabina) {
        this.numeroCabina = numeroCabina;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
