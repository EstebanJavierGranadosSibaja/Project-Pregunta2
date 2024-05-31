/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
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
    @NamedQuery(name = "PregPrinpartida.findByPparId", query = "SELECT p FROM PregPrinpartida p WHERE p.id = :id"),
    @NamedQuery(name = "PregPrinpartida.findByPparModoJuego", query = "SELECT p FROM PregPrinpartida p WHERE p.modoJuego = :modoJuego"),
    @NamedQuery(name = "PregPrinpartida.findByPparModoDuelo", query = "SELECT p FROM PregPrinpartida p WHERE p.modoDuelo = :modoDuelo"),
    @NamedQuery(name = "PregPrinpartida.findByPparTiempoTotal", query = "SELECT p FROM PregPrinpartida p WHERE p.tiempoTotal = :tiempoTotal"),
    @NamedQuery(name = "PregPrinpartida.findByPparTiempoTranscurrido", query = "SELECT p FROM PregPrinpartida p WHERE p.tiempoTranscurrido = :tiempoTranscurrido"),
    @NamedQuery(name = "PregPrinpartida.findByPparCantidadRondas", query = "SELECT p FROM PregPrinpartida p WHERE p.cantidadRondas = :cantidadRondas"),
    @NamedQuery(name = "PregPrinpartida.findByPparEstadoPartida", query = "SELECT p FROM PregPrinpartida p WHERE p.estadoPartida = :estadoPartida"),
    @NamedQuery(name = "PregPrinpartida.findByPparCantidadJugadores", query = "SELECT p FROM PregPrinpartida p WHERE p.cantidadJugadores = :cantidadJugadores"),
    @NamedQuery(name = "PregPrinpartida.findByPparSectorActivo", query = "SELECT p FROM PregPrinpartida p WHERE p.sectorActivo = :sectorActivo"),
    @NamedQuery(name = "PregPrinpartida.findByPparVersion", query = "SELECT p FROM PregPrinpartida p WHERE p.version = :version")})
public class PregPrinpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "PREG_PRINPARTIDA_TGR01", sequenceName = "PREG_PRINPARTIDA_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_PRINPARTIDA_TGR01")
    @Id
    @Basic(optional = false)
    @Column(name = "PPAR_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "PPAR_MODO_JUEGO")
    private String modoJuego;
    @Basic(optional = false)
    @Column(name = "PPAR_MODO_DUELO")
    private String modoDuelo;
    @Column(name = "PPAR_TIEMPO_TOTAL")
    private LocalDate tiempoTotal;
    @Column(name = "PPAR_TIEMPO_TRANSCURRIDO")
    private LocalDate tiempoTranscurrido;
    @Basic(optional = false)
    @Column(name = "PPAR_CANTIDAD_RONDAS")
    private Long cantidadRondas;
    @Basic(optional = false)
    @Column(name = "PPAR_ESTADO_PARTIDA")
    private String estadoPartida;
    @Basic(optional = false)
    @Column(name = "PPAR_CANTIDAD_JUGADORES")
    private Long cantidadJugadores;
    @Basic(optional = false)
    @Column(name = "PPAR_SECTOR_ACTIVO")
    private Long sectorActivo;
    @Version
    @Column(name = "PPAR_VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pparId", fetch = FetchType.LAZY)
    private List<PregPreguntaspartida> pregPreguntaspartidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pparId", fetch = FetchType.LAZY)
    private List<PregJugpartida> pregJugpartidaList;

    public PregPrinpartida() {
    }

    public PregPrinpartida(PregPrinpartidaDto pregPrinpartidaDto) {
        this.id = pregPrinpartidaDto.getId();
        Actualizar(pregPrinpartidaDto);
    }

    public void Actualizar(PregPrinpartidaDto pregPrinpartidaDto) {
        this.modoJuego = pregPrinpartidaDto.getModoJuego();
        this.modoDuelo = pregPrinpartidaDto.getModoDuelo();
        this.tiempoTotal = pregPrinpartidaDto.getTiempoTotal();
        this.tiempoTranscurrido = pregPrinpartidaDto.getTiempoTranscurrido();
        this.cantidadRondas = pregPrinpartidaDto.getCantidadRondas();
        this.cantidadJugadores = pregPrinpartidaDto.getCantidadJugadores();
        this.estadoPartida = pregPrinpartidaDto.getEstadoPartida();
        this.sectorActivo = pregPrinpartidaDto.getSectorActivo();
        this.version = pregPrinpartidaDto.getVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregPrinpartida)) {
            return false;
        }
        PregPrinpartida other = (PregPrinpartida) object;
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
