/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "PREG_PRINPARTIDA")
@NamedQueries({
    @NamedQuery(name = "PregPrinpartida.findAll", query = "SELECT p FROM PregPrinpartida p"),
    @NamedQuery(name = "PregPrinpartida.findByPparId", query = "SELECT p FROM PregPrinpartida p WHERE p.pparId = :pparId"),
    @NamedQuery(name = "PregPrinpartida.findByPparModoJuego", query = "SELECT p FROM PregPrinpartida p WHERE p.pparModoJuego = :pparModoJuego"),
    @NamedQuery(name = "PregPrinpartida.findByPparModoDuelo", query = "SELECT p FROM PregPrinpartida p WHERE p.pparModoDuelo = :pparModoDuelo"),
    @NamedQuery(name = "PregPrinpartida.findByPparTiempoTotal", query = "SELECT p FROM PregPrinpartida p WHERE p.pparTiempoTotal = :pparTiempoTotal"),
    @NamedQuery(name = "PregPrinpartida.findByPparTiempoTranscurrido", query = "SELECT p FROM PregPrinpartida p WHERE p.pparTiempoTranscurrido = :pparTiempoTranscurrido"),
    @NamedQuery(name = "PregPrinpartida.findByPparCantidadRondas", query = "SELECT p FROM PregPrinpartida p WHERE p.pparCantidadRondas = :pparCantidadRondas"),
    @NamedQuery(name = "PregPrinpartida.findByPparEstadoPartida", query = "SELECT p FROM PregPrinpartida p WHERE p.pparEstadoPartida = :pparEstadoPartida"),
    @NamedQuery(name = "PregPrinpartida.findByPparCantidadJugadores", query = "SELECT p FROM PregPrinpartida p WHERE p.pparCantidadJugadores = :pparCantidadJugadores"),
    @NamedQuery(name = "PregPrinpartida.findByPparSectorActivo", query = "SELECT p FROM PregPrinpartida p WHERE p.pparSectorActivo = :pparSectorActivo")})
public class PregPrinpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "PREG_PRINPARTIDA_ID_GENERATOR", sequenceName = "PREG_PRINPARTIDA_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_PRINPARTIDA_ID_GENERATOR")
    @Id
    @Basic(optional = false)
    @Column(name = "PPAR_ID")
    private BigDecimal pparId;
    @Basic(optional = false)
    @Column(name = "PPAR_MODO_JUEGO")
    private String pparModoJuego;
    @Basic(optional = false)
    @Column(name = "PPAR_MODO_DUELO")
    private String pparModoDuelo;
    @Column(name = "PPAR_TIEMPO_TOTAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pparTiempoTotal;
    @Column(name = "PPAR_TIEMPO_TRANSCURRIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pparTiempoTranscurrido;
    @Basic(optional = false)
    @Column(name = "PPAR_CANTIDAD_RONDAS")
    private BigInteger pparCantidadRondas;
    @Basic(optional = false)
    @Column(name = "PPAR_ESTADO_PARTIDA")
    private String pparEstadoPartida;
    @Basic(optional = false)
    @Column(name = "PPAR_CANTIDAD_JUGADORES")
    private BigInteger pparCantidadJugadores;
    @Basic(optional = false)
    @Column(name = "PPAR_SECTOR_ACTIVO")
    private BigInteger pparSectorActivo;
    @JoinTable(name = "PREG_PREGUNTASPARTIDA", joinColumns = {
        @JoinColumn(name = "PXP_IDPPAR", referencedColumnName = "PPAR_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PXP_IDPRE", referencedColumnName = "PRE_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<PregPreguntas> pregPreguntasList;
    @OneToMany(mappedBy = "pparId", fetch = FetchType.LAZY)
    private List<PregJugpartida> pregJugpartidaList;

    public PregPrinpartida() {
    }

    public PregPrinpartida(BigDecimal pparId) {
        this.pparId = pparId;
    }

    public PregPrinpartida(BigDecimal pparId, String pparModoJuego, String pparModoDuelo, BigInteger pparCantidadRondas, String pparEstadoPartida, BigInteger pparCantidadJugadores, BigInteger pparSectorActivo) {
        this.pparId = pparId;
        this.pparModoJuego = pparModoJuego;
        this.pparModoDuelo = pparModoDuelo;
        this.pparCantidadRondas = pparCantidadRondas;
        this.pparEstadoPartida = pparEstadoPartida;
        this.pparCantidadJugadores = pparCantidadJugadores;
        this.pparSectorActivo = pparSectorActivo;
    }

    public BigDecimal getPparId() {
        return pparId;
    }

    public void setPparId(BigDecimal pparId) {
        this.pparId = pparId;
    }

    public String getPparModoJuego() {
        return pparModoJuego;
    }

    public void setPparModoJuego(String pparModoJuego) {
        this.pparModoJuego = pparModoJuego;
    }

    public String getPparModoDuelo() {
        return pparModoDuelo;
    }

    public void setPparModoDuelo(String pparModoDuelo) {
        this.pparModoDuelo = pparModoDuelo;
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

    public String getPparEstadoPartida() {
        return pparEstadoPartida;
    }

    public void setPparEstadoPartida(String pparEstadoPartida) {
        this.pparEstadoPartida = pparEstadoPartida;
    }

    public BigInteger getPparCantidadJugadores() {
        return pparCantidadJugadores;
    }

    public void setPparCantidadJugadores(BigInteger pparCantidadJugadores) {
        this.pparCantidadJugadores = pparCantidadJugadores;
    }

    public BigInteger getPparSectorActivo() {
        return pparSectorActivo;
    }

    public void setPparSectorActivo(BigInteger pparSectorActivo) {
        this.pparSectorActivo = pparSectorActivo;
    }

    public List<PregPreguntas> getPregPreguntasList() {
        return pregPreguntasList;
    }

    public void setPregPreguntasList(List<PregPreguntas> pregPreguntasList) {
        this.pregPreguntasList = pregPreguntasList;
    }

    public List<PregJugpartida> getPregJugpartidaList() {
        return pregJugpartidaList;
    }

    public void setPregJugpartidaList(List<PregJugpartida> pregJugpartidaList) {
        this.pregJugpartidaList = pregJugpartidaList;
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
