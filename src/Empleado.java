import java.util.Iterator;
import java.util.Scanner;
public class Empleado {

    static Scanner input = new Scanner(System.in);
    private String nombre;
    private String puesto;
    private double salario;
    private int matricula;
    private boolean ocupado;

    public Empleado() {
    }

    public Empleado(String nombre, String puesto, double salario, int matricula) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.matricula = matricula;
        this.ocupado = false;
    }

    public Empleado(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isOcupado() {
        return ocupado;
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
        System.out.println("introduzca el salario del empleado nuevo");
        double salario = input.nextDouble();
        return salario;
    }
    public double getSalario2() {
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

    public boolean contieneNumero(String nombre) {
        return nombre.matches(".*\\d+.*");
    }
    //metodo para verificar si existen numeros.

    public static int cantEmplMasivos() {
        System.out.println("¿Cuantos empleados quieres agregar?");
        int nEmpleadosMasivos = input.nextInt();
        return nEmpleadosMasivos;
    }
    public static String puestoMasivo() {
        System.out.println("¿Que puesto necesitas que cubran los empleados nuevos?");
        return input.next();
    }
    public static double salarioMasivo() {
        System.out.println("¿Que salario tendrán los empleados nuevos?");
        return input.nextDouble();
    }
    public static int matriculaMasiva() {
        System.out.println("A partir de que numero de matricula se regitrarán los empleados nuevos?");
        int matriculaMasiva = input.nextInt();
        return matriculaMasiva;
    }
}



