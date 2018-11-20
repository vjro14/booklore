package sv.edu.catolica.booklore;

public class DataModelFrases {
    String Frase,autor;

    public DataModelFrases(String frase, String autor) {
        Frase = frase;
        this.autor = autor;
    }

    public String getFrase() {
        return Frase;
    }

    public String getAutor() {
        return autor;
    }
}
