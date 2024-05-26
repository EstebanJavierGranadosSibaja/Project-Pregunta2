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

@Entity
@Table(name = "PREG_JUGPARTIDA")
@NamedQueries({ /*@NamedQuery(name = "PregJugpartida.findAll", query = "SELECT p FROM PregJugpartida p"),
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
    @NamedQuery(name = "PregJugpartida.findByJparFichaDeporte", query = "SELECT p FROM PregJugpartida p WHERE p.jparFichaDeporte = :jparFichaDeporte")*/})
public class PregJugpartida implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "PREG_JUGPARTIDA_ID_GENERATOR", sequenceName = "PREG_JUGPARTIDA_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_JUGPARTIDA_ID_GENERATOR")
    @Id
    @Basic(optional = false)
    @Column(name = "JPAR_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "JPAR_POSICION_SECTOR")
    private Integer posicionSector;
    @Basic(optional = false)
    @Column(name = "JPAR_POSICION_CASILLA")
    private Integer posicionCasilla;
    @Basic(optional = false)
    @Column(name = "JPAR_CANTIDAD_AYUDAS")
    private Integer cantidadAyudas;
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
    private Integer cantidadFichas;
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
    @Basic(optional = false)
    @JoinColumn(name = "JUG_ID", referencedColumnName = "JUG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PregJugadores jugId;
    @Basic(optional = false)
    @JoinColumn(name = "PPAR_ID", referencedColumnName = "PPAR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PregPrinpartida pparId;

    public PregJugpartida() {
    }

    public PregJugpartida(PregJugpartidaDto pregJugpartidaDto) {
        this.id = pregJugpartidaDto.getId();
        Actualizar(pregJugpartidaDto);
    }

    public void Actualizar(PregJugpartidaDto pregJugpartidaDto) {
        this.posicionSector = pregJugpartidaDto.getPosicionSector();
        this.posicionCasilla = pregJugpartidaDto.getPosicionCasilla();
        this.cantidadAyudas = pregJugpartidaDto.getCantidadAyudas();
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosicionSector() {
        return posicionSector;
    }

    public void setPosicionSector(Integer posicionSector) {
        this.posicionSector = posicionSector;
    }

    public Integer getPosicionCasilla() {
        return posicionCasilla;
    }

    public void setPosicionCasilla(Integer posicionCasilla) {
        this.posicionCasilla = posicionCasilla;
    }

    public Integer getCantidadAyudas() {
        return cantidadAyudas;
    }

    public void setCantidadAyudas(Integer cantidadAyudas) {
        this.cantidadAyudas = cantidadAyudas;
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

    public Integer getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(Integer cantidadFichas) {
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
