/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.dao;

import Modelo.Objeto;
import Modelo.Prestar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author stein
 */
public class PrestarDao extends AbstractDao{
    public Prestar Buscar(String nombreLibro) throws DataAccessLayerException{
        Prestar returnValue = null;
        session.getTransaction().commit();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            returnValue = (Prestar) session.createQuery("from "+"Prestar"+" where "+"id"+"= " + nombreLibro+" and  "  ).uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
    public void Actualizar(Prestar o) throws DataAccessLayerException{
       super.update(o);
    }
    public void Eliminar(Prestar o) throws DataAccessLayerException{
        super.delete(o);
    }
    public void Guardar(Prestar o) throws DataAccessLayerException{
        super.save(o);
    }
    public List<Prestar>obtenerTodos(){
        return super.findAll(Prestar.class);
    }
    public  boolean disponible(Objeto obj){
        Boolean disponible = false;
        super.startOperation();
        try {
            Query d = session.createQuery("from "+"Prestar"+" where "+"nombrelibro"+" like \'" +obj.getNombrelibro()+"\'");
            disponible = (d.list().isEmpty());
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return disponible;
    }
    
}
