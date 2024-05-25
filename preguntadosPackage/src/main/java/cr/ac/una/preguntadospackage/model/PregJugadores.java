package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Id;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Author: esteb
 */
@Entity
@Table(name = "preg_jugadores")
@NamedQueries({
        @NamedQuery(name = "PregJugadores.findAll", query = "SELECT p FROM PregJugadores p"),
        @NamedQuery(name = "PregJugadores.findByJugId", query = "SELECT p FROM PregJugadores p WHERE p.jugId = :jugId"),
        @NamedQuery(name = "PregJugadores.findByJugNombre", query = "SELECT p FROM PregJugadores p WHERE p.jugNombre = :jugNombre"),
        @NamedQuery(name = "PregJugadores.findByJugPartidasGanadas", query = "SELECT p FROM PregJugadores p WHERE p.jugPartidasGanadas = :jugPartidasGanadas")
})
public class PregJugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "jug_id")
    private BigDecimal jugId;

    @Basic(optional = false)
    @Column(name = "jug_nombre")
    private String jugNombre;

    @Basic(optional = false)
    @Column(name = "jug_partidas_ganadas")
    private BigInteger jugPartidasGanadas;

    @JoinTable(name = "preg_interjugpre", joinColumns = {
            @JoinColumn(name = "jug_id", referencedColumnName = "jug_id")}, inverseJoinColumns = {
            @JoinColumn(name = "pre_id", referencedColumnName = "pre_id")})
    @ManyToMany
    private List<PregPreguntas> pregPreguntasList;


    // TODO: Check this @Esteban
    //@OneToMany(mappedBy = "jugId")
    //private List<PregJugpartidas> pregJugpartidasList;

    public PregJugadores() {
    }

    public PregJugadores(BigDecimal jugId) {
        this.jugId = jugId;
    }

    public PregJugadores(BigDecimal jugId, String jugNombre, BigInteger jugPartidasGanadas) {
        this.jugId = jugId;
        this.jugNombre = jugNombre;
        this.jugPartidasGanadas = jugPartidasGanadas;
    }

    public BigDecimal getJugId() {
        return jugId;
    }

    public void setJugId(BigDecimal jugId) {
        this.jugId = jugId;
    }

    public String getJugNombre() {
        return jugNombre;
    }

    public void setJugNombre(String jugNombre) {
        this.jugNombre = jugNombre;
    }

    public BigInteger getJugPartidasGanadas() {
        return jugPartidasGanadas;
    }

    public void setJugPartidasGanadas(BigInteger jugPartidasGanadas) {
        this.jugPartidasGanadas = jugPartidasGanadas;
    }

    public List<PregPreguntas> getPregPreguntasList() {
        return pregPreguntasList;
    }

    public void setPregPreguntasList(List<PregPreguntas> pregPreguntasList) {
        this.pregPreguntasList = pregPreguntasList;
    }

    // TODO: Check this @Esteban
    //public List<PregJugpartidas> getPregJugpartidasList() {
        //return pregJugpartidasList;
    //}

    // TODO: Check this @Esteban
    //public void setPregJugpartidasList(List<PregJugpartidas> pregJugpartidasList) {
        //this.pregJugpartidasList = pregJugpartidasList;
    //}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugId != null ? jugId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregJugadores)) {
            return false;
        }
        PregJugadores other = (PregJugadores) object;
        if ((this.jugId == null && other.jugId != null) || (this.jugId != null && !this.jugId.equals(other.jugId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugadores[ jugId=" + jugId + " ]";
    }
}
