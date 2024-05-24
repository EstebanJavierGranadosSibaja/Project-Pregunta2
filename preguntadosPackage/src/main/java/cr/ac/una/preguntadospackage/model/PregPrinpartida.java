/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author esteb
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "preg_prinpartida")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "PregPrinpartida.findAll", query = "SELECT p FROM PregPrinpartida p"),
    @javax.persistence.NamedQuery(name = "PregPrinpartida.findByPparId", query = "SELECT p FROM PregPrinpartida p WHERE p.pparId = :pparId"),
    @javax.persistence.NamedQuery(name = "PregPrinpartida.findByPparModoJuego", query = "SELECT p FROM PregPrinpartida p WHERE p.pparModoJuego = :pparModoJuego"),
    @javax.persistence.NamedQuery(name = "PregPrinpartida.findByPparTiempoTotal", query = "SELECT p FROM PregPrinpartida p WHERE p.pparTiempoTotal = :pparTiempoTotal"),
    @javax.persistence.NamedQuery(name = "PregPrinpartida.findByPparTiempoTranscurrido", query = "SELECT p FROM PregPrinpartida p WHERE p.pparTiempoTranscurrido = :pparTiempoTranscurrido"),
    @javax.persistence.NamedQuery(name = "PregPrinpartida.findByPparCantidadRondas", query = "SELECT p FROM PregPrinpartida p WHERE p.pparCantidadRondas = :pparCantidadRondas"),
    @javax.persistence.NamedQuery(name = "PregPrinpartida.findByPparEstadoPartida", query = "SELECT p FROM PregPrinpartida p WHERE p.pparEstadoPartida = :pparEstadoPartida")})
public class PregPrinpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ppar_id")
    private BigDecimal pparId;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ppar_modo_juego")
    private Character pparModoJuego;
    @javax.persistence.Column(name = "ppar_tiempo_total")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date pparTiempoTotal;
    @javax.persistence.Column(name = "ppar_tiempo_transcurrido")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date pparTiempoTranscurrido;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ppar_cantidad_rondas")
    private BigInteger pparCantidadRondas;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ppar_estado_partida")
    private Character pparEstadoPartida;
    @javax.persistence.JoinTable(name = "preg_interpparpre", joinColumns = {
        @javax.persistence.JoinColumn(name = "ppar_id", referencedColumnName = "ppar_id")}, inverseJoinColumns = {
        @javax.persistence.JoinColumn(name = "pre_id", referencedColumnName = "pre_id")})
    @javax.persistence.ManyToMany
    private List<PregPreguntas> pregPreguntasList;
    @javax.persistence.OneToMany(mappedBy = "pparId")
    private List<PregJugpartidas> pregJugpartidasList;

    public PregPrinpartida() {
    }

    public PregPrinpartida(BigDecimal pparId) {
        this.pparId = pparId;
    }

    public PregPrinpartida(BigDecimal pparId, Character pparModoJuego, BigInteger pparCantidadRondas, Character pparEstadoPartida) {
        this.pparId = pparId;
        this.pparModoJuego = pparModoJuego;
        this.pparCantidadRondas = pparCantidadRondas;
        this.pparEstadoPartida = pparEstadoPartida;
    }

    public BigDecimal getPparId() {
        return pparId;
    }

    public void setPparId(BigDecimal pparId) {
        this.pparId = pparId;
    }

    public Character getPparModoJuego() {
        return pparModoJuego;
    }

    public void setPparModoJuego(Character pparModoJuego) {
        this.pparModoJuego = pparModoJuego;
    }

    public Date getPparTiempoTotal() {
        return pparTiempoTotal;
    }

    public void setPparTiempoTotal(Date pparTiempoTotal) {
        this.pparTiempoTotal = pparTiempoTotal;
    }

    public Date getPparTiempoTranscurrido() {
        return pparTiempoTranscurrido;
    }

    public void setPparTiempoTranscurrido(Date pparTiempoTranscurrido) {
        this.pparTiempoTranscurrido = pparTiempoTranscurrido;
    }

    public BigInteger getPparCantidadRondas() {
        return pparCantidadRondas;
    }

    public void setPparCantidadRondas(BigInteger pparCantidadRondas) {
        this.pparCantidadRondas = pparCantidadRondas;
    }

    public Character getPparEstadoPartida() {
        return pparEstadoPartida;
    }

    public void setPparEstadoPartida(Character pparEstadoPartida) {
        this.pparEstadoPartida = pparEstadoPartida;
    }

    public List<PregPreguntas> getPregPreguntasList() {
        return pregPreguntasList;
    }

    public void setPregPreguntasList(List<PregPreguntas> pregPreguntasList) {
        this.pregPreguntasList = pregPreguntasList;
    }

    public List<PregJugpartidas> getPregJugpartidasList() {
        return pregJugpartidasList;
    }

    public void setPregJugpartidasList(List<PregJugpartidas> pregJugpartidasList) {
        this.pregJugpartidasList = pregJugpartidasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pparId != null ? pparId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregPrinpartida)) {
            return false;
        }
        PregPrinpartida other = (PregPrinpartida) object;
        if ((this.pparId == null && other.pparId != null) || (this.pparId != null && !this.pparId.equals(other.pparId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregPrinpartida[ pparId=" + pparId + " ]";
    }
    
}
