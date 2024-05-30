/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "PREG_JUGADORES")
@NamedQueries({
    @NamedQuery(name = "PregJugadores.findAll", query = "SELECT p FROM PregJugadores p"),
    @NamedQuery(name = "PregJugadores.findByJugId", query = "SELECT p FROM PregJugadores p WHERE p.jugId = :jugId"),
    @NamedQuery(name = "PregJugadores.findByJugNombre", query = "SELECT p FROM PregJugadores p WHERE p.jugNombre = :jugNombre"),
    @NamedQuery(name = "PregJugadores.findByJugPartidasJugadas", query = "SELECT p FROM PregJugadores p WHERE p.jugPartidasJugadas = :jugPartidasJugadas"),
    @NamedQuery(name = "PregJugadores.findByJugPartidasGanadas", query = "SELECT p FROM PregJugadores p WHERE p.jugPartidasGanadas = :jugPartidasGanadas"),
    @NamedQuery(name = "PregJugadores.findByJugCantidadRespuestasGeneral", query = "SELECT p FROM PregJugadores p WHERE p.jugCantidadRespuestasGeneral = :jugCantidadRespuestasGeneral"),
    @NamedQuery(name = "PregJugadores.findByJugCantidadAcertadasGeneral", query = "SELECT p FROM PregJugadores p WHERE p.jugCantidadAcertadasGeneral = :jugCantidadAcertadasGeneral"),
    @NamedQuery(name = "PregJugadores.findByJugVersion", query = "SELECT p FROM PregJugadores p WHERE p.jugVersion = :jugVersion")})
public class PregJugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "JUG_ID")
    private BigDecimal jugId;
    @Basic(optional = false)
    @Column(name = "JUG_NOMBRE")
    private String jugNombre;
    @Basic(optional = false)
    @Column(name = "JUG_PARTIDAS_JUGADAS")
    private BigInteger jugPartidasJugadas;
    @Basic(optional = false)
    @Column(name = "JUG_PARTIDAS_GANADAS")
    private BigInteger jugPartidasGanadas;
    @Basic(optional = false)
    @Column(name = "JUG_CANTIDAD_RESPUESTAS_GENERAL")
    private BigInteger jugCantidadRespuestasGeneral;
    @Basic(optional = false)
    @Column(name = "JUG_CANTIDAD_ACERTADAS_GENERAL")
    private BigInteger jugCantidadAcertadasGeneral;
    @Basic(optional = false)
    @Column(name = "JUG_VERSION")
    private BigInteger jugVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregJugadores", fetch = FetchType.LAZY)
    private List<PregCategoriasjugador> pregCategoriasjugadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugId", fetch = FetchType.LAZY)
    private List<PregJugpartida> pregJugpartidaList;

    public PregJugadores() {
    }

    public PregJugadores(BigDecimal jugId) {
        this.jugId = jugId;
    }

    public PregJugadores(BigDecimal jugId, String jugNombre, BigInteger jugPartidasJugadas, BigInteger jugPartidasGanadas, BigInteger jugCantidadRespuestasGeneral, BigInteger jugCantidadAcertadasGeneral, BigInteger jugVersion) {
        this.jugId = jugId;
        this.jugNombre = jugNombre;
        this.jugPartidasJugadas = jugPartidasJugadas;
        this.jugPartidasGanadas = jugPartidasGanadas;
        this.jugCantidadRespuestasGeneral = jugCantidadRespuestasGeneral;
        this.jugCantidadAcertadasGeneral = jugCantidadAcertadasGeneral;
        this.jugVersion = jugVersion;
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

    public BigInteger getJugPartidasJugadas() {
        return jugPartidasJugadas;
    }

    public void setJugPartidasJugadas(BigInteger jugPartidasJugadas) {
        this.jugPartidasJugadas = jugPartidasJugadas;
    }

    public BigInteger getJugPartidasGanadas() {
        return jugPartidasGanadas;
    }

    public void setJugPartidasGanadas(BigInteger jugPartidasGanadas) {
        this.jugPartidasGanadas = jugPartidasGanadas;
    }

    public BigInteger getJugCantidadRespuestasGeneral() {
        return jugCantidadRespuestasGeneral;
    }

    public void setJugCantidadRespuestasGeneral(BigInteger jugCantidadRespuestasGeneral) {
        this.jugCantidadRespuestasGeneral = jugCantidadRespuestasGeneral;
    }

    public BigInteger getJugCantidadAcertadasGeneral() {
        return jugCantidadAcertadasGeneral;
    }

    public void setJugCantidadAcertadasGeneral(BigInteger jugCantidadAcertadasGeneral) {
        this.jugCantidadAcertadasGeneral = jugCantidadAcertadasGeneral;
    }

    public BigInteger getJugVersion() {
        return jugVersion;
    }

    public void setJugVersion(BigInteger jugVersion) {
        this.jugVersion = jugVersion;
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
