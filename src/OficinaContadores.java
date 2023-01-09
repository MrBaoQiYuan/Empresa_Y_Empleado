import java.time.LocalDateTime;

public class OficinaContadores extends Oficina {

    int tablas;

    public OficinaContadores(int cabina, int tablas) {
        super(cabina);
        this.tablas = tablas;
    }
}
