import java.time.LocalDateTime;
import java.util.ArrayList;

public class Oficina {

    int numeroCabina;
    Empleado empleado;
    LocalDateTime dateTime;
    boolean ocupado;

    public Oficina(int numeroCabina, Empleado empleado) {
        this.numeroCabina = numeroCabina;
        this.empleado = empleado;
        this.dateTime = LocalDateTime.now();
        this.ocupado=false;
    }



    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isOcupado() {
        return ocupado;
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

    @Override
    public String toString() {
        return "Oficina{" +
                "numeroCabina=" + numeroCabina +
                ", empleado=" + empleado +
                ", dateTime=" + dateTime +
                '}';
    }
}
