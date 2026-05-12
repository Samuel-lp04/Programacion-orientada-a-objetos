package material;

public class Neopreno implements IReservable{
    
    private String marca;
    private String categoria;
    private int talla;
    private boolean mangasLargas;
    private boolean piernasLargas;
    private int cremallera;
    public final int DELANTERA = 1;
    public final int TRASERA = 2;
    public final int SIN = 3;
    private static int[] precios = {5,8,12,20,32,40};
    private double suplemento;

    public Neopreno(String marca, String categoria, int talla, boolean mangasLargas, boolean piernasLargas,
            int cremallera, double suplemento) {
        this.marca = marca;
        this.categoria = categoria;
        this.talla = talla;
        this.mangasLargas = mangasLargas;
        this.piernasLargas = piernasLargas;
        this.cremallera = cremallera;
        this.suplemento = suplemento;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public int getTalla() {
        return talla;
    }
    
    public void setTalla(int talla) {
        this.talla = talla;
    }
    
    public boolean isMangasLargas() {
        return mangasLargas;
    }
    
    public void setMangasLargas(boolean mangasLargas) {
        this.mangasLargas = mangasLargas;
    }
    
    public boolean isPiernasLargas() {
        return piernasLargas;
    }
    
    public void setPiernasLargas(boolean piernasLargas) {
        this.piernasLargas = piernasLargas;
    }
    
    public int getCremallera() {
        return cremallera;
    }
    
    public void setCremallera(int cremallera) {
        if(cremallera>=1 && cremallera<=3){
            this.cremallera = cremallera;
        }
        else{
            this.cremallera = 3;
        }
    }
    
    public static int[] getPrecios() {
        return precios;
    }
    
    public static void setPrecios(int[] precios) {
        Neopreno.precios = precios;
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
        return getDenominacion() + " - " + getObservaciones();
    }

    @Override
    public String getDenominacion() {
        return marca +", " + categoria;
    }

    @Override
    public String getObservaciones() {
        String a;
        if(mangasLargas == true){
            if(piernasLargas == true){
                if(cremallera == DELANTERA){
                    a="mangas largas, piernas largas, Con cremallera trasera";
                }
                else if(cremallera == TRASERA){
                    a="mangas largas, piernas largas, con cremallera delantera";
                }
                else{
                    a="mangas largas, piernas largas, Sin cremallera";
                }
            }
            else{
                if(cremallera == DELANTERA){
                    a="mangas largas, con cremallera delantera"; 
                }
                else if(cremallera == TRASERA){
                    a= "mangas largas, con cremallera trasera";
                }
                else{
                    a="mangas largas, sin cremallera"; 
                }
            }
        }
        else{
            if(cremallera == DELANTERA){
                a="piernas largas, con cremallera delantera";                   
            }
            else if(cremallera == TRASERA){
                a="piernas largas, con cremallera trasera";  
            }
            else{
                a="piernas largas, sin cremallera";
            } 
        }
        return "talla: " + talla +", "+a;
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
        Neopreno cmp = (Neopreno)obj;
        if(cmp.getMarca().equals(marca) && cmp.getCategoria().equals(categoria) && cmp.getTalla() == talla &&
         cmp.isMangasLargas() == mangasLargas && cmp.isPiernasLargas() == piernasLargas && cmp.getCremallera() == cremallera){
            return true;
        }
        else{
            return false;
        }
    }
}
