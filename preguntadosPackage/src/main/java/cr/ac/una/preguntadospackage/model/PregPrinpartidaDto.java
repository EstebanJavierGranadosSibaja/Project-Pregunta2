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

    public SimpleStringProperty id;
    public SimpleStringProperty nombrePartida;
    public SimpleStringProperty modoJuego;
    public SimpleStringProperty modoDuelo;
    private LocalDate tiempoTotal;
    private LocalDate tiempoTranscurrido;
    public SimpleStringProperty cantidadRondas;
    public SimpleStringProperty estadoPartida;
    public SimpleStringProperty cantidadJugadores;
    private Long sectorActivo;
    private Long version;
    private Boolean modificado;
    private List<PregPreguntaspartida> pregPreguntaspartidaList;
    private List<PregJugpartida> pregJugpartidaList;

    public PregPrinpartidaDto() {
        this.id = new SimpleStringProperty("");
        this.nombrePartida = new SimpleStringProperty("");
        this.modoJuego = new SimpleStringProperty("");
        this.modoDuelo = new SimpleStringProperty("");
        this.cantidadRondas = new SimpleStringProperty("");
        this.cantidadJugadores = new SimpleStringProperty("");
        this.estadoPartida = new SimpleStringProperty("");
        this.modificado = false;
    }

    public PregPrinpartidaDto(PregPrinpartida pregPrinpartida) {
        this();
        this.id.set(pregPrinpartida.getId().toString());
        this.nombrePartida.set(pregPrinpartida.getNombrePartida());
        this.modoJuego.set(pregPrinpartida.getModoJuego());
        this.modoDuelo.set(pregPrinpartida.getModoDuelo());
        this.tiempoTotal = pregPrinpartida.getTiempoTotal();
        this.tiempoTranscurrido = pregPrinpartida.getTiempoTranscurrido();
        this.cantidadRondas.set(pregPrinpartida.getCantidadRondas().toString());
        this.estadoPartida.set(pregPrinpartida.getEstadoPartida());
        this.cantidadJugadores.set(pregPrinpartida.getCantidadJugadores().toString());
        this.sectorActivo = pregPrinpartida.getSectorActivo();
        this.version = pregPrinpartida.getVersion();
    }

    public Long getId() {
        if (this.id.get() != null && !this.id.get().isBlank()) {
            return Long.valueOf(this.id.get());
        }
        return null;
    }

    public void setId(Long id) {
        this.id.set(id.toString());
    }

    public String getNombrePartida() {
        return nombrePartida.get();
    }

    public void setNombrePartida(String nombrePartida) {
        this.nombrePartida.set(nombrePartida);
    }

    public String getModoJuego() {
        return modoJuego.get();
    }

    public void setModoJuego(String modoJuego) {
        this.modoJuego.set(modoJuego);
    }

    public String getModoDuelo() {
        return modoDuelo.get();
    }

    public void setModoDuelo(String modoDuelo) {
        this.modoDuelo.set(modoDuelo);
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
        return Long.valueOf(cantidadRondas.get());
    }

    public void setCantidadRondas(Long cantidadRondas) {
        this.cantidadRondas.set(cantidadRondas.toString());
    }

    public String getEstadoPartida() {
        return estadoPartida.get();
    }

    public void setEstadoPartida(String estadoPartida) {
        this.estadoPartida.set(estadoPartida);
    }

    public Long getCantidadJugadores() {
        return Long.valueOf(cantidadJugadores.get());
    }

    public void setCantidadJugadores(Long cantidadJugadores) {
        this.cantidadJugadores.set(cantidadJugadores.toString());
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
