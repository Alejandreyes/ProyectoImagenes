/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import Controlador.dao.ObjetoDao;
import Controlador.dao.PrestarDao;
import Modelo.Objeto;
import Modelo.Prestar;
import Modelo.PrestarId;
import Modelo.Usuario;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Stein
 */
@ManagedBean
@RequestScoped
public class MBPrestar {

    @ManagedProperty(value="#{mBUsuario}")
    MBUsuario mBUsuario;
    private PrestarId id;
    private Objeto objeto;
    private String nombreObjeto;
    private Usuario usuarioByNombreprestador;
    private Usuario usuarioByNombreconsumidor;
    private Date fechaprestamo;
    private Integer calificacionprestador;
    private Integer calificaconsumidor;
    private Usuario us;
    
    public MBPrestar() {
    }
    
    public MBUsuario getmBUsuario() {
        return mBUsuario;
    }

    public void setmBUsuario(MBUsuario mBUsuario) {
        this.mBUsuario = mBUsuario;
    }

    public PrestarId getId() {
        return id;
    }

    public void setId(PrestarId id) {
        this.id = id;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public Usuario getUsuarioByNombreprestador() {
        return usuarioByNombreprestador;
    }

    public void setUsuarioByNombreprestador(Usuario usuarioByNombreprestador) {
        this.usuarioByNombreprestador = usuarioByNombreprestador;
    }

    public Usuario getUsuarioByNombreconsumidor() {
        return usuarioByNombreconsumidor;
    }

    public void setUsuarioByNombreconsumidor(Usuario usuarioByNombreconsumidor) {
        this.usuarioByNombreconsumidor = usuarioByNombreconsumidor;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Integer getCalificacionprestador() {
        return calificacionprestador;
    }

    public void setCalificacionprestador(Integer calificacionprestador) {
        this.calificacionprestador = calificacionprestador;
    }

    public Integer getCalificaconsumidor() {
        return calificaconsumidor;
    }

    public void setCalificaconsumidor(Integer calificaconsumidor) {
        this.calificaconsumidor = calificaconsumidor;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public void solicitarPrestamo(){
        ObjetoDao objd = new ObjetoDao();
        Objeto obj = objd.Buscar(nombreObjeto);
        objeto = obj;
        Date date = new Date();
        Prestar prst = new Prestar();
        PrestarDao prstd = new PrestarDao();
        PrestarId psid = new PrestarId();
        
        psid.setNombreconsumidor(us.getNombreusuario());
        psid.setNombreprestador(objeto.getUsuario().getNombreusuario());
        psid.setNombrelibro(objeto.getNombrelibro());
        prst.setId(psid);
        
        prst.setUsuarioByNombreconsumidor(us);
        prst.setUsuarioByNombreprestador(obj.getUsuario());
        prst.setFechaprestamo(date);
        
        prstd.Guardar(prst);
    }
    
}
