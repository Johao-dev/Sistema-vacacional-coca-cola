package Model;

public class Trabajador {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String añosServicio;
    private String departamento;

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setAñosServicio(String añosServicio) {
        this.añosServicio = añosServicio;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getAñosServicio() {
        return añosServicio;
    }

    public String getDepartamento() {
        return departamento;
    }
}
