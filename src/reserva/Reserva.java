package reserva;

import java.util.GregorianCalendar;

import cliente.ICliente;
import material.IReservable;

public class Reserva {
    private static int numReserva = 0;
    private int idReserva;
    private ICliente cliente;
    private IReservable[] materiales;
    private int numMateriales;
    private final int MAXPRODUCTOSXRESERVA = 10;
    private int opcionTiempo;
    public final int UNAHORA = 0;
    public final int MEDIODIA = 1;
    public final int UNDIA = 2;
    public final int DOSDIAS = 3;
    public final int CUATRODIAS = 4;
    public final int UNASEMANA = 5;
    private GregorianCalendar fechaReserva;
    private double total;
 
    public Reserva(ICliente cliente, int opcionTiempo, GregorianCalendar fechaReserva) {
        this.cliente = cliente;
        this.opcionTiempo = opcionTiempo;
        this.fechaReserva = fechaReserva;
        materiales = new IReservable[MAXPRODUCTOSXRESERVA];
        numReserva++;
        idReserva=numReserva;
        cliente.incrementaNumReservas();
    }

    public void addMaterial(IReservable material){
        if(numMateriales<MAXPRODUCTOSXRESERVA){
        materiales[numMateriales] = material;
            total=materiales[numMateriales].getPrecio(opcionTiempo)+total;
        numMateriales++;
        }
        else{
            System.out.println("Numero maximo de reservas alcanzado");
        }
    }  
   
    public double getTotal() {
        return total;
    }

    public String toString(){
        int i;
        String toString, tiempo;
        if(opcionTiempo==UNAHORA){
            tiempo ="una hora";
        }
        else if(opcionTiempo==MEDIODIA){
            tiempo ="medio dia";
        }
        else if(opcionTiempo==UNDIA){
            tiempo ="un dia";
        }
        else if(opcionTiempo==DOSDIAS){
            tiempo ="dos dias";
        }
        else if(opcionTiempo==CUATRODIAS){
            tiempo ="cuatro dias";
        }
        else{
            tiempo ="una semana";
        }
        
        toString = idReserva + " - Reserva numero "+ idReserva+", realizada por " + cliente.toString() + "\npor un tiempo de "+ tiempo+", para el dia "+fechaReserva.toString();
        for(i=0;i<=numMateriales;i++){
            toString += materiales[i].getDenominacion()+" - "+ materiales[i].getObservaciones()+"\n";
        }
        toString += "==> Total: "+total;
        return toString;
    }

}
