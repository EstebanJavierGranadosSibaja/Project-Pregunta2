/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
    @NamedQuery(name = "PregJugpartida.findByJparNombreJugador", query = "SELECT p FROM PregJugpartida p WHERE p.jparNombreJugador = :jparNombreJugador"),
    @NamedQuery(name = "PregJugpartida.findByJparPosicionSector", query = "SELECT p FROM PregJugpartida p WHERE p.jparPosicionSector = :jparPosicionSector"),
    @NamedQuery(name = "PregJugpartida.findByJparColorPeon", query = "SELECT p FROM PregJugpartida p WHERE p.jparColorPeon = :jparColorPeon"),
    @NamedQuery(name = "PregJugpartida.findByJparPosicionCasilla", query = "SELECT p FROM PregJugpartida p WHERE p.jparPosicionCasilla = :jparPosicionCasilla"),
    @NamedQuery(name = "PregJugpartida.findByJparCantidadAyudasTotal", query = "SELECT p FROM PregJugpartida p WHERE p.jparCantidadAyudasTotal = :jparCantidadAyudasTotal"),
    @NamedQuery(name = "PregJugpartida.findByJparCantidadAyudasUsadas", query = "SELECT p FROM PregJugpartida p WHERE p.jparCantidadAyudasUsadas = :jparCantidadAyudasUsadas"),
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
    @NamedQuery(name = "PregJugpartida.findByJparFichaDeporte", query = "SELECT p FROM PregJugpartida p WHERE p.jparFichaDeporte = :jparFichaDeporte"),
    @NamedQuery(name = "PregJugpartida.findByJparVersion", query = "SELECT p FROM PregJugpartida p WHERE p.jparVersion = :jparVersion")})
public class PregJugpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "JPAR_ID")
    private BigDecimal jparId;
    @Basic(optional = false)
    @Column(name = "JPAR_NOMBRE_JUGADOR")
    private String jparNombreJugador;
    @Basic(optional = false)
    @Column(name = "JPAR_POSICION_SECTOR")
    private BigInteger jparPosicionSector;
    @Basic(optional = false)
    @Column(name = "JPAR_COLOR_PEON")
    private String jparColorPeon;
    @Basic(optional = false)
    @Column(name = "JPAR_POSICION_CASILLA")
    private BigInteger jparPosicionCasilla;
    @Basic(optional = false)
    @Column(name = "JPAR_CANTIDAD_AYUDAS_TOTAL")
    private BigInteger jparCantidadAyudasTotal;
    @Basic(optional = false)
    @Column(name = "JPAR_CANTIDAD_AYUDAS_USADAS")
    private BigInteger jparCantidadAyudasUsadas;
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
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_ARTE")
    private String jparFichaArte;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_HISTORIA")
    private String jparFichaHistoria;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_GEOGRAFIA")
    private String jparFichaGeografia;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_CIENCIAS")
    private String jparFichaCiencias;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_ENTRETENIMIENTO")
    private String jparFichaEntretenimiento;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_DEPORTE")
    private String jparFichaDeporte;
    @Basic(optional = false)
    @Column(name = "JPAR_VERSION")
    private BigInteger jparVersion;
    @JoinColumn(name = "JUG_ID", referencedColumnName = "JUG_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregJugadores jugId;
    @JoinColumn(name = "PPAR_ID", referencedColumnName = "PPAR_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregPrinpartida pparId;

    public PregJugpartida() {
    }

    public PregJugpartida(BigDecimal jparId) {
        this.jparId = jparId;
    }

    public PregJugpartida(BigDecimal jparId, String jparNombreJugador, BigInteger jparPosicionSector, String jparColorPeon, BigInteger jparPosicionCasilla, BigInteger jparCantidadAyudasTotal, BigInteger jparCantidadAyudasUsadas, String jparDobleAyuda, String jparPasarAyuda, String jparBombaAyuda, String jparExtraAyuda, BigInteger jparCantidadFichas, String jparFichaArte, String jparFichaHistoria, String jparFichaGeografia, String jparFichaCiencias, String jparFichaEntretenimiento, String jparFichaDeporte, BigInteger jparVersion) {
        this.jparId = jparId;
        this.jparNombreJugador = jparNombreJugador;
        this.jparPosicionSector = jparPosicionSector;
        this.jparColorPeon = jparColorPeon;
        this.jparPosicionCasilla = jparPosicionCasilla;
        this.jparCantidadAyudasTotal = jparCantidadAyudasTotal;
        this.jparCantidadAyudasUsadas = jparCantidadAyudasUsadas;
        this.jparDobleAyuda = jparDobleAyuda;
        this.jparPasarAyuda = jparPasarAyuda;
        this.jparBombaAyuda = jparBombaAyuda;
        this.jparExtraAyuda = jparExtraAyuda;
        this.jparCantidadFichas = jparCantidadFichas;
        this.jparFichaArte = jparFichaArte;
        this.jparFichaHistoria = jparFichaHistoria;
        this.jparFichaGeografia = jparFichaGeografia;
        this.jparFichaCiencias = jparFichaCiencias;
        this.jparFichaEntretenimiento = jparFichaEntretenimiento;
        this.jparFichaDeporte = jparFichaDeporte;
        this.jparVersion = jparVersion;
    }

    public BigDecimal getJparId() {
        return jparId;
    }

    public void setJparId(BigDecimal jparId) {
        this.jparId = jparId;
    }

    public String getJparNombreJugador() {
        return jparNombreJugador;
    }

    public void setJparNombreJugador(String jparNombreJugador) {
        this.jparNombreJugador = jparNombreJugador;
    }

    public BigInteger getJparPosicionSector() {
        return jparPosicionSector;
    }

    public void setJparPosicionSector(BigInteger jparPosicionSector) {
        this.jparPosicionSector = jparPosicionSector;
    }

    public String getJparColorPeon() {
        return jparColorPeon;
    }

    public void setJparColorPeon(String jparColorPeon) {
        this.jparColorPeon = jparColorPeon;
    }

    public BigInteger getJparPosicionCasilla() {
        return jparPosicionCasilla;
    }

    public void setJparPosicionCasilla(BigInteger jparPosicionCasilla) {
        this.jparPosicionCasilla = jparPosicionCasilla;
    }

    public BigInteger getJparCantidadAyudasTotal() {
        return jparCantidadAyudasTotal;
    }

    public void setJparCantidadAyudasTotal(BigInteger jparCantidadAyudasTotal) {
        this.jparCantidadAyudasTotal = jparCantidadAyudasTotal;
    }

    public BigInteger getJparCantidadAyudasUsadas() {
        return jparCantidadAyudasUsadas;
    }

    public void setJparCantidadAyudasUsadas(BigInteger jparCantidadAyudasUsadas) {
        this.jparCantidadAyudasUsadas = jparCantidadAyudasUsadas;
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

    public BigInteger getJparVersion() {
        return jparVersion;
    }

    public void setJparVersion(BigInteger jparVersion) {
        this.jparVersion = jparVersion;
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
