
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
import restful.Model.UserModel;
import restful.Service.UserService;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserResource {
    UserService servicio = new UserService();
    
    @GET
    public ArrayList<UserModel> getUser(){
        
        return servicio.getUser();
    }
    
    @Path("/{login}")
    @GET
    public UserModel getUser(@PathParam("login") String login){
     return servicio.getUser(login);
    }
    
    @POST
    public UserModel addUser(String JSON){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UserModel user = gson.fromJson(JSON, UserModel.class);
        return servicio.addUser(user);
    }
    
    @PUT
    public UserModel updateUser(String JSON){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UserModel user = gson.fromJson(JSON, UserModel.class);
        
        return servicio.updateUser(user);
    }
    
    @DELETE
    @Path("/{login}")
    public String delProducto(@PathParam("login") String login){
        return servicio.delUser(login);
    }
    
}
