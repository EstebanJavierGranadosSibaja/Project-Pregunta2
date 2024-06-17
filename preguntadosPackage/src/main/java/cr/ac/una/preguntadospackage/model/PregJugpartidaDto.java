/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class PregJugpartidaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombreJugador;
    private Long posicionSector;
    private String colorPeon;
    private Long posicionCasilla;
    private Long cantidadAyudasTotal;
    private Long cantidadAyudasUsadas;
    private String dobleAyuda;
    private String pasarAyuda;
    private String bombaAyuda;
    private String extraAyuda;
    private Long cantidadFichas;
    private String fichaArte;
    private String fichaHistoria;
    private String fichaGeografia;
    private String fichaCiencias;
    private String fichaEntretenimiento;
    private String fichaDeporte;
    private Long version;
    private Boolean modificado;
    private PregJugadores jugId;
    private PregPrinpartida pparId;

    public PregJugpartidaDto() {
        this.cantidadAyudasTotal = Long.valueOf(0);
        this.cantidadAyudasUsadas = Long.valueOf(0);
        this.modificado = false;
    }

    public PregJugpartidaDto(PregJugpartida pregJugpartida) {
        this();
        this.id = pregJugpartida.getId();
        this.nombreJugador = pregJugpartida.getNombreJugador();
        this.posicionSector = pregJugpartida.getPosicionSector();
        this.colorPeon = pregJugpartida.getColorPeon();
        this.posicionCasilla = pregJugpartida.getPosicionCasilla();
        this.cantidadAyudasTotal = pregJugpartida.getCantidadAyudasTotal();
        this.cantidadAyudasUsadas = pregJugpartida.getCantidadAyudasUsadas();
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
        this.version = pregJugpartida.getVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Long getPosicionSector() {
        return posicionSector;
    }

    public void setPosicionSector(Long posicionSector) {
        this.posicionSector = posicionSector;
    }

    public String getColorPeon() {
        return colorPeon;
    }

    public void setColorPeon(String colorPeon) {
        this.colorPeon = colorPeon;
    }

    public Long getPosicionCasilla() {
        return posicionCasilla;
    }

    public void setPosicionCasilla(Long posicionCasilla) {
        this.posicionCasilla = posicionCasilla;
    }

    public Long getCantidadAyudasTotal() {
        return cantidadAyudasTotal;
    }

    public void setCantidadAyudasTotal(Long cantidadAyudasTotal) {
        this.cantidadAyudasTotal = cantidadAyudasTotal;
    }

    public Long getCantidadAyudasUsadas() {
        return cantidadAyudasUsadas;
    }

    public void setCantidadAyudasUsadas(Long cantidadAyudasUsadas) {
        this.cantidadAyudasUsadas = cantidadAyudasUsadas;
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

    public Long getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(Long cantidadFichas) {
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
