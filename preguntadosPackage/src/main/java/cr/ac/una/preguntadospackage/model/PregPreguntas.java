
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "PREG_PREGUNTAS")
@NamedQueries({
    @NamedQuery(name = "PregPreguntas.findAll", query = "SELECT p FROM PregPreguntas p"),
    @NamedQuery(name = "PregPreguntas.findByPreId", query = "SELECT p FROM PregPreguntas p WHERE p.preId = :preId"),
    @NamedQuery(name = "PregPreguntas.findByPreTextoPregunta", query = "SELECT p FROM PregPreguntas p WHERE p.preTextoPregunta = :preTextoPregunta"),
    @NamedQuery(name = "PregPreguntas.findByPreCantidadRespuestas", query = "SELECT p FROM PregPreguntas p WHERE p.preCantidadRespuestas = :preCantidadRespuestas"),
    @NamedQuery(name = "PregPreguntas.findByPreCantidadAciertos", query = "SELECT p FROM PregPreguntas p WHERE p.preCantidadAciertos = :preCantidadAciertos"),
    @NamedQuery(name = "PregPreguntas.findByPreEstado", query = "SELECT p FROM PregPreguntas p WHERE p.preEstado = :preEstado"),
    @NamedQuery(name = "PregPreguntas.findByVersion", query = "SELECT p FROM PregPreguntas p WHERE p.version = :version")})
public class PregPreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "PREG_PREGUNTAS_ID_GENERATOR", sequenceName = "PREG_PREGUNTAS_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_PREGUNTAS_ID_GENERATOR")
    @Id
    @Basic(optional = false)
    @Column(name = "PRE_ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "PRE_TEXTO_PREGUNTA")
    private String textoPregunta;
    @Basic(optional = false)
    @Column(name = "PRE_CANTIDAD_RESPUESTAS")
    private BigInteger cantidadRespuestas;
    @Basic(optional = false)
    @Column(name = "PRE_CANTIDAD_ACIERTOS")
    private BigInteger cantidadAciertos;
    @Basic(optional = false)
    @Column(name = "PRE_ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private BigInteger version;
    @ManyToMany(mappedBy = "preguntasList", fetch = FetchType.LAZY)
    private List<PregPrinpartida> pregPrinpartidaList;
    @ManyToMany(mappedBy = "preguntasList", fetch = FetchType.LAZY)
    private List<PregJugadores> pregJugadoresList;
    @OneToMany(mappedBy = "preId", fetch = FetchType.LAZY)
    private List<PregRespuestas> pregRespuestasList;
    @JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PregCategorias catId;

    public PregPreguntas() {
    }

    public PregPreguntas(BigDecimal preId) {
        this.id = preId;
    }

    public PregPreguntas(BigDecimal preId, String preTextoPregunta, BigInteger preCantidadRespuestas, BigInteger preCantidadAciertos, String preEstado, BigInteger version) {
        this.id = preId;
        this.textoPregunta = preTextoPregunta;
        this.cantidadRespuestas = preCantidadRespuestas;
        this.cantidadAciertos = preCantidadAciertos;
        this.estado = preEstado;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public BigInteger getCantidadRespuestas() {
        return cantidadRespuestas;
    }

    public void setCantidadRespuestas(BigInteger cantidadRespuestas) {
        this.cantidadRespuestas = cantidadRespuestas;
    }

    public BigInteger getCantidadAciertos() {
        return cantidadAciertos;
    }

    public void setCantidadAciertos(BigInteger cantidadAciertos) {
        this.cantidadAciertos = cantidadAciertos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public List<PregPrinpartida> getPregPrinpartidaList() {
        return pregPrinpartidaList;
    }

    public void setPregPrinpartidaList(List<PregPrinpartida> pregPrinpartidaList) {
        this.pregPrinpartidaList = pregPrinpartidaList;
    }

    public List<PregJugadores> getPregJugadoresList() {
        return pregJugadoresList;
    }

    public void setPregJugadoresList(List<PregJugadores> pregJugadoresList) {
        this.pregJugadoresList = pregJugadoresList;
    }

    public List<PregRespuestas> getPregRespuestasList() {
        return pregRespuestasList;
    }

    public void setPregRespuestasList(List<PregRespuestas> pregRespuestasList) {
        this.pregRespuestasList = pregRespuestasList;
    }

    public PregCategorias getCatId() {
        return catId;
    }

    public void setCatId(PregCategorias catId) {
        this.catId = catId;
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
        if (!(object instanceof PregPreguntas)) {
            return false;
        }
        PregPreguntas other = (PregPreguntas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregPreguntas[ preId=" + id + " ]";
    }

}
