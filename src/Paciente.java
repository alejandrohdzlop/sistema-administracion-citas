public class Paciente {
    private String idPaciente;
    private String nombre;

    public Paciente(String idPaciente, String nombre) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getIdPaciente() {
        return idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return idPaciente + "," + nombre;
    }
}
