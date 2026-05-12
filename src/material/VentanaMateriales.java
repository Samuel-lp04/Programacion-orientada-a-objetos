package material;

import java.util.Scanner;

public class VentanaMateriales {
    private CentralMateriales materiales;
    
    public VentanaMateriales(CentralMateriales materiales){
        this.materiales = materiales;
    }
    
    public void mostrarMenuGestionMateriales(){
        Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\n\n\n\tMenú Gestion Materiales:\n");
            System.out.println("\t1. Alta de tabla de surf");
            System.out.println("\t2. Baja de tabla de surf");
            System.out.println("\t3. Listado de tablas de surf");
            System.out.println("\t4. Alta de tabla de neopreno");
            System.out.println("\t5. Baja de tabla de neopreno");
            System.out.println("\t6. Listado de tablas de neopreno");
            System.out.println("\t---------------------");
            System.out.println("\t\t0. Salir");
            System.out.print("\n\n--> Introduzca una opción: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 3) {
                System.out.print("--> Introduzca una opción valida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionGestionMaterial(opc);
            }
        } while (opc != 0);
    }

    private void realizarOpcionGestionMaterial(int opc){
        switch(opc){
            case 1:
                this.mostrarAltaTablas();
                break;
            case 2:
                this.mostrarBajaTablas();
                break;
            case 3:
                this.mostrarListadoTablas();
                break;
            case 4:
                this.mostrarAltaTrajes();
                break;
            case 5:
                this.mostrarBajaTrajes();
                break;
            case 6:
                this.mostrarListadoTrajes();
                break;
        }
    }

    private void mostrarAltaTablas(){
        Scanner s = new Scanner(System.in);
        String marca, tipo;
        int volumen, construccion;
        double talla, suplemento;
        System.out.println("Marca: \n");
        marca = s.nextLine();
        System.out.println("Tipo: \n");
        tipo = s.nextLine();
        System.out.println("Volumen: \n");
        volumen = s.nextInt();
        System.out.println("Talla: \n");
        talla = s.nextDouble();
        System.out.println("Construcciones: \n");
        construccion = s.nextInt();
        System.out.println("Suplemento: \n");
        suplemento = s.nextDouble();

        materiales.nuevaTabla(marca, tipo, volumen,  talla, construccion, suplemento);
}

private void mostrarBajaTablas(){
    Scanner s = new Scanner(System.in);
    int identificador;
    String comprobante;
    TablaSurf bajaTabla;
    System.out.println(materiales.tablasToString());
    System.out.println("Escriba el identificador deseado");
    identificador = s.nextInt();
    s.nextLine();
    bajaTabla = materiales.getTabla(identificador);
    System.out.println(bajaTabla.toString());
    System.out.println("¿Estas seguro? Si/No");
    comprobante = s.nextLine();
    if(comprobante.equals("Si")){
        materiales.eliminaTabla(bajaTabla);
        System.out.println("Se ha dado de baja correctamente");
    }
    else{
        System.out.println("Operacion cancelada");
    }
}

private void mostrarListadoTablas(){
    System.out.println(materiales.tablasToString());
}
private void mostrarAltaTrajes(){
    Scanner s = new Scanner(System.in);
    String marca, categoria;
    int cremallera, talla;
    double suplemento;
    String mL, pL;
    boolean mangasLargas, piernasLargas;
    System.out.println("Marca: \n");
    marca = s.nextLine();
    System.out.println("categoria: \n");
    categoria = s.nextLine();
    System.out.println("¿Tiene mangas largas? \n");
    mL = s.nextLine();
    if(mL.equals("si")){
        mangasLargas = true;
    }
    else{
        mangasLargas = false;
    }
    System.out.println("¿Tiene piernas largas? \n");
    pL = s.nextLine();
    if(pL.equals("si")){
        piernasLargas = true;
    }
    else{
        piernasLargas = false;
    }
    System.out.println("Cremallera: \n");
    cremallera = s.nextInt();
    System.out.println("Talla: \n");
    talla = s.nextInt();
    System.out.println("Suplemento: \n");
    suplemento = s.nextDouble();

    materiales.nuevoTraje(marca, categoria, talla, mangasLargas, piernasLargas, cremallera, suplemento);
}

private void mostrarBajaTrajes(){
    Scanner s = new Scanner(System.in);
    int identificador;
    String comprobante;
    Neopreno bajaTrajes;
    System.out.println(materiales.trajesToString());
    System.out.println("Escriba el identificador deseado");
    identificador = s.nextInt();
    s.nextLine();
    bajaTrajes = materiales.getTraje(identificador);
    System.out.println(bajaTrajes.toString());
    System.out.println("¿Estas seguro?");
    comprobante = s.nextLine();
    if(comprobante.equals("si")){
        materiales.eliminaTraje(bajaTrajes);
        System.out.println("Se ha dado de baja correctamente");
    }
    else{
        System.out.println("Operacion cancelada");
    }
}

private void mostrarListadoTrajes(){
    System.out.println(materiales.trajesToString());
}
}