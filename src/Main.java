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
                    switchOpcionesAgregar(opcionesAgregar, empleado1, empresa1);
                }
                case 2 -> { //Eliminar Empleados
                    opcionesMenuEliminarEmpleados();
                    int opcionesEliminar = input.nextInt();
                    switchOpcionEliminar(opcionesEliminar, empresa1);
                }
                case 3 -> //Modificar datos de empleado
                        empresa1.modificarEmpleado();
                case 4 -> {//consultar datos de empleado.
                    System.out.println("Seleccione consultar los empleados activos o despedidos." +
                            "\nOpcion 30.- Empleados actuales activos." +
                            "\nOpcion 31.- Empleados despedidos");
                    int opcionesConsulta = input.nextInt();
                    switchOpcionesConsulta(opcionesConsulta, empresa1);
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
                case 11-> //Asociar empleado con oficina
                        empresa1.asociarEmpleadoConOficina();
                case 12-> //Mostrar Oficinas.
                        empresa1.mostrarOficinas();
            }
        }
        System.out.println("Has salido del programa. ¡Hasta otra!");
    }



    private static void switchOpcionesAgregar(int opcionesAgregar, Empleado empleado1, Empresa empresa1) {
        switch (opcionesAgregar) {
            case 20 -> //Agregar un empleado
                    empresa1.agregarEmpleado(new Empleado(empleado1.darNombreUnEmpleado(), empleado1.darPuestoUnEmpleado(), empleado1.darSalarioUnEmpleado(), empleado1.darMatriculaUnEmpleado()));
            case 21 -> //Agregar varios empleados
                    empresa1.creandoEmpMasivos();
        }
    }

    private static void switchOpcionEliminar(int opcionesEliminar, Empresa empresa1) {
        switch (opcionesEliminar) {
            case 22 -> //Eliminar segun nombre y puesto del empleado.
                    empresa1.eliminarSegunNombreYpuesto();
            case 23 -> //Eliminar todos los empleados de un puesto
                    empresa1.eliminarEmpleadosDeUnPuesto();
            case 24 -> {//Eliminar todos los empleados de la empresa
                try {
                    empresa1.eliminarTodosEmpleados();
                } catch (ConcurrentModificationException exception) {
                    System.out.println("excepcion, todos los empleados se han borrado satisfactoriamente");
                }
            }
        }
    }

    private static void switchOpcionesConsulta(int opcionesConsulta, Empresa empresa1) {
        switch (opcionesConsulta) {
            case 30 -> empresa1.consultarEmpleado();
            case 31 -> empresa1.consultarEmpleadosDespedidos();
        }
    }

    static void opcionesDeMenu() {
        System.out.println("Seleccione una opcion del menu de Empleados: ");
        System.out.println("Opcion 1: Agregar empleados");
        System.out.println("Opcion 2: Eliminar empleados");
        System.out.println("Opcion 3: Modificar empleados");
        System.out.println("Opcion 4: Consultar empleados");
        System.out.println("Opcion 5: Calcula el promedio de los salarios de los empleados");
        System.out.println("Opcion 6: Salario maximo y salario minimo empleados");
        System.out.println("Opcion 7: Salir del programa");
        System.out.println("Opcion 8: Añadir o eliminar empleados al turno"); //añadir / quitar empleados del turno.
        System.out.println("Opcion 9: Consultar datos internos.");
        System.out.println("Opcion 10: Crear oficinas.");
        System.out.println("Opcion 11: Asociar empleado a oficina");
        System.out.println("Opcion 12: Mostrar oficinas.");
        System.out.println("Elija una opcion");
    }

    static void opcionesAgregarEmpleado() {
        System.out.println("Vamos a agregar un Empleado. Elija una opcion: " +
                "\nOpcion 20.- Agregar un empleado. " +
                "\nOpcion 21.- Agregar varios empleados a la vez");
    }

    static void opcionesMenuEliminarEmpleados(){
        System.out.println("Elija una de las siguientes opciones:" +
                "\nOpcion 22: Eliminar según nombre y puesto del empleado." +
                "\nOpcion 23: Eliminar todos los empleados de un mismo puesto." +
                "\nOpcion 24: Eliminar todos los empleados de la empresa.");
    }
}