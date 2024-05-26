package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;

public class PregCategoriasDto  implements Serializable {

    private static final long serialVersionUID = 1L;
    public SimpleStringProperty id;
    public SimpleStringProperty cantidadRespondidas;
    public SimpleStringProperty cantidadAciertos;
    private Boolean modificado;

    public PregCategoriasDto() {
        this.id = new SimpleStringProperty("");
        this.cantidadRespondidas = new SimpleStringProperty("");
        this.cantidadAciertos = new SimpleStringProperty("");
        this.modificado = false; 
    }

    public PregCategoriasDto(PregCategorias pregCategorias) {
        this();
        this.id.set(pregCategorias.getId());
        this.cantidadRespondidas.set(pregCategorias.getCantidadRespondidas().toString());
        this.cantidadAciertos.set(pregCategorias.getCantidadAciertos().toString());
    }

    public String getId() {
        if (this.id.get() != null && !this.id.get().isBlank()) {
            return id.toString();
        }
        return null;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public Long getCantidadRespondidas() {
        return Long.valueOf(cantidadRespondidas.get());
    }

    public void setCantidadRespondidas(Long cantidadRespondidas) {
        this.cantidadRespondidas.set(cantidadRespondidas.toString());
    }

    public Long getCantidadAciertos() {
        return Long.valueOf(cantidadAciertos.get());
    }

    public void setCantidadAciertos(Long cantidadAciertos) {
        this.cantidadAciertos.set(cantidadAciertos.toString());
    }
    
    public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }

//    public List<PregJugadores> getJugadoresList() {
//        return jugadoresList;
//    }
//
//    public void setJugadoresList(List<PregJugadores> jugadoresList) {
//        this.jugadoresList = jugadoresList;
//    }
//
//    public List<PregPreguntas> getPreguntasList() {
//        return preguntasList;
//    }
//
//    public void setPreguntasList(List<PregPreguntas> preguntasList) {
//        this.preguntasList = preguntasList;
//    }
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
