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
@Table(name = "PREG_CATEGORIASJUGADOR")
@NamedQueries({
    @NamedQuery(name = "PregCategoriasjugador.findAll", query = "SELECT p FROM PregCategoriasjugador p"),
    @NamedQuery(name = "PregCategoriasjugador.findByCajuId", query = "SELECT p FROM PregCategoriasjugador p WHERE p.pregCategoriasjugadorPK.cajuId = :cajuId"),
    @NamedQuery(name = "PregCategoriasjugador.findByCajuCantidadRespuestas", query = "SELECT p FROM PregCategoriasjugador p WHERE p.cajuCantidadRespuestas = :cajuCantidadRespuestas"),
    @NamedQuery(name = "PregCategoriasjugador.findByCajuCantidadAcertada", query = "SELECT p FROM PregCategoriasjugador p WHERE p.cajuCantidadAcertada = :cajuCantidadAcertada"),
    @NamedQuery(name = "PregCategoriasjugador.findByCxjIdjug", query = "SELECT p FROM PregCategoriasjugador p WHERE p.pregCategoriasjugadorPK.cxjIdjug = :cxjIdjug"),
    @NamedQuery(name = "PregCategoriasjugador.findByCxjIdcat", query = "SELECT p FROM PregCategoriasjugador p WHERE p.pregCategoriasjugadorPK.cxjIdcat = :cxjIdcat")})
public class PregCategoriasjugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PregCategoriasjugadorPK pregCategoriasjugadorPK;
    @Basic(optional = false)
    @Column(name = "CAJU_CANTIDAD_RESPUESTAS")
    private BigInteger cajuCantidadRespuestas;
    @Basic(optional = false)
    @Column(name = "CAJU_CANTIDAD_ACERTADA")
    private BigInteger cajuCantidadAcertada;
    @JoinColumn(name = "CXJ_IDCAT", referencedColumnName = "CAT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregCategorias pregCategorias;
    @JoinColumn(name = "CXJ_IDJUG", referencedColumnName = "JUG_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregJugadores pregJugadores;

    public PregCategoriasjugador() {
    }

    public PregCategoriasjugador(PregCategoriasjugadorPK pregCategoriasjugadorPK) {
        this.pregCategoriasjugadorPK = pregCategoriasjugadorPK;
    }

    public PregCategoriasjugador(PregCategoriasjugadorPK pregCategoriasjugadorPK, BigInteger cajuCantidadRespuestas, BigInteger cajuCantidadAcertada) {
        this.pregCategoriasjugadorPK = pregCategoriasjugadorPK;
        this.cajuCantidadRespuestas = cajuCantidadRespuestas;
        this.cajuCantidadAcertada = cajuCantidadAcertada;
    }

    public PregCategoriasjugador(BigInteger cajuId, BigInteger cxjIdjug, BigInteger cxjIdcat) {
        this.pregCategoriasjugadorPK = new PregCategoriasjugadorPK(cajuId, cxjIdjug, cxjIdcat);
    }

    public PregCategoriasjugadorPK getPregCategoriasjugadorPK() {
        return pregCategoriasjugadorPK;
    }

    public void setPregCategoriasjugadorPK(PregCategoriasjugadorPK pregCategoriasjugadorPK) {
        this.pregCategoriasjugadorPK = pregCategoriasjugadorPK;
    }

    public BigInteger getCajuCantidadRespuestas() {
        return cajuCantidadRespuestas;
    }

    public void setCajuCantidadRespuestas(BigInteger cajuCantidadRespuestas) {
        this.cajuCantidadRespuestas = cajuCantidadRespuestas;
    }

    public BigInteger getCajuCantidadAcertada() {
        return cajuCantidadAcertada;
    }

    public void setCajuCantidadAcertada(BigInteger cajuCantidadAcertada) {
        this.cajuCantidadAcertada = cajuCantidadAcertada;
    }

    public PregCategorias getPregCategorias() {
        return pregCategorias;
    }

    public void setPregCategorias(PregCategorias pregCategorias) {
        this.pregCategorias = pregCategorias;
    }

    public PregJugadores getPregJugadores() {
        return pregJugadores;
    }

    public void setPregJugadores(PregJugadores pregJugadores) {
        this.pregJugadores = pregJugadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pregCategoriasjugadorPK != null ? pregCategoriasjugadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregCategoriasjugador)) {
            return false;
        }
        PregCategoriasjugador other = (PregCategoriasjugador) object;
        if ((this.pregCategoriasjugadorPK == null && other.pregCategoriasjugadorPK != null) || (this.pregCategoriasjugadorPK != null && !this.pregCategoriasjugadorPK.equals(other.pregCategoriasjugadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregCategoriasjugador[ pregCategoriasjugadorPK=" + pregCategoriasjugadorPK + " ]";
    }
    
}
