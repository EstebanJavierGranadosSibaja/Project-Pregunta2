/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
    @NamedQuery(name = "PregCategorias.findByCatId", query = "SELECT p FROM PregCategorias p WHERE p.id = :id"),
    @NamedQuery(name = "PregCategorias.findByCatCategoria", query = "SELECT p FROM PregCategorias p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "PregCategorias.findByCatEstado", query = "SELECT p FROM PregCategorias p WHERE p.estado = :estado"),
    @NamedQuery(name = "PregCategorias.findByCatVersion", query = "SELECT p FROM PregCategorias p WHERE p.version = :version")})
public class PregCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "PREG_CATEGORIAS_TGR01", sequenceName = "PREG_CATEGORIAS_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_CATEGORIAS_TGR01")
    @Id
    @Basic(optional = false)
    @Column(name = "CAT_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "CAT_CATEGORIA")
    private String categoria;
    @Basic(optional = false)
    @Column(name = "CAT_ESTADO")
    private String estado;
    @Version
    @Column(name = "CAT_VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregCategorias", fetch = FetchType.LAZY)
    private List<PregCategoriasjugador> pregCategoriasjugadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private List<PregPreguntas> pregPreguntasList;

    
    public PregCategorias() {
    }

    public PregCategorias(PregCategoriasDto pregCategoriasDto) {
        this.id = pregCategoriasDto.getId();
        Actualizar(pregCategoriasDto);
    }

    public void Actualizar(PregCategoriasDto pregCategoriasDto) {
        this.categoria = pregCategoriasDto.getCategoria();
        this.estado = pregCategoriasDto.getEstado();
        this.version = pregCategoriasDto.getVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long catId) {
        this.id = catId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<PregCategoriasjugador> getPregCategoriasjugadorList() {
        return pregCategoriasjugadorList;
    }

    public void setPregCategoriasjugadorList(List<PregCategoriasjugador> pregCategoriasjugadorList) {
        this.pregCategoriasjugadorList = pregCategoriasjugadorList;
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
