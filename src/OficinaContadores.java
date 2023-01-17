import java.time.LocalDateTime;
import java.util.ArrayList;

public class OficinaContadores extends Oficina {

    int tablas;
    static ArrayList<Empleado> listaEmpleados;

    public OficinaContadores(int cabina, int tablas) {
        super(cabina);
        this.tablas = tablas;
        this.listaEmpleados = new ArrayList<>();

    }

    public static void agregarEmpleado(Empleado e) {
        listaEmpleados.add(e);
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
