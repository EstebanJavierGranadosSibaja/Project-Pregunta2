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
public class PregCategoriasjugadorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CAJU_ID")
    private BigInteger cajuId;
    @Basic(optional = false)
    @Column(name = "CXJ_IDJUG")
    private BigInteger cxjIdjug;
    @Basic(optional = false)
    @Column(name = "CXJ_IDCAT")
    private BigInteger cxjIdcat;

    public PregCategoriasjugadorPK() {
    }

    public PregCategoriasjugadorPK(BigInteger cajuId, BigInteger cxjIdjug, BigInteger cxjIdcat) {
        this.cajuId = cajuId;
        this.cxjIdjug = cxjIdjug;
        this.cxjIdcat = cxjIdcat;
    }

    public BigInteger getCajuId() {
        return cajuId;
    }

    public void setCajuId(BigInteger cajuId) {
        this.cajuId = cajuId;
    }

    public BigInteger getCxjIdjug() {
        return cxjIdjug;
    }

    public void setCxjIdjug(BigInteger cxjIdjug) {
        this.cxjIdjug = cxjIdjug;
    }

    public BigInteger getCxjIdcat() {
        return cxjIdcat;
    }

    public void setCxjIdcat(BigInteger cxjIdcat) {
        this.cxjIdcat = cxjIdcat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajuId != null ? cajuId.hashCode() : 0);
        hash += (cxjIdjug != null ? cxjIdjug.hashCode() : 0);
        hash += (cxjIdcat != null ? cxjIdcat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregCategoriasjugadorPK)) {
            return false;
        }
        PregCategoriasjugadorPK other = (PregCategoriasjugadorPK) object;
        if ((this.cajuId == null && other.cajuId != null) || (this.cajuId != null && !this.cajuId.equals(other.cajuId))) {
            return false;
        }
        if ((this.cxjIdjug == null && other.cxjIdjug != null) || (this.cxjIdjug != null && !this.cxjIdjug.equals(other.cxjIdjug))) {
            return false;
        }
        if ((this.cxjIdcat == null && other.cxjIdcat != null) || (this.cxjIdcat != null && !this.cxjIdcat.equals(other.cxjIdcat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregCategoriasjugadorPK[ cajuId=" + cajuId + ", cxjIdjug=" + cxjIdjug + ", cxjIdcat=" + cxjIdcat + " ]";
    }
    
}
