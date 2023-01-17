import java.time.LocalDateTime;

public class OficinaAdministrativa extends Oficina{

    int documentos;



    public OficinaAdministrativa(int cabina, int documentos) {
        super(cabina);
        this.documentos = documentos;
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
