/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "PREG_PREGUNTASPARTIDA")
@NamedQueries({
    @NamedQuery(name = "PregPreguntaspartida.findAll", query = "SELECT p FROM PregPreguntaspartida p"),
    @NamedQuery(name = "PregPreguntaspartida.findByPrpaId", query = "SELECT p FROM PregPreguntaspartida p WHERE p.pregPreguntaspartidaPK.prpaId = :prpaId"),
    @NamedQuery(name = "PregPreguntaspartida.findByPrpaEstadoRespondida", query = "SELECT p FROM PregPreguntaspartida p WHERE p.prpaEstadoRespondida = :prpaEstadoRespondida"),
    @NamedQuery(name = "PregPreguntaspartida.findByPxpIdpre", query = "SELECT p FROM PregPreguntaspartida p WHERE p.pregPreguntaspartidaPK.pxpIdpre = :pxpIdpre"),
    @NamedQuery(name = "PregPreguntaspartida.findByPxpIdppar", query = "SELECT p FROM PregPreguntaspartida p WHERE p.pregPreguntaspartidaPK.pxpIdppar = :pxpIdppar")})
public class PregPreguntaspartida implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PregPreguntaspartidaPK pregPreguntaspartidaPK;
    @Basic(optional = false)
    @Column(name = "PRPA_ESTADO_RESPONDIDA")
    private String prpaEstadoRespondida;
    @JoinColumn(name = "PXP_IDPRE", referencedColumnName = "PRE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregPreguntas pregPreguntas;
    @JoinColumn(name = "PXP_IDPPAR", referencedColumnName = "PPAR_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregPrinpartida pregPrinpartida;

    public PregPreguntaspartida() {
    }

    public PregPreguntaspartida(PregPreguntaspartidaPK pregPreguntaspartidaPK) {
        this.pregPreguntaspartidaPK = pregPreguntaspartidaPK;
    }

    public PregPreguntaspartida(PregPreguntaspartidaPK pregPreguntaspartidaPK, String prpaEstadoRespondida) {
        this.pregPreguntaspartidaPK = pregPreguntaspartidaPK;
        this.prpaEstadoRespondida = prpaEstadoRespondida;
    }

    public PregPreguntaspartida(BigInteger prpaId, BigInteger pxpIdpre, BigInteger pxpIdppar) {
        this.pregPreguntaspartidaPK = new PregPreguntaspartidaPK(prpaId, pxpIdpre, pxpIdppar);
    }

    public PregPreguntaspartidaPK getPregPreguntaspartidaPK() {
        return pregPreguntaspartidaPK;
    }

    public void setPregPreguntaspartidaPK(PregPreguntaspartidaPK pregPreguntaspartidaPK) {
        this.pregPreguntaspartidaPK = pregPreguntaspartidaPK;
    }

    public String getPrpaEstadoRespondida() {
        return prpaEstadoRespondida;
    }

    public void setPrpaEstadoRespondida(String prpaEstadoRespondida) {
        this.prpaEstadoRespondida = prpaEstadoRespondida;
    }

    public PregPreguntas getPregPreguntas() {
        return pregPreguntas;
    }

    public void setPregPreguntas(PregPreguntas pregPreguntas) {
        this.pregPreguntas = pregPreguntas;
    }

    public PregPrinpartida getPregPrinpartida() {
        return pregPrinpartida;
    }

    public void setPregPrinpartida(PregPrinpartida pregPrinpartida) {
        this.pregPrinpartida = pregPrinpartida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pregPreguntaspartidaPK != null ? pregPreguntaspartidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregPreguntaspartida)) {
            return false;
        }
        PregPreguntaspartida other = (PregPreguntaspartida) object;
        if ((this.pregPreguntaspartidaPK == null && other.pregPreguntaspartidaPK != null) || (this.pregPreguntaspartidaPK != null && !this.pregPreguntaspartidaPK.equals(other.pregPreguntaspartidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregPreguntaspartida[ pregPreguntaspartidaPK=" + pregPreguntaspartidaPK + " ]";
    }
    
}
