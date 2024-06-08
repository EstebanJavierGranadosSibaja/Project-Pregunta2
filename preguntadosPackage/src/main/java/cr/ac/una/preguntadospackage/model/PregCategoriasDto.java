/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class PregCategoriasDto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    public SimpleStringProperty id;
    public SimpleStringProperty categoria;
    public SimpleBooleanProperty estado;
    private Long version;
    private List<PregCategoriasjugador> pregCategoriasjugadorList;
    private List<PregPreguntas> pregPreguntasList;
    private Boolean modificado;

    
    public PregCategoriasDto() {
        this.id = new SimpleStringProperty("");
        this.categoria = new SimpleStringProperty("");
        this.estado = new SimpleBooleanProperty(true);

        this.modificado = false;
    }

    public PregCategoriasDto(PregCategorias pregCategorias) {
        this();
        this.id.set(pregCategorias.getId().toString());
        this.categoria.set(pregCategorias.getCategoria());
        this.estado.set(pregCategorias.getEstado().equals("S"));
        this.version = pregCategorias.getVersion();
    }

    public Long getId() {
          if (this.id.get() != null && !this.id.get().isBlank()) {
            return Long.valueOf(this.id.get());
        }
        return null;
    }

    public void setId(Long id) {
        this.id.set(id.toString());
    }

    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public SimpleStringProperty getSimpleCategoria(){
        return categoria;
    }
    
    public void getSimpleCategoria(SimpleStringProperty categoria){
        this.categoria = categoria;
    }
    
    public String getEstado() {
        return estado.get() ? "A" : "I";
    }

    public void setEstado(String estado) {
        this.estado.set(estado.equalsIgnoreCase("A"));
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
        if (!(object instanceof PregCategoriasDto)) {
            return false;
        }
        PregCategoriasDto other = (PregCategoriasDto) object;
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
