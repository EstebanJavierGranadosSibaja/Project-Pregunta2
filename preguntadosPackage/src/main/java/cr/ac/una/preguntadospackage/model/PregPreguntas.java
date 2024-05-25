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

/**
 *
 * @author esteb
 */
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
    private BigDecimal preId;
    @Basic(optional = false)
    @Column(name = "PRE_TEXTO_PREGUNTA")
    private String preTextoPregunta;
    @Basic(optional = false)
    @Column(name = "PRE_CANTIDAD_RESPUESTAS")
    private BigInteger preCantidadRespuestas;
    @Basic(optional = false)
    @Column(name = "PRE_CANTIDAD_ACIERTOS")
    private BigInteger preCantidadAciertos;
    @Basic(optional = false)
    @Column(name = "PRE_ESTADO")
    private String preEstado;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private BigInteger version;
    @ManyToMany(mappedBy = "pregPreguntasList", fetch = FetchType.LAZY)
    private List<PregPrinpartida> pregPrinpartidaList;
    @ManyToMany(mappedBy = "pregPreguntasList", fetch = FetchType.LAZY)
    private List<PregJugadores> pregJugadoresList;
    @OneToMany(mappedBy = "preId", fetch = FetchType.LAZY)
    private List<PregRespuestas> pregRespuestasList;
    @JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PregCategorias catId;

    public PregPreguntas() {
    }

    public PregPreguntas(BigDecimal preId) {
        this.preId = preId;
    }

    public PregPreguntas(BigDecimal preId, String preTextoPregunta, BigInteger preCantidadRespuestas, BigInteger preCantidadAciertos, String preEstado, BigInteger version) {
        this.preId = preId;
        this.preTextoPregunta = preTextoPregunta;
        this.preCantidadRespuestas = preCantidadRespuestas;
        this.preCantidadAciertos = preCantidadAciertos;
        this.preEstado = preEstado;
        this.version = version;
    }

    public BigDecimal getPreId() {
        return preId;
    }

    public void setPreId(BigDecimal preId) {
        this.preId = preId;
    }

    public String getPreTextoPregunta() {
        return preTextoPregunta;
    }

    public void setPreTextoPregunta(String preTextoPregunta) {
        this.preTextoPregunta = preTextoPregunta;
    }

    public BigInteger getPreCantidadRespuestas() {
        return preCantidadRespuestas;
    }

    public void setPreCantidadRespuestas(BigInteger preCantidadRespuestas) {
        this.preCantidadRespuestas = preCantidadRespuestas;
    }

    public BigInteger getPreCantidadAciertos() {
        return preCantidadAciertos;
    }

    public void setPreCantidadAciertos(BigInteger preCantidadAciertos) {
        this.preCantidadAciertos = preCantidadAciertos;
    }

    public String getPreEstado() {
        return preEstado;
    }

    public void setPreEstado(String preEstado) {
        this.preEstado = preEstado;
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
        hash += (preId != null ? preId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregPreguntas)) {
            return false;
        }
        PregPreguntas other = (PregPreguntas) object;
        if ((this.preId == null && other.preId != null) || (this.preId != null && !this.preId.equals(other.preId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregPreguntas[ preId=" + preId + " ]";
    }

}
