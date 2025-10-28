import java.io.*;
import java.util.Scanner;

public class InterfacePrincipal {
    public void InteraccionesUsuarios(){
        Cls_Administrador obj = new Cls_Administrador();
        Cls_Estacionamiento<Cls_Terrestre> Estacionamiento2023_01 = cargarEstacionamiento("Estacionamiento2023_01.ser");
        Cls_Estacionamiento<Cls_Terrestre> Estacionamiento2023_02 = cargarEstacionamiento("Estacionamiento2023_02.ser");
        Cls_Estacionamiento<Cls_Terrestre> Estacionamiento2024_01 = cargarEstacionamiento("Estacionamiento2024_01.ser");
        Cls_Estacionamiento<Cls_Terrestre> Estacionamiento2024_02 = cargarEstacionamiento("Estacionamiento2024_02.ser");
        Scanner scanner = new Scanner(System.in);
        int opcion = 0, opc2=0, opc3=0,opc4=0, opc5=0;
        do {
            System.out.println("======================================================================");
            System.out.println("============== BIENVENIDO AL ESTACIONAMIENTO 'AUTOBOTS' ==============");
            System.out.println("======================================================================");
            System.out.println("                      Menú del Estacionamiento");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Listar vehículos");
            System.out.println("3. Listar vehículos todas las temporadas");
            System.out.println("4. Retirar vehículo");
            System.out.println("5. Modificar");
            System.out.println("6. Reportes");
            System.out.println("7. Otros");
            System.out.println("8. Salir");
            System.out.println("======================================================================");
            boolean validInput = false;
            do {
                System.out.print("Seleccione una opción: ");
                try {
                    opcion = scanner.nextInt();
                    if (opcion >= 1 && opcion <= 8) {
                        validInput = true;
                    } else {
                        System.out.println("Por favor, ingrese un número entre 1 y 8.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.nextLine();
                }
            }while (!validInput);
            boolean validInput2 = false;
            switch (opcion) {
                case 1:
                    System.out.println("==================== REGISTRAR VEHICULO ====================");
                    System.out.println("Seleccione la Temporada que desea ingresar:");
                    System.out.println("1. Estacionamiento 2023 - 01");
                    System.out.println("2. Estacionamiento 2023 - 02");
                    System.out.println("3. Estacionamiento 2024 - 01");
                    System.out.println("4. Estacionamiento 2024 - 02");
                    do {
                        System.out.print("Seleccione una opción: ");
                        try {
                            opc2 = scanner.nextInt();
                            if (opc2 >= 1 && opc2 <= 4) {
                                validInput2 = true;
                            } else {
                                System.out.println("Por favor, ingrese un número entre 1 y 4.");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número.");
                            scanner.nextLine();
                        }
                    }while (!validInput2);
                    int tipo = 0;
                    String matricula;
                    String modelo;
                    String marca;
                    int Horas = 0;
                    String TipoVehiculo;
                    float Tarifa;
                    float Precio;
                    boolean validInput3 = false;
                    boolean validInput4 = false;
                    boolean validInput5 = false;
                    boolean esDeportiva = false;
                    int numPuertas = 0;
                    double capacidadCarga = 0;
                    boolean esElectrica = false;
                    switch (opc2){
                        case 1:
                            System.out.println("=================================================");
                            System.out.println("=========== Estacionamiento 2023 - 01 ===========");
                            System.out.println("=================================================");
                            System.out.println("Seleccione el tipo de vehículo:");
                            System.out.println("1. Moto");
                            System.out.println("2. Auto");
                            System.out.println("3. Camión");
                            System.out.println("4. Bicicleta");
                            do {
                                System.out.print("Seleccione una opción: ");
                                try {
                                    tipo = scanner.nextInt();
                                    if (opc2 >= 1 && tipo <= 4) {
                                        validInput3 = true;
                                    } else {
                                        System.out.println("Por favor, ingrese un número entre 1 y 4.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                                    scanner.nextLine();
                                }
                            }while (!validInput3);
                            scanner.nextLine();
                            System.out.print("Ingrese matrícula: ");
                            matricula = scanner.nextLine();
                            System.out.print("Ingrese modelo: ");
                            modelo = scanner.nextLine();
                            System.out.print("Ingrese marca: ");
                            marca = scanner.nextLine();

                            do {
                                System.out.print("Ingrese Cantidad de Horas: ");
                                if (scanner.hasNextInt()) {
                                    Horas = scanner.nextInt(); // Lee el número entero
                                    scanner.nextLine(); // Limpia el buffer
                                    validInput4 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                    scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                }
                            } while (!validInput4);

                            switch (tipo) {
                                case 1:
                                    do {
                                        System.out.print("¿Es deportiva? (true/false): ");
                                        if (scanner.hasNextBoolean()) {
                                            esDeportiva = scanner.nextBoolean(); // Lee el valor booleano
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Moto";
                                    String PregDeportiva;
                                    if (esDeportiva ==true){
                                        PregDeportiva = "Deportiva";
                                    }else{
                                        PregDeportiva = "Normal";
                                    }
                                    Precio = 3.8f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2023_01.registrarVehiculo(new Cls_Moto(TipoVehiculo,matricula,
                                            modelo, marca,Horas, PregDeportiva, Precio,Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 2:
                                    do {
                                        System.out.print("Ingrese número de puertas: ");
                                        if (scanner.hasNextInt()) {
                                            numPuertas= scanner.nextInt();
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                            scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Auto";
                                    Precio = 4.2f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2023_01.registrarVehiculo(new Cls_Auto(TipoVehiculo,matricula,
                                            modelo, marca, Horas,numPuertas, Precio,Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 3:
                                    do {
                                        System.out.print("Ingrese capacidad de carga (en toneladas): ");
                                        if (scanner.hasNextDouble()) {
                                            capacidadCarga = scanner.nextDouble(); // Lee el valor de tipo double
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Camion";
                                    Precio = 5.5f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2023_01.registrarVehiculo(new Cls_Camion(TipoVehiculo,matricula,
                                            modelo, marca,Horas, (float)capacidadCarga, Precio, Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 4:
                                    do {
                                        System.out.print("¿Es eléctrica? (true/false): ");
                                        if (scanner.hasNextBoolean()) {
                                            esElectrica = scanner.nextBoolean(); // Lee el valor booleano
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    String PregElectrica;
                                    if (esElectrica == true){
                                        PregElectrica = "Electrica";
                                    }else{
                                        PregElectrica = "Normal";
                                    }
                                    TipoVehiculo = "Bicicleta";
                                    Precio = 2;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2023_01.registrarVehiculo(new Cls_Bicicleta(TipoVehiculo,matricula,
                                            modelo, marca, Horas,PregElectrica, Precio, Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                            }
                            break;
                        case 2:
                            System.out.println("=================================================");
                            System.out.println("=========== Estacionamiento 2023 - 02 ===========");
                            System.out.println("=================================================");
                            System.out.println("Seleccione el tipo de vehículo:");
                            System.out.println("1. Moto");
                            System.out.println("2. Auto");
                            System.out.println("3. Camión");
                            System.out.println("4. Bicicleta");
                            do {
                                System.out.print("Seleccione una opción: ");
                                try {
                                    tipo = scanner.nextInt();
                                    if (opc2 >= 1 && tipo <= 4) {
                                        validInput3 = true;
                                    } else {
                                        System.out.println("Por favor, ingrese un número entre 1 y 4.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                                    scanner.nextLine();
                                }
                            }while (!validInput3);
                            scanner.nextLine();
                            System.out.print("Ingrese matrícula: ");
                            matricula = scanner.nextLine();
                            System.out.print("Ingrese modelo: ");
                            modelo = scanner.nextLine();
                            System.out.print("Ingrese marca: ");
                            marca = scanner.nextLine();

                            do {
                                System.out.print("Ingrese Cantidad de Horas: ");
                                if (scanner.hasNextInt()) {
                                    Horas = scanner.nextInt(); // Lee el número entero
                                    scanner.nextLine(); // Limpia el buffer
                                    validInput4 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                    scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                }
                            } while (!validInput4);

                            switch (tipo) {
                                case 1:
                                    do {
                                        System.out.print("¿Es deportiva? (true/false): ");
                                        if (scanner.hasNextBoolean()) {
                                            esDeportiva = scanner.nextBoolean(); // Lee el valor booleano
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Moto";
                                    String PregDeportiva;
                                    if (esDeportiva ==true){
                                        PregDeportiva = "Deportiva";
                                    }else{
                                        PregDeportiva = "Normal";
                                    }
                                    Precio = 3.8f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2023_02.registrarVehiculo(new Cls_Moto(TipoVehiculo,matricula,
                                            modelo, marca,Horas, PregDeportiva, Precio,Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 2:
                                    do {
                                        System.out.print("Ingrese número de puertas: ");
                                        if (scanner.hasNextInt()) {
                                            numPuertas= scanner.nextInt();
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                            scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Auto";
                                    Precio = 4.2f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2023_02.registrarVehiculo(new Cls_Auto(TipoVehiculo,matricula,
                                            modelo, marca, Horas,numPuertas, Precio,Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 3:
                                    do {
                                        System.out.print("Ingrese capacidad de carga (en toneladas): ");
                                        if (scanner.hasNextDouble()) {
                                            capacidadCarga = scanner.nextDouble(); // Lee el valor de tipo double
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Camion";
                                    Precio = 5.5f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2023_02.registrarVehiculo(new Cls_Camion(TipoVehiculo,matricula,
                                            modelo, marca,Horas, (float)capacidadCarga, Precio, Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 4:
                                    do {
                                        System.out.print("¿Es eléctrica? (true/false): ");
                                        if (scanner.hasNextBoolean()) {
                                            esElectrica = scanner.nextBoolean(); // Lee el valor booleano
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    String PregElectrica;
                                    if (esElectrica == true){
                                        PregElectrica = "Electrica";
                                    }else{
                                        PregElectrica = "Normal";
                                    }
                                    TipoVehiculo = "Bicicleta";
                                    Precio = 2;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2023_02.registrarVehiculo(new Cls_Bicicleta(TipoVehiculo,matricula,
                                            modelo, marca, Horas,PregElectrica, Precio, Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                            }
                            break;
                        case 3:
                            System.out.println("=================================================");
                            System.out.println("=========== Estacionamiento 2024 - 01 ===========");
                            System.out.println("=================================================");
                            System.out.println("Seleccione el tipo de vehículo:");
                            System.out.println("1. Moto");
                            System.out.println("2. Auto");
                            System.out.println("3. Camión");
                            System.out.println("4. Bicicleta");
                            do {
                                System.out.print("Seleccione una opción: ");
                                try {
                                    tipo = scanner.nextInt();
                                    if (opc2 >= 1 && tipo <= 4) {
                                        validInput3 = true;
                                    } else {
                                        System.out.println("Por favor, ingrese un número entre 1 y 4.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                                    scanner.nextLine();
                                }
                            }while (!validInput3);
                            scanner.nextLine();
                            System.out.print("Ingrese matrícula: ");
                            matricula = scanner.nextLine();
                            System.out.print("Ingrese modelo: ");
                            modelo = scanner.nextLine();
                            System.out.print("Ingrese marca: ");
                            marca = scanner.nextLine();

                            do {
                                System.out.print("Ingrese Cantidad de Horas: ");
                                if (scanner.hasNextInt()) {
                                    Horas = scanner.nextInt(); // Lee el número entero
                                    scanner.nextLine(); // Limpia el buffer
                                    validInput4 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                    scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                }
                            } while (!validInput4);

                            switch (tipo) {
                                case 1:
                                    do {
                                        System.out.print("¿Es deportiva? (true/false): ");
                                        if (scanner.hasNextBoolean()) {
                                            esDeportiva = scanner.nextBoolean(); // Lee el valor booleano
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Moto";
                                    String PregDeportiva;
                                    if (esDeportiva == true){
                                        PregDeportiva = "Deportiva";
                                    }else{
                                        PregDeportiva = "Normal";
                                    }
                                    Precio = 3.8f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2024_01.registrarVehiculo(new Cls_Moto(TipoVehiculo,matricula,
                                            modelo, marca,Horas, PregDeportiva, Precio,Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 2:
                                    do {
                                        System.out.print("Ingrese número de puertas: ");
                                        if (scanner.hasNextInt()) {
                                            numPuertas= scanner.nextInt();
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                            scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Auto";
                                    Precio = 4.2f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2024_01.registrarVehiculo(new Cls_Auto(TipoVehiculo,matricula,
                                            modelo, marca, Horas,numPuertas, Precio,Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 3:
                                    do {
                                        System.out.print("Ingrese capacidad de carga (en toneladas): ");
                                        if (scanner.hasNextDouble()) {
                                            capacidadCarga = scanner.nextDouble(); // Lee el valor de tipo double
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Camion";
                                    Precio = 5.5f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2024_01.registrarVehiculo(new Cls_Camion(TipoVehiculo,matricula,
                                            modelo, marca,Horas, (float)capacidadCarga, Precio, Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 4:
                                    do {
                                        System.out.print("¿Es eléctrica? (true/false): ");
                                        if (scanner.hasNextBoolean()) {
                                            esElectrica = scanner.nextBoolean(); // Lee el valor booleano
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    String PregElectrica;
                                    if (esElectrica == true){
                                        PregElectrica = "Electrica";
                                    }else{
                                        PregElectrica = "Normal";
                                    }
                                    TipoVehiculo = "Bicicleta";
                                    Precio = 2;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2024_01.registrarVehiculo(new Cls_Bicicleta(TipoVehiculo,matricula,
                                            modelo, marca, Horas,PregElectrica, Precio, Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                            }
                            break;
                        case 4:
                            System.out.println("=================================================");
                            System.out.println("=========== Estacionamiento 2024 - 02 ===========");
                            System.out.println("=================================================");
                            System.out.println("Seleccione el tipo de vehículo:");
                            System.out.println("1. Moto");
                            System.out.println("2. Auto");
                            System.out.println("3. Camión");
                            System.out.println("4. Bicicleta");
                            do {
                                System.out.print("Seleccione una opción: ");
                                try {
                                    tipo = scanner.nextInt();
                                    if (opc2 >= 1 && tipo <= 4) {
                                        validInput3 = true;
                                    } else {
                                        System.out.println("Por favor, ingrese un número entre 1 y 4.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                                    scanner.nextLine();
                                }
                            }while (!validInput3);
                            scanner.nextLine();
                            System.out.print("Ingrese matrícula: ");
                            matricula = scanner.nextLine();
                            System.out.print("Ingrese modelo: ");
                            modelo = scanner.nextLine();
                            System.out.print("Ingrese marca: ");
                            marca = scanner.nextLine();

                            do {
                                System.out.print("Ingrese Cantidad de Horas: ");
                                if (scanner.hasNextInt()) {
                                    Horas = scanner.nextInt(); // Lee el número entero
                                    scanner.nextLine(); // Limpia el buffer
                                    validInput4 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                    scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                }
                            } while (!validInput4);

                            switch (tipo) {
                                case 1:
                                    do {
                                        System.out.print("¿Es deportiva? (true/false): ");
                                        if (scanner.hasNextBoolean()) {
                                            esDeportiva = scanner.nextBoolean(); // Lee el valor booleano
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Moto";
                                    String PregDeportiva;
                                    if (esDeportiva == true){
                                        PregDeportiva = "Deportiva";
                                    }else{
                                        PregDeportiva = "Normal";
                                    }
                                    Precio = 3.8f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2024_02.registrarVehiculo(new Cls_Moto(TipoVehiculo,matricula,
                                            modelo, marca,Horas, PregDeportiva, Precio,Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 2:
                                    do {
                                        System.out.print("Ingrese número de puertas: ");
                                        if (scanner.hasNextInt()) {
                                            numPuertas= scanner.nextInt();
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                            scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Auto";
                                    Precio = 4.2f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2024_02.registrarVehiculo(new Cls_Auto(TipoVehiculo,matricula,
                                            modelo, marca, Horas,numPuertas, Precio,Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 3:
                                    do {
                                        System.out.print("Ingrese capacidad de carga (en toneladas): ");
                                        if (scanner.hasNextDouble()) {
                                            capacidadCarga = scanner.nextDouble(); // Lee el valor de tipo double
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    TipoVehiculo = "Camion";
                                    Precio = 5.5f;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2024_02.registrarVehiculo(new Cls_Camion(TipoVehiculo,matricula,
                                            modelo, marca,Horas, (float)capacidadCarga, Precio, Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                case 4:
                                    do {
                                        System.out.print("¿Es eléctrica? (true/false): ");
                                        if (scanner.hasNextBoolean()) {
                                            esElectrica = scanner.nextBoolean(); // Lee el valor booleano
                                            scanner.nextLine(); // Limpia el buffer
                                            validInput5 = true; // Entrada válida, se sale del bucle
                                        } else {
                                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                                            scanner.nextLine(); // Limpia el buffer para evitar problemas
                                        }
                                    } while (!validInput5);
                                    String PregElectrica;
                                    if (esElectrica == true){
                                        PregElectrica = "Electrica";
                                    }else{
                                        PregElectrica = "Normal";
                                    }
                                    TipoVehiculo = "Bicicleta";
                                    Precio = 2;
                                    Tarifa = Horas *Precio;
                                    Estacionamiento2024_02.registrarVehiculo(new Cls_Bicicleta(TipoVehiculo,matricula,
                                            modelo, marca, Horas,PregElectrica, Precio, Tarifa));
                                    System.out.println("Vehiculo Agregado Correctamente.");
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                            }
                            break;
                    }
                    guardarEstacionamiento("Estacionamiento2023_01.ser", Estacionamiento2023_01);
                    guardarEstacionamiento("Estacionamiento2023_02.ser", Estacionamiento2023_02);
                    guardarEstacionamiento("Estacionamiento2024_01.ser", Estacionamiento2024_01);
                    guardarEstacionamiento("Estacionamiento2024_02.ser", Estacionamiento2024_02);
                    break;
                case 2:
                    System.out.println("==================== LISTAR VEHICULOS ====================");
                    System.out.println("Seleccione la Temporada que desea ingresar:");
                    System.out.println("1. Estacionamiento 2023 - 01");
                    System.out.println("2. Estacionamiento 2023 - 02");
                    System.out.println("3. Estacionamiento 2024 - 01");
                    System.out.println("4. Estacionamiento 2024 - 02");
                    do {
                        System.out.print("Seleccione una opción: ");
                        try {
                            opc2 = scanner.nextInt();
                            if (opc2 >= 1 && opc2 <= 4) {
                                validInput2 = true;
                            } else {
                                System.out.println("Por favor, ingrese un número entre 1 y 4.");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número.");
                            scanner.nextLine();
                        }
                    }while (!validInput2);
                    scanner.nextLine();
                    switch (opc2) {
                        case 1:
                           Estacionamiento2023_01.listarVehiculos();
                            break;
                        case 2:
                           Estacionamiento2023_02.listarVehiculos();
                            break;
                        case 3:
                            Estacionamiento2024_01.listarVehiculos();
                            break;
                        case 4:
                            Estacionamiento2024_02.listarVehiculos();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("==================================================================================================================================");
                    System.out.println("============================================== LISTA DE TODAS LAS TEMPORADAS =====================================================");
                    System.out.println("==================================================================================================================================");
                    System.out.println("                                                                                                                                  ");
                    System.out.println("==================================================================================================================================");
                    System.out.println("================================================ Estacionamiento 2023 - 01 =======================================================");
                    System.out.println("==================================================================================================================================");
                    Estacionamiento2023_01.listarVehiculos();
                    System.out.println("                                                                                                                                  ");
                    System.out.println("==================================================================================================================================");
                    System.out.println("================================================ Estacionamiento 2023 - 02 =======================================================");
                    System.out.println("==================================================================================================================================");
                    Estacionamiento2023_02.listarVehiculos();
                    System.out.println("                                                                                                                                  ");
                    System.out.println("==================================================================================================================================");
                    System.out.println("================================================ Estacionamiento 2024 - 01 =======================================================");
                    System.out.println("==================================================================================================================================");
                    Estacionamiento2024_01.listarVehiculos();
                    System.out.println("                                                                                                                                  ");
                    System.out.println("==================================================================================================================================");
                    System.out.println("================================================ Estacionamiento 2024 - 02 =======================================================");
                    System.out.println("==================================================================================================================================");
                    Estacionamiento2024_02.listarVehiculos();
                    System.out.println("                                                                                                                                  ");
                    break;
                case 4:
                    System.out.println("==================== ELIMINAR VEHICULO ====================");
                    System.out.println("Seleccione la Temporada que desea ingresar:");
                    System.out.println("1. Estacionamiento 2023 - 01");
                    System.out.println("2. Estacionamiento 2023 - 02");
                    System.out.println("3. Estacionamiento 2024 - 01");
                    System.out.println("4. Estacionamiento 2024 - 02");
                    do {
                        System.out.print("Seleccione una opción: ");
                        try {
                            opc2 = scanner.nextInt();
                            if (opc2 >= 1 && opc2 <= 4) {
                                validInput2 = true;
                            } else {
                                System.out.println("Por favor, ingrese un número entre 1 y 4.");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número.");
                            scanner.nextLine();
                        }
                    }while (!validInput2);
                    scanner.nextLine();
                    String mat;
                    switch (opc2) {
                        case 1:
                            System.out.print("Ingrese matrícula del vehículo a retirar: ");
                            mat = scanner.nextLine();
                            Estacionamiento2023_01.retirarVehiculo(mat);
                            System.out.println("Vehículo eliminado correctamente.");
                            break;
                        case 2:
                            System.out.print("Ingrese matrícula del vehículo a retirar: ");
                            mat = scanner.nextLine();
                            Estacionamiento2023_02.retirarVehiculo(mat);
                            System.out.println("Vehículo eliminado correctamente.");
                            break;
                        case 3:
                            System.out.print("Ingrese matrícula del vehículo a retirar: ");
                            mat = scanner.nextLine();
                            Estacionamiento2024_01.retirarVehiculo(mat);
                            System.out.println("Vehículo eliminado correctamente.");
                            break;
                        case 4:
                            System.out.print("Ingrese matrícula del vehículo a retirar: ");
                            mat = scanner.nextLine();
                            Estacionamiento2024_02.retirarVehiculo(mat);
                            System.out.println("Vehículo eliminado correctamente.");
                            break;
                    }
                    guardarEstacionamiento("Estacionamiento2023_01.ser", Estacionamiento2023_01);
                    guardarEstacionamiento("Estacionamiento2023_02.ser", Estacionamiento2023_02);
                    guardarEstacionamiento("Estacionamiento2024_01.ser", Estacionamiento2024_01);
                    guardarEstacionamiento("Estacionamiento2024_02.ser", Estacionamiento2024_02);
                    break;
                case 5:
                    System.out.println("=============== MODIFICAR HORAS VEHICULO ===============");
                    System.out.println("Seleccione la Temporada que desea ingresar:");
                    System.out.println("1. Estacionamiento 2023 - 01");
                    System.out.println("2. Estacionamiento 2023 - 02");
                    System.out.println("3. Estacionamiento 2024 - 01");
                    System.out.println("4. Estacionamiento 2024 - 02");
                    do {
                        System.out.print("Seleccione una opción: ");
                        try {
                            opc2 = scanner.nextInt();
                            if (opc2 >= 1 && opc2 <= 4) {
                                validInput2 = true;
                            } else {
                                System.out.println("Por favor, ingrese un número entre 1 y 4.");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número.");
                            scanner.nextLine();
                        }
                        scanner.nextLine();
                    }while (!validInput2);
                    int nhoras = 0;
                    switch (opc2) {
                        case 1:
                            System.out.print("Ingrese matrícula del vehículo a modificar: ");
                            mat = scanner.nextLine();
                            boolean validInput10 = false;
                            do {
                                System.out.print("Ingrese hora del vehículo a modificar: ");
                                if (scanner.hasNextInt()) {
                                    nhoras= scanner.nextInt();
                                    scanner.nextLine(); // Limpia el buffer
                                    validInput10 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                    scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                }
                            }while (!validInput10);
                            Estacionamiento2023_01.Modificar(mat,nhoras);
                            System.out.println("Vehículo modificado/no modificado correctamente.");
                            break;
                        case 2:
                            System.out.print("Ingrese matrícula del vehículo a modificar: ");
                            mat = scanner.nextLine();
                            boolean validInput11 = false;
                            do {
                                System.out.print("Ingrese hora del vehículo a modificar: ");
                                if (scanner.hasNextInt()) {
                                    nhoras= scanner.nextInt();
                                    scanner.nextLine(); // Limpia el buffer
                                    validInput11 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                    scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                }
                            }while (!validInput11);
                            Estacionamiento2023_02.Modificar(mat,nhoras);
                            System.out.println("Vehículo modificado/no modificado correctamente.");
                            break;
                        case 3:
                            System.out.print("Ingrese matrícula del vehículo a modificar: ");
                            mat = scanner.nextLine();
                            boolean validInput12 = false;
                            do {
                                System.out.print("Ingrese hora del vehículo a modificar: ");
                                if (scanner.hasNextInt()) {
                                    nhoras= scanner.nextInt();
                                    scanner.nextLine(); // Limpia el buffer
                                    validInput12 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                    scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                }
                            }while (!validInput12);
                            Estacionamiento2024_01.Modificar(mat,nhoras);
                            System.out.println("Vehículo modificado/no modificado correctamente.");
                            break;
                        case 4:
                            System.out.print("Ingrese matrícula del vehículo a modificar: ");
                            mat = scanner.nextLine();
                            boolean validInput13 = false;
                            do {
                                System.out.print("Ingrese hora del vehículo a modificar: ");
                                if (scanner.hasNextInt()) {
                                    nhoras= scanner.nextInt();
                                    scanner.nextLine(); // Limpia el buffer
                                    validInput13 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                                    scanner.nextLine(); // Limpia el buffer para evitar bucle infinito
                                }
                            }while (!validInput13);
                            Estacionamiento2024_02.Modificar(mat,nhoras);
                            System.out.println("Vehículo modificado/no modificado correctamente.");
                            break;
                    }
                    guardarEstacionamiento("Estacionamiento2023_01.ser", Estacionamiento2023_01);
                    guardarEstacionamiento("Estacionamiento2023_02.ser", Estacionamiento2023_02);
                    guardarEstacionamiento("Estacionamiento2024_01.ser", Estacionamiento2024_01);
                    guardarEstacionamiento("Estacionamiento2024_02.ser", Estacionamiento2024_02);
                    break;
                case 6:
                    System.out.println("=====================================================");
                    System.out.println("====================== REPORTES =====================");
                    System.out.println("=====================================================");
                    System.out.println("Seleccione el reporte que desea obtener:");
                    System.out.println("1. Reporte del total de vehiculos de todos los semestres juntos");
                    System.out.println("2. Mayor cantidad de tipo de vehiculo");
                    System.out.println("3. Reporte  ingresos por semestre");
                    do {
                        System.out.print("Seleccione una opción: ");
                        try {
                            opc2 = scanner.nextInt();
                            if (opc2 >= 1 && opc2 <= 4) {
                                validInput2 = true;
                            } else {
                                System.out.println("Por favor, ingrese un número entre 1 y 4.");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número.");
                            scanner.nextLine();
                        }
                    }while (!validInput2);
                    scanner.nextLine();
                    String semestre;
                    boolean validInput6 = false;
                    switch (opc2) {
                        case 1:
                            System.out.println("=========================================================================");
                            System.out.println("============== TOTAL VEHICULOS EN TODOS LOS SEMESTRES ===================");
                            System.out.println("=========================================================================");
                            int Totalmotos = Estacionamiento2023_01.generarReportetipoMoto() +
                                    Estacionamiento2023_02.generarReportetipoMoto()+
                                    Estacionamiento2024_01.generarReportetipoMoto()+
                                    Estacionamiento2024_02.generarReportetipoMoto();
                            int Totalauto = Estacionamiento2023_01.generarReportetipoAuto() +
                                    Estacionamiento2023_02.generarReportetipoAuto()+
                                    Estacionamiento2024_01.generarReportetipoAuto()+
                                    Estacionamiento2024_02.generarReportetipoAuto();
                            int Totalcamiones = Estacionamiento2023_01.generarReportetipoCamion()+
                                    Estacionamiento2023_02.generarReportetipoCamion()+
                                    Estacionamiento2024_01.generarReportetipoCamion()+
                                    Estacionamiento2024_02.generarReportetipoCamion();
                            int Totalbicicletas = Estacionamiento2023_01.generarReportetipoBicicleta()+
                                    Estacionamiento2023_02.generarReportetipoBicicleta()+
                                    Estacionamiento2024_01.generarReportetipoBicicleta()+
                                    Estacionamiento2024_02.generarReportetipoBicicleta();
                            int Totalvehiculos = Totalmotos + Totalauto+ Totalcamiones + Totalbicicletas;
                            System.out.println("EL TOTAL DE MOTOS DE TODOS LOS SEMESTRES ES: " + Totalmotos);
                            System.out.println("EL TOTAL DE AUTOS DE TODOS LOS SEMESTRES ES: " + Totalauto);
                            System.out.println("EL TOTAL DE CAMIONES DE TODOS LOS SEMESTRES ES: " + Totalcamiones);
                            System.out.println("EL TOTAL DE BICICLETAS DE TODOS LOS SEMESTRES ES: " + Totalbicicletas);
                            System.out.println("EL TOTAL DE VEHICULOS DE TODOS LOS SEMESTRES ES: " + Totalvehiculos);
                            System.out.println();
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("=====================================================================================");
                            System.out.println("====================== MAYOR CANTIDAD DE VEHICULOS POR SEMESTRE =====================");
                            System.out.println("=====================================================================================");
                            do {
                                System.out.print("Ingrese el semestre (2023/1, 2023/2, 2024/1, 2024/2): ");
                                semestre = scanner.nextLine(); // Lee la entrada del usuario
                                if (semestre.matches("2023/1|2023/2|2024/1|2024/2")) { // Verifica si coincide con los formatos válidos
                                    validInput6 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un semestre válido (ejemplo: 2023/1).");
                                }
                            } while (!validInput6);
                            float cmoto = 0;
                            float cauto = 0;
                            float ccamion = 0;
                            float cbicileta = 0;
                            switch (semestre){
                                case "2023/1":
                                    cmoto = Estacionamiento2023_01.generarReportetipoMoto();
                                    cauto = Estacionamiento2023_01.generarReportetipoAuto();
                                    ccamion = Estacionamiento2023_01.generarReportetipoCamion();
                                    cbicileta = Estacionamiento2023_01.generarReportetipoBicicleta();
                                    if (cmoto > cauto && cmoto > ccamion && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON MÁS MOTOS AL ESTABLECIMIENTO");
                                    } else if (cauto > cmoto && cauto > ccamion && cauto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON MÁS AUTOS AL ESTABLECIMIENTO");
                                    } else if (ccamion > cmoto && ccamion > cauto && ccamion > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON MÁS CAMIONES AL ESTABLECIMIENTO");
                                    } else if (cbicileta > cmoto && cbicileta > cauto && cbicileta > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON MÁS BICICLETAS AL ESTABLECIMIENTO");
                                    } else if (cmoto == cauto && cauto == cbicileta && cbicileta == ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE TODOS LOS TIPOS DE VEHÍCULOS AL ESTABLECIMIENTO");
                                    } else if (cmoto == cauto && cmoto > cbicileta && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y AUTOS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == ccamion && cmoto > cauto && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cbicileta && cmoto > cauto && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == ccamion && cauto > cmoto && cauto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE AUTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == cbicileta && cauto > cmoto && cauto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE AUTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (ccamion == cbicileta && ccamion > cmoto && ccamion > cauto) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cauto && cauto == ccamion && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS, AUTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cauto && cauto == cbicileta && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS, AUTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == ccamion && ccamion == cbicileta && cmoto > cauto) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS, CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == ccamion && ccamion == cbicileta && cauto > cmoto) {
                                        System.out.println("EN EL SEMESTRE 2023/1 ASISTIERON LA MISMA CANTIDAD DE AUTOS, CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    }
                                    break;
                                case "2023/2":
                                    cmoto = Estacionamiento2023_02.generarReportetipoMoto();
                                    cauto = Estacionamiento2023_02.generarReportetipoAuto();
                                    ccamion = Estacionamiento2023_02.generarReportetipoCamion();
                                    cbicileta = Estacionamiento2023_02.generarReportetipoBicicleta();
                                    if (cmoto > cauto && cmoto > ccamion && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON MÁS MOTOS AL ESTABLECIMIENTO");
                                    } else if (cauto > cmoto && cauto > ccamion && cauto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON MÁS AUTOS AL ESTABLECIMIENTO");
                                    } else if (ccamion > cmoto && ccamion > cauto && ccamion > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON MÁS CAMIONES AL ESTABLECIMIENTO");
                                    } else if (cbicileta > cmoto && cbicileta > cauto && cbicileta > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON MÁS BICICLETAS AL ESTABLECIMIENTO");
                                    } else if (cmoto == cauto && cauto == cbicileta && cbicileta == ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE TODOS LOS TIPOS DE VEHÍCULOS AL ESTABLECIMIENTO");
                                    } else if (cmoto == cauto && cmoto > cbicileta && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y AUTOS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == ccamion && cmoto > cauto && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cbicileta && cmoto > cauto && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == ccamion && cauto > cmoto && cauto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE AUTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == cbicileta && cauto > cmoto && cauto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE AUTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (ccamion == cbicileta && ccamion > cmoto && ccamion > cauto) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cauto && cauto == ccamion && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS, AUTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cauto && cauto == cbicileta && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS, AUTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == ccamion && ccamion == cbicileta && cmoto > cauto) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS, CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == ccamion && ccamion == cbicileta && cauto > cmoto) {
                                        System.out.println("EN EL SEMESTRE 2023/2 ASISTIERON LA MISMA CANTIDAD DE AUTOS, CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    }
                                    break;
                                case "2024/1":
                                    cmoto = Estacionamiento2024_01.generarReportetipoMoto();
                                    cauto = Estacionamiento2024_01.generarReportetipoAuto();
                                    ccamion = Estacionamiento2024_01.generarReportetipoCamion();
                                    cbicileta = Estacionamiento2024_01.generarReportetipoBicicleta();
                                    if (cmoto > cauto && cmoto > ccamion && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON MÁS MOTOS AL ESTABLECIMIENTO");
                                    } else if (cauto > cmoto && cauto > ccamion && cauto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON MÁS AUTOS AL ESTABLECIMIENTO");
                                    } else if (ccamion > cmoto && ccamion > cauto && ccamion > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON MÁS CAMIONES AL ESTABLECIMIENTO");
                                    } else if (cbicileta > cmoto && cbicileta > cauto && cbicileta > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON MÁS BICICLETAS AL ESTABLECIMIENTO");
                                    } else if (cmoto == cauto && cauto == cbicileta && cbicileta == ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE TODOS LOS TIPOS DE VEHÍCULOS AL ESTABLECIMIENTO");
                                    } else if (cmoto == cauto && cmoto > cbicileta && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y AUTOS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == ccamion && cmoto > cauto && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cbicileta && cmoto > cauto && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == ccamion && cauto > cmoto && cauto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE AUTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == cbicileta && cauto > cmoto && cauto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE AUTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (ccamion == cbicileta && ccamion > cmoto && ccamion > cauto) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cauto && cauto == ccamion && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS, AUTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cauto && cauto == cbicileta && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS, AUTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == ccamion && ccamion == cbicileta && cmoto > cauto) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE MOTOS, CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == ccamion && ccamion == cbicileta && cauto > cmoto) {
                                        System.out.println("EN EL SEMESTRE 2024/1 ASISTIERON LA MISMA CANTIDAD DE AUTOS, CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    }
                                    break;
                                case "2024/2":
                                    cmoto = Estacionamiento2024_02.generarReportetipoMoto();
                                    cauto = Estacionamiento2024_02.generarReportetipoAuto();
                                    ccamion = Estacionamiento2024_02.generarReportetipoCamion();
                                    cbicileta = Estacionamiento2024_02.generarReportetipoBicicleta();
                                    if (cmoto > cauto && cmoto > ccamion && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON MÁS MOTOS AL ESTABLECIMIENTO");
                                    } else if (cauto > cmoto && cauto > ccamion && cauto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON MÁS AUTOS AL ESTABLECIMIENTO");
                                    } else if (ccamion > cmoto && ccamion > cauto && ccamion > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON MÁS CAMIONES AL ESTABLECIMIENTO");
                                    } else if (cbicileta > cmoto && cbicileta > cauto && cbicileta > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON MÁS BICICLETAS AL ESTABLECIMIENTO");
                                    } else if (cmoto == cauto && cauto == cbicileta && cbicileta == ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE TODOS LOS TIPOS DE VEHÍCULOS AL ESTABLECIMIENTO");
                                    } else if (cmoto == cauto && cmoto > cbicileta && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y AUTOS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == ccamion && cmoto > cauto && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cbicileta && cmoto > cauto && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == ccamion && cauto > cmoto && cauto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE AUTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == cbicileta && cauto > cmoto && cauto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE AUTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (ccamion == cbicileta && ccamion > cmoto && ccamion > cauto) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cauto && cauto == ccamion && cmoto > cbicileta) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS, AUTOS Y CAMIONES, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == cauto && cauto == cbicileta && cmoto > ccamion) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS, AUTOS Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cmoto == ccamion && ccamion == cbicileta && cmoto > cauto) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE MOTOS, CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    } else if (cauto == ccamion && ccamion == cbicileta && cauto > cmoto) {
                                        System.out.println("EN EL SEMESTRE 2024/2 ASISTIERON LA MISMA CANTIDAD DE AUTOS, CAMIONES Y BICICLETAS, SIENDO LOS MÁS FRECUENTES");
                                    }
                                    break;
                            }
                            break;

                        case 3:
                            System.out.println("=========================================================================");
                            System.out.println("====================== INGRESOS TOTALES POR SEMESTRE =====================");
                            System.out.println("=========================================================================");
                            do {
                                System.out.print("Ingrese el semestre (2023/1, 2023/2, 2024/1, 2024/2): ");
                                semestre = scanner.nextLine(); // Lee la entrada del usuario
                                if (semestre.matches("2023/1|2023/2|2024/1|2024/2")) { // Verifica si coincide con los formatos válidos
                                    validInput6 = true; // Entrada válida, se sale del bucle
                                } else {
                                    System.out.println("Entrada inválida. Por favor, ingrese un semestre válido (ejemplo: 2023/1).");
                                }
                            } while (!validInput6);
                            switch (semestre){
                                case "2023/1":
                                    Estacionamiento2023_01.getIngresosMotos();
                                    Estacionamiento2023_01.getIngresosAutos();
                                    Estacionamiento2023_01.getIngresosCamion();
                                    Estacionamiento2023_01.getIngresosBicicleta();
                                    Estacionamiento2023_01.getTotalIngresosSemestre();
                                    break;
                                case "2023/2":
                                    Estacionamiento2023_02.getIngresosMotos();
                                    Estacionamiento2023_02.getIngresosAutos();
                                    Estacionamiento2023_02.getIngresosCamion();
                                    Estacionamiento2023_02.getIngresosBicicleta();
                                    Estacionamiento2023_02.getTotalIngresosSemestre();
                                    break;
                                case "2024/1":
                                    Estacionamiento2024_01.getIngresosMotos();
                                    Estacionamiento2024_01.getIngresosAutos();
                                    Estacionamiento2024_01.getIngresosCamion();
                                    Estacionamiento2024_01.getIngresosBicicleta();
                                    Estacionamiento2024_01.getTotalIngresosSemestre();
                                    break;
                                case "2024/2":
                                    Estacionamiento2024_02.getIngresosMotos();
                                    Estacionamiento2024_02.getIngresosAutos();
                                    Estacionamiento2024_02.getIngresosCamion();
                                    Estacionamiento2024_02.getIngresosBicicleta();
                                    Estacionamiento2024_02.getTotalIngresosSemestre();
                                    break;
                            }
                            break;

                    }
                    break;
                case 7:
                    System.out.println("=====================================================");
                    System.out.println("====================== OTROS ========================");
                    System.out.println("=====================================================");
                    obj.AccionesOtros();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    Main.main(null);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }
    // Método para guardar el estado del estacionamiento en un archivo
    public static void guardarEstacionamiento(String archivo, Cls_Estacionamiento<Cls_Terrestre> estacionamiento) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(estacionamiento);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    // Método para cargar el estado del estacionamiento desde un archivo
    @SuppressWarnings("unchecked")
    public static Cls_Estacionamiento<Cls_Terrestre> cargarEstacionamiento(String archivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Cls_Estacionamiento<Cls_Terrestre>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar el archivo, se inicializa un nuevo estacionamiento.");
            return new Cls_Estacionamiento<>();
        }
    }
}