/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "PREG_CATEGORIAS")
@NamedQueries({
    @NamedQuery(name = "PregCategorias.findAll", query = "SELECT p FROM PregCategorias p"),
    @NamedQuery(name = "PregCategorias.findByCatId", query = "SELECT p FROM PregCategorias p WHERE p.catId = :catId"),
    @NamedQuery(name = "PregCategorias.findByCatCantidadRespondidas", query = "SELECT p FROM PregCategorias p WHERE p.catCantidadRespondidas = :catCantidadRespondidas"),
    @NamedQuery(name = "PregCategorias.findByCatCantidadAciertos", query = "SELECT p FROM PregCategorias p WHERE p.catCantidadAciertos = :catCantidadAciertos")})
public class PregCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CAT_ID")
    private String catId;
    @Basic(optional = false)
    @Column(name = "CAT_CANTIDAD_RESPONDIDAS")
    private BigInteger catCantidadRespondidas;
    @Basic(optional = false)
    @Column(name = "CAT_CANTIDAD_ACIERTOS")
    private BigInteger catCantidadAciertos;
    @ManyToMany(mappedBy = "pregCategoriasList", fetch = FetchType.LAZY)
    private List<PregJugadores> pregJugadoresList;
    @OneToMany(mappedBy = "catId", fetch = FetchType.LAZY)
    private List<PregPreguntas> pregPreguntasList;

    public PregCategorias() {
    }

    public PregCategorias(String catId) {
        this.catId = catId;
    }

    public PregCategorias(String catId, BigInteger catCantidadRespondidas, BigInteger catCantidadAciertos) {
        this.catId = catId;
        this.catCantidadRespondidas = catCantidadRespondidas;
        this.catCantidadAciertos = catCantidadAciertos;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
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

    public List<PregJugadores> getPregJugadoresList() {
        return pregJugadoresList;
    }

    public void setPregJugadoresList(List<PregJugadores> pregJugadoresList) {
        this.pregJugadoresList = pregJugadoresList;
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
