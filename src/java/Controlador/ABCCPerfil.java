/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.dao.UsuarioDao;
import MB.MBUsuario;
import Modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Stein
 */
@ManagedBean
@RequestScoped
public class ABCCPerfil {

    @ManagedProperty(value="#{mBUsuario}")
    private MBUsuario mBUsuario;
    private String nombreusuario;
     private String contrasenia;
     private String nombre;
     private String apellidos;
     private String correo;
    public ABCCPerfil() {
    }

    public MBUsuario getmBUsuario() {
        return mBUsuario;
    }

    public void setmBUsuario(MBUsuario mBUsuario) {
        this.mBUsuario = mBUsuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String Consulta(){    
        nombre= mBUsuario.getNombre();
        apellidos=mBUsuario.getApellidos();
        correo=mBUsuario.getCorreo();
        
        return "ConsultarIH?faces-redirect=true";
    }
    public String elimina(){
       Usuario usuarioSesion = new Usuario(mBUsuario.getNombreusuario(), mBUsuario.getContrasenia(), mBUsuario.getNombre(),mBUsuario.getApellidos(),mBUsuario.getCorreo() );

       UsuarioDao dao= new UsuarioDao();
       dao.Eliminar(usuarioSesion);
       return "SignInIH?faces-redirect=true";
    }
    public String actualizar(){
        nombre = (nombre==null || nombre.equals(""))? mBUsuario.getNombre():nombre;
        apellidos = (apellidos==null || apellidos.equals(""))? mBUsuario.getApellidos():apellidos;
        correo = (correo==null || correo.equals(""))? mBUsuario.getCorreo():correo;
       Usuario usuarioSesion = new Usuario(mBUsuario.getNombreusuario(), mBUsuario.getContrasenia(), nombre,apellidos,correo );
       UsuarioDao dao= new UsuarioDao();
       dao.Actualizar(usuarioSesion);
       mBUsuario.setNombre(nombre);
       mBUsuario.setApellidos(apellidos);
       mBUsuario.setCorreo(correo);
       return "ConsultarIH?faces-redirect=true";
    }
    public boolean verificarSesion(){
        return mBUsuario.getNombreusuario() != null;
    }
}
