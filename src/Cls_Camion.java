import java.io.Serializable;

public class Cls_Camion extends Cls_Terrestre {
    private float capacidadCarga;

    public Cls_Camion(String TipoVehiculo, String matricula, String modelo, String marca, int horas,
                      float capacidadCarga, float Precio, float Tarifa) {
        super(TipoVehiculo, matricula, modelo, marca, horas, Precio, Tarifa);
        this.capacidadCarga = capacidadCarga;
    }




    @Override
    public void Estacionar() {
        System.out.println("El camión con matrícula:  " + getMatricula() + " ha sido estacionada.");
    }
    @Override
    public String toString(){
        return getTipoVehiculo() + " -> Matricula : " + getMatricula() + "    Modelo: " + getModelo() +
                "    Marca:  " + getMarca() + "   Capacidad Carga: " + capacidadCarga+ "    Horas: " + getHoras() +
                "   Precio: " +getPrecio()+ "     Tarifa: " + getTarifa();
    }
}
