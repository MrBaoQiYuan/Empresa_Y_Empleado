import java.util.ArrayList;

public class OficinaAdministrativa extends Oficina{
    int documentos;

    public OficinaAdministrativa(int numeroCabina, int documentos) {
        super(numeroCabina,null);
        this.documentos = documentos;
    }

    @Override
    public void setNumeroCabina(int numeroCabina) {
        this.numeroCabina = numeroCabina;
    }

    @Override
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public boolean isOcupado() {
        return ocupado;
    }

    @Override
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "OficinaAdministrativa{" +
                "documentos=" + documentos +
                ", numeroCabina=" + numeroCabina +
                ", empleado=" + empleado +
                ", dateTime=" + dateTime +
                '}';
    }
}
