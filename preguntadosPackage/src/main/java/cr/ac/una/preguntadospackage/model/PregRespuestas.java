/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.persistence.*;

/**
 * Author: esteb
 */
@Entity
@Table(name = "preg_respuestas")
@NamedQueries({
        @NamedQuery(name = "PregRespuestas.findAll", query = "SELECT p FROM PregRespuestas p"),
        @NamedQuery(name = "PregRespuestas.findByResId", query = "SELECT p FROM PregRespuestas p WHERE p.resId = :resId"),
        @NamedQuery(name = "PregRespuestas.findByResRespuesta", query = "SELECT p FROM PregRespuestas p WHERE p.resRespuesta = :resRespuesta"),
        @NamedQuery(name = "PregRespuestas.findByResEsCorrecta", query = "SELECT p FROM PregRespuestas p WHERE p.resEsCorrecta = :resEsCorrecta"),
        @NamedQuery(name = "PregRespuestas.findByResCantidadSeleccionada", query = "SELECT p FROM PregRespuestas p WHERE p.resCantidadSeleccionada = :resCantidadSeleccionada")
})
public class PregRespuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "res_id")
    private BigDecimal resId;

    @Basic(optional = false)
    @Column(name = "res_respuesta")
    private String resRespuesta;

    @Basic(optional = false)
    @Column(name = "res_es_correcta")
    private Character resEsCorrecta;

    @Basic(optional = false)
    @Column(name = "res_cantidad_seleccionada")
    private BigInteger resCantidadSeleccionada;

    @JoinColumn(name = "pre_id", referencedColumnName = "pre_id")
    @ManyToOne
    private PregPreguntas preId;

    public PregRespuestas() {
    }

    public PregRespuestas(BigDecimal resId) {
        this.resId = resId;
    }

    public PregRespuestas(BigDecimal resId, String resRespuesta, Character resEsCorrecta, BigInteger resCantidadSeleccionada) {
        this.resId = resId;
        this.resRespuesta = resRespuesta;
        this.resEsCorrecta = resEsCorrecta;
        this.resCantidadSeleccionada = resCantidadSeleccionada;
    }

    public BigDecimal getResId() {
        return resId;
    }

    public void setResId(BigDecimal resId) {
        this.resId = resId;
    }

    public String getResRespuesta() {
        return resRespuesta;
    }

    public void setResRespuesta(String resRespuesta) {
        this.resRespuesta = resRespuesta;
    }

    public Character getResEsCorrecta() {
        return resEsCorrecta;
    }

    public void setResEsCorrecta(Character resEsCorrecta) {
        this.resEsCorrecta = resEsCorrecta;
    }

    public BigInteger getResCantidadSeleccionada() {
        return resCantidadSeleccionada;
    }

    public void setResCantidadSeleccionada(BigInteger resCantidadSeleccionada) {
        this.resCantidadSeleccionada = resCantidadSeleccionada;
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
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregRespuestas)) {
            return false;
        }
        PregRespuestas other = (PregRespuestas) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregRespuestas[ resId=" + resId + " ]";
    }
}
