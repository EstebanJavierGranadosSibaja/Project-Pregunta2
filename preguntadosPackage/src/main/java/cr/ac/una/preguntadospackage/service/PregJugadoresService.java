/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.service;

import cr.ac.una.preguntadospackage.util.EntityManagerHelper;
import cr.ac.una.preguntadospackage.model.PregJugadores;
import cr.ac.una.preguntadospackage.model.PregJugadoresDto;
import cr.ac.una.preguntadospackage.util.Respuesta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PregJugadoresService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Boolean validarJugador(String nombre) {
        Query qryJugador = em.createNamedQuery("PregJugadores.findByJugNombre", PregJugadores.class);
        qryJugador.setParameter("nombre", nombre);
        PregJugadoresDto pregJugadoresDto = new PregJugadoresDto((PregJugadores) qryJugador.getSingleResult());

        if (pregJugadoresDto.getId() == null) {
            return false;
        }
        if (pregJugadoresDto.getNombre().isEmpty() || pregJugadoresDto.getNombre().isBlank()) {
            return true;
        }
        return false;
    }

    public Respuesta getJugador(String nombre) {
        try {
            Query qryJugador = em.createNamedQuery("PregJugadores.findByJugNombre", PregJugadores.class);
            qryJugador.setParameter("nombre", nombre);
            PregJugadoresDto pregJugadoresDto = new PregJugadoresDto((PregJugadores) qryJugador.getSingleResult());
            return new Respuesta(true, "", "", "PregJugador", pregJugadoresDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe el jugador consultado.", "getJugador NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PregCategoriasService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el jugador.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el jugador.", "getJugador NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PregCategoriasService.class.getName()).log(Level.SEVERE, "Error obteniendo al jugador [" + nombre + "]", ex);
            return new Respuesta(false, "Error obteniendo el jugador.", "getJugador " + ex.getMessage());
        }
    }

    public Respuesta getJugadores(Long id, String nombre, Long partidasJugadas, Long partidasGanadas, Long cantidadRespuestasGeneral, Long cantidadAcertadasGeneral) {
        try {
            Query qryJugadores = em.createNamedQuery("PregJugadores.findByParameters", PregJugadores.class);
            qryJugadores.setParameter("id", "%" + id + "%");
            qryJugadores.setParameter("nombre", "%" + nombre + "%");
            qryJugadores.setParameter("partidasJugadas", "%" + partidasJugadas + "%");
            qryJugadores.setParameter("partidasGanadas", "%" + partidasGanadas + "%");
            qryJugadores.setParameter("cantidadRespuestasGeneral", "%" + cantidadRespuestasGeneral + "%");
            qryJugadores.setParameter("cantidadAcertadasGeneral", "%" + cantidadAcertadasGeneral + "%");

            List<PregJugadoresDto> jugadores = new ArrayList<>();
            List<PregJugadores> jugador = qryJugadores.getResultList();
            for (PregJugadores tempJugadores : jugador) {
                jugadores.add(new PregJugadoresDto(tempJugadores));
            }
            return new Respuesta(true, "", "", "PregJugadores", jugadores);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe ningun jugador con los parametros colocados.", "getJugadores NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el jugador.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar los jugadores.", "getJugadores NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Error obteniendo los jugadores", ex);
            return new Respuesta(false, "Error obteniendo los jugadores.", "getJugadores " + ex.getMessage());
        }
    }

    public Respuesta guardarJugador(PregJugadoresDto pregJugadoresDto) {
        try {
            et = em.getTransaction();
            et.begin();
            PregJugadores pregJugadores;
            if (pregJugadoresDto.getId() != null && pregJugadoresDto.getId() > 0) {
                pregJugadores = em.find(PregJugadores.class, pregJugadoresDto.getId());
                if (pregJugadores == null) {
                    return new Respuesta(false, "No se encontró", "guardarJugador NoResultException");
                }
                pregJugadores.Actualizar(pregJugadoresDto);
                pregJugadores = em.merge(pregJugadores);
            } else {
                pregJugadores = new PregJugadores(pregJugadoresDto);
                em.persist(pregJugadores);
            }
            et.commit();
            return new Respuesta(true, "", "", "PregJugador", new PregJugadoresDto(pregJugadores));

        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Error guardadndo al jugador", ex);
            return new Respuesta(false, "Error guardadndo al jugador.", "guardarJugador " + ex.getMessage());
        }
    }

    public Respuesta eliminarJugador(String nombre) {
        try {
            et = em.getTransaction();
            et.begin();
            PregJugadores pregJugadores;
            if (nombre != null && nombre.isEmpty() && nombre.isBlank()) {
                pregJugadores = em.find(PregJugadores.class, nombre);
                if (pregJugadores == null) {
                    return new Respuesta(false, "No se encontró", "eliminarJugador NoResultException");
                }
                em.remove(pregJugadores);
            } else {
                return new Respuesta(false, "No se encontró", "eliminarJugador NoResultException");
            }
            et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Error eliminando al jugador", ex);
            return new Respuesta(false, "Error eliminando al jugador.", "eliminarJugador " + ex.getMessage());
        }
    }
}
