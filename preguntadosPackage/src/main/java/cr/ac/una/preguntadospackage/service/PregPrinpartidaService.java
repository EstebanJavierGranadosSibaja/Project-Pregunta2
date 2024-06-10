/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntadospackage.service;

import cr.ac.una.preguntadospackage.model.PregJugpartida;
import cr.ac.una.preguntadospackage.model.PregJugpartidaDto;
import cr.ac.una.preguntadospackage.model.PregPreguntaspartida;
import cr.ac.una.preguntadospackage.model.PregPreguntaspartidaDto;
import cr.ac.una.preguntadospackage.model.PregPrinpartida;
import cr.ac.una.preguntadospackage.model.PregPrinpartidaDto;
import cr.ac.una.preguntadospackage.util.EntityManagerHelper;
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

public class PregPrinpartidaService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta getPartidas(String id, String nombrePartida, String cantidadRondas, String cantidadJugadores, String modoJuego, String modoDuelo, String estadoPartida) {
        try {
            Query qryPartidas = em.createNamedQuery("PregPrinpartida.findByParameters", PregPrinpartida.class);
            qryPartidas.setParameter("id", "%" + id + "%");
            qryPartidas.setParameter("nombrePartida", "%" + nombrePartida + "%");
            qryPartidas.setParameter("cantidadRondas", "%" + cantidadRondas + "%");
            qryPartidas.setParameter("cantidadJugadores", "%" + cantidadJugadores + "%");
            qryPartidas.setParameter("modoJuego", "%" + modoJuego + "%");
            qryPartidas.setParameter("modoDuelo", "%" + modoDuelo + "%");
            qryPartidas.setParameter("estadoPartida", "%" + estadoPartida + "%");

            List<PregPrinpartidaDto> partidas = new ArrayList<>();
            List<PregPrinpartida> partida = qryPartidas.getResultList();

            for (PregPrinpartida tempPartidas : partida) {
                partidas.add(new PregPrinpartidaDto(tempPartidas));
                for (PregPrinpartidaDto partidasDto : partidas) {
                    for (PregPreguntaspartida parPreguntas : tempPartidas.getPreguntaspartidaList()) {
                        partidasDto.getPregPreguntaspartidaList().add(new PregPreguntaspartidaDto(parPreguntas));
                    }
                    for (PregJugpartida parJugpartidas : tempPartidas.getPregJugpartidaList()) {
                        partidasDto.getPregJugpartidaList().add(new PregJugpartidaDto(parJugpartidas));
                    }
                }
            }
            return new Respuesta(true, "", "", "PregPrinpartidas", partidas);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe ninguna partida con los parametros colocados.", "getPartidas NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PregPrinpartidaService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar la partida.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar las partdias.", "getPartidas NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PregPrinpartidaService.class.getName()).log(Level.SEVERE, "Error obteniendo las partidas", ex);
            return new Respuesta(false, "Error obteniendo las partidas.", "getPartidas " + ex.getMessage());
        }
    }

}
