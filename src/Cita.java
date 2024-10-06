public class Cita {
    private String idCita;
    private String fechaHora;
    private String motivo;
    private Doctor doctorAsignado;
    private Paciente pacienteAsignado;

    public Cita(String idCita, String fechaHora, String motivo, Doctor doctor, Paciente paciente) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctorAsignado = doctor;
        this.pacienteAsignado = paciente;
    }

    // Getters y Setters
    public String getIdCita() {
        return idCita;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
    }

    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }

    @Override
    public String toString() {
        return idCita + "," + fechaHora + "," + motivo + "," + doctorAsignado.getIdDoctor() + "," + pacienteAsignado.getIdPaciente();
    }
}
