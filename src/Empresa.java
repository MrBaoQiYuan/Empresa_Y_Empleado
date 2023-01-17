// croquis del programa y arreglar las opciones.
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
    ArrayList<OficinaAdministrativa> listaOficinaAdministrativa;
    ArrayList<OficinaContadores> listaOficinaContadores;


    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
        this.listaEmpleadosDespedidos = new ArrayList<>();
        this.listaEmpleadosEnTurno = new ArrayList<>();
        this.listaOficinaAdministrativa = new ArrayList<>();
        this.listaOficinaContadores = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado emp) { //Agregar un empleado.
        listaEmpleados.add(emp);
    }

    public void creandoEmpMasivos() { //Agregar empleados de forma masiva.
        String nombre2 = "";
        String puestoMasivo = Empleado.puestoMasivo();
        double salarioMasivo = Empleado.salarioMasivo();
        int cantEmplMasivos = Empleado.cantEmplMasivos();
        int matriculaMasiva = Empleado.matriculaMasiva();

        for (int j = matriculaMasiva; j < cantEmplMasivos + matriculaMasiva; j++) {
            int matriculaMasiva2 = j;
            listaEmpleados.add(new Empleado(nombre2, puestoMasivo, salarioMasivo, matriculaMasiva2));
        }
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
    public void eliminarSegunNombreYpuesto() {
        try {
            if (listaEmpleados.size() > 0) {
                System.out.println("Introduzca el nombre del empleado a eliminar");
                String nombre2 = input.next();
                System.out.println("Introduzca el puesto del empleado a eliminar");
                String puesto2 = input.next();
                eliminarEmpleado(nombre2, puesto2);
            } else {
                System.out.println("No hay empleados que eliminar");
            }
        } catch (ConcurrentModificationException ex) {
            System.out.println("proceso de eliminacion finalizado");
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
        System.out.println("Se han eliminado todos los empleados de la empresa");
    }

    public void modificarEmpleado() { //Modificar datos de empleado.

        System.out.println("usted ha seleccionado modificar." + "\nIngrese el numero de matricula del empleado que desea modificar.");
        int matricula2 = input.nextInt();

        for (Empleado e : listaEmpleados) {
            if (matricula2 == e.getMatricula()) {

                boolean salir = false;
                while (!salir) {
                    System.out.println("Que datos desea modificar? ");
                    System.out.println("opcion 25: nombre");
                    System.out.println("opcion 26: puesto");
                    System.out.println("opcion 27: salario");
                    System.out.println("opcion 28: matricula");
                    System.out.println("opcion 29: salir");

                    int opcion2 = input.nextInt();
                    switch (opcion2) {
                        case 25 -> { //Modificar datos de empleado.(nombre)
                            System.out.println("El nombre que va a cambiar es:" + e.getNombre());
                            System.out.println("ingrese el nuevo nombre");
                            String nombre3 = input.next();
                            e.setNombre(nombre3);
                        }
                        case 26 -> {//Modificar datos de empleado.(puesto)
                            System.out.println("El puesto actual es de" + e.getPuesto());
                            System.out.println("Ingrese el nuevo puesto de trabajo");
                            String puesto3 = input.next();
                            e.setPuesto(puesto3);
                        }
                        case 27 -> {//Modificar datos de empleado.(salario)
                            System.out.println("¿Cual quiere que sea su nuevo salario? Introduzcalo.");
                            double salario3 = input.nextDouble();
                            e.setSalario(salario3);
                        }
                        case 28 -> {//Modificar datos de empleado.(numero matricula)
                            System.out.println("Introduzca el nuevo numero de matricula de " + e.getNombre());
                            int matricula3 = input.nextInt();
                            e.setMatricula(matricula3);
                        }
                        case 29 ->//Modificar datos de empleado.
                                salir = true;
                        default -> {
                            System.out.println("Introduzca una opcion valida.");
                            modificarEmpleado();
                        }
                    }
                }
            }
        }
    }

    public void consultarEmpleado() { //Consultar datos de empleado.
        System.out.println("32.- Consultar lista completa.");
        System.out.println("33.- Consultar un empleado.");
        System.out.println("Elija una opcion");

        int opcionesConsulta = input.nextInt();
        switch (opcionesConsulta) {
            case 32 -> { //consultar datos de empleado. (lista completa)
                for (Empleado e : listaEmpleados) {
                    System.out.println(e);
                }
            }
            case 33 -> {//consultar datos de empleado.(un empleado)
                System.out.println("Ingrese la matricula del empleado");
                int nMatricula = input.nextInt();
                for (Empleado e : listaEmpleados) {
                    if (nMatricula == e.getMatricula()) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    public void calcularPromedioSalarios() { //Calcular el promedio de los salarios
        double salarioTotal = 0;
        double salarioMedio = 0;
        int nEmpleados = listaEmpleados.size();
        for (Empleado e : listaEmpleados) {
            salarioTotal += e.getSalario2();
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
            if (e.getSalario2() > salarioMaximo) {
                salarioMaximo = e.getSalario2();
                empleadoSalarioMaximo = e;
            }
        }
        System.out.println("El empleado " + empleadoSalarioMaximo.getNombre() + " tiene el salario maximo de " + empleadoSalarioMaximo.getSalario2());

        for (Empleado e : listaEmpleados) {//calculo min
            if (e.getSalario2() < salarioMinimo) {
                salarioMinimo = e.getSalario2();
                empleadoSalarioMinimo = e;
            }
        }
        System.out.println("El empleado " + empleadoSalarioMinimo.getNombre() + " tiene el salario minimo de " + empleadoSalarioMinimo.getSalario2());
    }

    public void consultarEmpleadosDespedidos() {
        for (Empleado f : listaEmpleadosDespedidos) {
            System.out.println(f);
        }
    }
    public void anadirOEliminarEmpleadosAlTurno() {
        System.out.println("¿Que deseas hacer?" +
                "\nOpcion 34.- Añadir un empleado al turno" +
                "\nOpcion 35.- Eliminar un empleado del turno");
        int opcion = input.nextInt();
        switch (opcion) {
            case 34 -> {
                System.out.println("Inserte la matricula del empleado que entra al turno");
                int matriculaEmpleado = input.nextInt();
                for (Empleado e : listaEmpleados) {
                    if (e.getMatricula() == matriculaEmpleado) {
                        listaEmpleadosEnTurno.add(e);
                    }
                }
            }
            case 35 -> {
                System.out.println("Introduzca la matricula del empleado a eliminar del turno");
                int matriculaEmpleado2 = input.nextInt();
                Iterator<Empleado> it = listaEmpleadosEnTurno.iterator();
                while (it.hasNext()) {
                    Empleado e = it.next();
                    if (e.getMatricula() == matriculaEmpleado2) {
                        it.remove();
                    }
                }
            }
            default -> anadirOEliminarEmpleadosAlTurno();
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
                "\nOpcion 36: Mostrar porcentaje de numeros empleados en turno." +
                "\nOpcion 37: Mostrar total de empleados en turno." +
                "\nOpcion 38: Mostrar empleados generales de la empresa.");
        int opcion = input.nextInt();
        switch (opcion) {
            case 36 -> System.out.println("el porcentaje de empleados en turno es de: " + porcentajeEmpleadosEnTurno() + "%");
            case 37 -> System.out.println("Existen " + numeroEmpleadosEnTurno() + " empleados en el turno");
            case 38 -> System.out.println("Existen " + listaEmpleados.size() + " empleados generales");
            default -> consultarDatosInternos();
        }
    }

    public void crearOficinas() {
        System.out.println("¿Que tipo de oficina quieres crear?" +
                "\n Opcion 39.- Oficina de contadores" +
                "\n Opcion 40.- Oficina administrativa");

        int oficinas = input.nextInt();

        switch (oficinas) {
            case 39 -> {
                System.out.println("Cual es el numero de cabina?");
                int cabina = input.nextInt();
                System.out.println("Cuantas tablas tiene la oficina?");
                int tablas = input.nextInt();
                OficinaContadores oficinaContadores = new OficinaContadores(cabina, tablas);
                listaOficinaContadores.add(oficinaContadores);
            }
            case 40 -> {
                System.out.println("cual es el numero de cabina?");
                int cabina2 = input.nextInt();
                System.out.println("Cuantos documentos guarda?");
                int documentos = input.nextInt();
                OficinaAdministrativa oficinaDeAdministradores = new OficinaAdministrativa(cabina2, documentos);
                listaOficinaAdministrativa.add(oficinaDeAdministradores);
            }
        }
    }

    public void asociarEmpleadoConOficina() {
        System.out.println("¿Hacia que tipo de oficina te quieres dirigir?" +
                "\nOpcion 41.- Oficina administrativa" +
                "\nOpcion 42.- Oficina de contadores");
        int opcionOficina = input.nextInt();
        switch (opcionOficina) {
            case 41 -> {
                System.out.println("Que empleado quieres elegir?. Introduzca su matricula");
                int matricula2 = input.nextInt();
                for (Empleado e : listaEmpleados) {
                    if (matricula2 == e.getMatricula()) {
                        OficinaAdministrativa.agregarEmpleado(e);
                    }
                }
            }
            case 42 -> {
                System.out.println("Que empleado quieres elegir?. Introduzca su matricula");
                int matricula2 = input.nextInt();
                for (Empleado e: listaEmpleados) {
                    if (matricula2 == e.getMatricula()) {
                        OficinaContadores.agregarEmpleado(e);
                    }
                }
            }
        }
    }


    public void mostrarOficinas() {
        System.out.println("¿Que lista de oficinas deseas visualizar?" +
                "\nOpcion 43.- Lista de oficinas administrativas" +
                "\nOpcion 44.- Lista de oficinas de contadores");
        int opcionOficinas = input.nextInt();
        switch (opcionOficinas) {
            case 43 -> {
                for (Oficina e : listaOficinaAdministrativa) {
                    System.out.println(e.toString());
                }
            }
            case 44 -> {
                for (Oficina e : listaOficinaContadores) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}