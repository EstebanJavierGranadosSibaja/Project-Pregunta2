package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class PregRespuestasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleStringProperty id;
    public SimpleStringProperty textoRespuesta;
    public SimpleBooleanProperty esCorrecta;
    public SimpleStringProperty cantidadSelecionada;
    private Long version;
    private Boolean modificado;
    private PregPreguntas preId;

    public PregRespuestasDto() {
        this.id = new SimpleStringProperty("");
        this.textoRespuesta = new SimpleStringProperty("");
        this.esCorrecta = new SimpleBooleanProperty(true);
        this.cantidadSelecionada = new SimpleStringProperty("");
        this.modificado = false;
    }

    public PregRespuestasDto(PregRespuestas pregRespuestas) {
        this();
        this.id.set(pregRespuestas.getId().toString());
        this.textoRespuesta.set(pregRespuestas.getTextoRespuesta());
        this.esCorrecta.set(pregRespuestas.getEsCorrecta().equals("T"));
        this.cantidadSelecionada.set(pregRespuestas.getCantidadSelecionada().toString());
        this.version = pregRespuestas.getVersion();
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

    public String getTextoRespuesta() {
        return textoRespuesta.get();
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta.set(textoRespuesta);
    }

    public String getEsCorrecta() {
        return esCorrecta.get()?"T":"F";
    }

    public void setEsCorrecta(String esCorrecta) {
        this.esCorrecta.set(esCorrecta.equalsIgnoreCase("T"));
    }

    public Long getCantidadSelecionada() {
        return Long.valueOf(cantidadSelecionada.get());
    }

    public void setCantidadSelecionada(Long cantidadSelecionada) {
        this.cantidadSelecionada.set(cantidadSelecionada.toString());
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public PregPreguntas getPreId() {
        return preId;
    }

    public void setPreId(PregPreguntas preId) {
        this.preId = preId;
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
        if (!(object instanceof PregRespuestasDto)) {
            return false;
        }
        PregRespuestasDto other = (PregRespuestasDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregRespuestas[ respId=" + id + " ]";
    }

}
