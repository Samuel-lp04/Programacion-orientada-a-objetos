package reserva;

public class CentralReservas {
    private final int MAXRESERVAS = 100;
    private int numReservas=0;
    private Reserva[] reservas;
   
    public CentralReservas() {
        reservas = new Reserva[MAXRESERVAS];
    }

    public void addReserva(Reserva reserva){
        if(numReservas<MAXRESERVAS){
            reservas[numReservas] = reserva;
            numReservas++;
            }
            else{
                System.out.println("Numero maximo de reservas alcanzado");
            }
    }

    public String toString(){
        int i;
        String toString;
        toString = reservas[0].toString();
        for(i=1;i<=numReservas;i++){
            toString += reservas[i].toString();
        }
        return toString;
    }
}
