
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
import restful.Model.UsuariosModel;
import restful.Service.UsuariosService;

@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosResource {
    UsuariosService servicio = new UsuariosService();
    
    @GET
    public ArrayList<UsuariosModel> getUser(){
        
        return servicio.getUsuarios();
    }
    
    @Path("/{id_usuario}")
    @GET
    public UsuariosModel getUsuario(@PathParam("id_usuario") int id_usuario){
     return servicio.getUsuario(id_usuario);
    }
    
    @POST
    public UsuariosModel addUsuario(String JSON){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UsuariosModel usuario = gson.fromJson(JSON, UsuariosModel.class);
        return servicio.addUsuarios(usuario);
    }
    
    @PUT
    public UsuariosModel updateUsuario(String JSON){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UsuariosModel usuario = gson.fromJson(JSON, UsuariosModel.class);
        
        return servicio.updateUsuario(usuario);
    }
    
    @DELETE
    @Path("/{id_usuario}")
    public String delUsuario(@PathParam("id_usuario") int id){
        return servicio.delUsuario(id);
    }
}
