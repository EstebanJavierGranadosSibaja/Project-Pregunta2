package cr.ac.una.preguntadospackage.service;

import cr.ac.una.preguntadospackage.util.EntityManagerHelper;
import cr.ac.una.preguntadospackage.model.PregCategorias;
import cr.ac.una.preguntadospackage.model.PregCategoriasDto;
import cr.ac.una.preguntadospackage.util.Respuesta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PregCategoriasService {
    
    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta getCategoria(String categoria) {
        try {
            Query qryCategoria = em.createNamedQuery("PregCategorias.findByCatCategoria", PregCategorias.class);
            qryCategoria.setParameter("categoria", categoria);
            PregCategoriasDto pregCategoriasDto = new PregCategoriasDto((PregCategorias) qryCategoria.getSingleResult());
            return new Respuesta(true, "", "", "PregCategoria", pregCategoriasDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe la categoria consultada.", "getCategoria NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PregCategoriasService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar la categoria.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar la categoria.", "getCategoria NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PregCategoriasService.class.getName()).log(Level.SEVERE, "Error obteniendo la categoria [" + categoria + "]", ex);
            return new Respuesta(false, "Error obteniendo la categoria.", "getCategoria " + ex.getMessage());
        }
    }
}
