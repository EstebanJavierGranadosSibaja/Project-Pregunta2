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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "PREG_JUGPARTIDA")
@NamedQueries({
    @NamedQuery(name = "PregJugpartida.findAll", query = "SELECT p FROM PregJugpartida p"),
    @NamedQuery(name = "PregJugpartida.findByJparId", query = "SELECT p FROM PregJugpartida p WHERE p.jparId = :jparId"),
    @NamedQuery(name = "PregJugpartida.findByJparPosicionSector", query = "SELECT p FROM PregJugpartida p WHERE p.jparPosicionSector = :jparPosicionSector"),
    @NamedQuery(name = "PregJugpartida.findByJparPosicionCasilla", query = "SELECT p FROM PregJugpartida p WHERE p.jparPosicionCasilla = :jparPosicionCasilla"),
    @NamedQuery(name = "PregJugpartida.findByJparCantidadAyudas", query = "SELECT p FROM PregJugpartida p WHERE p.jparCantidadAyudas = :jparCantidadAyudas"),
    @NamedQuery(name = "PregJugpartida.findByJparDobleAyuda", query = "SELECT p FROM PregJugpartida p WHERE p.jparDobleAyuda = :jparDobleAyuda"),
    @NamedQuery(name = "PregJugpartida.findByJparPasarAyuda", query = "SELECT p FROM PregJugpartida p WHERE p.jparPasarAyuda = :jparPasarAyuda"),
    @NamedQuery(name = "PregJugpartida.findByJparBombaAyuda", query = "SELECT p FROM PregJugpartida p WHERE p.jparBombaAyuda = :jparBombaAyuda"),
    @NamedQuery(name = "PregJugpartida.findByJparExtraAyuda", query = "SELECT p FROM PregJugpartida p WHERE p.jparExtraAyuda = :jparExtraAyuda"),
    @NamedQuery(name = "PregJugpartida.findByJparCantidadFichas", query = "SELECT p FROM PregJugpartida p WHERE p.jparCantidadFichas = :jparCantidadFichas"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaArte", query = "SELECT p FROM PregJugpartida p WHERE p.jparFichaArte = :jparFichaArte"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaHistoria", query = "SELECT p FROM PregJugpartida p WHERE p.jparFichaHistoria = :jparFichaHistoria"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaGeografia", query = "SELECT p FROM PregJugpartida p WHERE p.jparFichaGeografia = :jparFichaGeografia"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaCiencias", query = "SELECT p FROM PregJugpartida p WHERE p.jparFichaCiencias = :jparFichaCiencias"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaEntretenimiento", query = "SELECT p FROM PregJugpartida p WHERE p.jparFichaEntretenimiento = :jparFichaEntretenimiento"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaDeporte", query = "SELECT p FROM PregJugpartida p WHERE p.jparFichaDeporte = :jparFichaDeporte")})
