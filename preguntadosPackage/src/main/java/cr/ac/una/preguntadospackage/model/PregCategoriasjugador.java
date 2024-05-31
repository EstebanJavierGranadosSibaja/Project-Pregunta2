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
@Table(name = "PREG_CATEGORIASJUGADOR")
@NamedQueries({
    @NamedQuery(name = "PregCategoriasjugador.findAll", query = "SELECT p FROM PregCategoriasjugador p"),
    @NamedQuery(name = "PregCategoriasjugador.findByCajuId", query = "SELECT p FROM PregCategoriasjugador p WHERE p.id = :id"),
    @NamedQuery(name = "PregCategoriasjugador.findByCajuCantidadRespuestas", query = "SELECT p FROM PregCategoriasjugador p WHERE p.cantidadRespuestas = :cantidadRespuestas"),
    @NamedQuery(name = "PregCategoriasjugador.findByCajuCantidadAcertada", query = "SELECT p FROM PregCategoriasjugador p WHERE p.cantidadAcertada = :cantidadAcertada")})
public class PregCategoriasjugador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "PREG_CATEGORIASJUGADOR_TGR01", sequenceName = "PREG_CATEGORIASJUGADOR_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_CATEGORIASJUGADOR_TGR01")
    @Id
    @Basic(optional = false)
    @Column(name = "CAJU_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "CAJU_CANTIDAD_RESPUESTAS")
    private Long cantidadRespuestas;
    @Basic(optional = false)
    @Column(name = "CAJU_CANTIDAD_ACERTADA")
    private Long cantidadAcertada;
    @JoinColumn(name = "CAJU_IDCAT", referencedColumnName = "CAT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregCategorias cajuIdcat;
    @JoinColumn(name = "CAJU_IDJUG", referencedColumnName = "JUG_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregJugadores cajuIdjug;

   public PregCategoriasjugador() {
    }

    public PregCategoriasjugador(PregCategoriasjugadorDto pregCategoriasjugadorDto) {
        this.id = pregCategoriasjugadorDto.getId();
        Actualizar(pregCategoriasjugadorDto);
    }

    public void Actualizar(PregCategoriasjugadorDto pregCategoriasjugadorDto) {
        this.cantidadRespuestas = pregCategoriasjugadorDto.getCantidadRespuestas();
        this.cantidadAcertada = pregCategoriasjugadorDto.getCantidadAcertada();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidadRespuestas() {
        return cantidadRespuestas;
    }

    public void setCantidadRespuestas(Long cantidadRespuestas) {
        this.cantidadRespuestas = cantidadRespuestas;
    }

    public Long getCantidadAcertada() {
        return cantidadAcertada;
    }

    public void setCantidadAcertada(Long cantidadAcertada) {
        this.cantidadAcertada = cantidadAcertada;
    }

    public PregCategorias getCajuIdCat() {
        return cajuIdcat;
    }

    public void setCajuIdCat(PregCategorias cajuIdcat) {
        this.cajuIdcat = cajuIdcat;
    }

    public PregJugadores getCajuIdjug() {
        return cajuIdjug;
    }

    public void setCajuIdjug(PregJugadores cajuIdjug) {
        this.cajuIdjug = cajuIdjug;
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
        if (!(object instanceof PregCategoriasjugador)) {
            return false;
        }
        PregCategoriasjugador other = (PregCategoriasjugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregCategoriasjugador[ cajuId=" + id + " ]";
    }
}
