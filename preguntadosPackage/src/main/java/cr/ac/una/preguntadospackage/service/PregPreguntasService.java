package cr.ac.una.preguntadospackage.service;

import cr.ac.una.preguntadospackage.util.EntityManagerHelper;
import cr.ac.una.preguntadospackage.model.PregPreguntas;
import cr.ac.una.preguntadospackage.model.PregPreguntasDto;
import cr.ac.una.preguntadospackage.model.PregRespuestas;
import cr.ac.una.preguntadospackage.model.PregRespuestasDto;
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

    public Respuesta getPregunta(Long id) {
        try {
            Query qryPregunta = em.createNamedQuery("PregPreguntas.findByPreId", PregPreguntas.class);
            qryPregunta.setParameter("id", id);

            PregPreguntas pregPreguntas = (PregPreguntas) qryPregunta.getSingleResult();
            PregPreguntasDto pregPreguntasDto = new PregPreguntasDto(pregPreguntas);

            for (PregRespuestas respuestas : pregPreguntas.getRespuestasList()) {
                pregPreguntasDto.getPregRespuestasList().add(new PregRespuestasDto(respuestas));
            }

            return new Respuesta(true, "", "", "PregPregunta", pregPreguntasDto);
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

    public Respuesta getPregunta(String id, String textoPregunta, String cantidadRespuestas, String cantidadAciertos) {
        try {
            Query qryPregunta = em.createNamedQuery("PregJugadores.findByJugNombre", PregPreguntas.class);
            qryPregunta.setParameter("id", "%" + id + "%");
            qryPregunta.setParameter("textoPregunta", "%" + textoPregunta + "%");
            qryPregunta.setParameter("cantidadRespuestas", "%" + cantidadRespuestas + "%");
            qryPregunta.setParameter("cantidadAciertos", "%" + cantidadAciertos + "%");

            PregPreguntas pregPreguntas = (PregPreguntas) qryPregunta.getSingleResult();
            PregPreguntasDto pregPreguntasDto = new PregPreguntasDto(pregPreguntas);

            for (PregRespuestas respuestas : pregPreguntas.getRespuestasList()) {
                pregPreguntasDto.getPregRespuestasList().add(new PregRespuestasDto(respuestas));
            }

            return new Respuesta(true, "", "", "PregPregunta", pregPreguntasDto);
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

    public Respuesta getPreguntas(String id, String textoPregunta, String cantidadRespuestas, String cantidadAciertos, String estado, String categoria) {
        try {
            Query qryJugadores = em.createNamedQuery("PregPreguntas.findByParameters", PregPreguntas.class);
            qryJugadores.setParameter("id", "%" + id + "%");
            qryJugadores.setParameter("textoPregunta", "%" + textoPregunta + "%");
            qryJugadores.setParameter("cantidadRespuestas", "%" + cantidadRespuestas + "%");
            qryJugadores.setParameter("cantidadAciertos", "%" + cantidadAciertos + "%");
            qryJugadores.setParameter("estado", "%" + estado + "%");
            qryJugadores.setParameter("categoria", "%" + categoria + "%");

            List<PregPreguntasDto> preguntas = new ArrayList<>();
            List<PregPreguntas> pregunta = qryJugadores.getResultList();

            for (PregPreguntas tempPreguntas : pregunta) {
                PregPreguntasDto preguntasDto = new PregPreguntasDto(tempPreguntas);
                for (PregRespuestas respuestas : tempPreguntas.getRespuestasList()) {
                    PregRespuestasDto respuestaDto = new PregRespuestasDto(respuestas);
                    respuestaDto.setPreId(tempPreguntas);
                    preguntasDto.getPregRespuestasList().add(respuestaDto);
                }
                preguntas.add(preguntasDto);
            }

            return new Respuesta(true, "", "", "PregPreguntas", preguntas);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe ninguna pregunta con los parametros colocados.", "getPreguntas NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PregPreguntasService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar la pregunta.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar las preguntas.", "getPreguntas NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PregPreguntasService.class.getName()).log(Level.SEVERE, "Error obteniendo las preguntas", ex);
            return new Respuesta(false, "Error obteniendo las preguntas.", "getPreguntas " + ex.getMessage());
        }
    }

    public Respuesta guardarPregunta(PregPreguntasDto pregPreguntasDto) {
        try {
            et = em.getTransaction();
            et.begin();
            PregPreguntas pregPreguntas;
            if (pregPreguntasDto.getId() != null && pregPreguntasDto.getId() > 0) {
                pregPreguntas = em.find(PregPreguntas.class, pregPreguntasDto.getId());
                if (pregPreguntas == null) {
                    return new Respuesta(false, "No se encontró la pregunta", "guardarPregunta NoResultException");
                }
                pregPreguntas.Actualizar(pregPreguntasDto);
                for (PregRespuestasDto resp : pregPreguntasDto.getPregRespuestasList()) {
                    pregPreguntas.getRespuestasList().remove(new PregRespuestas(resp.getId()));
                }
                if (!pregPreguntasDto.getPregRespuestasList().isEmpty()) {
                    for (PregRespuestasDto resp : pregPreguntasDto.getPregRespuestasList()) {
                        if (resp.getModificado()) {
                            PregRespuestas respuesta = em.find(PregRespuestas.class, resp.getId());
                            pregPreguntas.getRespuestasList().add(respuesta);
                        }
                    }
                }
                pregPreguntas = em.merge(pregPreguntas);
            } else {
                pregPreguntas = new PregPreguntas(pregPreguntasDto);
                em.persist(pregPreguntas);
            }
            et.commit();
            return new Respuesta(true, "", "", "PregPregunta", new PregPreguntasDto(pregPreguntas));

        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PregPreguntasService.class.getName()).log(Level.SEVERE, "Error guardando la pregunta", ex);
            return new Respuesta(false, "Error guardando la pregunta.", "guardarPregunta " + ex.getMessage());
        }
    }

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
            Logger.getLogger(PregPreguntasService.class.getName()).log(Level.SEVERE, "Error eliminando la pregunta", ex);
            return new Respuesta(false, "Error eliminando la pregunta.", "eliminarPregunta " + ex.getMessage());
        }
    }
}
