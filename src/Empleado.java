public class Empleado {
    private String nombre;
    private String puesto;
    private double salario;
    private int matricula;

    public Empleado(String nombre, String puesto, double salario, int matricula) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                ", matricula=" + matricula +
                '}';
    }
}
