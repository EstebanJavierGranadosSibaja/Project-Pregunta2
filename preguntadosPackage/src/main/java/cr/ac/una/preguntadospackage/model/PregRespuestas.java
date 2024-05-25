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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "PREG_RESPUESTAS")
@NamedQueries({
    @NamedQuery(name = "PregRespuestas.findAll", query = "SELECT p FROM PregRespuestas p"),
    @NamedQuery(name = "PregRespuestas.findByRespId", query = "SELECT p FROM PregRespuestas p WHERE p.respId = :respId"),
    @NamedQuery(name = "PregRespuestas.findByRespTextoRespuesta", query = "SELECT p FROM PregRespuestas p WHERE p.respTextoRespuesta = :respTextoRespuesta"),
    @NamedQuery(name = "PregRespuestas.findByRespEsCorrecta", query = "SELECT p FROM PregRespuestas p WHERE p.respEsCorrecta = :respEsCorrecta"),
    @NamedQuery(name = "PregRespuestas.findByResCantidadSelecionada", query = "SELECT p FROM PregRespuestas p WHERE p.resCantidadSelecionada = :resCantidadSelecionada"),
    @NamedQuery(name = "PregRespuestas.findByVersion", query = "SELECT p FROM PregRespuestas p WHERE p.version = :version")})
public class PregRespuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "PREG_RESPUESTAS_ID_GENERATOR", sequenceName = "PREG_RESPUESTAS_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_RESPUESTAS_ID_GENERATOR")
    @Id
    @Basic(optional = false)
    @Column(name = "RESP_ID")
    private BigDecimal respId;
    @Basic(optional = false)
    @Column(name = "RESP_TEXTO_RESPUESTA")
    private String respTextoRespuesta;
    @Basic(optional = false)
    @Column(name = "RESP_ES_CORRECTA")
    private String respEsCorrecta;
    @Basic(optional = false)
    @Column(name = "RES_CANTIDAD_SELECIONADA")
    private BigInteger resCantidadSelecionada;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private BigInteger version;
    @JoinColumn(name = "PRE_ID", referencedColumnName = "PRE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PregPreguntas preId;

    public PregRespuestas() {
    }

    public PregRespuestas(BigDecimal respId) {
        this.respId = respId;
    }

    public PregRespuestas(BigDecimal respId, String respTextoRespuesta, String respEsCorrecta, BigInteger resCantidadSelecionada, BigInteger version) {
        this.respId = respId;
        this.respTextoRespuesta = respTextoRespuesta;
        this.respEsCorrecta = respEsCorrecta;
        this.resCantidadSelecionada = resCantidadSelecionada;
        this.version = version;
    }

    public BigDecimal getRespId() {
        return respId;
    }

    public void setRespId(BigDecimal respId) {
        this.respId = respId;
    }

    public String getRespTextoRespuesta() {
        return respTextoRespuesta;
    }

    public void setRespTextoRespuesta(String respTextoRespuesta) {
        this.respTextoRespuesta = respTextoRespuesta;
    }

    public String getRespEsCorrecta() {
        return respEsCorrecta;
    }

    public void setRespEsCorrecta(String respEsCorrecta) {
        this.respEsCorrecta = respEsCorrecta;
    }

    public BigInteger getResCantidadSelecionada() {
        return resCantidadSelecionada;
    }

    public void setResCantidadSelecionada(BigInteger resCantidadSelecionada) {
        this.resCantidadSelecionada = resCantidadSelecionada;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public PregPreguntas getPreId() {
        return preId;
    }

    public void setPreId(PregPreguntas preId) {
        this.preId = preId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respId != null ? respId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregRespuestas)) {
            return false;
        }
        PregRespuestas other = (PregRespuestas) object;
        if ((this.respId == null && other.respId != null) || (this.respId != null && !this.respId.equals(other.respId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregRespuestas[ respId=" + respId + " ]";
    }
    
}
