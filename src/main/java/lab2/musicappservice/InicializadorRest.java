/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import lab2.musicappservice.servicios.CancionServiceImpl;

/**
 * Clase que crea una Conjunto de objetos de tipo Cancion service, es decir un 
 * conjunto de singletons del servicio Cancion. (Necesaria para el funcionamiento de EASYRest)
 * Esta clase debe ser Registrada en el web.xml y mapeada a un servlet de la siguiente manera: <br><br>
 *    &lt servlet &gt <br>
       &lt servlet-name &gt RESTEasyService&lt/servlet-name &gt <br>
       &lt servlet-class &gt org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher&lt/servlet-class &gt <br>
       &lt init-param &gt <br>
           &lt param-name &gt javax.ws.rs.Application&lt/param-name &gt <br>
           &lt param-value &gt lab2.musicappservice.InicializadorRest &lt/param-value &gt <br>
       &lt /init-param &gt <br>
   &lt /servlet &gt <br>
   &lt servlet-mapping &gt <br>
       &lt servlet-name &gt RESTEasyService&lt/servlet-name &gt <br>
       &lt url-pattern &gt /* &lt /url-pattern &gt <br>
   &lt /servlet-mapping &gt <br>
 * @author CristianCamilo
 */

public class InicializadorRest extends Application {
    
    private Set<Object> singletons = new HashSet<Object>();
    
    /**
     * Añade una nueva instancia de CancionServiceImpl al conjunto
     */
    public InicializadorRest() {
        singletons.add(new CancionServiceImpl());
    }
    
    /**
     * Retorna el conjunto de instancias Activas de la clase CancionServiceImpl
     * @return 
     */
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
} 
