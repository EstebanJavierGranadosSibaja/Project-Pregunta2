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
import jakarta.persistence.OneToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author esteb
 */
@Entity
@Table (name = "preg_categorias")
@NamedQueries({
    @NamedQuery(name = "PregCategorias.findAll", query = "SELECT p FROM PregCategorias p"),
    @NamedQuery(name = "PregCategorias.findByCatId", query = "SELECT p FROM PregCategorias p WHERE p.catId = :catId"),
    @NamedQuery(name = "PregCategorias.findByCatCategoria", query = "SELECT p FROM PregCategorias p WHERE p.catCategoria = :catCategoria"),
    @NamedQuery(name = "PregCategorias.findByCatCantidadRespondidas", query = "SELECT p FROM PregCategorias p WHERE p.catCantidadRespondidas = :catCantidadRespondidas"),
    @NamedQuery(name = "PregCategorias.findByCatCantidadAciertos", query = "SELECT p FROM PregCategorias p WHERE p.catCantidadAciertos = :catCantidadAciertos")})
public class PregCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Long catId;
    @Basic(optional = false)
    @Column(name = "cat_categoria")
    private String catCategoria;
    @Basic(optional = false)
    @Column(name = "cat_cantidad_respondidas")
    private Long catCantidadRespondidas;
    @Basic(optional = false)
    @Column(name = "cat_cantidad_aciertos")
    private Long catCantidadAciertos;
    @OneToMany(mappedBy = "catId")
    private List<PregPreguntas> pregPreguntasList;

    public PregCategorias() {
    }

    public PregCategorias(BigDecimal catId) {
        this.catId = catId;
    }

    public PregCategorias(BigDecimal catId, String catCategoria, BigInteger catCantidadRespondidas, BigInteger catCantidadAciertos) {
        this.catId = catId;
        this.catCategoria = catCategoria;
        this.catCantidadRespondidas = catCantidadRespondidas;
        this.catCantidadAciertos = catCantidadAciertos;
    }

    public BigDecimal getCatId() {
        return catId;
    }

    public void setCatId(BigDecimal catId) {
        this.catId = catId;
    }

    public String getCatCategoria() {
        return catCategoria;
    }

    public void setCatCategoria(String catCategoria) {
        this.catCategoria = catCategoria;
    }

    public BigInteger getCatCantidadRespondidas() {
        return catCantidadRespondidas;
    }

    public void setCatCantidadRespondidas(BigInteger catCantidadRespondidas) {
        this.catCantidadRespondidas = catCantidadRespondidas;
    }

    public BigInteger getCatCantidadAciertos() {
        return catCantidadAciertos;
    }

    public void setCatCantidadAciertos(BigInteger catCantidadAciertos) {
        this.catCantidadAciertos = catCantidadAciertos;
    }

    public List<PregPreguntas> getPregPreguntasList() {
        return pregPreguntasList;
    }

    public void setPregPreguntasList(List<PregPreguntas> pregPreguntasList) {
        this.pregPreguntasList = pregPreguntasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregCategorias)) {
            return false;
        }
        PregCategorias other = (PregCategorias) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregCategorias[ catId=" + catId + " ]";
    }
    
}
