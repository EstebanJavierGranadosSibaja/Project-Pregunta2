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
import jakarta.persistence.Version;
import java.io.Serializable;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "PREG_JUGPARTIDA")
@NamedQueries({
    @NamedQuery(name = "PregJugpartida.findAll", query = "SELECT p FROM PregJugpartida p"),
    @NamedQuery(name = "PregJugpartida.findByJparId", query = "SELECT p FROM PregJugpartida p WHERE p.id = :id"),
    @NamedQuery(name = "PregJugpartida.findByJparNombreJugador", query = "SELECT p FROM PregJugpartida p WHERE p.nombreJugador = :nombreJugador"),
    @NamedQuery(name = "PregJugpartida.findByJparPosicionSector", query = "SELECT p FROM PregJugpartida p WHERE p.posicionSector = :posicionSector"),
    @NamedQuery(name = "PregJugpartida.findByJparColorPeon", query = "SELECT p FROM PregJugpartida p WHERE p.colorPeon = :colorPeon"),
    @NamedQuery(name = "PregJugpartida.findByJparPosicionCasilla", query = "SELECT p FROM PregJugpartida p WHERE p.posicionCasilla = :posicionCasilla"),
    @NamedQuery(name = "PregJugpartida.findByJparCantidadAyudasTotal", query = "SELECT p FROM PregJugpartida p WHERE p.cantidadAyudasTotal = :cantidadAyudasTotal"),
    @NamedQuery(name = "PregJugpartida.findByJparCantidadAyudasUsadas", query = "SELECT p FROM PregJugpartida p WHERE p.cantidadAyudasUsadas = :cantidadAyudasUsadas"),
    @NamedQuery(name = "PregJugpartida.findByJparDobleAyuda", query = "SELECT p FROM PregJugpartida p WHERE p.dobleAyuda = :dobleAyuda"),
    @NamedQuery(name = "PregJugpartida.findByJparPasarAyuda", query = "SELECT p FROM PregJugpartida p WHERE p.pasarAyuda = :pasarAyuda"),
    @NamedQuery(name = "PregJugpartida.findByJparBombaAyuda", query = "SELECT p FROM PregJugpartida p WHERE p.bombaAyuda = :bombaAyuda"),
    @NamedQuery(name = "PregJugpartida.findByJparExtraAyuda", query = "SELECT p FROM PregJugpartida p WHERE p.extraAyuda = :extraAyuda"),
    @NamedQuery(name = "PregJugpartida.findByJparCantidadFichas", query = "SELECT p FROM PregJugpartida p WHERE p.cantidadFichas = :cantidadFichas"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaArte", query = "SELECT p FROM PregJugpartida p WHERE p.fichaArte = :fichaArte"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaHistoria", query = "SELECT p FROM PregJugpartida p WHERE p.fichaHistoria = :fichaHistoria"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaGeografia", query = "SELECT p FROM PregJugpartida p WHERE p.fichaGeografia = :fichaGeografia"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaCiencias", query = "SELECT p FROM PregJugpartida p WHERE p.fichaCiencias = :fichaCiencias"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaEntretenimiento", query = "SELECT p FROM PregJugpartida p WHERE p.fichaEntretenimiento = :fichaEntretenimiento"),
    @NamedQuery(name = "PregJugpartida.findByJparFichaDeporte", query = "SELECT p FROM PregJugpartida p WHERE p.fichaDeporte = :fichaDeporte"),
    @NamedQuery(name = "PregJugpartida.findByJparVersion", query = "SELECT p FROM PregJugpartida p WHERE p.version = :version")})
public class PregJugpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "PREG_JUGPARTIDA_TGR01", sequenceName = "PREG_JUGPARTIDA_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_JUGPARTIDA_TGR01")
    @Id
    @Basic(optional = false)
    @Column(name = "JPAR_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "JPAR_NOMBRE_JUGADOR")
    private String nombreJugador;
    @Basic(optional = false)
    @Column(name = "JPAR_POSICION_SECTOR")
    private Long posicionSector;
    @Basic(optional = false)
    @Column(name = "JPAR_COLOR_PEON")
    private String colorPeon;
    @Basic(optional = false)
    @Column(name = "JPAR_POSICION_CASILLA")
    private Long posicionCasilla;
    @Basic(optional = false)
    @Column(name = "JPAR_CANTIDAD_AYUDAS_TOTAL")
    private Long cantidadAyudasTotal;
    @Basic(optional = false)
    @Column(name = "JPAR_CANTIDAD_AYUDAS_USADAS")
    private Long cantidadAyudasUsadas;
    @Basic(optional = false)
    @Column(name = "JPAR_DOBLE_AYUDA")
    private String dobleAyuda;
    @Basic(optional = false)
    @Column(name = "JPAR_PASAR_AYUDA")
    private String pasarAyuda;
    @Basic(optional = false)
    @Column(name = "JPAR_BOMBA_AYUDA")
    private String bombaAyuda;
    @Basic(optional = false)
    @Column(name = "JPAR_EXTRA_AYUDA")
    private String extraAyuda;
    @Basic(optional = false)
    @Column(name = "JPAR_CANTIDAD_FICHAS")
    private Long cantidadFichas;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_ARTE")
    private String fichaArte;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_HISTORIA")
    private String fichaHistoria;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_GEOGRAFIA")
    private String fichaGeografia;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_CIENCIAS")
    private String fichaCiencias;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_ENTRETENIMIENTO")
    private String fichaEntretenimiento;
    @Basic(optional = false)
    @Column(name = "JPAR_FICHA_DEPORTE")
    private String fichaDeporte;
    @Version
    @Column(name = "JPAR_VERSION")
    private Long version;
    @JoinColumn(name = "JUG_ID", referencedColumnName = "JUG_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregJugadores jugId;
    @JoinColumn(name = "PPAR_ID", referencedColumnName = "PPAR_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PregPrinpartida pparId;

    public PregJugpartida() {
    }

    public PregJugpartida(PregJugpartidaDto pregJugpartidaDto) {
        this.id = pregJugpartidaDto.getId();
        Actualizar(pregJugpartidaDto);
    }

    public void Actualizar(PregJugpartidaDto pregJugpartidaDto) {
        this.nombreJugador = pregJugpartidaDto.getNombreJugador();
        this.posicionSector = pregJugpartidaDto.getPosicionSector();
        this.colorPeon = pregJugpartidaDto.getColorPeon();
        this.posicionCasilla = pregJugpartidaDto.getPosicionCasilla();
        this.cantidadAyudasTotal = pregJugpartidaDto.getCantidadAyudasTotal();
        this.cantidadAyudasUsadas = pregJugpartidaDto.getCantidadAyudasUsadas();
        this.dobleAyuda = pregJugpartidaDto.getDobleAyuda();
        this.pasarAyuda = pregJugpartidaDto.getPasarAyuda();
        this.bombaAyuda = pregJugpartidaDto.getBombaAyuda();
        this.extraAyuda = pregJugpartidaDto.getExtraAyuda();
        this.cantidadFichas = pregJugpartidaDto.getCantidadFichas();
        this.fichaArte = pregJugpartidaDto.getFichaArte();
        this.fichaHistoria = pregJugpartidaDto.getFichaHistoria();
        this.fichaGeografia = pregJugpartidaDto.getFichaGeografia();
        this.fichaCiencias = pregJugpartidaDto.getFichaCiencias();
        this.fichaEntretenimiento = pregJugpartidaDto.getFichaEntretenimiento();
        this.fichaDeporte = pregJugpartidaDto.getFichaDeporte();
        this.version = pregJugpartidaDto.getVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Long getPosicionSector() {
        return posicionSector;
    }

    public void setPosicionSector(Long posicionSector) {
        this.posicionSector = posicionSector;
    }

    public String getColorPeon() {
        return colorPeon;
    }

    public void setColorPeon(String colorPeon) {
        this.colorPeon = colorPeon;
    }

    public Long getPosicionCasilla() {
        return posicionCasilla;
    }

    public void setPosicionCasilla(Long posicionCasilla) {
        this.posicionCasilla = posicionCasilla;
    }

    public Long getCantidadAyudasTotal() {
        return cantidadAyudasTotal;
    }

    public void setCantidadAyudasTotal(Long cantidadAyudasTotal) {
        this.cantidadAyudasTotal = cantidadAyudasTotal;
    }

    public Long getCantidadAyudasUsadas() {
        return cantidadAyudasUsadas;
    }

    public void setCantidadAyudasUsadas(Long cantidadAyudasUsadas) {
        this.cantidadAyudasUsadas = cantidadAyudasUsadas;
    }

    public String getDobleAyuda() {
        return dobleAyuda;
    }

    public void setDobleAyuda(String dobleAyuda) {
        this.dobleAyuda = dobleAyuda;
    }

    public String getPasarAyuda() {
        return pasarAyuda;
    }

    public void setPasarAyuda(String pasarAyuda) {
        this.pasarAyuda = pasarAyuda;
    }

    public String getBombaAyuda() {
        return bombaAyuda;
    }

    public void setBombaAyuda(String bombaAyuda) {
        this.bombaAyuda = bombaAyuda;
    }

    public String getExtraAyuda() {
        return extraAyuda;
    }

    public void setExtraAyuda(String extraAyuda) {
        this.extraAyuda = extraAyuda;
    }

    public Long getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(Long cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }

    public String getFichaArte() {
        return fichaArte;
    }

    public void setFichaArte(String fichaArte) {
        this.fichaArte = fichaArte;
    }

    public String getFichaHistoria() {
        return fichaHistoria;
    }

    public void setFichaHistoria(String fichaHistoria) {
        this.fichaHistoria = fichaHistoria;
    }

    public String getFichaGeografia() {
        return fichaGeografia;
    }

    public void setFichaGeografia(String fichaGeografia) {
        this.fichaGeografia = fichaGeografia;
    }

    public String getFichaCiencias() {
        return fichaCiencias;
    }

    public void setFichaCiencias(String fichaCiencias) {
        this.fichaCiencias = fichaCiencias;
    }

    public String getFichaEntretenimiento() {
        return fichaEntretenimiento;
    }

    public void setFichaEntretenimiento(String fichaEntretenimiento) {
        this.fichaEntretenimiento = fichaEntretenimiento;
    }

    public String getFichaDeporte() {
        return fichaDeporte;
    }

    public void setFichaDeporte(String fichaDeporte) {
        this.fichaDeporte = fichaDeporte;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregJugpartida)) {
            return false;
        }
        PregJugpartida other = (PregJugpartida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugpartida[ jparId=" + id + " ]";
    }
    
}
