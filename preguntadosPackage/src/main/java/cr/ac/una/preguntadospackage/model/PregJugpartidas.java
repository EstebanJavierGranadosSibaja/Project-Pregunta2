package cr.ac.una.preguntadospackage.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
 * Entity representing player-partida associations in the Preguntados game.
 * Author: esteb
 */
@Entity
@Table(name = "preg_jugpartidas")
@NamedQueries({
        @NamedQuery(name = "PregJugpartidas.findAll", query = "SELECT p FROM PregJugpartidas p"),
        @NamedQuery(name = "PregJugpartidas.findByJparId", query = "SELECT p FROM PregJugpartidas p WHERE p.jparId = :jparId"),
        @NamedQuery(name = "PregJugpartidas.findByJparPosicionSector", query = "SELECT p FROM PregJugpartidas p WHERE p.jparPosicionSector = :jparPosicionSector"),
        @NamedQuery(name = "PregJugpartidas.findByJparPosicionCasilla", query = "SELECT p FROM PregJugpartidas p WHERE p.jparPosicionCasilla = :jparPosicionCasilla"),
        @NamedQuery(name = "PregJugpartidas.findByJparCantidadAyudas", query = "SELECT p FROM PregJugpartidas p WHERE p.jparCantidadAyudas = :jparCantidadAyudas"),
        @NamedQuery(name = "PregJugpartidas.findByJparDobleAyuda", query = "SELECT p FROM PregJugpartidas p WHERE p.jparDobleAyuda = :jparDobleAyuda"),
        @NamedQuery(name = "PregJugpartidas.findByJparPasarAyuda", query = "SELECT p FROM PregJugpartidas p WHERE p.jparPasarAyuda = :jparPasarAyuda"),
        @NamedQuery(name = "PregJugpartidas.findByJparBombaAyuda", query = "SELECT p FROM PregJugpartidas p WHERE p.jparBombaAyuda = :jparBombaAyuda"),
        @NamedQuery(name = "PregJugpartidas.findByJparExtraAyuda", query = "SELECT p FROM PregJugpartidas p WHERE p.jparExtraAyuda = :jparExtraAyuda"),
        @NamedQuery(name = "PregJugpartidas.findByJparCantidadFichas", query = "SELECT p FROM PregJugpartidas p WHERE p.jparCantidadFichas = :jparCantidadFichas"),
        @NamedQuery(name = "PregJugpartidas.findByJparFichaArte", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaArte = :jparFichaArte"),
        @NamedQuery(name = "PregJugpartidas.findByJparFichaHistoria", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaHistoria = :jparFichaHistoria"),
        @NamedQuery(name = "PregJugpartidas.findByJparFichaGeografia", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaGeografia = :jparFichaGeografia"),
        @NamedQuery(name = "PregJugpartidas.findByJparFichaCiencias", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaCiencias = :jparFichaCiencias"),
        @NamedQuery(name = "PregJugpartidas.findByJparFichaEntretenimiento", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaEntretenimiento = :jparFichaEntretenimiento"),
        @NamedQuery(name = "PregJugpartidas.findByJparFichaDeporte", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaDeporte = :jparFichaDeporte")
})
public class PregJugpartidas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "jpar_id")
    private BigDecimal jparId;

    @Basic(optional = false)
    @Column(name = "jpar_posicion_sector")
    private BigInteger jparPosicionSector;

    @Basic(optional = false)
    @Column(name = "jpar_posicion_casilla")
    private BigInteger jparPosicionCasilla;

    @Basic(optional = false)
    @Column(name = "jpar_cantidad_ayudas")
    private BigInteger jparCantidadAyudas;

    @Column(name = "jpar_doble_ayuda")
    private Character jparDobleAyuda;

    @Column(name = "jpar_pasar_ayuda")
    private Character jparPasarAyuda;

    @Column(name = "jpar_bomba_ayuda")
    private Character jparBombaAyuda;

    @Column(name = "jpar_extra_ayuda")
    private Character jparExtraAyuda;

    @Basic(optional = false)
    @Column(name = "jpar_cantidad_fichas")
    private BigInteger jparCantidadFichas;

    @Column(name = "jpar_ficha_arte")
    private Character jparFichaArte;

    @Column(name = "jpar_ficha_historia")
    private Character jparFichaHistoria;

    @Column(name = "jpar_ficha_geografia")
    private Character jparFichaGeografia;

    @Column(name = "jpar_ficha_ciencias")
    private Character jparFichaCiencias;

    @Column(name = "jpar_ficha_entretenimiento")
    private Character jparFichaEntretenimiento;

    @Column(name = "jpar_ficha_deporte")
    private Character jparFichaDeporte;

    @JoinColumn(name = "jug_id", referencedColumnName = "jug_id")
    @ManyToOne
    private PregJugadores jugId;

    @JoinColumn(name = "ppar_id", referencedColumnName = "ppar_id")
    @ManyToOne
    private PregPrinpartida pparId;

    public PregJugpartidas() {
    }

    public PregJugpartidas(BigDecimal jparId) {
        this.jparId = jparId;
    }

    public PregJugpartidas(BigDecimal jparId, BigInteger jparPosicionSector, BigInteger jparPosicionCasilla, BigInteger jparCantidadAyudas, BigInteger jparCantidadFichas) {
        this.jparId = jparId;
        this.jparPosicionSector = jparPosicionSector;
        this.jparPosicionCasilla = jparPosicionCasilla;
        this.jparCantidadAyudas = jparCantidadAyudas;
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

    public Character getJparDobleAyuda() {
        return jparDobleAyuda;
    }

    public void setJparDobleAyuda(Character jparDobleAyuda) {
        this.jparDobleAyuda = jparDobleAyuda;
    }

    public Character getJparPasarAyuda() {
        return jparPasarAyuda;
    }

    public void setJparPasarAyuda(Character jparPasarAyuda) {
        this.jparPasarAyuda = jparPasarAyuda;
    }

    public Character getJparBombaAyuda() {
        return jparBombaAyuda;
    }

    public void setJparBombaAyuda(Character jparBombaAyuda) {
        this.jparBombaAyuda = jparBombaAyuda;
    }

    public Character getJparExtraAyuda() {
        return jparExtraAyuda;
    }

    public void setJparExtraAyuda(Character jparExtraAyuda) {
        this.jparExtraAyuda = jparExtraAyuda;
    }

    public BigInteger getJparCantidadFichas() {
        return jparCantidadFichas;
    }

    public void setJparCantidadFichas(BigInteger jparCantidadFichas) {
        this.jparCantidadFichas = jparCantidadFichas;
    }

    public Character getJparFichaArte() {
        return jparFichaArte;
    }

    public void setJparFichaArte(Character jparFichaArte) {
        this.jparFichaArte = jparFichaArte;
    }

    public Character getJparFichaHistoria() {
        return jparFichaHistoria;
    }

    public void setJparFichaHistoria(Character jparFichaHistoria) {
        this.jparFichaHistoria = jparFichaHistoria;
    }

    public Character getJparFichaGeografia() {
        return jparFichaGeografia;
    }

    public void setJparFichaGeografia(Character jparFichaGeografia) {
        this.jparFichaGeografia = jparFichaGeografia;
    }

    public Character getJparFichaCiencias() {
        return jparFichaCiencias;
    }

    public void setJparFichaCiencias(Character jparFichaCiencias) {
        this.jparFichaCiencias = jparFichaCiencias;
    }

    public Character getJparFichaEntretenimiento() {
        return jparFichaEntretenimiento;
    }

    public void setJparFichaEntretenimiento(Character jparFichaEntretenimiento) {
        this.jparFichaEntretenimiento = jparFichaEntretenimiento;
    }

    public Character getJparFichaDeporte() {
        return jparFichaDeporte;
    }

    public void setJparFichaDeporte(Character jparFichaDeporte) {
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
        if (!(object instanceof PregJugpartidas)) {
            return false;
        }
        PregJugpartidas other = (PregJugpartidas) object;
        return (this.jparId != null || other.jparId == null) && (this.jparId == null || this.jparId.equals(other.jparId));
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugpartidas[ jparId=" + jparId + " ]";
    }
}
