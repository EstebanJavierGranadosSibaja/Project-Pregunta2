/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author esteb
 */
@Embeddable
public class PregPreguntaspartidaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PRPA_ID")
    private BigInteger prpaId;
    @Basic(optional = false)
    @Column(name = "PXP_IDPRE")
    private BigInteger pxpIdpre;
    @Basic(optional = false)
    @Column(name = "PXP_IDPPAR")
    private BigInteger pxpIdppar;

    public PregPreguntaspartidaPK() {
    }

    public PregPreguntaspartidaPK(BigInteger prpaId, BigInteger pxpIdpre, BigInteger pxpIdppar) {
        this.prpaId = prpaId;
        this.pxpIdpre = pxpIdpre;
        this.pxpIdppar = pxpIdppar;
    }

    public BigInteger getPrpaId() {
        return prpaId;
    }

    public void setPrpaId(BigInteger prpaId) {
        this.prpaId = prpaId;
    }

    public BigInteger getPxpIdpre() {
        return pxpIdpre;
    }

    public void setPxpIdpre(BigInteger pxpIdpre) {
        this.pxpIdpre = pxpIdpre;
    }

    public BigInteger getPxpIdppar() {
        return pxpIdppar;
    }

    public void setPxpIdppar(BigInteger pxpIdppar) {
        this.pxpIdppar = pxpIdppar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prpaId != null ? prpaId.hashCode() : 0);
        hash += (pxpIdpre != null ? pxpIdpre.hashCode() : 0);
        hash += (pxpIdppar != null ? pxpIdppar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregPreguntaspartidaPK)) {
            return false;
        }
        PregPreguntaspartidaPK other = (PregPreguntaspartidaPK) object;
        if ((this.prpaId == null && other.prpaId != null) || (this.prpaId != null && !this.prpaId.equals(other.prpaId))) {
            return false;
        }
        if ((this.pxpIdpre == null && other.pxpIdpre != null) || (this.pxpIdpre != null && !this.pxpIdpre.equals(other.pxpIdpre))) {
            return false;
        }
        if ((this.pxpIdppar == null && other.pxpIdppar != null) || (this.pxpIdppar != null && !this.pxpIdppar.equals(other.pxpIdppar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregPreguntaspartidaPK[ prpaId=" + prpaId + ", pxpIdpre=" + pxpIdpre + ", pxpIdppar=" + pxpIdppar + " ]";
    }
    
}