public class PregJugpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "PREG_JUGPARTIDA_ID_GENERATOR", sequenceName = "PREG_JUGPARTIDA_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_JUGPARTIDA_ID_GENERATOR")
    @Id
    @Basic(optional = false)
    @Column(name = "JPAR_ID")
    private BigDecimal jparId;
    @Basic(optional = false)
    @Column(name = "JPAR_POSICION_SECTOR")
    private BigInteger jparPosicionSector;
    @Basic(optional = false)
    @Column(name = "JPAR_POSICION_CASILLA")
    private BigInteger jparPosicionCasilla;
    @Basic(optional = false)
    @Column(name = "JPAR_CANTIDAD_AYUDAS")
    private BigInteger jparCantidadAyudas;
    @Basic(optional = false)
    @Column(name = "JPAR_DOBLE_AYUDA")
    private String jparDobleAyuda;
    @Basic(optional = false)
    @Column(name = "JPAR_PASAR_AYUDA")
    private String jparPasarAyuda;
    @Basic(optional = false)
    @Column(name = "JPAR_BOMBA_AYUDA")
    private String jparBombaAyuda;
    @Basic(optional = false)
    @Column(name = "JPAR_EXTRA_AYUDA")
    private String jparExtraAyuda;
    @Basic(optional = false)
    @Column(name = "JPAR_CANTIDAD_FICHAS")
    private BigInteger jparCantidadFichas;
    @Column(name = "JPAR_FICHA_ARTE")
    private String jparFichaArte;
    @Column(name = "JPAR_FICHA_HISTORIA")
    private String jparFichaHistoria;
    @Column(name = "JPAR_FICHA_GEOGRAFIA")
    private String jparFichaGeografia;
    @Column(name = "JPAR_FICHA_CIENCIAS")
    private String jparFichaCiencias;
    @Column(name = "JPAR_FICHA_ENTRETENIMIENTO")
    private String jparFichaEntretenimiento;
    @Column(name = "JPAR_FICHA_DEPORTE")
    private String jparFichaDeporte;
    @JoinColumn(name = "JUG_ID", referencedColumnName = "JUG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PregJugadores jugId;
    @JoinColumn(name = "PPAR_ID", referencedColumnName = "PPAR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PregPrinpartida pparId;

    public PregJugpartida() {
    }

    public PregJugpartida(BigDecimal jparId) {
        this.jparId = jparId;
    }

    public PregJugpartida(BigDecimal jparId, BigInteger jparPosicionSector, BigInteger jparPosicionCasilla, BigInteger jparCantidadAyudas, String jparDobleAyuda, String jparPasarAyuda, String jparBombaAyuda, String jparExtraAyuda, BigInteger jparCantidadFichas) {
        this.jparId = jparId;
        this.jparPosicionSector = jparPosicionSector;
        this.jparPosicionCasilla = jparPosicionCasilla;
        this.jparCantidadAyudas = jparCantidadAyudas;
        this.jparDobleAyuda = jparDobleAyuda;
        this.jparPasarAyuda = jparPasarAyuda;
        this.jparBombaAyuda = jparBombaAyuda;
        this.jparExtraAyuda = jparExtraAyuda;
        this.jparCantidadFichas = jparCantidadFichas;
    }

    public BigDecimal getJparId() {
        return jparId;
    }

    public void setJparId(BigDecimal jparId) {
        this.jparId = jparId;
    }

    public BigInteger getJparPosicionSector() {
        return jparPosicionSector;
    }

    public void setJparPosicionSector(BigInteger jparPosicionSector) {
        this.jparPosicionSector = jparPosicionSector;
    }

    public BigInteger getJparPosicionCasilla() {
        return jparPosicionCasilla;
    }

    public void setJparPosicionCasilla(BigInteger jparPosicionCasilla) {
        this.jparPosicionCasilla = jparPosicionCasilla;
    }

    public BigInteger getJparCantidadAyudas() {
        return jparCantidadAyudas;
    }

    public void setJparCantidadAyudas(BigInteger jparCantidadAyudas) {
        this.jparCantidadAyudas = jparCantidadAyudas;
    }

    public String getJparDobleAyuda() {
        return jparDobleAyuda;
    }

    public void setJparDobleAyuda(String jparDobleAyuda) {
        this.jparDobleAyuda = jparDobleAyuda;
    }

    public String getJparPasarAyuda() {
        return jparPasarAyuda;
    }

    public void setJparPasarAyuda(String jparPasarAyuda) {
        this.jparPasarAyuda = jparPasarAyuda;
    }

    public String getJparBombaAyuda() {
        return jparBombaAyuda;
    }

    public void setJparBombaAyuda(String jparBombaAyuda) {
        this.jparBombaAyuda = jparBombaAyuda;
    }

    public String getJparExtraAyuda() {
        return jparExtraAyuda;
    }

    public void setJparExtraAyuda(String jparExtraAyuda) {
        this.jparExtraAyuda = jparExtraAyuda;
    }

    public BigInteger getJparCantidadFichas() {
        return jparCantidadFichas;
    }

    public void setJparCantidadFichas(BigInteger jparCantidadFichas) {
        this.jparCantidadFichas = jparCantidadFichas;
    }

    public String getJparFichaArte() {
        return jparFichaArte;
    }

    public void setJparFichaArte(String jparFichaArte) {
        this.jparFichaArte = jparFichaArte;
    }

    public String getJparFichaHistoria() {
        return jparFichaHistoria;
    }

    public void setJparFichaHistoria(String jparFichaHistoria) {
        this.jparFichaHistoria = jparFichaHistoria;
    }

    public String getJparFichaGeografia() {
        return jparFichaGeografia;
    }

    public void setJparFichaGeografia(String jparFichaGeografia) {
        this.jparFichaGeografia = jparFichaGeografia;
    }

    public String getJparFichaCiencias() {
        return jparFichaCiencias;
    }

    public void setJparFichaCiencias(String jparFichaCiencias) {
        this.jparFichaCiencias = jparFichaCiencias;
    }

    public String getJparFichaEntretenimiento() {
        return jparFichaEntretenimiento;
    }

    public void setJparFichaEntretenimiento(String jparFichaEntretenimiento) {
        this.jparFichaEntretenimiento = jparFichaEntretenimiento;
    }

    public String getJparFichaDeporte() {
        return jparFichaDeporte;
    }

    public void setJparFichaDeporte(String jparFichaDeporte) {
        this.jparFichaDeporte = jparFichaDeporte;
    }

    public PregJugadores getJugId() {
        return jugId;
    }

    public void setJugId(PregJugadores jugId) {
        this.jugId = jugId;
    }

    public PregPrinpartida getPparId() {
        return pparId;
    }

    public void setPparId(PregPrinpartida pparId) {
        this.pparId = pparId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jparId != null ? jparId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregJugpartida)) {
            return false;
        }
        PregJugpartida other = (PregJugpartida) object;
        if ((this.jparId == null && other.jparId != null) || (this.jparId != null && !this.jparId.equals(other.jparId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugpartida[ jparId=" + jparId + " ]";
    }
    
}
