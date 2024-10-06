public class Administrador {
    private String idAdmin;
    private String contrasena;

    public Administrador(String idAdmin, String contrasena) {
        this.idAdmin = idAdmin;
        this.contrasena = contrasena;
    }

    public boolean verificarAcceso(String id, String pass) {
        return this.idAdmin.equals(id) && this.contrasena.equals(pass);
    }
}
