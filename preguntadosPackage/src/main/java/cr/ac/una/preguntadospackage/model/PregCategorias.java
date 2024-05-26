package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PREG_CATEGORIAS")
@NamedQueries({
    /*@NamedQuery(name = "PregCategorias.findAll", query = "SELECT p FROM PregCategorias p"),
    @NamedQuery(name = "PregCategorias.findByCatId", query = "SELECT p FROM PregCategorias p WHERE p.catId = :catId"),
    @NamedQuery(name = "PregCategorias.findByCatCantidadRespondidas", query = "SELECT p FROM PregCategorias p WHERE p.catCantidadRespondidas = :catCantidadRespondidas"),
    @NamedQuery(name = "PregCategorias.findByCatCantidadAciertos", query = "SELECT p FROM PregCategorias p WHERE p.catCantidadAciertos = :catCantidadAciertos")*/
})
public class PregCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CAT_ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "CAT_CANTIDAD_RESPONDIDAS")
    private Long cantidadRespondidas;
    @Basic(optional = false)
    @Column(name = "CAT_CANTIDAD_ACIERTOS")
    private Long cantidadAciertos;
    @ManyToMany(mappedBy = "categoriasList", fetch = FetchType.LAZY)
    private List<PregJugadores> jugadoresList;
    @OneToMany(mappedBy = "catId", fetch = FetchType.LAZY)
    private List<PregPreguntas> preguntasList;

    public PregCategorias() {
    }
    
    public PregCategorias(PregCategoriasDto pregCategoriasDto) {
        this.id = pregCategoriasDto.getId();
         Actualizar(pregCategoriasDto);
    }
    
    public void Actualizar(PregCategoriasDto pregCategoriasDto) {
       this.cantidadAciertos = pregCategoriasDto.getCantidadAciertos();
       this.cantidadRespondidas = pregCategoriasDto.getCantidadRespondidas();
    }

    public PregCategorias(String catId) {
        this.id = catId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCantidadRespondidas() {
        return cantidadRespondidas;
    }

    public void setCantidadRespondidas(Long cantidadRespondidas) {
        this.cantidadRespondidas = cantidadRespondidas;
    }

    public Long getCantidadAciertos() {
        return cantidadAciertos;
    }

    public void setCantidadAciertos(Long cantidadAciertos) {
        this.cantidadAciertos = cantidadAciertos;
    }

    public List<PregJugadores> getJugadoresList() {
        return jugadoresList;
    }

    public void setJugadoresList(List<PregJugadores> jugadoresList) {
        this.jugadoresList = jugadoresList;
    }

    public List<PregPreguntas> getPreguntasList() {
        return preguntasList;
    }

    public void setPreguntasList(List<PregPreguntas> preguntasList) {
        this.preguntasList = preguntasList;
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
        if (!(object instanceof PregCategorias)) {
            return false;
        }
        PregCategorias other = (PregCategorias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregCategorias[ catId=" + id + " ]";
    }
    
}
