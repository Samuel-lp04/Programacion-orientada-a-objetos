package material;

public class TablaSurf implements IReservable{


    private String marca;
    private String tipo;
    private int volumen;
    private double talla;
    private int construccion;
    public final int  POLIESTER=1;
    public final int  EPOXY=2;
    public final int  SOFTBOARD=3;
    public final int  HINCHABLE=4;
    public final int INDETERMINADA=5;
    private static int[] precios = {10,15,25,40,70,90};
    private double suplemento;

    
    public TablaSurf(String marca, String tipo, int volumen, double talla, int construccion, double suplemento) {
        this.marca = marca;
        this.tipo = tipo;
        this.setVolumen(volumen);
        this.talla = talla;
        this.setConstruccion(construccion);
        this.setSuplemento(suplemento);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        if(volumen>=10 && volumen<=100){
            this.volumen = volumen;
        }
        else if(volumen<10){
            this.volumen = 10;
        }
        else{
            this.volumen = 100;
        }
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public int getConstruccion() {
        return construccion;
    }

    public void setConstruccion(int construccion) {
        if(construccion>=1 && construccion<=5){
            this.construccion = construccion;
        }
        else{
            this.construccion = 5;
        }
    }
    
    public static int[] getPrecios() {
        return precios;
    }

    public static void setPrecios(int[] precios) {
        TablaSurf.precios = precios;
    }

    public double getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(double suplemento) {
        if(suplemento>=0 && suplemento<=1){
            this.suplemento = suplemento;
        }
        else if(suplemento<0){
            this.suplemento = 0;
        }
        else{
            this.suplemento = 1;
        }
    }
    @Override
    public String toString(){
        return getDenominacion() +" - " + getObservaciones();
    }
    @Override
    public String getDenominacion() {
        return marca +", " + tipo;
    }
    @Override
    public String getObservaciones() {
        String a;
        if(construccion == POLIESTER){
            a="Poliester";
        }
        else if(construccion == EPOXY){
            a="Epoxy";
        }
        else if(construccion == SOFTBOARD){
            a="Softboard";
        }
        else if(construccion == HINCHABLE){
            a="Hinchable";
        }
        else{
            a="Indeterminada";
        }
        return "volumen: "+ volumen + ", talla: " + talla + ", construccion: " +a ;
    }
    @Override
    public double getPrecio(int opcionTiempo) {
        double x;
        x=precios[opcionTiempo]*suplemento;
        x=x+precios[opcionTiempo];
        return x;
    }
    @Override
    public boolean equals(Object obj) {
        TablaSurf cmp = (TablaSurf)obj;
        if(cmp.getMarca().equals(marca) && cmp.getTipo().equals(tipo) && cmp.getVolumen() == volumen &&
         cmp.getTalla() == talla && cmp.getConstruccion() == construccion){
            return true;
        }
        else{
            return false;
        }
    }
}
