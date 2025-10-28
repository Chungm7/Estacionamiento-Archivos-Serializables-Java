public class Cls_Auto extends Cls_Terrestre{
    private int numPuertas;
    public Cls_Auto(String TipoVehiculo, String matricula, String modelo, String marca, int horas, int numPuertas,
                    float Precio, float Tarifa) {
        super(TipoVehiculo, matricula, modelo, marca, horas, Precio, Tarifa);
        this.numPuertas = numPuertas;
    }
    @Override
    public void Estacionar() {
        System.out.println("El auto con matrícula:  " + getMatricula() + " ha sido estacionada.");
    }
    @Override
    public String toString(){
        return getTipoVehiculo() + " -> Matricula : " + getMatricula() + "    Modelo: " + getModelo() +
                "    Marca:  " + getMarca() + "   Numero Puertas: " + numPuertas+ "    Horas: " + getHoras() +
                "   Precio: " +getPrecio()+ "     Tarifa: " + getTarifa();
    }
}
