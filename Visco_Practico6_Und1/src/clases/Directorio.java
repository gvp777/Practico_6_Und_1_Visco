/**
 *
 * @author Guillermo
 *
 *
 * NOTA: Los System.out.println("..."); entiendo que son redundantes porque
 *       el practico pide hacerlo con vistas graficas
 *      (ademas de entender que la funcion del metodo es 'una' y devolver
 *       que sucedio en cada caso, etc. sin cargar de responsabilidades al mismo
 *       con motrar por consola) pero, en este caso, las dejo para ir testeando
 *       el funcionamiento de cada metodo acompañado de los datos pre-cargados
 *       en el metodo 'main' de la clase TestMain. Solo con ese fin
 */
package clases;

import java.util.*;


//---Clase Directorio-----------------------------------------------------------
public class Directorio {

    //---Declaracion de Variables-----------------------------------------------
    TreeMap<String, Cliente> unDirectorio = new TreeMap<>();                    //<--NOTA: La clave del TreeMap es de tipo String por lo que esta clase ya implementa la interfaz Comparable. 

    
    //****************************** METODOS ***********************************
    
    //---Metodo getLista
    public TreeMap<String, Cliente> getDeClaseDirectorio() {
        return unDirectorio;
    } 
    
    
    //---Metodo Agregar Cliente-------------------------------------------------
    public boolean agragarCliente(String telefono, Cliente cliente) {

        if (!unDirectorio.containsKey(telefono)) {                              //<---Entra si NO CONTIENE un telefono(clave) porque sino, pisa el anterior                                                                  

            unDirectorio.put(telefono, cliente);
            return true;

        } else {                                                                //<---Entra si el telefono ya estaba agendado, retorna un 'false' porque no lo agrego 

            return false;
        }

    }

    
    //---Metodo Buscar Cliente--------------------------------------------------   
    public Cliente buscarCliente(String telefono) {

        return unDirectorio.get(telefono);                                      //Si encuenta el telefono(la clave) en el directorio, devuelve el valor (el cliente) sino, retorna un null

    }

    
    //---Metodo Buscar Telefono-------------------------------------------------       
    public ArrayList<String> buscarTelefono(String apellidoParam) {
        
        //---Declaracion de Variables---
        ArrayList<String> listaApellidosEncontrados = new ArrayList<>();
        
        //---Traigo las claves y las almaceno en una coleccion Set---
        Set<String> claves = unDirectorio.keySet();             
        
        //---Recorro esa coleccion de claves--- 
        for (String claveIt : claves) {                            

            if (apellidoParam.equals(unDirectorio.get(claveIt).getApellido())){ //<---Entra si el apellidoParametro es igual al del traido del directorio mediante el metodo equals del la clase String
                
                listaApellidosEncontrados.add(claveIt);                         //<---Va almacenando las claves de los clientes en los cuales el apellido fue el mismo que el pasado por parametro                   
            }
        }
        
        return listaApellidosEncontrados;                                       //<---y al terminar de iterar, los retorna
    }    

    
    //---Metodo Buscar Clientes-------------------------------------------------       
    public HashSet<Cliente> buscarClientes(String ciudadParam) {

        //---Declaracion de Variables---       
        HashSet<Cliente> listaClienetsAsociados = new HashSet<>();              //<---Tuve que cambiar de una ArrayList<Cliente> a un HashSet<Cliente> porque cargaba en la coleccion que devolvia '2 veces' a Pedro QWuiroga ya que este cliente tiene 'Dos Telefonos' pero en realidad, es un solo cliente
        String claveActual;                                                     
           
        

        Set<String> claves = unDirectorio.keySet();
        Iterator<String> itClave = claves.iterator();

        while (itClave.hasNext()) {

            claveActual = itClave.next();                                       //<---Esta variable la creo porque necesito la clave quieta para usarla. Porque si voy poniendo itClave.next(), me va al siguiente elemento y esa fue la solucion que le encontre  (Es porque uso, en este caso, un iterador de la clase Iterator)

            if (ciudadParam.equals(unDirectorio.get(claveActual).getCiudad())){

                listaClienetsAsociados.add(unDirectorio.get(claveActual));

            }    
        }

        return listaClienetsAsociados;                                     
    }

    

    //---Metodo Borrar Cliente-------------------------------------------------    
    public TreeMap<String, Cliente> borrarCliente(long dniParam) {
        
        //---Declaracion de Variables--- 
        TreeMap<String, Cliente> clienteBorrado = new TreeMap<>();              //<---aca voy a almacenar el clientes con sus telefonos (si tubiera varios) que fueron borrados
        String claveIT;
        
        Set<String> claves = unDirectorio.keySet();                             //<---Almaceno las claves en una coleccion de tipo Set asi puedo reccorrer       
        Iterator<String> itClave = claves.iterator();

        while (itClave.hasNext()) {
           
            claveIT = itClave.next();

            Cliente cliente = unDirectorio.get(claveIT);                        //<---Traigo los clientes para hacerlo por separado

            if (dniParam == cliente.getDni()) {                                 //<---Si ese telefono (clave) pertenece a un cliente que tiene el mismo dniParam, entra

                clienteBorrado.put(claveIT, cliente);                           //<---guardo la/s clave/s (los telefono//) y cliente que tiene el dnidel parametro para despues rotrnar ese mapa
                unDirectorio.remove(claveIT);
                return clienteBorrado;
            }
            
            
        }

        return clienteBorrado;
    }

    //--------------------------------------------------------------------------

 
}
    
//------------------------------------------------------------------------------
