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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
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
    @NamedQuery(name = "PregJugadores.findByJugCantidadAcertadasGeneral", query = "SELECT p FROM PregJugadores p WHERE p.jugCantidadAcertadasGeneral = :jugCantidadAcertadasGeneral")})
public class PregJugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "PREG_JUGADORES_ID_GENERATOR", sequenceName = "PREG_JUGADORES_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREG_JUGADORES_ID_GENERATOR")
    @Id
    @Basic(optional = false)
    @Column(name = "JUG_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "JUG_NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "JUG_PARTIDAS_JUGADAS")
    private Long partidasJugadas;
    @Basic(optional = false)
    @Column(name = "JUG_PARTIDAS_GANADAS")
    private Long partidasGanadas;
    @Basic(optional = false)
    @Column(name = "JUG_CANTIDAD_RESPUESTAS_GENERAL")
    private Long cantidadRespuestasGeneral;
    @Basic(optional = false)
    @Column(name = "JUG_CANTIDAD_ACERTADAS_GENERAL")
    private Long cantidadAcertadasGeneral;
    @JoinTable(name = "PREG_CATEGORIASJUGADOR", joinColumns = {
        @JoinColumn(name = "CXJ_IDJUG", referencedColumnName = "JUG_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CXJ_IDCAT", referencedColumnName = "CAT_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<PregCategorias> categoriasList;
    @JoinTable(name = "PREG_PREGUNTASJUGADOR", joinColumns = {
        @JoinColumn(name = "PXJ_IDJUG", referencedColumnName = "JUG_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PXJ_IDPRE", referencedColumnName = "PRE_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<PregPreguntas> preguntasList;
    @OneToMany(mappedBy = "jugId", fetch = FetchType.LAZY)
    private List<PregJugpartida> jugpartidaList;

    public PregJugadores() {
    }

    public PregJugadores(PregJugadoresDto pregJugadoresDto) {
        this.id = pregJugadoresDto.getId();
         Actualizar(pregJugadoresDto);
    }
    
    public void Actualizar(PregJugadoresDto pregJugadoresDto) {
        this.nombre = pregJugadoresDto.getNombre();
        this.partidasJugadas = pregJugadoresDto.getPartidasJugadas();
        this.partidasGanadas = pregJugadoresDto.getPartidasGanadas();
        this.cantidadRespuestasGeneral = pregJugadoresDto.getCantidadRespuestasGeneral();
        this.cantidadAcertadasGeneral = pregJugadoresDto.getCantidadAcertadasGeneral();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(Long partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public Long getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(Long partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public Long getCantidadRespuestasGeneral() {
        return cantidadRespuestasGeneral;
    }

    public void setCantidadRespuestasGeneral(Long cantidadRespuestasGeneral) {
        this.cantidadRespuestasGeneral = cantidadRespuestasGeneral;
    }

    public Long getCantidadAcertadasGeneral() {
        return cantidadAcertadasGeneral;
    }

    public void setCantidadAcertadasGeneral(Long cantidadAcertadasGeneral) {
        this.cantidadAcertadasGeneral = cantidadAcertadasGeneral;
    }

    public List<PregCategorias> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<PregCategorias> categoriasList) {
        this.categoriasList = categoriasList;
    }

    public List<PregPreguntas> getPreguntasList() {
        return preguntasList;
    }

    public void setPreguntasList(List<PregPreguntas> preguntasList) {
        this.preguntasList = preguntasList;
    }

    public List<PregJugpartida> getJugpartidaList() {
        return jugpartidaList;
    }

    public void setJugpartidaList(List<PregJugpartida> jugpartidaList) {
        this.jugpartidaList = jugpartidaList;
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
        if (!(object instanceof PregJugadores)) {
            return false;
        }
        PregJugadores other = (PregJugadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntadospackage.model.PregJugadores[ jugId=" + id + " ]";
    }

}
