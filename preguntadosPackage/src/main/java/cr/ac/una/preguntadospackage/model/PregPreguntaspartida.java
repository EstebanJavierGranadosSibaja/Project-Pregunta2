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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "PREG_PREGUNTASPARTIDA")
@NamedQueries({
    @NamedQuery(name = "PregPreguntaspartida.findAll", query = "SELECT p FROM PregPreguntaspartida p"),
    @NamedQuery(name = "PregPreguntaspartida.findByPrpaId", query = "SELECT p FROM PregPreguntaspartida p WHERE p.id = :id"),
    @NamedQuery(name = "PregPreguntaspartida.findByPrpaEstadoRespondida", query = "SELECT p FROM PregPreguntaspartida p WHERE p.estadoRespondida = :estadoRespondida")})
public class PregPreguntaspartida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "PREG_PREGUNTASPARTIDA_TGR01", sequenceName = "PREG_PREGUNTASPARTIDA_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_PREGUNTASPARTIDA_TGR01")
    @Id
    @Basic(optional = false)
    @Column(name = "PRPA_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "PRPA_ESTADO_RESPONDIDA")
    private String estadoRespondida;
    @JoinColumn(name = "PRPA_IDPRE", referencedColumnName = "PRE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregPreguntas prpaIdpre;
    @JoinColumn(name = "PPAR_IDPPAR", referencedColumnName = "PPAR_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregPrinpartida prpaIdppar;
    

    public PregPreguntaspartida() {
    }

    public PregPreguntaspartida(PregPreguntaspartidaDto pregPreguntaspartidaDto) {
        this.id = pregPreguntaspartidaDto.getId();
        Actualizar(pregPreguntaspartidaDto);
    }

    public void Actualizar(PregPreguntaspartidaDto pregPreguntaspartidaDto) {
        this.estadoRespondida = pregPreguntaspartidaDto.getEstadoRespondida();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstadoRespondida() {
        return estadoRespondida;
    }

    public void setEstadoRespondida(String estadoRespondida) {
        this.estadoRespondida = estadoRespondida;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregPreguntaspartida)) {
            return false;
        }
        PregPreguntaspartida other = (PregPreguntaspartida) object;
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
