/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author esteb
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "preg_preguntas")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "PregPreguntas.findAll", query = "SELECT p FROM PregPreguntas p"),
    @javax.persistence.NamedQuery(name = "PregPreguntas.findByPreId", query = "SELECT p FROM PregPreguntas p WHERE p.preId = :preId"),
    @javax.persistence.NamedQuery(name = "PregPreguntas.findByPreTextoPregunta", query = "SELECT p FROM PregPreguntas p WHERE p.preTextoPregunta = :preTextoPregunta"),
    @javax.persistence.NamedQuery(name = "PregPreguntas.findByPreCantidadRespondidas", query = "SELECT p FROM PregPreguntas p WHERE p.preCantidadRespondidas = :preCantidadRespondidas"),
    @javax.persistence.NamedQuery(name = "PregPreguntas.findByPreCantidadAciertos", query = "SELECT p FROM PregPreguntas p WHERE p.preCantidadAciertos = :preCantidadAciertos")})
public class PregPreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pre_id")
    private BigDecimal preId;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pre_texto_pregunta")
    private String preTextoPregunta;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pre_cantidad_respondidas")
    private BigInteger preCantidadRespondidas;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pre_cantidad_aciertos")
    private BigInteger preCantidadAciertos;
    @javax.persistence.ManyToMany(mappedBy = "pregPreguntasList")
    private List<PregJugadores> pregJugadoresList;
    @javax.persistence.ManyToMany(mappedBy = "pregPreguntasList")
    private List<PregPrinpartida> pregPrinpartidaList;
    @javax.persistence.JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @javax.persistence.ManyToOne
    private PregCategorias catId;
    @javax.persistence.OneToMany(mappedBy = "preId")
    private List<PregRespuestas> pregRespuestasList;

    public PregPreguntas() {
    }

    public PregPreguntas(BigDecimal preId) {
        this.preId = preId;
    }

    public PregPreguntas(BigDecimal preId, String preTextoPregunta, BigInteger preCantidadRespondidas, BigInteger preCantidadAciertos) {
        this.preId = preId;
        this.preTextoPregunta = preTextoPregunta;
        this.preCantidadRespondidas = preCantidadRespondidas;
        this.preCantidadAciertos = preCantidadAciertos;
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

    public BigInteger getPreCantidadRespondidas() {
        return preCantidadRespondidas;
    }

    public void setPreCantidadRespondidas(BigInteger preCantidadRespondidas) {
        this.preCantidadRespondidas = preCantidadRespondidas;
    }

    public BigInteger getPreCantidadAciertos() {
        return preCantidadAciertos;
    }

    public void setPreCantidadAciertos(BigInteger preCantidadAciertos) {
        this.preCantidadAciertos = preCantidadAciertos;
    }

    public List<PregJugadores> getPregJugadoresList() {
        return pregJugadoresList;
    }

    public void setPregJugadoresList(List<PregJugadores> pregJugadoresList) {
        this.pregJugadoresList = pregJugadoresList;
    }

    public List<PregPrinpartida> getPregPrinpartidaList() {
        return pregPrinpartidaList;
    }

    public void setPregPrinpartidaList(List<PregPrinpartida> pregPrinpartidaList) {
        this.pregPrinpartidaList = pregPrinpartidaList;
    }

    public PregCategorias getCatId() {
        return catId;
    }

    public void setCatId(PregCategorias catId) {
        this.catId = catId;
    }

    public List<PregRespuestas> getPregRespuestasList() {
        return pregRespuestasList;
    }

    public void setPregRespuestasList(List<PregRespuestas> pregRespuestasList) {
        this.pregRespuestasList = pregRespuestasList;
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
