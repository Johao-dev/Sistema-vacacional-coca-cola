package Model;

public class Gerencia extends Departamento implements DiasVacaciones {
    
    private String unAño;
    private String dosAñosSeisAños;
    private String masSieteAños;
   
    @Override
    public void diasDeVacaciones() {
        this.unAño = "10 dias de vacaciones.";
        this.dosAñosSeisAños = "20 dias de vacaciones.";
        this.masSieteAños = "30 dias de vacaciones.";
    }

    @Override
    public String getUnAño() {
        return this.unAño;
    }

    @Override
    public String getDosAñosSeisAños() {
        return this.dosAñosSeisAños;
    }

    @Override
    public String getMasDeSieteAños() {
        return this.masSieteAños;
    }
}
