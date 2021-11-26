public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // Cuandos billetes se han vendidos 
    private int numeroBilletesVendidos;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //Al comprar una entrada te da un  
    private boolean darPremio;
    //numero de billetes que hay 
    private int cantidadBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean darElPremio, int cantidadDeBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        numeroBilletesVendidos = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        darPremio = darElPremio;
        cantidadBilletes = cantidadDeBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    public int getcantidadBilletes(int imprimirBilletes) {
        return cantidadBilletes;
    }
    
    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadBilletes >= numeroBilletesVendidos) {
            System.out.println ("Aun puedes segir comprando billetes");
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }   
        }
        else{
            System.out.println ("ERROR");
        }    
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete (int intcantidadDeDineroQueFalta) {
        if (cantidadBilletes >= numeroBilletesVendidos) {
            System.out.println ("Quedan " + (cantidadBilletes - numeroBilletesVendidos) + " por imprimir");
            int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
            if (cantidadDeDineroQueFalta <= 0) {
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                if (darPremio) { 
                    System.out.println("Tiene un descuento de"+ (precioBillete*0.1)+"€ en el supermercado");
                }
            
                else {
                    System.out.println("Lo sentimos pero no podemos darle el premio");
                }
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // Nos indica cuantos billetes se han vendido
                numeroBilletesVendidos = numeroBilletesVendidos + 1;
            }

            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                System.out.println("No tiene ningun premio");
                System.out.println("Lo sentimos pero nos hemos quedado sin billetes");
            } 
        } 
        else {
            System.out.println ("Ya no quedan billetes en la maquina");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
     /**
     * Esto nos permite vaciar el dinero que 
     * tenemos acumulaod en la maquina expendedora
     */
    public int vaciarDineroDeLaMaquina() {
        int aDevolver = 0;
        if (balanceClienteActual == 0) {
          System.out.println("Vacias la maquina"); 
          balanceClienteActual = 0;
          totalDineroAcumulado = 0;
        }
        
        else {
            System.out.println("ERROR"); 
            aDevolver = -1;
        }
        return aDevolver;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getNumeroBilletesVendidos() {
        return numeroBilletesVendidos;
    }
    
    /**
     * Imprimimos la cantidad de 
     * billetes que han sido vendidos 
     */
    public void imprimeNumeroBilletesVendidos () {
        if (numeroBilletesVendidos >= 0) {
            System.out.println("Se han vendido"+ (numeroBilletesVendidos) +"billetes");        
        }
        
        else{
            System.out.println("No se ha vendido ningun billete");
        }
    }
}
