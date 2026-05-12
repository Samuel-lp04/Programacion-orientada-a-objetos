package material;

public class CentralMateriales {
    public final int MAXMATERIALES = 50;
    private int numTablas = 0;
    private int numTrajes = 0;
    public TablaSurf[] tablas;
    public Neopreno[] trajes;

    public CentralMateriales(){
        tablas = new TablaSurf[MAXMATERIALES];
        trajes = new Neopreno[MAXMATERIALES];
    }

    public void nuevaTabla(String marca, String tipo, int volumen, 
    double talla, int construccion, double suplemento){
        if(numTablas<=50){
        this.tablas[numTablas++] = new TablaSurf(marca, tipo, volumen, talla, construccion, suplemento);
        }
        else{
            System.out.println("Numero maximo de tablas alcanzado");
        }
    }

    public TablaSurf getTabla(int l){
        return tablas[l];
    }

    public void eliminaTabla(TablaSurf t){
        int i=0;
        int j;
        while(!t.equals(tablas[i])){
            i++;
        }
        i++;
        for(j=i;j<=numTablas ; j++){
            tablas[j-1] = tablas[j];
        }
        numTablas--;
    }

    public void nuevoTraje(String marca, String categoria,int talla, boolean mangasLargas, 
    boolean piernasLargas, int cremallera, double suplemento){
        
        if(numTrajes<=50){
        this.trajes[numTrajes++]= new Neopreno(marca, categoria, cremallera, mangasLargas, piernasLargas, cremallera, suplemento);
        }
        else{
            System.out.println("Numero maximo de trajes alcanzado");
        }
    }
    public Neopreno getTraje(int l){
        return trajes[l];
    }

    public void eliminaTraje(Neopreno n){
        int i=0;
        int j;
        while(!n.equals(trajes[i])){
            i++;
        }
        i++;
        for(j=i;j<=numTrajes ; j++){
            trajes[j-1] = trajes[j];
        }
        numTrajes--;
    }

    public int getNumTrajes() {
        return numTrajes;
    }

    public void setNumTrajes(int numTrajes) {
        this.numTrajes = numTrajes;
    }
    
    public int getNumTablas() {
        return numTablas;
    }

    public void setNumTablas(int numTablas) {
        this.numTablas = numTablas;
    }    

    public String tablasToString(){
        int i;
        String toString;
        toString = "1. ";
        toString += tablas[0].toString()+"\n";
        
        for(i=1; i<numTablas; i++){
            toString += i+1 +". ";
            toString += tablas[i].toString()+"\n";
        }
        return toString;
    }

    public String trajesToString(){
        int i;
        String toString;
        toString = "1. ";
        toString += trajes[0].toString()+"\n";
        
        for(i=1; i<numTrajes; i++){
            toString += i+1 +". ";
            toString += trajes[i].toString() + "\n";
        }
        return toString;
    }
}
