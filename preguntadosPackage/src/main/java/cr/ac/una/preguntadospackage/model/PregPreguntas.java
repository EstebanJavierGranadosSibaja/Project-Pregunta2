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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "PREG_PREGUNTAS")
@NamedQueries({
    @NamedQuery(name = "PregPreguntas.findAll", query = "SELECT p FROM PregPreguntas p"),
    @NamedQuery(name = "PregPreguntas.findByParameters", query = "SELECT p FROM PregPreguntas p Where upper(p.id) LIKE :id AND upper(p.textoPregunta) LIKE :textoPregunta AND upper(p.cantidadRespuestas) LIKE :cantidadRespuestas AND upper(p.cantidadAciertos) LIKE :cantidadAciertos AND upper(p.estado) LIKE :estado AND upper(p.preIdcat.categoria) LIKE :categoria"),
    @NamedQuery(name = "PregPreguntas.findByPreId", query = "SELECT p FROM PregPreguntas p WHERE p.id = :id"),
    @NamedQuery(name = "PregPreguntas.findByPreTextoPregunta", query = "SELECT p FROM PregPreguntas p WHERE p.textoPregunta = :textoPregunta"),
    @NamedQuery(name = "PregPreguntas.findByPreCantidadRespuestas", query = "SELECT p FROM PregPreguntas p WHERE p.cantidadRespuestas = :cantidadRespuestas"),
    @NamedQuery(name = "PregPreguntas.findByPreCantidadAciertos", query = "SELECT p FROM PregPreguntas p WHERE p.cantidadAciertos = :cantidadAciertos"),
    @NamedQuery(name = "PregPreguntas.findByPreEstado", query = "SELECT p FROM PregPreguntas p WHERE p.estado = :estado"),
    @NamedQuery(name = "PregPreguntas.findByPreVersion", query = "SELECT p FROM PregPreguntas p WHERE p.version = :version"),
    @NamedQuery(name = "PregPreguntas.findByCatCategoria", query = "SELECT p FROM PregPreguntas p WHERE upper(p.preIdcat.categoria) LIKE :categoria")
})
public class PregPreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "PREG_PREGUNTAS_TGR01", sequenceName = "PREG_PREGUNTAS_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_PREGUNTAS_TGR01")
    @Id
    @Basic(optional = false)
    @Column(name = "PRE_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "PRE_TEXTO_PREGUNTA")
    private String textoPregunta;
    @Basic(optional = false)
    @Column(name = "PRE_ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "PRE_CANTIDAD_RESPUESTAS")
    private Long cantidadRespuestas;
    @Basic(optional = false)
    @Column(name = "PRE_CANTIDAD_ACIERTOS")
    private Long cantidadAciertos;
    @Version
    @Column(name = "PRE_VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prpaIdpre", fetch = FetchType.LAZY)
    private List<PregPreguntaspartida> preguntaspartidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respIdpre", fetch = FetchType.LAZY)
    private List<PregRespuestas> respuestasList;
    @JoinColumn(name = "PRE_IDCAT", referencedColumnName = "CAT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregCategorias preIdcat;

    public PregPreguntas() {
    }

    public PregPreguntas(PregPreguntasDto pregPreguntasDto) {
        this.id = pregPreguntasDto.getId();
        Actualizar(pregPreguntasDto);
    }

    public void Actualizar(PregPreguntasDto pregPreguntasDto) {
        this.textoPregunta = pregPreguntasDto.getTextoPregunta();
        this.cantidadRespuestas = pregPreguntasDto.getCantidadRespuestas();
        this.cantidadAciertos = pregPreguntasDto.getCantidadAciertos();
        this.estado = pregPreguntasDto.getEstado();
        this.version = pregPreguntasDto.getVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public Long getCantidadRespuestas() {
        return cantidadRespuestas;
    }

    public void setCantidadRespuestas(Long cantidadRespuestas) {
        this.cantidadRespuestas = cantidadRespuestas;
    }

    public Long getCantidadAciertos() {
        return cantidadAciertos;
    }

    public void setCantidadAciertos(Long cantidadAciertos) {
        this.cantidadAciertos = cantidadAciertos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<PregPreguntaspartida> getPreguntaspartidaList() {
        return preguntaspartidaList;
    }

    public void setPregPreguntaspartidaList(List<PregPreguntaspartida> preguntaspartidaList) {
        this.preguntaspartidaList = preguntaspartidaList;
    }

    public List<PregRespuestas> getRespuestasList() {
        return respuestasList;
    }

    public void setPregRespuestasList(List<PregRespuestas> respuestasList) {
        this.respuestasList = respuestasList;
    }

    public PregCategorias getPreIdcat() {
        return preIdcat;
    }

    public void setPreIdcat(PregCategorias preIdcat) {
        this.preIdcat = preIdcat;
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
