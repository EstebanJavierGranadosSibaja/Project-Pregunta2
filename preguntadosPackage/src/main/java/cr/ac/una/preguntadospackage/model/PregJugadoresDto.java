package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;

public class PregJugadoresDto implements Serializable {

    private static final long serialVersionUID = 1L;
    public SimpleStringProperty id;
    public SimpleStringProperty nombre;
    public SimpleStringProperty partidasJugadas;
    public SimpleStringProperty partidasGanadas;
    public SimpleStringProperty cantidadRespuestasGeneral;
    public SimpleStringProperty cantidadAcertadasGeneral;
    private Boolean modificado;
//    private List<PregCategorias> categoriasList;
//    private List<PregPreguntas> preguntasList;
//    private List<PregJugpartida> jugpartidaList;

    public PregJugadoresDto() {
        this.id = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.partidasJugadas = new SimpleStringProperty();
        this.partidasGanadas = new SimpleStringProperty();
        this.cantidadRespuestasGeneral = new SimpleStringProperty();
        this.cantidadAcertadasGeneral = new SimpleStringProperty();
        this.modificado = false;
    }

    public PregJugadoresDto(PregJugadores pregJugadores) {
        this();
        this.id.set(pregJugadores.getId().toString());
        this.nombre.set(pregJugadores.getNombre());
        this.partidasJugadas.set(pregJugadores.getPartidasJugadas().toString());
        this.partidasGanadas.set(pregJugadores.getPartidasGanadas().toString());
        this.cantidadRespuestasGeneral.set(pregJugadores.getCantidadRespuestasGeneral().toString());
        this.cantidadAcertadasGeneral.set(pregJugadores.getCantidadAcertadasGeneral().toString());
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

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public Long getPartidasJugadas() {
        return Long.valueOf(partidasJugadas.get());
    }

    public void setPartidasJugadas(Long partidasJugadas) {
        this.partidasJugadas.set(partidasJugadas.toString());
    }

    public Long getPartidasGanadas() {
        return Long.valueOf(partidasGanadas.get());
    }

    public void setPartidasGanadas(Long partidasGanadas) {
        this.partidasGanadas.set(partidasGanadas.toString());
    }

    public Long getCantidadRespuestasGeneral() {
        return Long.valueOf(cantidadRespuestasGeneral.get());
    }

    public void setCantidadRespuestasGeneral(Long cantidadRespuestasGeneral) {
        this.cantidadRespuestasGeneral.set(cantidadRespuestasGeneral.toString());
    }

    public Long getCantidadAcertadasGeneral() {
        return Long.valueOf(cantidadAcertadasGeneral.get());
    }

    public void setCantidadAcertadasGeneral(Long cantidadAcertadasGeneral) {
        this.cantidadAcertadasGeneral.set(cantidadAcertadasGeneral.toString());
    }
    
    public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }

//    public List<PregCategorias> getCategoriasList() {
//        return categoriasList;
//    }
//
//    public void setCategoriasList(List<PregCategorias> categoriasList) {
//        this.categoriasList = categoriasList;
//    }
//
//    public List<PregPreguntas> getPreguntasList() {
//        return preguntasList;
//    }
//
//    public void setPreguntasList(List<PregPreguntas> preguntasList) {
//        this.preguntasList = preguntasList;
//    }
//
//    public List<PregJugpartida> getJugpartidaList() {
//        return jugpartidaList;
//    }
//
//    public void setJugpartidaList(List<PregJugpartida> jugpartidaList) {
//        this.jugpartidaList = jugpartidaList;
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
        if (!(object instanceof PregJugadoresDto)) {
            return false;
        }
        PregJugadoresDto other = (PregJugadoresDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugadores[ jugId=" + id + " ]";
    }

}
