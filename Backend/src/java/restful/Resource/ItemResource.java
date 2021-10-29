
package restful.Resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restful.Model.ItemModel;
import restful.Service.ItemService;



@Path("item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)  
public class ItemResource {
    //creo el objeto de los servicios de item
    ItemService servicio = new ItemService();
    
    @GET
    public ArrayList<ItemModel> getItems(){
        
        return servicio.getItems();
    }
    
    //consulta de un item
    @Path("/{codigo_item}")
    @GET
    public ItemModel getItem(@PathParam("codigo_item") String id){
     return servicio.getItem(id);
    
    }
    //añadir un item nuevo
   @POST
    public ItemModel addItem(String JSON){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ItemModel item = gson.fromJson(JSON, ItemModel.class);
        return servicio.addItem(item);
    } 
            
    //actualización de un item
    @PUT
    public ItemModel updateItem(String JSON){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ItemModel item = gson.fromJson(JSON, ItemModel.class);
        
        return servicio.updateItem(item);
    }
    //eliminación de producto
    @DELETE
    @Path("/{codigo_item}")
    public String delItem(@PathParam("codigo_item") String codigo_item){
        return servicio.delItem(codigo_item);
    }
    
}
