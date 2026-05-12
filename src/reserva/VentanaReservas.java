package reserva;

import cliente.CentralClientes;
import cliente.ICliente;
import material.CentralMateriales;
import material.IReservable;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VentanaReservas {
    private CentralReservas reservas;
    private CentralClientes clientes;
    private CentralMateriales materiales;
    
    public VentanaReservas(CentralClientes clientes, CentralMateriales materiales, CentralReservas reservas) {
        this.clientes = clientes;
        this.materiales = materiales;
        this.reservas = reservas;
    }

    public void mostrarMenuGestionReservas(){
        Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\n\n\n\tMenú Gestion Reservas:\n");
            System.out.println("\t1. Realizar Reserva");
            System.out.println("\t2. Listado de Reservas");
            System.out.println("\t3. Cancelar Reserva");
            System.out.println("\t4. Consolidar Reserva");
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
                realizarOpcionGestionReserva(opc);
            }
        } while (opc != 0);
    }

    private void realizarOpcionGestionReserva(int opc){
        switch(opc){
            case 1:
                this.mostrarRealizarReserva();
                break;
            case 2:
                this.mostrarListadoReservas();
                break;
            case 3:
                this.mostrarCancelarReserva();
                break;
            case 4:
                this.mostrarConsolidarReserva();
                break;
        }
    }

    private void mostrarRealizarReserva(){
        Scanner s = new Scanner(System.in);
        String dni, nombre, email, telefono;
        int opcionTiempo, dia, mes, año, numTrajes, numTablas, i, identificador;
        ICliente cliente;
        IReservable material;
        boolean validoFecha=false;
        
        System.out.println("Escriba su DNI: ");
        dni = s.nextLine();
        cliente = clientes.buscaCliente(dni);
        
        if(cliente == null){
            System.out.println("Nombre: ");
            nombre = s.nextLine();
            System.out.println("email: ");
            email = s.nextLine();
            System.out.println("Telefono: ");
            telefono = s.nextLine();
            clientes.nuevoCliente(nombre, dni, email, telefono);
            cliente = clientes.buscaCliente(dni);
        }
        
        System.out.println("Introduzca cuanto quiere que dure la reserva:");
        System.out.println("1 Una hora");
        System.out.println("2 Medio dia");
        System.out.println("3 Un dia");
        System.out.println("4 Dos dias");
        System.out.println("5 Cuatro dias");
        System.out.println("6 Una semana");
        opcionTiempo = s.nextInt();
        while (opcionTiempo < 1 || opcionTiempo > 6) {
            System.out.print("--> Introduzca una opción valida: ");
            opcionTiempo = s.nextInt();
            System.out.println("\n");
        }

        opcionTiempo--;

        System.out.println("Para que fecha lo quieres reservar: ");
        System.out.println("Dia: ");
        dia = s.nextInt();
        System.out.println("Mes: ");
        mes = s.nextInt();
        System.out.println("Año: ");
        año = s.nextInt();
        
        while(validoFecha==false){
            if(dia>=1 && dia<=31){
                if(mes>=1 && mes<=12){
                    if(mes==2){
                        if(año%4==0 && (año%100!=0 ||año%400==0)){
                            if(dia<=29){
                                validoFecha=true;
                            }
                            else{
                                validoFecha=false;
                            }
                        }
                        else{
                            if(dia<=28){
                                validoFecha = true;
                            }
                            else{
                                validoFecha=false;
                            }
                        }
                    }
                    else if(mes==4 || mes==6 || mes==9 || mes==11){
                        if(dia<=30){
                            validoFecha = true;
                        }
                        else{
                            validoFecha=false;
                        }
                    }
                    else{
                        validoFecha=true;
                    }
                }
            }
            if(validoFecha==false){
                System.out.println("Fecha incorrecta.");
                System.out.println("Para que fecha lo quieres reservar: ");
                System.out.println("Dia: ");
                dia = s.nextInt();
                System.out.println("Mes: ");
                mes = s.nextInt();
                System.out.println("Año: ");
                año = s.nextInt();
            }
        }
        GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);

        Reserva reserva = new Reserva(cliente, opcionTiempo, fecha);
        System.out.println("Cuantas tablas quiere reservar: ");
        numTablas = s.nextInt();
        System.out.println("Cuantos trajes quiere reservar: ");
        numTrajes = s.nextInt();
        
        while(!((numTablas + numTrajes)<=10 && numTablas>=0 && numTrajes>=0)){
            System.out.println("El numero de reservas no puede ser negativo ni la suma de ambas reservas puede superar las 10 reservas");
            System.out.println("Tablas: ");
            numTablas = s.nextInt();
            System.out.println("Trajes: ");
            numTrajes = s.nextInt();
        }
        
        materiales.tablasToString();
        
        System.out.println("Escriba el identificador de las tablas que quiera reservar: ");
        
        for(i=0;i<numTablas;i++){
            identificador = s.nextInt();
            material=materiales.getTabla(identificador);
            reserva.addMaterial(material);
            System.out.println("\n");
        }
        
        materiales.trajesToString();
        
        System.out.println("Escriba el identificador de los trajes que quiera reservar: ");
        
        for(i=0;i<numTrajes;i++){
            identificador = s.nextInt();
            material=materiales.getTraje(identificador);
            reserva.addMaterial(material);
            System.out.println("\n");
        }
        
        reservas.addReserva(reserva);

        System.out.println("Reserva realizada.");
    }

    private void mostrarListadoReservas(){
        reservas.toString();
    }

    private void mostrarCancelarReserva(){
        
    }

    private void mostrarConsolidarReserva(){
        
    }
}