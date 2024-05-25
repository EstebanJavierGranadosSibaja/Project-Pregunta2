package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Entity representing categories in the Preguntados game.
 * Author: esteb
 */
@Entity
@Table(name = "preg_categorias")
@NamedQueries({
        @NamedQuery(name = "PregCategorias.findAll", query = "SELECT p FROM PregCategorias p"),
        @NamedQuery(name = "PregCategorias.findByCatId", query = "SELECT p FROM PregCategorias p WHERE p.catId = :catId"),
        @NamedQuery(name = "PregCategorias.findByCatCategoria", query = "SELECT p FROM PregCategorias p WHERE p.catCategoria = :catCategoria"),
        @NamedQuery(name = "PregCategorias.findByCatCantidadRespondidas", query = "SELECT p FROM PregCategorias p WHERE p.catCantidadRespondidas = :catCantidadRespondidas"),
        @NamedQuery(name = "PregCategorias.findByCatCantidadAciertos", query = "SELECT p FROM PregCategorias p WHERE p.catCantidadAciertos = :catCantidadAciertos")
})
public class PregCategorias implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public PregCategorias(Long catId) {
        this.catId = catId;
    }

    public PregCategorias(Long catId, String catCategoria, Long catCantidadRespondidas, Long catCantidadAciertos) {
        this.catId = catId;
        this.catCategoria = catCategoria;
        this.catCantidadRespondidas = catCantidadRespondidas;
        this.catCantidadAciertos = catCantidadAciertos;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatCategoria() {
        return catCategoria;
    }

    public void setCatCategoria(String catCategoria) {
        this.catCategoria = catCategoria;
    }

    public Long getCatCantidadRespondidas() {
        return catCantidadRespondidas;
    }

    public void setCatCantidadRespondidas(Long catCantidadRespondidas) {
        this.catCantidadRespondidas = catCantidadRespondidas;
    }

    public Long getCatCantidadAciertos() {
        return catCantidadAciertos;
    }

    public void setCatCantidadAciertos(Long catCantidadAciertos) {
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
