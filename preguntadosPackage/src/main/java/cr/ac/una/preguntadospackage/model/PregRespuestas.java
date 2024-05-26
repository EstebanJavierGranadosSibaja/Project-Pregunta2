/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PREG_RESPUESTAS")
@NamedQueries({ /*@NamedQuery(name = "PregRespuestas.findAll", query = "SELECT p FROM PregRespuestas p"),
    @NamedQuery(name = "PregRespuestas.findByRespId", query = "SELECT p FROM PregRespuestas p WHERE p.respId = :respId"),
    @NamedQuery(name = "PregRespuestas.findByRespTextoRespuesta", query = "SELECT p FROM PregRespuestas p WHERE p.respTextoRespuesta = :respTextoRespuesta"),
    @NamedQuery(name = "PregRespuestas.findByRespEsCorrecta", query = "SELECT p FROM PregRespuestas p WHERE p.respEsCorrecta = :respEsCorrecta"),
    @NamedQuery(name = "PregRespuestas.findByResCantidadSelecionada", query = "SELECT p FROM PregRespuestas p WHERE p.resCantidadSelecionada = :resCantidadSelecionada"),
    @NamedQuery(name = "PregRespuestas.findByVersion", query = "SELECT p FROM PregRespuestas p WHERE p.version = :version")*/})
public class PregRespuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "PREG_RESPUESTAS_ID_GENERATOR", sequenceName = "PREG_RESPUESTAS_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_RESPUESTAS_ID_GENERATOR")
    @Id
    @Basic(optional = false)
    @Column(name = "RESP_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "RESP_TEXTO_RESPUESTA")
    private String textoRespuesta;
    @Basic(optional = false)
    @Column(name = "RESP_ES_CORRECTA")
    private String esCorrecta;
    @Basic(optional = false)
    @Column(name = "RESP_CANTIDAD_SELECIONADA")
    private Long cantidadSelecionada;
    @Basic(optional = false)
    @Column(name = "RESP_VERSION")
    private Long version;
    @JoinColumn(name = "PRE_ID", referencedColumnName = "PRE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PregPreguntas preId;

    public PregRespuestas() {
    }

    public PregRespuestas(PregRespuestasDto pregRespuestasDto) {
        this.id = pregRespuestasDto.getId();
        Actualizar(pregRespuestasDto);
    }

    public void Actualizar(PregRespuestasDto pregRespuestasDto) {
        this.textoRespuesta = pregRespuestasDto.getTextoRespuesta();
        this.esCorrecta = pregRespuestasDto.getEsCorrecta();
        this.cantidadSelecionada = pregRespuestasDto.getCantidadSelecionada();
        this.version = pregRespuestasDto.getVersion();
    }

    public PregRespuestas(Long respId) {
        this.id = respId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public String getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(String esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public Long getCantidadSelecionada() {
        return cantidadSelecionada;
    }

    public void setCantidadSelecionada(Long cantidadSelecionada) {
        this.cantidadSelecionada = cantidadSelecionada;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregRespuestas)) {
            return false;
        }
        PregRespuestas other = (PregRespuestas) object;
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
