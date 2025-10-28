import java.io.*;
import java.util.ArrayList;

public class Cls_Estacionamiento <T extends Cls_Terrestre> implements Serializable{
    private ArrayList<T> vehiculos;

    public Cls_Estacionamiento() {
        this.vehiculos = new ArrayList<>();
    }

    public Object registrarVehiculo(T vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo.getMatricula());
        return vehiculo;
    }

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        System.out.println("\nVehículos registrados:");
        int i = 1;
        for (T vehiculo : vehiculos) {
            System.out.println(i +"° " + vehiculo);
            i = i+1;
        }
    }


    public void retirarVehiculo(String matricula) {
        for (T vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                vehiculos.remove(vehiculo);
                System.out.println("Vehículo retirado: " + matricula);
                return;
            }
        }
        System.out.println("Vehículo no encontrado: " + matricula);
    }

    public void Modificar(String matricula, int horas) {
        for (T vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                vehiculo.sethoras(horas);
                System.out.println("Horas modificadas: " + matricula);
                float ntarifa = horas * vehiculo.getPrecio();
                vehiculo.setTarifa(ntarifa);
                return;
            }
        }
        System.out.println("Vehículo no encontrado: " + matricula);
    }
    public int generarReportetipoMoto(){
        int motos = 0;
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Moto) motos++;
        }
        return motos;
    }
    public int generarReportetipoAuto(){
        int auto = 0;
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Auto) auto++;
        }
        return auto;

    }
    public int generarReportetipoCamion(){
        int camion = 0;
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Camion) camion++;
        }
        return camion;

    }
    public int generarReportetipoBicicleta(){
        int bicicleta = 0;
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Bicicleta) bicicleta++;
        }
        return bicicleta;

    }
    public void getIngresosMotos(){
        float totalingresosMotos = 0;
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Moto){
                totalingresosMotos = totalingresosMotos+ Vehiculo.getTarifa();
            }
        }
        System.out.println("TOTAL DE INGRESOS POR MOTOS: " + totalingresosMotos + "/S");;
    }
    public void getIngresosAutos(){
        float totalingresosAutos = 0;
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Auto){
                totalingresosAutos =   totalingresosAutos+ Vehiculo.getTarifa();
            }
        }
        System.out.println("TOTAL DE INGRESOS POR AUTOS: "+totalingresosAutos+ "/S");
    }
    public void getIngresosCamion(){
        float totalingresosCamion = 0;
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Camion){
                totalingresosCamion = totalingresosCamion+ Vehiculo.getTarifa();
            }
        }
        System.out.println("TOTAL DE INGRESOS POR CAMIONES: "+totalingresosCamion+ "/S");
    }
    public void getIngresosBicicleta(){
        float totalingresosBicicleta = 0;
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Bicicleta){
                totalingresosBicicleta = totalingresosBicicleta+ Vehiculo.getTarifa();
            }
        }
        System.out.println("TOTAL DE INGRESOS POR BICICLETAS: "+totalingresosBicicleta + "/S");
    }
    public void getTotalIngresosSemestre(){
        float totalingresosBicicleta = 0;
        float totalingresosMotos = 0;
        float totalingresosAutos = 0;
        float totalingresosCamion = 0;

        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Bicicleta){
                totalingresosBicicleta = totalingresosBicicleta+ Vehiculo.getTarifa();
            }
        }
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Camion){
                totalingresosCamion = totalingresosCamion+ Vehiculo.getTarifa();
            }
        }
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Auto){
                totalingresosAutos =   totalingresosAutos+ Vehiculo.getTarifa();
            }
        }
        for(T Vehiculo : vehiculos){
            if( Vehiculo instanceof Cls_Moto){
                totalingresosMotos = totalingresosMotos+ Vehiculo.getTarifa();
            }
        }
        float totalIngresos = totalingresosCamion+totalingresosAutos+totalingresosBicicleta+totalingresosMotos;
        System.out.println("EL TOTAL DE INGRESOS DE ESTE SEMESTRE ES: " + totalIngresos + "/S");
        System.out.println();
        System.out.println();
    }

}


