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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PREG_PRINPARTIDA")
@NamedQueries({ //    @NamedQuery(name = "PregPrinpartida.findAll", query = "SELECT p FROM PregPrinpartida p"),
//    @NamedQuery(name = "PregPrinpartida.findByPparId", query = "SELECT p FROM PregPrinpartida p WHERE p.pparId = :pparId"),
//    @NamedQuery(name = "PregPrinpartida.findByPparModoJuego", query = "SELECT p FROM PregPrinpartida p WHERE p.pparModoJuego = :pparModoJuego"),
//    @NamedQuery(name = "PregPrinpartida.findByPparModoDuelo", query = "SELECT p FROM PregPrinpartida p WHERE p.pparModoDuelo = :pparModoDuelo"),
//    @NamedQuery(name = "PregPrinpartida.findByPparTiempoTotal", query = "SELECT p FROM PregPrinpartida p WHERE p.pparTiempoTotal = :pparTiempoTotal"),
//    @NamedQuery(name = "PregPrinpartida.findByPparTiempoTranscurrido", query = "SELECT p FROM PregPrinpartida p WHERE p.pparTiempoTranscurrido = :pparTiempoTranscurrido"),
//    @NamedQuery(name = "PregPrinpartida.findByPparCantidadRondas", query = "SELECT p FROM PregPrinpartida p WHERE p.pparCantidadRondas = :pparCantidadRondas"),
//    @NamedQuery(name = "PregPrinpartida.findByPparEstadoPartida", query = "SELECT p FROM PregPrinpartida p WHERE p.pparEstadoPartida = :pparEstadoPartida"),
//    @NamedQuery(name = "PregPrinpartida.findByPparCantidadJugadores", query = "SELECT p FROM PregPrinpartida p WHERE p.pparCantidadJugadores = :pparCantidadJugadores"),
//    @NamedQuery(name = "PregPrinpartida.findByPparSectorActivo", query = "SELECT p FROM PregPrinpartida p WHERE p.pparSectorActivo = :pparSectorActivo")
})
public class PregPrinpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "PREG_PRINPARTIDA_ID_GENERATOR", sequenceName = "PREG_PRINPARTIDA_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_PRINPARTIDA_ID_GENERATOR")
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
    private LocalDate tiempoTrancurrido;
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
    @JoinTable(name = "PREG_PREGUNTASPARTIDA", joinColumns = {
        @JoinColumn(name = "PXP_IDPPAR", referencedColumnName = "PPAR_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PXP_IDPRE", referencedColumnName = "PRE_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<PregPreguntas> preguntasList;
    @OneToMany(mappedBy = "pparId", fetch = FetchType.LAZY)
    private List<PregJugpartida> jugpartidaList;

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
        this.tiempoTrancurrido = pregPrinpartidaDto.getTiempoTrancurrido();
        this.cantidadRondas = pregPrinpartidaDto.getCantidadRondas();
        this.estadoPartida = pregPrinpartidaDto.getEstadoPartida();
        this.cantidadJugadores = pregPrinpartidaDto.getCantidadJugadores();
        this.sectorActivo = pregPrinpartidaDto.getSectorActivo();
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

    public LocalDate getTiempoTrancurrido() {
        return tiempoTrancurrido;
    }

    public void setTiempoTrancurrido(LocalDate tiempoTrancurrido) {
        this.tiempoTrancurrido = tiempoTrancurrido;
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

    public List<PregPreguntas> getPreguntasList() {
        return preguntasList;
    }

    public void setPreguntasList(List<PregPreguntas> preguntasList) {
        this.preguntasList = preguntasList;
    }

    public List<PregJugpartida> getJugpartidaList() {
        return jugpartidaList;
    }

    public void setJugpartidaList(List<PregJugpartida> jugpartidaList) {
        this.jugpartidaList = jugpartidaList;
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
