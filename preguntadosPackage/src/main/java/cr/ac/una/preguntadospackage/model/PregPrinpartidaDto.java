package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class PregPrinpartidaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleStringProperty id;
    public SimpleStringProperty modoJuego;
    public SimpleStringProperty modoDuelo;
    public ObjectProperty<LocalDate> tiempoTotal;
    public ObjectProperty<LocalDate> tiempoTrancurrido;
    public SimpleStringProperty cantidadRondas;
    public SimpleStringProperty estadoPartida;
    public SimpleStringProperty cantidadJugadores;
    public SimpleStringProperty sectorActivo;
    private Boolean modificado;
//    private List<PregPreguntas> preguntasList;
//    private List<PregJugpartida> jugpartidaList;

    public PregPrinpartidaDto() {
        this.id = new SimpleStringProperty("");
        this.modoJuego = new SimpleStringProperty("");
        this.modoDuelo = new SimpleStringProperty("");
        this.cantidadRondas = new SimpleStringProperty("");
        this.cantidadJugadores = new SimpleStringProperty("");
        this.sectorActivo = new SimpleStringProperty("");
        this.tiempoTrancurrido = new SimpleObjectProperty();
        this.tiempoTotal = new SimpleObjectProperty();
        this.estadoPartida = new SimpleStringProperty("");
        this.modificado = false;
    }

    public PregPrinpartidaDto(PregPrinpartida pregPrinpartida) {
        this();
        this.id.set(pregPrinpartida.getId().toString());
        this.modoJuego.set(pregPrinpartida.getModoJuego());
        this.modoDuelo.set(pregPrinpartida.getModoDuelo());
        this.tiempoTotal.set(pregPrinpartida.getTiempoTotal());
        this.tiempoTrancurrido.set(pregPrinpartida.getTiempoTrancurrido());
        this.cantidadRondas.set(pregPrinpartida.getCantidadRondas().toString());
        this.estadoPartida.set(pregPrinpartida.getEstadoPartida());
        this.cantidadJugadores.set(pregPrinpartida.getCantidadJugadores().toString());
        this.sectorActivo.set(pregPrinpartida.getSectorActivo().toString());
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
        return tiempoTotal.get();
    }

    public void setTiempoTotal(LocalDate tiempoTotal) {
        this.tiempoTotal.set(tiempoTotal);
    }

    public LocalDate getTiempoTrancurrido() {
        return tiempoTrancurrido.get();
    }

    public void setTiempoTrancurrido(LocalDate tiempoTrancurrido) {
        this.tiempoTrancurrido.set(tiempoTrancurrido);
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
        return Long.valueOf(sectorActivo.get());
    }

    public void setSectorActivo(Long sectorActivo) {
        this.sectorActivo.set(sectorActivo.toString());
    }

//    public List<PregPreguntas> getPreguntasList() {
//        return preguntasList;
//    }
//
//    public void setPreguntasList(List<PregPreguntas> preguntasList) {
//        this.preguntasList = preguntasList;
//    }
//
//    public List<PregJugpartida> getJugpartidaList() {
//        return jugpartidaList;
//    }
//
//    public void setJugpartidaList(List<PregJugpartida> jugpartidaList) {
//        this.jugpartidaList = jugpartidaList;
//    }
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
