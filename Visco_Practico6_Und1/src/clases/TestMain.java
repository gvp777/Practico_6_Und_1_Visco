/**
 *
 * @author Guillermo
 */
package clases;

import java.util.Set;
import java.util.TreeMap;

public class TestMain {


    public static void main(String[] args) {
        
        String parametroStringPasado;
        int contador = 0;
              

        Cliente clientePedro = new Cliente (15280077,"Pedro","Quiroga","Calle 577", "San Luis");
        Cliente clienteGuillermo = new Cliente (27381779,"Guillermo","Juarez","Calle 377", "Mendoza");
        Cliente clienteMartin = new Cliente (35281079,"Martin","Visco","Calle 177", "San Luis");
        Cliente clienteJuan = new Cliente (3232323,"Juan","Funes","Calle 7015", "Cordoba");
        Cliente clienteCoco = new Cliente (2323545,"Coco","Quiroga","Calle 5577", "San Luis");
        
        
        //---------Llamo a Agregar Cliente con sus respetivos telefonos---------
        
        /* ENUNCIADO: 
           Que permite registrar un nuevo cliente con su respectivo nro de 
           teléfono. Siendo el nro del teléfono la clave del mismo. 
        
           Retorna: boolean
        
        */
        
        Directorio directorio = new Directorio();
        
        directorio.agragarCliente("2664560565", clienteGuillermo);
        directorio.agragarCliente("2664356877", clienteCoco);
        directorio.agragarCliente("2664033577", clientePedro);                  //<---El cliente 'Pedro' tiene DOS telefonos
        directorio.agragarCliente("2665565656", clienteMartin);
        directorio.agragarCliente("1165658995", clienteJuan);
        directorio.agragarCliente("2665020565", clientePedro);
        
        System.out.println("\n------------------------------------------");
        System.out.println("\nAgregor todo los clientes");
        System.out.println("\n------------------------------------------");     
       
        
        
        
        //---------Llamo a Buscar Cliente ---- Pansando el telefono-------------
        
        /*  ENUNCIADO: 
            En base al nro de teléfono retorna el 
            Cliente asociado al mismo.
        
            Retorna: Cliente
        */
        
        parametroStringPasado = "2664356877"; //2664356877
        
        
        if (directorio.buscarCliente(parametroStringPasado) != null){
        
            System.out.println("Cliente encontrado con el telefono " + parametroStringPasado + ": " + directorio.buscarCliente(parametroStringPasado));
        
        }else{
            System.out.println("No lo encontro un cliente con telefono: " + parametroStringPasado);
        }
                
        
        
        //---------Llamo a Buscar Telefono --Pansando un apellido-----
        
        /*  ENUNCIADO:
            En base a un apellido nos devuelve una lista con los nros de 
            teléfono asociados a dicho apellido. 
            
            Retorna: ArrayList<String>
        */
        
        parametroStringPasado = "Quiroga"; //Quiroga
        contador = directorio.buscarTelefono(parametroStringPasado).size();
        
        System.out.println("\n------------------------------------------");
        System.out.println("\n" + contador + " telefonos encontrados con el apellido : " + parametroStringPasado);



        for(String ape:  directorio.buscarTelefono(parametroStringPasado)){

            System.out.println("\n     >>> " + ape);
        }

         System.out.println("\n-----------------------------------------");  
             
             
             
             
             
        //---------Llamo a Buscar Clientes ----Pansando una ciudad--------------
        
        /*  ENUNCIADO:
            En base a una ciudad nos devuelve una lista con los Clientes 
            asociados a dicha ciudad.
        
            Retrona: HashSet<Cliente>
        */
        
        
        parametroStringPasado = "San Luis"; //San Luis"
        contador = directorio.buscarClientes(parametroStringPasado).size();
        
        System.out.println("\n" + contador + " clientes asociados de la ciudad de: " + parametroStringPasado);

        contador=0;
        for(Cliente cli:  directorio.buscarClientes(parametroStringPasado)){

            System.out.println("\n\t - " + ++contador + "º -" + cli);
        }

         
                    
             
        
        
        //---------Llamo a Borrar un Cliente ---- Pansando el dni-------------
        
        /*  ENUNCIADO:
            Que en base a un dni elimina el cliente del directorio. 
                    
            Retorna: TreeMap<String, Cliente>    <---Con los Telefonos borrados
        */
        
        System.out.println("\n-----------------------------------------\n"); 
       
        TreeMap<String, Cliente> clienteConTelefonosBorrados;
        
        
        
        parametroStringPasado = 15280077 + ""; //15280077
                
        System.out.println("Borrar Cliente con D.N.I: " + parametroStringPasado);
        
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - -"); 
        
        contador=0;
        
        //---Llamo al metodo boorarCliente con el DNI y lo que me devuelve se lo asigno a un Mapa para imprimir lo que borro MIENTRAS QUE el Mapa que devuelva tenga algo
        while( (clienteConTelefonosBorrados = directorio.borrarCliente(Long.parseLong(parametroStringPasado))).size() != 0 ){

            Set <String> claves = clienteConTelefonosBorrados.keySet();
            
            
            for(String claveIt: claves){
                
                System.out.println("\nTelefono borrado: " 
                        + claveIt +  " Cliente: " 
                        + clienteConTelefonosBorrados.get(claveIt).getApellido() 
                        + ", " 
                        +  clienteConTelefonosBorrados.get(claveIt).getNombre());
                
                contador = 1;
            }
            
        }
        
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -  ");
        System.out.println("\nCliente/s borrado/s: " + contador);
        
        System.out.println("\n-----------------------------------------\n");
        
        System.out.println("Prueba para ver si Despues de Borrar a Pedro Quiroga, lo encuenta".toUpperCase());
        System.out.println("\n"); 
        
        //*** Ahora me fijo si borro los dos telefonos que tenia el cliente ademas de a él mismo ***
        
        //---Pregunto por el 2664033577---
        
        if (directorio.buscarCliente("2664033577") != null){
        
            System.out.println("Cliente Encontrado Con telefono : 2664033577" + directorio.buscarCliente("2664033577").toString());
        
        }else{
            System.out.println("No encontro el telefono: 2664033577");
        }
               
        
        //---Pregunto por el 2665020565---
        
        if (directorio.buscarCliente("2665020565") != null){
        
            System.out.println("Cliente Encontrado Con telefono : 2665020565" + directorio.buscarCliente("2665020565").toString());
        
        }else{
            System.out.println("No encontro el telefono: 2665020565");
        }
           
         
        System.out.println("\n-----------------------------------------\n"); 
                     
    }
    
}

