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
import jakarta.persistence.Version;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PREG_JUGADORES")
@NamedQueries({
    @NamedQuery(name = "PregJugadores.findByParameters", query = "SELECT p FROM PregJugadores p WHERE upper(p.id) LIKE :id AND upper(p.nombre) LIKE :nombre AND upper(p.partidasJugadas) LIKE :partidasJugadas AND upper(p.partidasGanadas) LIKE :partidasGanadas AND upper(p.cantidadRespuestasGeneral) LIKE :cantidadRespuestasGeneral AND upper(p.cantidadAcertadasGeneral) LIKE :cantidadAcertadasGeneral"),
    @NamedQuery(name = "PregJugadores.findAll", query = "SELECT p FROM PregJugadores p"),
    @NamedQuery(name = "PregJugadores.findByJugId", query = "SELECT p FROM PregJugadores p WHERE p.id = :id"),
    @NamedQuery(name = "PregJugadores.findByJugNombre", query = "SELECT p FROM PregJugadores p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PregJugadores.findByJugPartidasJugadas", query = "SELECT p FROM PregJugadores p WHERE p.partidasJugadas = :partidasJugadas"),
    @NamedQuery(name = "PregJugadores.findByJugPartidasGanadas", query = "SELECT p FROM PregJugadores p WHERE p.partidasGanadas = :partidasGanadas"),
    @NamedQuery(name = "PregJugadores.findByJugCantidadRespuestasGeneral", query = "SELECT p FROM PregJugadores p WHERE p.cantidadRespuestasGeneral = :cantidadRespuestasGeneral"),
    @NamedQuery(name = "PregJugadores.findByJugCantidadAcertadasGeneral", query = "SELECT p FROM PregJugadores p WHERE p.cantidadAcertadasGeneral = :cantidadAcertadasGeneral"),
    @NamedQuery(name = "PregJugadores.findByJugVersion", query = "SELECT p FROM PregJugadores p WHERE p.version = :version")})
public class PregJugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "PREG_JUGADORES_TGR01", sequenceName = "PREG_JUGADORES_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_JUGADORES_TGR01")
    @Id
    @Basic(optional = false)
    @Column(name = "JUG_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "JUG_NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "JUG_PARTIDAS_JUGADAS")
    private Long partidasJugadas;
    @Basic(optional = false)
    @Column(name = "JUG_PARTIDAS_GANADAS")
    private Long partidasGanadas;
    @Basic(optional = false)
    @Column(name = "JUG_CANTIDAD_RESPUESTAS_GENERAL")
    private Long cantidadRespuestasGeneral;
    @Basic(optional = false)
    @Column(name = "JUG_CANTIDAD_ACERTADAS_GENERAL")
    private Long cantidadAcertadasGeneral;
    @Version
    @Column(name = "JUG_VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajuIdjug", fetch = FetchType.LAZY)
    private List<PregCategoriasjugador> categoriasjugadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jparIdjug", fetch = FetchType.LAZY)
    private List<PregJugpartida> jugpartidaList;

    public PregJugadores() {
    }

    public PregJugadores(PregJugadoresDto pregJugadoresDto) {
        this.id = pregJugadoresDto.getId();
        Actualizar(pregJugadoresDto);
    }

    public void Actualizar(PregJugadoresDto pregJugadoresDto) {
        this.nombre = pregJugadoresDto.getNombre();
        this.partidasGanadas = pregJugadoresDto.getPartidasGanadas();
        this.partidasJugadas = pregJugadoresDto.getPartidasJugadas();
        this.cantidadRespuestasGeneral = pregJugadoresDto.getCantidasRespuestasGeneral();
        this.cantidadAcertadasGeneral = pregJugadoresDto.getCantidasAcertadasGeneral();
        this.version = pregJugadoresDto.getVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(Long partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public Long getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(Long partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public Long getCantidadRespuestasGeneral() {
        return cantidadRespuestasGeneral;
    }

    public void setCantidadRespuestasGeneral(Long cantidasRespuestasGeneral) {
        this.cantidadRespuestasGeneral = cantidasRespuestasGeneral;
    }

    public Long getCantidadAcertadasGeneral() {
        return cantidadAcertadasGeneral;
    }

    public void setCantidadAcertadasGeneral(Long cantidasAcertadasGeneral) {
        this.cantidadAcertadasGeneral = cantidasAcertadasGeneral;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<PregCategoriasjugador> getCategoriasjugadorList() {
        return categoriasjugadorList;
    }

    public void setCategoriasjugadorList(List<PregCategoriasjugador> categoriasjugadorList) {
        this.categoriasjugadorList = categoriasjugadorList;
    }

    public List<PregJugpartida> getJugpartidaList() {
        return jugpartidaList;
    }

    public void setPregJugpartidaList(List<PregJugpartida> jugpartidaList) {
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
        if (!(object instanceof PregJugadores)) {
            return false;
        }
        PregJugadores other = (PregJugadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugadores[ jugId=" + id + " ]";
    }

}
