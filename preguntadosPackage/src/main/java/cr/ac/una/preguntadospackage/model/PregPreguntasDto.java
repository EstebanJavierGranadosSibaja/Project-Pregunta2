package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class PregPreguntasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleStringProperty id;
    public SimpleStringProperty textoPregunta;
    public SimpleStringProperty cantidadRespuestas;
    public SimpleStringProperty cantidadAciertos;
    public SimpleStringProperty estado;
    private Long version;
    private Boolean modificado;
//    private List<PregPrinpartida> prinpartidaList;
//    private List<PregJugadores> jugadoresList;
//    private List<PregRespuestas> respuestasList;
//    private PregCategorias catId;

    public PregPreguntasDto() {
        this.id = new SimpleStringProperty("");
        this.textoPregunta = new SimpleStringProperty("");
        this.cantidadAciertos = new SimpleStringProperty("");
        this.cantidadRespuestas = new SimpleStringProperty("");
        this.estado = new SimpleStringProperty("");
        this.modificado = false;
    }

    public PregPreguntasDto(PregPreguntas pregPreguntas) {
        this();
        this.id.set(pregPreguntas.getId().toString());
        this.textoPregunta.set(pregPreguntas.getTextoPregunta());
        this.cantidadAciertos.set(pregPreguntas.getCantidadAciertos().toString());
        this.cantidadRespuestas.set(pregPreguntas.getCantidadRespuestas().toString());
        this.estado.set(pregPreguntas.getEstado());
    }

    public Long getId() {
        return Long.valueOf(id.get());
    }

    public void setId(Long id) {
        this.id.set(id.toString());
    }

    public String getTextoPregunta() {
        return textoPregunta.toString();
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta.set(textoPregunta);
    }

    public Long getCantidadRespuestas() {
        return Long.valueOf(cantidadRespuestas.get());
    }

    public void setCantidadRespuestas(Long cantidadRespuestas) {
        this.cantidadRespuestas.set(cantidadRespuestas.toString());
    }

    public Long getCantidadAciertos() {
        return Long.valueOf(cantidadAciertos.get());
    }

    public void setCantidadAciertos(Long cantidadAciertos) {
        this.cantidadAciertos.set(cantidadAciertos.toString());
    }

    public String getEstado() {
        return estado.toString();
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

//    public List<PregPrinpartida> getPrinpartidaList() {
//        return prinpartidaList;
//    }
//
//    public void setPrinpartidaList(List<PregPrinpartida> prinpartidaList) {
//        this.prinpartidaList = prinpartidaList;
//    }
//
//    public List<PregJugadores> getJugadoresList() {
//        return jugadoresList;
//    }
//
//    public void setJugadoresList(List<PregJugadores> jugadoresList) {
//        this.jugadoresList = jugadoresList;
//    }
//
//    public List<PregRespuestas> getRespuestasList() {
//        return respuestasList;
//    }
//
//    public void setRespuestasList(List<PregRespuestas> respuestasList) {
//        this.respuestasList = respuestasList;
//    }
//
//    public PregCategorias getCatId() {
//        return catId;
//    }
//
//    public void setCatId(PregCategorias catId) {
//        this.catId = catId;
//    }
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
