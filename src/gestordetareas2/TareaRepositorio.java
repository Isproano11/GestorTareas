
package gestordetareas2;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TareaRepositorio {
    private final MongoCollection<Document> coleccion;

    public TareaRepositorio(MongoDatabase baseDatos) {
        this.coleccion = baseDatos.getCollection("tareas");
    }

    public void guardarTarea(Tarea tarea) {
        Document doc = new Document("id", tarea.getId())
                .append("descripcion", tarea.getDescripcion())
                .append("completada", tarea.isCompletada());
        coleccion.insertOne(doc);
    }

    public List<Tarea> obtenerTareas() {
        List<Tarea> tareas = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            Tarea tarea = new Tarea(doc.getString("id"), doc.getString("descripcion"));
            if (doc.getBoolean("completada")) {
                tarea.marcarComoCompletada();
            }
            tareas.add(tarea);
        }
        return tareas;
    }
}