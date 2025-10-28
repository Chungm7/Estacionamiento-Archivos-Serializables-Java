import java.io.Serializable;

public abstract class  Cls_Terrestre implements Serializable {
    private String TipoVehiculo;
    private String Matricula;
    private String Modelo;
    private String Marca;
    private int Horas;
    private float Precio;
    private float Tarifa;

    public Cls_Terrestre(String TipoVehiculo, String matricula, String modelo, String marca,int Horas, float Precio, float Tarifa) {
        this.TipoVehiculo = TipoVehiculo;
        this.Matricula = matricula;
        this.Modelo = modelo;
        this.Marca = marca;
        this.Horas = Horas;
        this.Precio = Precio;
        this.Tarifa = Tarifa;
    }
    public String getTipoVehiculo(){
        return TipoVehiculo;
    }
    public String getMatricula() {
        return Matricula;
    }

    public String getModelo() {
        return Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public int getHoras(){
        return Horas;
    }
    public void sethoras(int horas){
        this.Horas = horas;
    }

    public float getPrecio(){
        return Precio;
    }
    public float getTarifa(){
        return Tarifa;
    }
    public void setTarifa(float tarifa){
        this.Tarifa = tarifa;
    }

    @Override
    public String toString(){
        return TipoVehiculo + " -> Matricula : " + Matricula + "    Modelo: " + Modelo + "    Marca:  " + Marca
                + "    Horas: " + Horas + "     Tarifa: " + Tarifa;
    }
    public abstract void Estacionar();
}
