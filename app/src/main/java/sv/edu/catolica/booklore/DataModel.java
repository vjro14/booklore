package sv.edu.catolica.booklore;

public class DataModel {
    String Titulo,Ranked;
    int imagen;

    public DataModel(String titulo, String ranked, int imagen) {
        Titulo = titulo;
        Ranked = ranked;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getRanked() {
        return Ranked;
    }

    public int getImagen() {
        return imagen;
    }
}
