import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Scanner;

public class Empresa {
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    private String nombre;
    ArrayList<Empleado> listaEmpleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado emp) {
        listaEmpleados.add(emp);
    }

    public void eliminarEmpleado(String nombre2, String puesto2) {
        for (Empleado e : listaEmpleados) {
            if (e.getNombre().equals(nombre2) && e.getPuesto().equals(puesto2)) {
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
                iter.remove();
            }
        }
            System.out.println("Se han eliminado todos los empleados del puesto, gracias");
    }

    public void eliminarTodosEmpleados() {
        for (Empleado e : listaEmpleados) {
            listaEmpleados.clear();
        }
    }


        public void modificarEmpleado ( int matricula2){

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
                            case 1:
                                System.out.println("El nombre que va a cambiar es:" + empleadoAModificar.getNombre());
                                System.out.println("ingrese el nuevo nombre");
                                String nombre3 = input.next();
                                empleadoAModificar.setNombre(nombre3);
                                break;

                            case 2:
                                System.out.println("El puesto actual es de" + e.getPuesto());
                                System.out.println("Ingrese el nuevo puesto de trabajo");
                                String puesto3 = input.next();
                                empleadoAModificar.setPuesto(puesto3);
                                break;

                            case 3:
                                System.out.println("El salario actual de " + empleadoAModificar.getNombre() + " es de " + empleadoAModificar.getSalario());
                                System.out.println("¿Cual quiere que sea su nuevo salario? Introduzcalo.");
                                double salario3 = input.nextDouble();
                                empleadoAModificar.setSalario(salario3);
                                break;

                            case 4:
                                System.out.println("Introduzca el nuevo numero de matricula de " + empleadoAModificar.getNombre());
                                int matricula3 = input.nextInt();
                                empleadoAModificar.setMatricula(matricula3);
                                break;

                            case 5:
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

        public void consultarEmpleado () {
            System.out.println("1.- Consultar lista completa.");
            System.out.println("2.- Consultar un empleado.");
            System.out.println("Elija una opcion");

            int opcion2 = input.nextInt();
            switch (opcion2) {
                case 1:
                    for (Empleado e : listaEmpleados) {
                        System.out.println(e);
                    }
                    break;
                case 2:
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

        public void calcularPromedioSalarios () {
            double salarioTotal = 0;
            double salarioMedio = 0;
            int nEmpleados = listaEmpleados.size();
            for (Empleado e : listaEmpleados) {
                salarioTotal += e.getSalario();
            }
            salarioMedio = salarioTotal / nEmpleados;
            System.out.println("El salario medio de la empresa es de: " + salarioMedio);
        }

        public void calculaSalarioMaximoMinimo () {
            double salarioMaximo = 0;
            double salarioMinimo = Integer.MAX_VALUE;
            Empleado empleadoSalarioMaximo = null;
            Empleado empleadoSalarioMinimo = null;

            for (Empleado e : listaEmpleados) {
                if (e.getSalario() > salarioMaximo) {
                    salarioMaximo = e.getSalario();
                    empleadoSalarioMaximo = e;
                }
            }
            System.out.println("El empleado " + empleadoSalarioMaximo.getNombre() + " tiene el salario maximo de " + empleadoSalarioMaximo.getSalario());

            for (Empleado e : listaEmpleados) {
                if (e.getSalario() < salarioMinimo) {
                    salarioMinimo = e.getSalario();
                    empleadoSalarioMinimo = e;
                }
            }
            System.out.println("El empleado " + empleadoSalarioMinimo.getNombre() + "tiene el salario minimo de " + empleadoSalarioMinimo.getSalario());

        }

    }

