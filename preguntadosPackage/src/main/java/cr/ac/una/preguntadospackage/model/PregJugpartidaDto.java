package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class PregJugpartidaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer posicionSector;
    private Integer posicionCasilla;
    private Integer cantidadAyudas;
    private String dobleAyuda;
    private String pasarAyuda;
    private String bombaAyuda;
    private String extraAyuda;
    private Integer cantidadFichas;
    private String fichaArte;
    private String fichaHistoria;
    private String fichaGeografia;
    private String fichaCiencias;
    private String fichaEntretenimiento;
    private String fichaDeporte;
    private PregJugadores jugId;
    private PregPrinpartida pparId;
    private Boolean modificado;

    public PregJugpartidaDto() {
        this.modificado = false;
    }

    public PregJugpartidaDto(PregJugpartida pregJugpartida) {
        this();
        this.id = pregJugpartida.getId();
        this.posicionSector = pregJugpartida.getPosicionSector();
        this.posicionCasilla = pregJugpartida.getPosicionCasilla();
        this.cantidadAyudas = pregJugpartida.getCantidadAyudas();
        this.dobleAyuda = pregJugpartida.getDobleAyuda();
        this.pasarAyuda = pregJugpartida.getPasarAyuda();
        this.bombaAyuda = pregJugpartida.getBombaAyuda();
        this.extraAyuda = pregJugpartida.getExtraAyuda();
        this.cantidadFichas = pregJugpartida.getCantidadFichas();
        this.fichaArte = pregJugpartida.getFichaArte();
        this.fichaHistoria = pregJugpartida.getFichaHistoria();
        this.fichaGeografia = pregJugpartida.getFichaGeografia();
        this.fichaCiencias = pregJugpartida.getFichaCiencias();
        this.fichaEntretenimiento = pregJugpartida.getFichaEntretenimiento();
        this.fichaDeporte = pregJugpartida.getFichaDeporte();
    }

    public Long getId() {
        if(this.id!=null){
            return this.id;
        }
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosicionSector() {
        return posicionSector;
    }

    public void setPosicionSector(Integer posicionSector) {
        this.posicionSector = posicionSector;
    }

    public Integer getPosicionCasilla() {
        return posicionCasilla;
    }

    public void setPosicionCasilla(Integer posicionCasilla) {
        this.posicionCasilla = posicionCasilla;
    }

    public Integer getCantidadAyudas() {
        return cantidadAyudas;
    }

    public void setCantidadAyudas(Integer cantidadAyudas) {
        this.cantidadAyudas = cantidadAyudas;
    }

    public String getDobleAyuda() {
        return dobleAyuda;
    }

    public void setDobleAyuda(String dobleAyuda) {
        this.dobleAyuda = dobleAyuda;
    }

    public String getPasarAyuda() {
        return pasarAyuda;
    }

    public void setPasarAyuda(String pasarAyuda) {
        this.pasarAyuda = pasarAyuda;
    }

    public String getBombaAyuda() {
        return bombaAyuda;
    }

    public void setBombaAyuda(String bombaAyuda) {
        this.bombaAyuda = bombaAyuda;
    }

    public String getExtraAyuda() {
        return extraAyuda;
    }

    public void setExtraAyuda(String extraAyuda) {
        this.extraAyuda = extraAyuda;
    }

    public Integer getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(Integer cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }

    public String getFichaArte() {
        return fichaArte;
    }

    public void setFichaArte(String fichaArte) {
        this.fichaArte = fichaArte;
    }

    public String getFichaHistoria() {
        return fichaHistoria;
    }

    public void setFichaHistoria(String fichaHistoria) {
        this.fichaHistoria = fichaHistoria;
    }

    public String getFichaGeografia() {
        return fichaGeografia;
    }

    public void setFichaGeografia(String fichaGeografia) {
        this.fichaGeografia = fichaGeografia;
    }

    public String getFichaCiencias() {
        return fichaCiencias;
    }

    public void setFichaCiencias(String fichaCiencias) {
        this.fichaCiencias = fichaCiencias;
    }

    public String getFichaEntretenimiento() {
        return fichaEntretenimiento;
    }

    public void setFichaEntretenimiento(String fichaEntretenimiento) {
        this.fichaEntretenimiento = fichaEntretenimiento;
    }

    public String getFichaDeporte() {
        return fichaDeporte;
    }

    public void setFichaDeporte(String fichaDeporte) {
        this.fichaDeporte = fichaDeporte;
    }

    public PregJugadores getJugId() {
        return jugId;
    }

    public void setJugId(PregJugadores jugId) {
        this.jugId = jugId;
    }

    public PregPrinpartida getPparId() {
        return pparId;
    }

    public void setPparId(PregPrinpartida pparId) {
        this.pparId = pparId;
    }

    public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregJugpartidaDto)) {
            return false;
        }
        PregJugpartidaDto other = (PregJugpartidaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugpartida[ jparId=" + id + " ]";
    }

}
