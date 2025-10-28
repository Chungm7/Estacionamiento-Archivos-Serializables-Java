import java.io.*;
import java.util.Scanner;
public class Cls_Administrador {
    public static final int max = 15;
    private int m_cantidad;
    private char [] v_rol = {
            'A',
            'P',
            'P',
            'P',
            '*',
            '*',
            '*',
            '*',
            '*',
            '*',
            '*',
            '*',
            '*',
            '*',
            '*'};
    private String [] v_nombres = {
            "Italo Fabian Vásquez Valderrama ",
            "Víctor Elías Chung Coelho",
            "Gabriela Isabel Espinoza Fernandez",
            "Luis Fabian Tongo Rogriguez",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""};
    private String [] v_codigo = {
            "U23234993",
            "U23245438",
            "U23235037",
            "U23242778",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""};
    private String [] v_contraseña = {"111111111","222222222", "333333333", "444444444","","","","","","","","","","",""};
    public double [] v_sueldo = {3200, 2600, 1900, 2800, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int getCantidad(){
        return this.m_cantidad;
    }
    private int ObtenerIndex(String CodigoPersonal){

        for(int i=0; i< this.getCantidad() ;i++){
            if( CodigoPersonal.equals(this.v_codigo[i])){
                return i;
            }
        }
        return -1;
    }

    public  Cls_Administrador(){
        //Definir la cantidad de trabajadores predeterminados
        m_cantidad=4;

        //Limpiar un vector
        this.LimpiarVectorGran(this.v_nombres);
        this.LimpiarVector(this.v_codigo);
        this.LimpiarVector(this.v_contraseña);
    }
    //=============================================================================================================================
    //================================================== LIMPIAR LOS VECTORES =====================================================
    //=============================================================================================================================

    private void LimpiarVector(String[] vector2){
        //Limpiar vectores de tipo String - codigo - contraseña
        for(int i=0; i< vector2.length;i++) {
            if (vector2[i].equals("")) {
                vector2[i] = "*********";
            }
        }
    }
    private void LimpiarVectorGran(String[] vector){
        //Limpiar vectores de tipo String - nombre
        for (int i=0; i < vector.length; i++ ){
            if (vector[i].equals("")){
                vector[i]="***********************";
            }
        }
    }

    public boolean VerificarCuentaTrabajador(String CodigoTrabajador, String ContraseñaTrabajador){
        for(int i=0; i< this.v_nombres.length;i++){
            if (CodigoTrabajador.equals(this.v_codigo[i]) && ContraseñaTrabajador.equals(this.v_contraseña[i])){
                return true;
            }
        }
        return false;
    }


    public void AccionesOtros(){
        String Mod_Personal ="";
        int opc_ad =0, opc_EP =0, opc_EA = 0, opc_EA_reg =0 ,opc_EA_mod =0;
        Scanner Lector = new Scanner(System.in);
        do {
            System.out.println("=============== MENU ================");
            System.out.println("  [1] VISUALIZAR ESTADO PERSONAL");
            System.out.println("  [2] SALIR");
            System.out.println("=====================================");
            boolean validInput5 = false;
            do {
                System.out.print("Ingresar Opción [1-2]: ");
                try {
                    opc_ad = Lector.nextInt();
                    if (opc_ad >= 1 && opc_ad <= 2) {
                        validInput5 = true;
                    } else {
                        System.out.println("Por favor, ingrese un número entre 1 y 2.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    Lector.nextLine();
                }
            } while (!validInput5);
            switch (opc_ad){
                case 1:
                    // =========================== PERSONAL =============================
                    do{
                        System.out.println("=============== ESTADO PERSONAL ================");
                        System.out.println("        [1] LISTA DE TRABAJADORES");
                        System.out.println("        [2] REGISTRAR PERSONAL");
                        System.out.println("        [3] MODIFICAR PERSONAL");
                        System.out.println("        [4] SALIR");
                        System.out.println("================================================");

                        boolean validInput11 = false;

                        do {
                            System.out.print("Ingresar Opción [1-4]: ");
                            try {
                                opc_EP = Lector.nextInt();
                                if (opc_EP >= 1 && opc_EP <= 4) {
                                    validInput11 = true;
                                } else {
                                    System.out.println("Por favor, ingrese un número entre 1 y 4.");
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                                Lector.nextLine();
                            }
                        } while (!validInput11);

                        switch (opc_EP){
                            case 1:
                                System.out.println();
                                System.out.println();
                                System.out.println("==================== MOTRAR LISTA DE TRABAJADORES ====================");
                                System.out.println();
                                System.out.println();
                                mostrar();
                                System.out.println();
                                System.out.println();
                                break;
                            case 2:
                                System.out.println();
                                System.out.println();
                                System.out.println("========================= REGISTRAR PERSONAL =========================");
                                System.out.println();
                                Registrar();
                                System.out.println();
                                System.out.println();
                                break;
                            case 3:
                                System.out.println();
                                System.out.println();
                                System.out.println("========================= MODIFICAR PERSONAL =========================");
                                System.out.println();
                                if(getCantidad()>0) {

                                    boolean validInput12 =false;
                                    Lector.nextLine();
                                    do {
                                        try{
                                            System.out.println("Ingresar Código: ");
                                            Mod_Personal = Lector.nextLine();
                                            if (Mod_Personal.length() != 9) {
                                                throw new Exception("El código debe tener exactamente 9 caracteres.");
                                            }
                                            validInput12 = true;
                                        } catch (Exception e){
                                            System.out.println("Error: " + e.getMessage());
                                            System.out.println("Por favor, intente de nuevo.");
                                        }
                                    } while (!validInput12);

                                    modificar(Mod_Personal);
                                }else{
                                    System.out.println("MENSAJE: Listas vacias");
                                }
                                System.out.println();
                                break;
                        }
                    } while (opc_EP != 4);
                    break;

                case 2:
                    System.out.println("Saliendo ...");
                    //Main.main(null);
                    break;
            }
        }while(opc_ad != 2);
    }

    public void Registrar(){
        String Est_Codigo= "", Est_Nombre= "", Est_Contraseña = "";
        char Est_Rol = ' ';
        double Est_Sueldo = 0;
        Scanner Lector = new Scanner(System.in);

        if (m_cantidad < max) { // Verifica si hay espacio disponible en los vectores
            do {

                boolean validInput13 =false;
                //[1] Registrar Personal
                System.out.println("Registrar Personal");
                System.out.println("==================================");
                System.out.println("Ingresar los Siguientes Datos " + (m_cantidad + 1) + "/" + max);

                do {
                    try {
                        System.out.print("Nombre: ");
                        Est_Nombre = Lector.nextLine();

                        System.out.print("Código: ");
                        Est_Codigo = Lector.nextLine();
                        if (Est_Codigo.length() != 9) {
                            throw new Exception("El código debe tener exactamente 9 caracteres.");
                        }

                        System.out.print("Contraseña: ");
                        Est_Contraseña = Lector.nextLine();
                        if (Est_Contraseña.length() != 9) {
                            throw new Exception("La contraseña debe tener exactamente 9 caracteres.");
                        }

                        System.out.print("Rol (una letra): ");
                        String rolInput = Lector.nextLine();
                        if (rolInput.length() != 1 || !Character.isLetter(rolInput.charAt(0))) {
                            throw new Exception("El rol debe ser una sola letra.");
                        }
                        Est_Rol = rolInput.charAt(0);

                        System.out.print("Sueldo: ");
                        if (!Lector.hasNextDouble()) {
                            throw new Exception("El sueldo debe ser un número.");
                        }
                        Est_Sueldo = Lector.nextDouble();
                        Lector.nextLine(); // Limpiar el buffer

                        validInput13 = true;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        System.out.println("Por favor, intente de nuevo.");
                        Lector.nextLine();
                    }
                } while (!validInput13);

                // Guardar datos en los vectores
                this.v_nombres[m_cantidad] = Est_Nombre;
                this.v_codigo[m_cantidad] = Est_Codigo;
                this.v_contraseña[m_cantidad] = Est_Contraseña;
                this.v_rol[m_cantidad] = Est_Rol;
                this.v_sueldo[m_cantidad] = Est_Sueldo;

                System.out.println("MENSAJE: Registro Exitoso.");
                m_cantidad++;

                // Verificar si se desea seguir registrando más personal
                if (m_cantidad < max - 1) {
                    System.out.println("¿Desea registrar otro personal? (s -> presionar s / n -> presionar cualquier letra.): ");
                    String respuesta = Lector.nextLine();
                    //TRY CATCH
                    if (!respuesta.equalsIgnoreCase("s")) {
                        break;
                    }
                }
            } while (m_cantidad < max);
        } else {
            System.out.println("ERROR: Espacio para registrar lleno.");
        }
    }

    public void modificar(String CodigoPersonal){

        double Mod_Sueldo = 0;
        String Mod_Contraseña = "";
        int IndexPersonal;
        Scanner Lector = new Scanner(System.in);

        IndexPersonal = this.ObtenerIndex(CodigoPersonal);

        if(  IndexPersonal >= 0 ){

            System.out.println("Ingresar los Siguientes Datos a Modificar:");
            boolean validInput14 = false;
            do {
                try{
                    System.out.println("Contraseña: ");
                    Mod_Contraseña = Lector.nextLine();
                    if (Mod_Contraseña.length() != 9) {
                        throw new Exception("La contraseña debe tener exactamente 9 caracteres.");
                    }
                    System.out.println("Sueldo: ");
                    if (!Lector.hasNextDouble()) {
                        throw new Exception("El sueldo debe ser un número.");
                    }
                    Mod_Sueldo = Lector.nextDouble();
                    Lector.nextLine(); // Limpiar el buffer

                    validInput14 = true;
                }catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Por favor, intente de nuevo.");
                    Lector.nextLine();
                }
            }while (!validInput14);

            this.v_sueldo[IndexPersonal]= Mod_Sueldo;
            this.v_contraseña[IndexPersonal]= Mod_Contraseña;

            System.out.println("MENSAJE: Modificación Exitosa.");
        }else{
            System.out.println("Personal no encontrado");
        }
    }

    public void mostrar(){
        System.out.println("======================================================================");
        System.out.println("======================= LISTADO DE TRABAJADORES ======================");
        System.out.println("======================================================================");

        System.out.printf("\nP \tCODIGO\t\tNOMBRE\t\t\t\t\t\tROL  \tCONTRASEÑA\t\tSUELDO: \n");
        System.out.println("---------------------------------------------------------------------------------------");
        for(int i=0; i< this.v_nombres.length;i++){
            System.out.printf("%d\t%s\t%.23S \t%C\t\t%s \t\t%.2f" ,i,this.v_codigo[i],this.v_nombres[i],
                    this.v_rol[i],this.v_contraseña[i], this.v_sueldo[i]);
            System.out.printf("\n");
            System.out.println("---------------------------------------------------------------------------------------");
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("\n");
    }
}
