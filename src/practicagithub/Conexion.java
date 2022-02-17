package practicagithub;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();

    public Conexion() {
        try {
            Mongo mongo = new Mongo("localhost",27017);
            BaseDatos = mongo.getDB("escuela");
            coleccion = BaseDatos.getCollection("alumnos");
            System.out.println("OK");
        } catch (UnknownHostException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }
    }
    
   public boolean insertar(String nombre, int edad, String grupo){
       document.put("nombre",nombre);
       document.put("edad", edad);
       document.put("grupo", grupo);
       coleccion.insert(document);
       return true;
   }
   public void mostrar(){
       DBCursor cursor = coleccion.find();
       while (cursor.hasNext()){
           System.out.println(cursor.next());
       }
   }
   public boolean actualizar(String nombreV, String nombreN, int edadV,
           int edadN, String grupoV, String grupoN){
       document.put("nombre", nombreV);
       document.put("edad", edadV);
       document.put("grupo", grupoV);
       BasicDBObject documentoNuevo = new BasicDBObject();
       documentoNuevo.put("nombre", nombreN);
       documentoNuevo.put("edad", edadN);
       documentoNuevo.put("grupo", grupoN);
       coleccion.findAndModify(document, documentoNuevo);
       return true;
   }
   public boolean eliminar(String nombre){
       document.put("nombre", nombre);
       coleccion.remove(document);
       return true;
   }
   
}
