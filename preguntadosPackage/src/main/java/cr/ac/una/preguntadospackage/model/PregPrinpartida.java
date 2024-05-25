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
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Id;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

/**
 * Author: esteb
 */
@Entity
@Table(name = "preg_prinpartida")
@NamedQueries({
        @NamedQuery(name = "PregPrinpartida.findAll", query = "SELECT p FROM PregPrinpartida p"),
        @NamedQuery(name = "PregPrinpartida.findByPparId", query = "SELECT p FROM PregPrinpartida p WHERE p.pparId = :pparId"),
        @NamedQuery(name = "PregPrinpartida.findByPparModoJuego", query = "SELECT p FROM PregPrinpartida p WHERE p.pparModoJuego = :pparModoJuego"),
        @NamedQuery(name = "PregPrinpartida.findByPparTiempoTotal", query = "SELECT p FROM PregPrinpartida p WHERE p.pparTiempoTotal = :pparTiempoTotal"),
        @NamedQuery(name = "PregPrinpartida.findByPparTiempoTranscurrido", query = "SELECT p FROM PregPrinpartida p WHERE p.pparTiempoTranscurrido = :pparTiempoTranscurrido"),
        @NamedQuery(name = "PregPrinpartida.findByPparCantidadRondas", query = "SELECT p FROM PregPrinpartida p WHERE p.pparCantidadRondas = :pparCantidadRondas"),
        @NamedQuery(name = "PregPrinpartida.findByPparEstadoPartida", query = "SELECT p FROM PregPrinpartida p WHERE p.pparEstadoPartida = :pparEstadoPartida")
})
public class PregPrinpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ppar_id")
    private BigDecimal pparId;

    @Basic(optional = false)
    @Column(name = "ppar_modo_juego")
    private Character pparModoJuego;

    @Column(name = "ppar_tiempo_total")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pparTiempoTotal;

    @Column(name = "ppar_tiempo_transcurrido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pparTiempoTranscurrido;

    @Basic(optional = false)
    @Column(name = "ppar_cantidad_rondas")
    private BigInteger pparCantidadRondas;

    @Basic(optional = false)
    @Column(name = "ppar_estado_partida")
    private Character pparEstadoPartida;

    @JoinTable(name = "preg_interpparpre", joinColumns = {
            @JoinColumn(name = "ppar_id", referencedColumnName = "ppar_id")}, inverseJoinColumns = {
            @JoinColumn(name = "pre_id", referencedColumnName = "pre_id")})
    @ManyToMany
    private List<PregPreguntas> pregPreguntasList;

    // TODO: Check this @Esteban
    //@OneToMany(mappedBy = "pparId")
    //private List<PregJugpartidas> pregJugpartidasList;

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

    // TODO: Check this @Esteban
    //public List<PregJugpartidas> getPregJugpartidasList() {
       // return pregJugpartidasList;
    //}

    // TODO: Check this @Esteban
    //public void setPregJugpartidasList(List<PregJugpartidas> pregJugpartidasList) {
        //this.pregJugpartidasList = pregJugpartidasList;
    //}

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
