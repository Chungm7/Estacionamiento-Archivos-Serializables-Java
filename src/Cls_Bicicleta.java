public class Cls_Bicicleta extends Cls_Terrestre{
    private String esElectrica;

    public Cls_Bicicleta(String TipoVehiculo,String matricula, String modelo, String marca, int horas,
                         String esElectrica, float Precio, float Tarifa) {
        super(TipoVehiculo,matricula, modelo, marca, horas, Precio, Tarifa);
        this.esElectrica = esElectrica;
    }

    @Override
    public void Estacionar() {
        System.out.println("La bicicleta con matrícula:  " + getMatricula() + " ha sido estacionada.");
    }

    @Override
    public String toString(){
        return getTipoVehiculo() + " -> Matricula : " + getMatricula() + "    Modelo: " + getModelo() +
                "    Marca:  " + getMarca() + "   Detalle: " + esElectrica+ "    Horas: " + getHoras() +
                "   Precio: " +getPrecio()+ "     Tarifa: " + getTarifa();
    }
}
