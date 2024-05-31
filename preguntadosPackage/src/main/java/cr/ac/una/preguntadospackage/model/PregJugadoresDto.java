package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class PregJugadoresDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleStringProperty id;
    public SimpleStringProperty nombre;
    public SimpleStringProperty partidasJugadas;
    public SimpleStringProperty partidasGanadas;
    public SimpleStringProperty cantidasRespuestasGeneral;
    public SimpleStringProperty cantidasAcertadasGeneral;
    private Long version;
    private Boolean modificado;
    private List<PregCategoriasjugador> pregCategoriasjugadorList;
    private List<PregJugpartida> pregJugpartidaList;

    public PregJugadoresDto() {
        this.id = new SimpleStringProperty("");
        this.nombre = new SimpleStringProperty("");
        this.partidasJugadas = new SimpleStringProperty("");
        this.partidasGanadas = new SimpleStringProperty("");
        this.cantidasRespuestasGeneral = new SimpleStringProperty("");
        this.cantidasAcertadasGeneral = new SimpleStringProperty("");
        this.modificado = false;
    }

    public PregJugadoresDto(PregJugadores pregJugadores) {
        this();
        this.id.set(pregJugadores.getId().toString());
        this.nombre.set(pregJugadores.getNombre());
        this.partidasJugadas.set(pregJugadores.getPartidasJugadas().toString());
        this.partidasGanadas.set(pregJugadores.getPartidasGanadas().toString());
        this.cantidasRespuestasGeneral.set(pregJugadores.getCantidadRespuestasGeneral().toString());
        this.cantidasAcertadasGeneral.set(pregJugadores.getCantidadAcertadasGeneral().toString());
        this.version = pregJugadores.getVersion();
    }

    public Long getId() {
         if(this.id.get()!=null && !this.id.get().isBlank()){
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

    public Long getCantidasRespuestasGeneral() {
        return Long.valueOf(cantidasRespuestasGeneral.get());
    }

    public void setCantidasRespuestasGeneral(Long cantidasRespuestasGeneral) {
        this.cantidasRespuestasGeneral.set(cantidasRespuestasGeneral.toString());
    }

    public Long getCantidasAcertadasGeneral() {
        return Long.valueOf(cantidasAcertadasGeneral.get());
    }

    public void setCantidasAcertadasGeneral(Long cantidasAcertadasGeneral) {
        this.cantidasAcertadasGeneral.set(cantidasAcertadasGeneral.toString());
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

    public List<PregJugpartida> getPregJugpartidaList() {
        return pregJugpartidaList;
    }

    public void setPregJugpartidaList(List<PregJugpartida> pregJugpartidaList) {
        this.pregJugpartidaList = pregJugpartidaList;
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
