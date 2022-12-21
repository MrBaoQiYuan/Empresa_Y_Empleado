import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Empresa empresa1 = new Empresa("Inditex");

/*
        empresa1.agregarEmpleado(new Empleado("luis","Encargado",2000,001));
        empresa1.agregarEmpleado(new Empleado("Pepe","Jefe",3000,002));
        empresa1.agregarEmpleado(new Empleado("Juan","mozo",1200,003));
*/

        boolean repetir = false;
        Scanner input = new Scanner(System.in);

        while (!repetir) {

            System.out.println("Seleccione una opcion del menu de Empleados: ");
            System.out.println("Opcion 1: Agregar");
            System.out.println("Opcion 2: Eliminar");
            System.out.println("Opcion 3: Modificar");
            System.out.println("Opcion 4: Consultar");
            System.out.println("Opcion 5: Calcula el promedio de los salarios");
            System.out.println("Opcion 6: Salario maximo y salario minimo");
            System.out.println("Opcion 7: Salir");

            System.out.println("Elija una opcion");
            int opcion;
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Vamos a agregar un Empleado. ¿Que desea?" +
                            "Opcion 10.- Agregar un empleado. " +
                            "Opcion 11.- Agregar varios empleados a la vez");
                    int opcion2 = input.nextInt();
                    switch (opcion2) {
                        case 10:
                            System.out.println("introduzca el nombre del empleado nuevo");
                            String nombre = input.nextLine();
                            System.out.println("introduzca el puesto del empleado nuevo");
                            String puesto = input.nextLine();
                            System.out.println("introduzca el salario del empleado nuevo");
                            double salario = input.nextDouble();
                            System.out.println("introduzca la matricula del empleado nuevo");
                            int matricula = input.nextInt();
                            input.nextLine();

                            empresa1.agregarEmpleado(new Empleado(nombre, puesto, salario, matricula));
                            break;

                        case 11:
                            System.out.println("Cuantos empleados quieres agregar?");
                            int numeroEmpleados = input.nextInt();
                            int arrayEmpleados[] = new int[numeroEmpleados];
                            for ()
                    }



                case 2:
                    if (empresa1.listaEmpleados.size() > 0) {
                        System.out.println("Introduzca el nombre del empleado a eliminar");
                        String nombre2 = input.nextLine();
                        System.out.println("Introduzca el puesto del empleado a eliminar");
                        String puesto2 = input.nextLine();
                        empresa1.eliminarEmpleado(nombre2, puesto2);
                    }else{
                        System.out.println("No hay empleados que eliminar");
                    }
                    break;

                case 3:
                    System.out.println("usted ha seleccionado modificar." +
                            "\nIngrese el numero de matricula del empleado que desea modificar.");
                    int matricula2 = input.nextInt();
                    input.nextLine();
                    empresa1.modificarEmpleado(matricula2);
                    break;


                case 4:
                    System.out.println("usted ha pulsado consultar. Estos son los empleados actuales.");
                    empresa1.consultarEmpleado();
                    break;


                case 5:
                    empresa1.calcularPromedioSalarios();
                    break;


                case 6:
                    empresa1.calculaSalarioMaximoMinimo();
                    break;


                case 7:
                    repetir = true;
                    break;


            }
        }
        System.out.println("Has salido del programa. ¡Hasta otra!");
    }

}