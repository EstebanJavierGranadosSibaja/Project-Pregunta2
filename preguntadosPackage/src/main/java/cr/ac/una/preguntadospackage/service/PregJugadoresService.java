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
            qryJugadores.setParameter("id", "%"+id+"%");
            qryJugadores.setParameter("nombre", "%"+nombre+"%");
            qryJugadores.setParameter("partidasJugadas", "%"+partidasJugadas+"%");
            qryJugadores.setParameter("partidasGanadas", "%"+partidasGanadas+"%");
            qryJugadores.setParameter("cantidadRespuestasGeneral", "%"+cantidadRespuestasGeneral+"%");
            qryJugadores.setParameter("cantidadAcertadasGeneral", "%"+cantidadAcertadasGeneral+"%");
            
            List<PregJugadoresDto> jugadores = new ArrayList<>();
            List<PregJugadores> jugador = qryJugadores.getResultList();
            for (PregJugadores tempJugadores : jugador) 
            {
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

//    public Respuesta getEmpleado(Long id) {
//        try {
//            Query qryEmpleado = em.createNamedQuery("Empleado.findByEmpId", Empleado.class);
//            qryEmpleado.setParameter("id", id);
//            EmpleadoDto empleadoDto = new EmpleadoDto((Empleado) qryEmpleado.getSingleResult());
//            return new Respuesta(true, "", "", "Empleado", empleadoDto);
//        } catch (NoResultException ex) {
//            return new Respuesta(false, "No existe un empleado el ID ingresadas.", "getEmpleado NoResultException");
//        } catch (NonUniqueResultException ex) {
//            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
//            return new Respuesta(false, "Ocurrio un error al consultar al empleado.", "getEmpleado NonUniqueResultException");
//        } catch (Exception ex) {
//            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo al empleado [" + id + "]", ex);
//            return new Respuesta(false, "Error obteniendo al empleado.", "getEmpleado " + ex.getMessage());
//        }
//    }
//
//    public Respuesta getEmpleados(String cedula, String nombre, String pApellido, String sApellido) {
//        try {
//            Query qryEmpleado = em.createNamedQuery("Empleado.findByParameters", Empleado.class);
//            qryEmpleado.setParameter("cedula", "%"+cedula+"%");
//            qryEmpleado.setParameter("nombre", "%"+nombre+"%");
//            qryEmpleado.setParameter("pApellido", "%"+pApellido+"%");
//            qryEmpleado.setParameter("sApellido", "%"+sApellido+"%");
//            
//            List<EmpleadoDto> empleados = new ArrayList<>();
//            List<Empleado> empleado = qryEmpleado.getResultList();
//            for (Empleado tempEmpleado : empleado) 
//            {
//                empleados.add(new EmpleadoDto(tempEmpleado));
//            }
//            return new Respuesta(true, "", "", "Empleados", empleados);
//        } catch (NoResultException ex) {
//            return new Respuesta(false, "No existe ningun usuario con los parametros colocados.", "getEmpleados NoResultException");
//        } catch (NonUniqueResultException ex) {
//            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
//            return new Respuesta(false, "Ocurrio un error al consultar los empleados.", "getEmpleado NonUniqueResultException");
//        } catch (Exception ex) {
//            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo los empleados", ex);
//            return new Respuesta(false, "Error obteniendo los empleados.", "getEmpleados " + ex.getMessage());
//        }
//    }
//
//    public Respuesta guardarEmpleado(EmpleadoDto empleadoDto) {
//        try {
//            et = em.getTransaction();
//            et.begin();
//            Empleado empleado;
//            if (empleadoDto.getId() != null && empleadoDto.getId() > 0) {
//                empleado = em.find(Empleado.class, empleadoDto.getId());
//                if (empleado == null) {
//                    return new Respuesta(false, "No se encontró", "guardarEmpleado NoResultException");
//                }
//                empleado.Actualizar(empleadoDto);
//                empleado = em.merge(empleado);
//            } else {
//                empleado = new Empleado(empleadoDto);
//                em.persist(empleado);
//            }
//            et.commit();
//            return new Respuesta(true, "", "", "Empleado", new EmpleadoDto(empleado));
//
//        } catch (Exception ex) {
//            et.rollback();
//            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error guardadndo al empleado", ex);
//            return new Respuesta(false, "Error guardadndo al empleado.", "guardarEmpleado " + ex.getMessage());
//        }
//    }
//
//    public Respuesta eliminarEmpleado(Long id) {
//        try {
//            et = em.getTransaction();
//            et.begin();
//            Empleado empleado;
//            if (id != null && id > 0) {
//                empleado = em.find(Empleado.class, id);
//                if (empleado == null) {
//                    return new Respuesta(false, "No se encontró", "eliminarEmpleado NoResultException");
//                }
//                em.remove(empleado);
//            } else {
//                return new Respuesta(false, "No se encontró", "eliminarEmpleado NoResultException");
//            }
//            et.commit();
//            return new Respuesta(true, "", "");
//        } catch (Exception ex) {
//            et.rollback();
//            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error guardadndo al empleado", ex);
//            return new Respuesta(false, "Error guardadndo al empleado.", "guardarEmpleado " + ex.getMessage());
//        }
//    }
}
