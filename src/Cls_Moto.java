public class Cls_Moto extends Cls_Terrestre{
    private String esDeportiva;

    public Cls_Moto(String TipoVehiculo, String matricula, String modelo, String marca, int horas,
                    String esDeportiva, float Precio, float Tarifa) {
        super(TipoVehiculo,matricula, modelo, marca, horas, Precio, Tarifa);
        this.esDeportiva = esDeportiva;
    }


    @Override
    public void Estacionar() {
        System.out.println("La moto con matrícula:  " + getMatricula() + " ha sido estacionada.");
    }
    @Override
    public String toString(){
        return getTipoVehiculo() + " -> Matricula : " + getMatricula() + "    Modelo: " + getModelo() +
                "    Marca:  " + getMarca() + "   Detalle: " + esDeportiva+ "    Horas: " + getHoras() +
                "   Precio: " +getPrecio()+ "     Tarifa: " + getTarifa();
    }
}
