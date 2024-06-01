package cr.ac.una.preguntadospackage.service;

import cr.ac.una.preguntadospackage.util.EntityManagerHelper;
import cr.ac.una.preguntadospackage.model.PregPreguntas;
import cr.ac.una.preguntadospackage.model.PregPreguntasDto;
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

public class PregPreguntasService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta getPregunta(Long id, String textoPregunta, Long cantidadRespuestas, Long cantidadAciertos) {
        try {
            Query qryPregunta = em.createNamedQuery("PregJugadores.findByJugNombre", PregPreguntas.class);
            qryPregunta.setParameter("id", "%" + id + "%");
            qryPregunta.setParameter("textoPregunta", "%" + textoPregunta + "%");
            qryPregunta.setParameter("cantidadRespuestas", "%" + cantidadRespuestas + "%");
            qryPregunta.setParameter("cantidadAciertos", "%" + cantidadAciertos + "%");
            PregPreguntasDto pregPreguntasDto = new PregPreguntasDto((PregPreguntas) qryPregunta.getSingleResult());
            return new Respuesta(true, "", "", "PregJugador", pregPreguntasDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe la pregunta consultado.", "getPregunta NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PregCategoriasService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar la pregunta.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar la pregunta.", "getPregunta NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PregCategoriasService.class.getName()).log(Level.SEVERE, "Error obteniendo la pregunta", ex);
            return new Respuesta(false, "Error obteniendo la pregunta.", "getPregunta " + ex.getMessage());
        }
    }

//    public Respuesta getPreguntas(Long id, String nombre, Long partidasJugadas, Long partidasGanadas, Long cantidadRespuestasGeneral, Long cantidadAcertadasGeneral) {
//        try {
//            Query qryJugadores = em.createNamedQuery("PregPreguntas.findByParameters", PregJugadores.class);
//            qryJugadores.setParameter("id", "%" + id + "%");
//            qryJugadores.setParameter("nombre", "%" + nombre + "%");
//            qryJugadores.setParameter("partidasJugadas", "%" + partidasJugadas + "%");
//            qryJugadores.setParameter("partidasGanadas", "%" + partidasGanadas + "%");
//            qryJugadores.setParameter("cantidadRespuestasGeneral", "%" + cantidadRespuestasGeneral + "%");
//            qryJugadores.setParameter("cantidadAcertadasGeneral", "%" + cantidadAcertadasGeneral + "%");
//
//            List<PregJugadoresDto> jugadores = new ArrayList<>();
//            List<PregJugadores> jugador = qryJugadores.getResultList();
//            for (PregJugadores tempJugadores : jugador) {
//                jugadores.add(new PregJugadoresDto(tempJugadores));
//            }
//            return new Respuesta(true, "", "", "PregJugadores", jugadores);
//        } catch (NoResultException ex) {
//            return new Respuesta(false, "No existe ningun jugador con los parametros colocados.", "getJugadores NoResultException");
//        } catch (NonUniqueResultException ex) {
//            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el jugador.", ex);
//            return new Respuesta(false, "Ocurrio un error al consultar los jugadores.", "getJugadores NonUniqueResultException");
//        } catch (Exception ex) {
//            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Error obteniendo los jugadores", ex);
//            return new Respuesta(false, "Error obteniendo los jugadores.", "getJugadores " + ex.getMessage());
//        }
//    }

//    public Respuesta guardarJugador(PregJugadoresDto pregJugadoresDto) {
//        try {
//            et = em.getTransaction();
//            et.begin();
//            PregJugadores pregJugadores;
//            if (pregJugadoresDto.getId() != null && pregJugadoresDto.getId() > 0) {
//                pregJugadores = em.find(PregJugadores.class, pregJugadoresDto.getId());
//                if (pregJugadores == null) {
//                    return new Respuesta(false, "No se encontró", "guardarJugador NoResultException");
//                }
//                pregJugadores.Actualizar(pregJugadoresDto);
//                pregJugadores = em.merge(pregJugadores);
//            } else {
//                pregJugadores = new PregJugadores(pregJugadoresDto);
//                em.persist(pregJugadores);
//            }
//            et.commit();
//            return new Respuesta(true, "", "", "PregJugador", new PregJugadoresDto(pregJugadores));
//
//        } catch (Exception ex) {
//            et.rollback();
//            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Error guardadndo al jugador", ex);
//            return new Respuesta(false, "Error guardadndo al jugador.", "guardarJugador " + ex.getMessage());
//        }
//    }

    public Respuesta eliminarPregunta(Long id) {
        try {
            et = em.getTransaction();
            et.begin();
            PregPreguntas pregPregunta;
            if (id != null && id > 0) {
                pregPregunta = em.find(PregPreguntas.class, id);
                if (pregPregunta == null) {
                    return new Respuesta(false, "No se encontró", "eliminarPregunta NoResultException");
                }
                em.remove(pregPregunta);
            } else {
                return new Respuesta(false, "No se encontró", "eliminarPregunta NoResultException");
            }
            et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Error eliminando la pregunta", ex);
            return new Respuesta(false, "Error eliminando la pregunta.", "eliminarPregunta " + ex.getMessage());
        }
    }
}
