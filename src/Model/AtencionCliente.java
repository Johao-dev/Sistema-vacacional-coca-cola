package Model;

public class AtencionCliente extends Departamento implements DiasVacaciones {
    
    private String unAño;
    private String dosAñosSeisAños;
    private String masSieteAños;
   
    @Override
    public final void diasDeVacaciones() {
        this.unAño = "6 dias de vacaciones.";
        this.dosAñosSeisAños = "10 dias de vacaciones.";
        this.masSieteAños = "14 dias de vacaciones.";
    }
    
    public AtencionCliente() {
        diasDeVacaciones();
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
