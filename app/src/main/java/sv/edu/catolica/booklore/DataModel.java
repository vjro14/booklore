package sv.edu.catolica.booklore;

public class DataModel {
    String Titulo,id;
    int imagen;

    public DataModel(String titulo, String id, int imagen) {
        Titulo = titulo;
        this.imagen = imagen;
        this.id = id;
    }

    public String getId() { return id; }

    public String getTitulo() {
        return Titulo;
    }

    public int getImagen() {
        return imagen;
    }
}
