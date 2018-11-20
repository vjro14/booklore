package sv.edu.catolica.booklore;

public class DataModelPuntuaciones {
    float Calificacion;
    String Persona;

    public DataModelPuntuaciones(float calificacion, String persona) {
        Calificacion = calificacion;
        Persona = persona;
    }

    public float getCalificacion() {
        return Calificacion;
    }

    public String getPersona() {
        return Persona;
    }
}
