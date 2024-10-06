public class Doctor {
    private String idDoctor;
    private String nombre;
    private String especialidad;

    public Doctor(String idDoctor, String nombre, String especialidad) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getIdDoctor() {
        return idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return idDoctor + "," + nombre + "," + especialidad;
    }
}
