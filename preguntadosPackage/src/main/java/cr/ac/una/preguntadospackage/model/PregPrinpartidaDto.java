/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class PregPrinpartidaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    private Long id;
    private SimpleStringProperty nombrePartida;
    private String modoJuego;
    private String modoDuelo;
    private LocalDate tiempoTotal;
    private LocalDate tiempoTranscurrido;
    private Long cantidadRondas;
    private String estadoPartida;
    private Long cantidadJugadores;
    private Long sectorActivo;
    private Long version;
    private Boolean modificado;
    private List<PregPreguntaspartida> pregPreguntaspartidaList;
    private List<PregJugpartida> pregJugpartidaList;

    public PregPrinpartidaDto() {
        this.nombrePartida = new SimpleStringProperty("");
        this.modificado = false;
    }

    public PregPrinpartidaDto(PregPrinpartida pregPrinpartida) {
        this();
        this.id = pregPrinpartida.getId();
        this.nombrePartida.set(pregPrinpartida.getNombrePartida());
        this.modoJuego = pregPrinpartida.getModoJuego();
        this.modoDuelo = pregPrinpartida.getModoDuelo();
        this.tiempoTotal = pregPrinpartida.getTiempoTotal();
        this.tiempoTranscurrido = pregPrinpartida.getTiempoTranscurrido();
        this.cantidadRondas = pregPrinpartida.getCantidadRondas();
        this.estadoPartida = pregPrinpartida.getEstadoPartida();
        this.cantidadJugadores = pregPrinpartida.getCantidadJugadores();
        this.sectorActivo = pregPrinpartida.getSectorActivo();
        this.version = pregPrinpartida.getVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePartida() {
        return nombrePartida.get();
    }

    public void setNombrePartida(String nombrePartida) {
        this.nombrePartida.set(nombrePartida);
    }
    
    public String getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(String modoJuego) {
        this.modoJuego = modoJuego;
    }

    public String getModoDuelo() {
        return modoDuelo;
    }

    public void setModoDuelo(String modoDuelo) {
        this.modoDuelo = modoDuelo;
    }

    public LocalDate getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(LocalDate tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public LocalDate getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public void setTiempoTranscurrido(LocalDate tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }

    public Long getCantidadRondas() {
        return cantidadRondas;
    }

    public void setCantidadRondas(Long cantidadRondas) {
        this.cantidadRondas = cantidadRondas;
    }

    public String getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(String estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public Long getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(Long cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public Long getSectorActivo() {
        return sectorActivo;
    }

    public void setSectorActivo(Long sectorActivo) {
        this.sectorActivo = sectorActivo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<PregPreguntaspartida> getPregPreguntaspartidaList() {
        return pregPreguntaspartidaList;
    }

    public void setPregPreguntaspartidaList(List<PregPreguntaspartida> pregPreguntaspartidaList) {
        this.pregPreguntaspartidaList = pregPreguntaspartidaList;
    }

    public List<PregJugpartida> getPregJugpartidaList() {
        return pregJugpartidaList;
    }

    public void setPregJugpartidaList(List<PregJugpartida> pregJugpartidaList) {
        this.pregJugpartidaList = pregJugpartidaList;
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
        if (!(object instanceof PregPrinpartidaDto)) {
            return false;
        }
        PregPrinpartidaDto other = (PregPrinpartidaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregPrinpartida[ pparId=" + id + " ]";
    }

}
