
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
import restful.Model.PerfilUsuarioModel;
import restful.Service.PerfilUsuarioService;


@Path("perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilUsuarioResource {
    
    PerfilUsuarioService servicio = new PerfilUsuarioService();
     @GET
    public ArrayList<PerfilUsuarioModel> getPerfil(){
        
        return servicio.getPerfilUser();
    }
    
    @Path("/{id_perfil}")
    @GET
    public PerfilUsuarioModel getUser(@PathParam("id_perfil") int id){
     return servicio.getPerfilUser(id);
    }
    
    @POST
    public PerfilUsuarioModel addPerfil(String JSON){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        PerfilUsuarioModel perfil = gson.fromJson(JSON, PerfilUsuarioModel.class);
        return servicio.addPerfil(perfil);
    }
    
    @PUT
    public PerfilUsuarioModel updatePerfil(String JSON){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        PerfilUsuarioModel perfil = gson.fromJson(JSON, PerfilUsuarioModel.class);
        
        return servicio.updatePerfil(perfil);
    }
    
    @DELETE
    @Path("/{id_perfil}")
    public String delProducto(@PathParam("id_perfil") int login){
        return servicio.delPerfil(login);
    }
    
}
