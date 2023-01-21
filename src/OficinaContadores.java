import java.util.ArrayList;

public class OficinaContadores extends Oficina {

    int tablas;
    ArrayList<Empleado> listaEmpleadosContadores;

    public OficinaContadores(int cabina, int tablas) {
        super(cabina, null);
        this.tablas = tablas;
        listaEmpleadosContadores = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        listaEmpleadosContadores.add(e);
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
        return "OficinaContadores{" +
                "tablas=" + tablas +
                ", numeroCabina=" + numeroCabina +
                ", empleado=" + empleado +
                ", dateTime=" + dateTime +
                '}';
    }
}
