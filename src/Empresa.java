import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Scanner;

public class Empresa {
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    private String nombre;
    ArrayList<Empleado> listaEmpleados;
    ArrayList<Empleado> listaEmpleadosDespedidos;
    ArrayList<Empleado> listaEmpleadosEnTurno;


    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
        this.listaEmpleadosDespedidos = new ArrayList<>();
        this.listaEmpleadosEnTurno = new ArrayList<>();
    }


    public void agregarEmpleado(Empleado emp) {
        listaEmpleados.add(emp);
    }

    public void eliminarEmpleado(String nombre2, String puesto2) {
        for (Empleado e : listaEmpleados) {
            if (e.getNombre().equals(nombre2) && e.getPuesto().equals(puesto2)) {
                listaEmpleadosDespedidos.add(e);
                listaEmpleados.remove(e);

                System.out.println("Se ha eliminado, gracias");
            }
        }
    }

    public void eliminarEmpleadosDeUnPuesto() {
        System.out.println("Introduzca el puesto que va a eliminar de la empresa");

        String puesto2 = input.next();
        Iterator<Empleado> iter = listaEmpleados.iterator();
        while (iter.hasNext()) {
            Empleado e = iter.next();
            if (e.getPuesto().equals(puesto2)) {
                listaEmpleadosDespedidos.add(e);
                iter.remove();
            }
        }
        System.out.println("Se han eliminado todos los empleados del puesto, gracias");
    }

    public void eliminarTodosEmpleados() {
        for (Empleado e : listaEmpleados) {
            listaEmpleadosDespedidos.add(e);
            listaEmpleados.clear();
        }
    }


    public void modificarEmpleado(int matricula2) { //Modificar datos de empleado.

        for (Empleado e : listaEmpleados) {
            if (matricula2 == e.getMatricula()) {

                Empleado empleadoAModificar = e;

                boolean salir = false;
                while (!salir) {
                    System.out.println("Que datos desea modificar? ");
                    System.out.println("opcion 1: nombre");
                    System.out.println("opcion 2: puesto");
                    System.out.println("opcion 3: salario");
                    System.out.println("opcion 4: matricula");
                    System.out.println("opcion 5: salir");

                    int opcion2 = input.nextInt();
                    switch (opcion2) {
                        case 1: //Modificar datos de empleado.(nombre)
                            System.out.println("El nombre que va a cambiar es:" + empleadoAModificar.getNombre());
                            System.out.println("ingrese el nuevo nombre");
                            String nombre3 = input.next();
                            empleadoAModificar.setNombre(nombre3);
                            break;

                        case 2://Modificar datos de empleado.(puesto)
                            System.out.println("El puesto actual es de" + e.getPuesto());
                            System.out.println("Ingrese el nuevo puesto de trabajo");
                            String puesto3 = input.next();
                            empleadoAModificar.setPuesto(puesto3);
                            break;

                        case 3://Modificar datos de empleado.(salario)
                            System.out.println("El salario actual de " + empleadoAModificar.getNombre() + " es de " + empleadoAModificar.getSalario());
                            System.out.println("¿Cual quiere que sea su nuevo salario? Introduzcalo.");
                            double salario3 = input.nextDouble();
                            empleadoAModificar.setSalario(salario3);
                            break;

                        case 4://Modificar datos de empleado.(numero matricula)
                            System.out.println("Introduzca el nuevo numero de matricula de " + empleadoAModificar.getNombre());
                            int matricula3 = input.nextInt();
                            empleadoAModificar.setMatricula(matricula3);
                            break;

                        case 5://Modificar datos de empleado.
                            salir = true;
                            break;

                        default:
                            System.out.println("Introduzca una opcion valida.");
                            break;
                    }


                }
            }
        }
    }

    public void consultarEmpleado() { //Consultar datos de empleado.
        System.out.println("1.- Consultar lista completa.");
        System.out.println("2.- Consultar un empleado.");
        System.out.println("Elija una opcion");

        int opcion2 = input.nextInt();
        switch (opcion2) {
            case 1: //consultar datos de empleado. (lista completa)
                for (Empleado e : listaEmpleados) {
                    System.out.println(e);
                }
                break;
            case 2://consultar datos de empleado.(un empleado)
                System.out.println("Ingrese la matricula del empleado");
                int nMatricula = input.nextInt();
                for (Empleado e : listaEmpleados) {
                    if (nMatricula == e.getMatricula()) {
                        System.out.println(e);
                    }
                }
                break;
        }
    }

    public void calcularPromedioSalarios() { //Calcular el promedio de los salarios
        double salarioTotal = 0;
        double salarioMedio = 0;
        int nEmpleados = listaEmpleados.size();
        for (Empleado e : listaEmpleados) {
            salarioTotal += e.getSalario();
        }
        salarioMedio = salarioTotal / nEmpleados;
        System.out.println("El salario medio de la empresa es de: " + salarioMedio);
    }

    public void calculaSalarioMaximoMinimo() { //Calcula el max y min de los salarios
        double salarioMaximo = 0;
        double salarioMinimo = Integer.MAX_VALUE;
        Empleado empleadoSalarioMaximo = null;
        Empleado empleadoSalarioMinimo = null;

        for (Empleado e : listaEmpleados) { //calculo max
            if (e.getSalario() > salarioMaximo) {
                salarioMaximo = e.getSalario();
                empleadoSalarioMaximo = e;
            }
        }
        System.out.println("El empleado " + empleadoSalarioMaximo.getNombre() + " tiene el salario maximo de " + empleadoSalarioMaximo.getSalario());

        for (Empleado e : listaEmpleados) {//calculo min
            if (e.getSalario() < salarioMinimo) {
                salarioMinimo = e.getSalario();
                empleadoSalarioMinimo = e;
            }
        }
        System.out.println("El empleado " + empleadoSalarioMinimo.getNombre() + "tiene el salario minimo de " + empleadoSalarioMinimo.getSalario());

    }

    public void consultarEmpleadosDespedidos() {
        for (Empleado f : listaEmpleadosDespedidos) {
            System.out.println(f);
        }
    }

    public void anadirOEliminarEmpleadosAlTurno() {
        System.out.println("¿Que deseas hacer?" +
                "\nOpcion 1.- Añadir un empleado al turno" +
                "\nOpcion 2.- Eliminar un empleado del turno");
        int opcion = input.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Inserte la matricula del empleado que entra");
                int matriculaEmpleado = input.nextInt();
                for (Empleado e : listaEmpleados) {
                    if (e.getMatricula() == matriculaEmpleado) {
                        listaEmpleadosEnTurno.add(e);
                    }
                }
                break;
            case 2:
                System.out.println("Introduzca la matricula del empleado a eliminar del turno");
                int matriculaEmpleado2 = input.nextInt();
                Iterator <Empleado> it = listaEmpleadosEnTurno.iterator();
                while(it.hasNext()) {
                    Empleado e = it.next();
                    if(e.getMatricula() == matriculaEmpleado2){
                        it.remove();
                    }
                }
                break;
            default:
                anadirOEliminarEmpleadosAlTurno();

        }
    }


    public boolean existenEmpleadosEnTurno(){
        return !listaEmpleadosEnTurno.isEmpty();
    }

    public int numeroEmpleadosEnTurno(){
        if(existenEmpleadosEnTurno()) {
            int numeroEmpleadosEnTurno = listaEmpleadosEnTurno.size();
            return numeroEmpleadosEnTurno;
        }else{
            System.out.println("0");
            return 0;
        }
    }

    public int numeroEmpleadosGenerales(){
        return listaEmpleados.size();
    }

    public double porcentajeEmpleadosEnTurno(){
        return (double) numeroEmpleadosEnTurno()*100/numeroEmpleadosGenerales();
    }

    public void consultarDatosInternos() { //consultar datos internos
        System.out.println("Escoja la opcion deseada: " +
                "\nOpcion 1: Mostrar porcentaje de numeros empleados en turno." +
                "\nOpcion 2: Mostrar total de empleados en turno." +
                "\nOpcion 3: Mostrar empleados generales de la empresa.");
        int opcion = input.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("el porcentaje de empleados en turno es de: "+ porcentajeEmpleadosEnTurno() + "%");
                break;
            case 2:
                System.out.println("Existen "+numeroEmpleadosEnTurno() + " empleados en el turno");
                break;
            case 3:
                System.out.println("Existen " + listaEmpleados.size()+ " empleados generales");
                break;
            default:
                consultarDatosInternos();
                break;
        }
    }

    public void crearOficinas() {
        System.out.println("¿Que tipo de oficina quieres crear?" +
                "Opcion 1.- Oficina de contadores" +
                "Opcion 2.- Oficina administrativa");

        int oficinas = input.nextInt();

        switch (oficinas){
            case 1:
                System.out.println("Cual es el numero de cabina?");
                    int cabina = input.nextInt();
                System.out.println("Cuantas tablas tiene la oficina?");
                    int tablas = input.nextInt();

                Oficina oficinaContadores = new OficinaContadores(cabina, tablas);
                break;

            case 2:

/*

                int cabina = input.nextInt();
                System.out.println();

                LocalDateTime dateTime;
*/

        }



    }
}

//1 - solucionar metodo porcentajeEmpleadosEnTurno()
//2 - nueva opcion menu general: Datos internos. -> Mostrar % de numero empleados en turno(15%), total de empleados en turno,(20 empleados) o generales (150 empleados).
//solucionar quitar empleados.

