package cr.ac.una.preguntadospackage.service;

import cr.ac.una.preguntadospackage.model.PregPreguntas;
import cr.ac.una.preguntadospackage.util.EntityManagerHelper;
import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
import cr.ac.una.preguntadospackage.model.PregRespuestas;
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

public class PregRespuestasService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta getRespuesta(Long id) {
        try {
            Query qryRespuesta = em.createNamedQuery("PregRespuestas.findByRespId", PregRespuestas.class);
            qryRespuesta.setParameter("id", id);
            PregRespuestasDto pregJugadoresDto = new PregRespuestasDto((PregRespuestas) qryRespuesta.getSingleResult());
            return new Respuesta(true, "", "", "PregJugador", pregJugadoresDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe la respuesta consultada.", "getRespuesta NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PregCategoriasService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar la respuesta.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar la respuesta.", "getJugador NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PregCategoriasService.class.getName()).log(Level.SEVERE, "Error obteniendo la respuesta de id:  [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo la repuesta.", "getRespuesta " + ex.getMessage());
        }
    }

    public Respuesta getRespuestas(PregPreguntas respIdpre) {
        try {
           Query qryRespuesta = em.createNamedQuery("PregRespuestas.findByRespIdpre", PregRespuestas.class);
            qryRespuesta.setParameter("respIdpre", respIdpre);

            List<PregRespuestasDto> respuestas = new ArrayList<>();
            List<PregRespuestas> respuesta = qryRespuesta.getResultList();
            for (PregRespuestas tempRespuestas : respuesta) {
                respuestas.add(new PregRespuestasDto(tempRespuestas));
            }
            return new Respuesta(true, "", "", "PregRespuestas", respuestas);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe ninguna respuesta con los parametros colocados.", "getRespuestas NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar la respuesta.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar las respuestas.", "getRespuestas NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Error obteniendo las respuestas", ex);
            return new Respuesta(false, "Error obteniendo las respuestas.", "getRespuestas " + ex.getMessage());
        }
    }

//    public Respuesta guardarRespuesta(PregRespuestasDto pregRespuestasDto) {
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

//    public Respuesta eliminarJugador(String nombre) {
//        try {
//            et = em.getTransaction();
//            et.begin();
//            PregJugadores pregJugadores;
//            if (nombre != null && nombre.isEmpty() && nombre.isBlank()) {
//                pregJugadores = em.find(PregJugadores.class, nombre);
//                if (pregJugadores == null) {
//                    return new Respuesta(false, "No se encontró", "eliminarJugador NoResultException");
//                }
//                em.remove(pregJugadores);
//            } else {
//                return new Respuesta(false, "No se encontró", "eliminarJugador NoResultException");
//            }
//            et.commit();
//            return new Respuesta(true, "", "");
//        } catch (Exception ex) {
//            et.rollback();
//            Logger.getLogger(PregJugadoresService.class.getName()).log(Level.SEVERE, "Error eliminando al jugador", ex);
//            return new Respuesta(false, "Error eliminando al jugador.", "eliminarJugador " + ex.getMessage());
//        }
//    }
}
