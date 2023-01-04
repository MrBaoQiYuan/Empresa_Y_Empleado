import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Empresa empresa1 = new Empresa("Inditex");
        Scanner input = new Scanner(System.in);

        boolean repetir = false;
        while (!repetir) {

            System.out.println("Seleccione una opcion del menu de Empleados: ");
            System.out.println("Opcion 1: Agregar");
            System.out.println("Opcion 2: Eliminar");
            System.out.println("Opcion 3: Modificar");
            System.out.println("Opcion 4: Consultar");
            System.out.println("Opcion 5: Calcula el promedio de los salarios");
            System.out.println("Opcion 6: Salario maximo y salario minimo");
            System.out.println("Opcion 7: Salir");
            System.out.println("Opcion 8: Añadir empleados al turno"); //añadir / quitar empleados del turno.

            System.out.println("Elija una opcion");
            int opcion;
            opcion = input.nextInt();

            switch (opcion) {
                case 1: //AGREGAR UN EMPLEADO
                    System.out.println("Vamos a agregar un Empleado. Elija una opcion: " +
                            "\nOpcion 10.- Agregar un empleado. " +
                            "\nOpcion 11.- Agregar varios empleados a la vez");

                    int opcion2 = input.nextInt();
                    switch (opcion2) {
                        case 10: //Agregar un empleado
                            System.out.println("introduzca el nombre del empleado nuevo");
                            String nombre = input.next();

                            while (contieneNumero(nombre)){
                                System.out.println("introduzca un nombre valido.");
                                nombre = input.next();
                            }
                            char primerLetra = nombre.charAt(0);
                            String primerLetraMayuscula = String.valueOf(Character.toUpperCase(primerLetra));
                            String restoDelString = nombre.substring(1).toLowerCase();
                            String nombreCorrecto = primerLetraMayuscula + restoDelString;

                            System.out.println("introduzca el puesto del empleado nuevo");
                            String puesto = input.next();
                            while(contieneNumero(puesto)){
                                System.out.println("introduzca un puesto valido");
                                puesto = input.next();
                            }
                            char primerLetra2 = puesto.charAt(0);
                            String primerLetraMayuscula2 = String.valueOf(Character.toUpperCase(primerLetra2));
                            String restoDelString2 = puesto.substring(1).toLowerCase();
                            String puestoCorrecto = primerLetraMayuscula2 + restoDelString2;

                            System.out.println("introduzca el salario del empleado nuevo");
                            double salario = input.nextDouble();
                            System.out.println("introduzca la matricula del empleado nuevo");
                            int matricula = input.nextInt();

                            empresa1.agregarEmpleado(new Empleado(nombreCorrecto, puestoCorrecto, salario, matricula));
                            break;

                        case 11: //Agregar varios empleados
                            System.out.println("¿Cuantos empleados quieres agregar?");
                            int nEmpleadosMasivos = input.nextInt();
                            System.out.println("¿Que puesto necesitas que cubran los " + nEmpleadosMasivos + " empleados nuevos?");
                            String puestoMasivo = input.next();
                            System.out.println("¿Que salario tendrán los " + nEmpleadosMasivos + " empleados nuevos?");
                            double salarioMasivo = input.nextDouble();
                            System.out.println("A partir de que numero de matricula se regitrarán los empleados nuevos?");
                            int matriculaAuto = input.nextInt() -1;

                            for (int i = 0; i < nEmpleadosMasivos; i++) {
                                String nombre2 = "";
                                matriculaAuto++;
                                empresa1.agregarEmpleado(new Empleado(nombre2, puestoMasivo, salarioMasivo, matriculaAuto));
                            }
                            break;
                    }
                    break;

                case 2: //Eliminar Empleados
                    System.out.println("Elija una de las siguientes opciones:" +
                            "\nOpcion 12: Eliminar según nombre y puesto del empleado." +
                            "\nOpcion 13: Eliminar todos los empleados de un mismo puesto." +
                            "\nOpcion 14: Eliminar todos los empleados de la empresa.");
                    int opcionEliminar = input.nextInt();
                    switch (opcionEliminar) {
                        case 12: //Eliminar segun nombre y puesto del empleado.
                            try {
                                if (empresa1.listaEmpleados.size() > 0) {
                                    System.out.println("Introduzca el nombre del empleado a eliminar");
                                    String nombre2 = input.next();
                                    System.out.println("Introduzca el puesto del empleado a eliminar");
                                    String puesto2 = input.next();
                                    empresa1.eliminarEmpleado(nombre2, puesto2);
                                } else {
                                    System.out.println("No hay empleados que eliminar");
                                }
                            }catch(ConcurrentModificationException ex) {
                                System.out.println("proceso de eliminacion finalizado");
                            }

                            break;

                        case 13: //Eliminar todos los empleados de un puesto
                            empresa1.eliminarEmpleadosDeUnPuesto();
                            break;

                        case 14://Eliminar todos los empleados de la empresa
                            try {
                                empresa1.eliminarTodosEmpleados();
                                System.out.println("Se han eliminado todos los empleados de la empresa");
                                break;
                            }catch (ConcurrentModificationException exception){
                                System.out.println("excepcion, todos los empleados se han borrado satisfactoriamente");
                            };
                    }
                    break;

                case 3: //Modificar datos de empleado
                    System.out.println("usted ha seleccionado modificar." +
                            "\nIngrese el numero de matricula del empleado que desea modificar.");
                    int matricula2 = input.nextInt();
                    input.nextLine();
                    empresa1.modificarEmpleado(matricula2);
                    break;


                case 4://consultar datos de empleado.
                    System.out.println("Seleccione consultar los empleados activos o despedidos." +
                            "Opcion 15.- Empleados actuales activos." +
                            "Opcion 16.- Empleados despedidos");
                    int opcion3 = input.nextInt();
                    switch (opcion3) {
                        case 15:
                            empresa1.consultarEmpleado();
                            break;
                        case 16:
                            empresa1.consultarEmpleadosDespedidos();
                            break;
                    }


                case 5: //Calcular el promedio de los salarios
                    empresa1.calcularPromedioSalarios();
                    break;


                case 6://Calcula el max y min de los salarios
                    empresa1.calculaSalarioMaximoMinimo();
                    break;


                case 7:
                    repetir = true;
                    break;

                case 8: // Añadir empleados al turno
                    empresa1.anadirEmpleadosAlTurno();


            }
        }
        System.out.println("Has salido del programa. ¡Hasta otra!");

    }

    public static boolean contieneNumero(String nombre){
        return nombre.matches(".*\\d+.*");
    }


}


