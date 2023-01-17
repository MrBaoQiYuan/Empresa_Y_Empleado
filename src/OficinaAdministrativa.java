import java.util.ArrayList;

public class OficinaAdministrativa extends Oficina{

    int documentos;

    static ArrayList<Empleado> listaEmpleados;

    public OficinaAdministrativa(int numeroCabina, int documentos) {
        super(numeroCabina);
        this.documentos = documentos;
        this.listaEmpleados = new ArrayList<>();
    }

    public static void agregarEmpleado(Empleado e) {
        listaEmpleados.add(e);
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
