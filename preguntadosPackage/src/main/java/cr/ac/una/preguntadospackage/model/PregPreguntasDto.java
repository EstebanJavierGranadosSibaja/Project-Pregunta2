
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class PregPreguntasDto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   
    public SimpleStringProperty id;
    public SimpleStringProperty textoPregunta;
    public SimpleStringProperty cantidadRespuestas;
    public SimpleStringProperty cantidadAciertos;
    public SimpleBooleanProperty estado;
    private Long version;
    private Boolean modificado;
    private List<PregPreguntaspartida> pregPreguntaspartidaList;
    private List<PregRespuestas> pregRespuestasList;
    private PregCategorias catId;

    public PregPreguntasDto() {
        this.id = new SimpleStringProperty("");
        this.textoPregunta = new SimpleStringProperty("");
        this.cantidadRespuestas = new SimpleStringProperty("");
        this.cantidadAciertos = new SimpleStringProperty("");
        this.estado = new SimpleBooleanProperty(true);
        this.modificado = false;
    }

    public PregPreguntasDto(PregPreguntas pregPreguntas) {
        this();
        this.id.set(pregPreguntas.getId().toString());
        this.textoPregunta.set(pregPreguntas.getTextoPregunta());
        this.cantidadRespuestas.set(pregPreguntas.getCantidadRespuestas().toString());
        this.cantidadAciertos.set(pregPreguntas.getCantidadAciertos().toString());
        this.estado.set(pregPreguntas.getEstado().equals("A"));
        this.version = pregPreguntas.getVersion();
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

    public String getTextoPregunta() {
        return textoPregunta.get();
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta.set(textoPregunta);
    }

    public Long getCantidadRespuestas() {
        return Long.valueOf(cantidadRespuestas.get());
    }

    public void setCantidadRespuestas(Long cantidadRespuestas) {
        this.cantidadRespuestas.set(cantidadRespuestas.toString());;
    }

    public Long getCantidadAciertos() {
        return Long.valueOf(cantidadAciertos.get());
    }

    public void setCantidadAciertos(Long cantidadAciertos) {
        this.cantidadAciertos.set(cantidadAciertos.toString());
    }

    public String getEstado() {
        return estado.get()?"A":"I";
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

    public List<PregPreguntaspartida> getPregPreguntaspartidaList() {
        return pregPreguntaspartidaList;
    }

    public void setPregPreguntaspartidaList(List<PregPreguntaspartida> pregPreguntaspartidaList) {
        this.pregPreguntaspartidaList = pregPreguntaspartidaList;
    }

    public List<PregRespuestas> getPregRespuestasList() {
        return pregRespuestasList;
    }

    public void setPregRespuestasList(List<PregRespuestas> pregRespuestasList) {
        this.pregRespuestasList = pregRespuestasList;
    }

    public PregCategorias getCatId() {
        return catId;
    }

    public void setCatId(PregCategorias catId) {
        this.catId = catId;
    }
    
     public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
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
        if (!(object instanceof PregPreguntasDto)) {
            return false;
        }
        PregPreguntasDto other = (PregPreguntasDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregPreguntas[ preId=" + id + " ]";
    }
    
}
