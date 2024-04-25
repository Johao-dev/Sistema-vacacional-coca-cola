package Model;

public class Logistica extends Departamento implements DiasVacaciones {
    private String unAño;
    private String dosAñosSeisAños;
    private String masSieteAños;
   
    @Override
    public void diasDeVacaciones() {
        this.unAño = "7 dias de vacaciones.";
        this.dosAñosSeisAños = "15 dias de vacaciones.";
        this.masSieteAños = "20 dias de vacaciones.";
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
