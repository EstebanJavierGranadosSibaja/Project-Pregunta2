/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author esteb
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "preg_jugpartidas")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findAll", query = "SELECT p FROM PregJugpartidas p"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparId", query = "SELECT p FROM PregJugpartidas p WHERE p.jparId = :jparId"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparPosicionSector", query = "SELECT p FROM PregJugpartidas p WHERE p.jparPosicionSector = :jparPosicionSector"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparPosicionCasilla", query = "SELECT p FROM PregJugpartidas p WHERE p.jparPosicionCasilla = :jparPosicionCasilla"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparCantidadAyudas", query = "SELECT p FROM PregJugpartidas p WHERE p.jparCantidadAyudas = :jparCantidadAyudas"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparDobleAyuda", query = "SELECT p FROM PregJugpartidas p WHERE p.jparDobleAyuda = :jparDobleAyuda"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparPasarAyuda", query = "SELECT p FROM PregJugpartidas p WHERE p.jparPasarAyuda = :jparPasarAyuda"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparBombaAyuda", query = "SELECT p FROM PregJugpartidas p WHERE p.jparBombaAyuda = :jparBombaAyuda"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparExtraAyuda", query = "SELECT p FROM PregJugpartidas p WHERE p.jparExtraAyuda = :jparExtraAyuda"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparCantidadFichas", query = "SELECT p FROM PregJugpartidas p WHERE p.jparCantidadFichas = :jparCantidadFichas"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparFichaArte", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaArte = :jparFichaArte"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparFichaHistoria", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaHistoria = :jparFichaHistoria"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparFichaGeografia", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaGeografia = :jparFichaGeografia"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparFichaCiencias", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaCiencias = :jparFichaCiencias"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparFichaEntretenimiento", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaEntretenimiento = :jparFichaEntretenimiento"),
    @javax.persistence.NamedQuery(name = "PregJugpartidas.findByJparFichaDeporte", query = "SELECT p FROM PregJugpartidas p WHERE p.jparFichaDeporte = :jparFichaDeporte")})
public class PregJugpartidas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "jpar_id")
    private BigDecimal jparId;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "jpar_posicion_sector")
    private BigInteger jparPosicionSector;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "jpar_posicion_casilla")
    private BigInteger jparPosicionCasilla;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "jpar_cantidad_ayudas")
    private BigInteger jparCantidadAyudas;
    @javax.persistence.Column(name = "jpar_doble_ayuda")
    private Character jparDobleAyuda;
    @javax.persistence.Column(name = "jpar_pasar_ayuda")
    private Character jparPasarAyuda;
    @javax.persistence.Column(name = "jpar_bomba_ayuda")
    private Character jparBombaAyuda;
    @javax.persistence.Column(name = "jpar_extra_ayuda")
    private Character jparExtraAyuda;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "jpar_cantidad_fichas")
    private BigInteger jparCantidadFichas;
    @javax.persistence.Column(name = "jpar_ficha_arte")
    private Character jparFichaArte;
    @javax.persistence.Column(name = "jpar_ficha_historia")
    private Character jparFichaHistoria;
    @javax.persistence.Column(name = "jpar_ficha_geografia")
    private Character jparFichaGeografia;
    @javax.persistence.Column(name = "jpar_ficha_ciencias")
    private Character jparFichaCiencias;
    @javax.persistence.Column(name = "jpar_ficha_entretenimiento")
    private Character jparFichaEntretenimiento;
    @javax.persistence.Column(name = "jpar_ficha_deporte")
    private Character jparFichaDeporte;
    @javax.persistence.JoinColumn(name = "jug_id", referencedColumnName = "jug_id")
    @javax.persistence.ManyToOne
    private PregJugadores jugId;
    @javax.persistence.JoinColumn(name = "ppar_id", referencedColumnName = "ppar_id")
    @javax.persistence.ManyToOne
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregJugpartidas)) {
            return false;
        }
        PregJugpartidas other = (PregJugpartidas) object;
        if ((this.jparId == null && other.jparId != null) || (this.jparId != null && !this.jparId.equals(other.jparId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugpartidas[ jparId=" + jparId + " ]";
    }
    
}
