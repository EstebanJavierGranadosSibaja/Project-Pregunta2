/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class PregPreguntaspartidaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    public SimpleBooleanProperty estadoRespondida;
    private PregPreguntas prpaIdpre;
    private PregPrinpartida prpaIdppar;
    private Boolean modificado;
    

    public PregPreguntaspartidaDto() {
        this.estadoRespondida = new SimpleBooleanProperty(true);
        this.modificado = false;
    }

    public PregPreguntaspartidaDto(PregPreguntaspartida pregPreguntaspartida) {
        this();
        this.id = pregPreguntaspartida.getId();
        this.estadoRespondida.set(pregPreguntaspartida.getEstadoRespondida().equals("T"));
        this.prpaIdppar = pregPreguntaspartida.getPrpaIdPpar();
        this.prpaIdpre = pregPreguntaspartida.getPrpaIdPre();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstadoRespondida() {
        return estadoRespondida.get()?"T":"F";
    }

    public void setEstadoRespondida(String estadoRespondida) {
        this.estadoRespondida.set(estadoRespondida.equalsIgnoreCase("T"));
    }

    public PregPreguntas getPrpaIdPre() {
        return prpaIdpre;
    }

    public void setPrpaIdPre(PregPreguntas prpaIdpre) {
        this.prpaIdpre = prpaIdpre;
    }

    public PregPrinpartida getPrpaIdPpar() {
        return prpaIdppar;
    }

    public void setPrpaIdPpar(PregPrinpartida prpaIdppar) {
        this.prpaIdppar = prpaIdppar;
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
        if (!(object instanceof PregPreguntaspartidaDto)) {
            return false;
        }
        PregPreguntaspartidaDto other = (PregPreguntaspartidaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregPreguntaspartida[ prpaId=" + id + " ]";
    }
}