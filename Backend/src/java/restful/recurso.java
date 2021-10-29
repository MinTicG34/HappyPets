
package restful;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import restful.Model.ItemModel;
import restful.Service.ItemService;


@Path("generico")
public class recurso {

    ItemService servicio = new ItemService();
       
    @GET
    public ArrayList<ItemModel> getItem(){
        
        return servicio.getItems();
    }

   
}
