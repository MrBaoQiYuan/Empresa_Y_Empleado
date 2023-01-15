import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Empresa empresa1 = new Empresa("Inditex");
        Empleado empleado1 = new Empleado();
        Scanner input = new Scanner(System.in);
        boolean repetir = false;
        while (!repetir) {

            opcionesDeMenu();
            int opcion;
            opcion = input.nextInt();

            switch (opcion) {
                case 1 -> { //AGREGAR UN EMPLEADO
                    opcionesAgregarEmpleado();
                    int opcionesAgregar = input.nextInt();
                    switch (opcionesAgregar) {
                        case 1 -> //Agregar un empleado
                                empresa1.agregarEmpleado(new Empleado(empleado1.darNombreUnEmpleado(), empleado1.darPuestoUnEmpleado(), empleado1.darSalarioUnEmpleado(), empleado1.darMatriculaUnEmpleado()));
                        case 2 -> //Agregar varios empleados
                                empresa1.creandoEmpMasivos();
                    }
                }
                case 2 -> { //Eliminar Empleados
                    opcionesMenuEliminarEmpleados();
                    int opcionesEliminar = input.nextInt();
                    switch (opcionesEliminar) {
                        case 1 -> //Eliminar segun nombre y puesto del empleado.
                                empresa1.eliminarSegunNombreYpuesto();
                        case 2 -> //Eliminar todos los empleados de un puesto
                                empresa1.eliminarEmpleadosDeUnPuesto();
                        case 3 -> {//Eliminar todos los empleados de la empresa
                            try {
                                empresa1.eliminarTodosEmpleados();
                            } catch (ConcurrentModificationException exception) {
                                System.out.println("excepcion, todos los empleados se han borrado satisfactoriamente");
                            }
                        }
                    }
                }
                case 3 -> //Modificar datos de empleado
                        empresa1.modificarEmpleado();
                case 4 -> {//consultar datos de empleado.
                    System.out.println("Seleccione consultar los empleados activos o despedidos." + "\nOpcion 1.- Empleados actuales activos." + "\nOpcion 2.- Empleados despedidos");
                    int opcionesConsulta = input.nextInt();
                    switch (opcionesConsulta) {
                        case 1 -> empresa1.consultarEmpleado();
                        case 2 -> empresa1.consultarEmpleadosDespedidos();
                    }
                }
                case 5 -> //Calcular el promedio de los salarios
                        empresa1.calcularPromedioSalarios();
                case 6 ->//Calcula el max y min de los salarios
                        empresa1.calculaSalarioMaximoMinimo();
                case 7 -> //Salir del programa
                        repetir = true;
                case 8 -> // Añadir o eliminar empleados al turno
                        empresa1.anadirOEliminarEmpleadosAlTurno();
                case 9 -> // consultar datos internos
                        empresa1.consultarDatosInternos();
                case 10 -> //Crear oficinas
                        empresa1.crearOficinas();
            }
        }
        System.out.println("Has salido del programa. ¡Hasta otra!");
    }

    static void opcionesDeMenu() {
        System.out.println("Seleccione una opcion del menu de Empleados: ");
        System.out.println("Opcion 1: Agregar");
        System.out.println("Opcion 2: Eliminar");
        System.out.println("Opcion 3: Modificar");
        System.out.println("Opcion 4: Consultar");
        System.out.println("Opcion 5: Calcula el promedio de los salarios");
        System.out.println("Opcion 6: Salario maximo y salario minimo");
        System.out.println("Opcion 7: Salir");
        System.out.println("Opcion 8: Añadir o eliminar empleados al turno"); //añadir / quitar empleados del turno.
        System.out.println("Opcion 9: Consultar datos internos.");
        System.out.println("Opcion 10: Crear oficinas.");
        System.out.println("Elija una opcion");
    }

    static void opcionesAgregarEmpleado() {
        System.out.println("Vamos a agregar un Empleado. Elija una opcion: " +
                "\nOpcion 1.- Agregar un empleado. " +
                "\nOpcion 2.- Agregar varios empleados a la vez");
    }

    static void opcionesMenuEliminarEmpleados(){
        System.out.println("Elija una de las siguientes opciones:" +
                "\nOpcion 1: Eliminar según nombre y puesto del empleado." +
                "\nOpcion 2: Eliminar todos los empleados de un mismo puesto." +
                "\nOpcion 3: Eliminar todos los empleados de la empresa.");
    }
}