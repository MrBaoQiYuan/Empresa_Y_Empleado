import java.time.LocalDateTime;

public class OficinaContadores extends Oficina {

    int tablas;

    public OficinaContadores(int cabina, int tablas) {
        super(cabina);
        this.tablas = tablas;
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
