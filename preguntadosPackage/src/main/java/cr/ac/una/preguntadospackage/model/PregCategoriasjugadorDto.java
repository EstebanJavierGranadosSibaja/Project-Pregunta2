package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;

public class PregCategoriasjugadorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    public SimpleStringProperty cantidadRespuestas;
    public SimpleStringProperty cantidadAcertada;
    private PregCategorias cajuIdcat;
    private PregJugadores cajuIdjug;
    private Boolean modificado;
    
    public PregCategoriasjugadorDto() {
        this.cantidadRespuestas = new SimpleStringProperty("0");
        this.cantidadAcertada = new SimpleStringProperty("0");
        this.modificado = false;
    }

    public PregCategoriasjugadorDto(PregCategoriasjugador pregCategoriasjugador) {
        this();
        this.id = pregCategoriasjugador.getId();
        this.cantidadRespuestas.set(pregCategoriasjugador.getCantidadRespuestas().toString());
        this.cantidadAcertada.set(pregCategoriasjugador.getCantidadAcertada().toString());
        this.cajuIdcat = pregCategoriasjugador.getCajuIdCat();
        this.cajuIdjug = pregCategoriasjugador.getCajuIdjug();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidadRespuestas() {
        return Long.valueOf(cantidadRespuestas.get());
    }

    public void setCantidadRespuestas(Long cantidadRespuestas) {
        this.cantidadRespuestas.set(cantidadRespuestas.toString());
    }

    public Long getCantidadAcertada() {
        return Long.valueOf(cantidadAcertada.get());
    }

    public void setCantidadAcertada(Long cantidadAcertada) {
        this.cantidadAcertada.set(cantidadAcertada.toString());
    }

    public PregCategorias getCajuCatId() {
        return cajuIdcat;
    }

    public void setCajuCatId(PregCategorias cajuIdcat) {
        this.cajuIdcat = cajuIdcat;
    }

    public PregJugadores getCajuIdjug() {
        return cajuIdjug;
    }

    public void setCajuIdjug(PregJugadores cajuIdjug) {
        this.cajuIdjug = cajuIdjug;
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
        if (!(object instanceof PregCategoriasjugadorDto)) {
            return false;
        }
        PregCategoriasjugadorDto other = (PregCategoriasjugadorDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregCategoriasjugador[ cajuId=" + id + " ]";
    }
}
