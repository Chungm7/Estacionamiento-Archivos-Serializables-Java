import java.util.Scanner;
public class Main{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        InterfacePrincipal Interaccion = new InterfacePrincipal();
        Cls_Administrador obj = new Cls_Administrador();

        String CodigoTrabajador = "", ContraseñaTrabajador ="";
        Scanner Lector = new Scanner(System.in);
        System.out.println();
        System.out.println("======================================================");
        System.out.println("==================== PLATAFORMA ======================");
        System.out.println("======================================================");
        System.out.println("Para acceder a la plataforma ingrese su:");

        boolean validInput4 = false;
        do {
            try {
                System.out.print("CODIGO: ");
                CodigoTrabajador = Lector.nextLine();
                if (CodigoTrabajador.length() != 9) {
                    throw new Exception("El código debe tener exactamente 9 caracteres.");
                }
                System.out.print("CONTRASEÑA: ");
                ContraseñaTrabajador = Lector.nextLine();
                if (ContraseñaTrabajador.length() != 9) {
                    throw new Exception("La contraseña debe tener exactamente 9 caracteres.");
                }
                validInput4 = true; // Si ambos son válidos, salimos del bucle

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, intente de nuevo.");
            }
        } while (!validInput4);

        if (obj.VerificarCuentaTrabajador(CodigoTrabajador, ContraseñaTrabajador) == true){
            System.out.println("Acceso permitido...");
            Interaccion.InteraccionesUsuarios();
        }else {
            System.out.println("ERROR. Datos Incorrectos. ");
        }
    }
}


