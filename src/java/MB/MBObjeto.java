/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import Controlador.dao.ObjetoDao;
import Controlador.dao.PrestarDao;
import Controlador.dao.UsuarioDao;
import Modelo.Objeto;
import Modelo.Prestar;
import Modelo.PrestarId;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Stein
 */
@ManagedBean
@RequestScoped
public class MBObjeto {

    @ManagedProperty(value="#{mBUsuario}")
    private MBUsuario mBUsuario;
    String nombreLibro;
    String buscarLibro;
    String autor;
    Integer edicion;
    Integer anio;
    String genero;
    String sinopsis;
    Integer numPaginas;
    String nombreUsuario;
    String resultado;
    private String usuarioIniciado;
    
    List<Objeto> objetos = new ArrayList<Objeto>();
    public MBObjeto() {
    }

    public MBUsuario getmBUsuario() {
        return mBUsuario;
    }

    public void setmBUsuario(MBUsuario mBUsuario) {
        this.mBUsuario = mBUsuario;
    }

    

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getBuscarLibro() {
        return buscarLibro;
    }

    public void setBuscarLibro(String buscarLibro) {
        this.buscarLibro = buscarLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getEdicion() {
        return edicion;
    }

    public void setEdicion(Integer edicion) {
        this.edicion = edicion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }
       public String altaObjeto(){
          Usuario us= new Usuario(mBUsuario.getNombreusuario(), mBUsuario.getContrasenia(), mBUsuario.getNombre(),mBUsuario.getApellidos(),mBUsuario.getCorreo() );
        Objeto obj;
        obj = new Objeto();
        obj.setNombrelibro(nombreLibro);
        obj.setAutor(autor);
        obj.setEdicion(edicion);
        obj.setAnio(anio);
        obj.setGenero(genero);
        obj.setSinopsis(sinopsis);
        obj.setNumpaginas(numPaginas);
        UsuarioDao usrd = new UsuarioDao();
        Usuario usr = usrd.Buscar(us.getNombreusuario());
        obj.setUsuario(usr);
        ObjetoDao objd = new ObjetoDao();
        objd.Guardar(obj);
        return "index?faces-redirect=true";
    }
    public String consultarObjeto(){
         Usuario us= new Usuario(mBUsuario.getNombreusuario(), mBUsuario.getContrasenia(), mBUsuario.getNombre(),mBUsuario.getApellidos(),mBUsuario.getCorreo() );
        ObjetoDao objd = new ObjetoDao();
        System.out.println(buscarLibro);
        Objeto obj = objd.Buscar(buscarLibro);
        
        nombreLibro = obj.getNombrelibro();
        autor = obj.getAutor();
        edicion = obj.getEdicion();
        anio = obj.getAnio();
        genero = obj.getGenero();
        sinopsis = obj.getSinopsis();
        numPaginas = obj.getNumpaginas();
        nombreUsuario = obj.getUsuario().getNombreusuario();
        //nombreLibro = obj.getNombrelibro();
        System.out.println(obj);
        return "ConsultaObjetoIH.xhtml";
    }
    public String bajaObjeto(){
        System.out.println("-------------->"+nombreLibro);
        Objeto obj;// = new Objeto();
        ObjetoDao objd = new ObjetoDao();
        obj = objd.Buscar(nombreLibro);
        objd.Eliminar(obj);
        return "index.xhtml";
    }
    public void cambiarObjeto(){
        System.out.println("-.-.-.-243-4-->"+nombreLibro);
        Objeto obj;
        ObjetoDao objd = new ObjetoDao();
        obj = objd.Buscar(nombreLibro);
        obj.setNombrelibro(nombreLibro);
        obj.setAutor(autor);
        obj.setEdicion(edicion);
        obj.setAnio(anio);
        obj.setGenero(genero);
        obj.setSinopsis(sinopsis);
        obj.setNumpaginas(numPaginas);
        objd.Actualizar(obj);
    }
    public List<Objeto> getAllObjetos(){
        ObjetoDao dao=new ObjetoDao();
        return dao.obtenerTodos();
    }
    
    public void solicitarPrestamo(){
        System.out.println("aquiiiiiiiii " +nombreLibro);
        ObjetoDao objd = new ObjetoDao();
        Objeto obj = objd.Buscar(nombreLibro);

        System.out.println("Objetooooo "+obj.getNombrelibro());
        Date date = new Date();
        Prestar prst = new Prestar();
        PrestarDao prstd = new PrestarDao();
        PrestarId psid = new PrestarId();
        
        UsuarioDao usdao = new UsuarioDao();
        Usuario us1 = usdao.Buscar(mBUsuario.getNombreusuario()); //el de la sesion iniciada
        
        System.out.println("|----------|------------|--------|--"); 
        System.out.println("nombUs: "+ us1.getNombreusuario() );
        System.out.println("Usuario:"+obj.getUsuario().getNombreusuario());
        System.out.println("NombLib"+obj.getNombrelibro());
        
        
        psid.setNombreconsumidor(us1.getNombreusuario());
        psid.setNombreprestador(obj.getUsuario().getNombreusuario());
        psid.setNombrelibro(obj.getNombrelibro());
        prst.setId(psid);
        
        prst.setUsuarioByNombreconsumidor(us1);
        prst.setUsuarioByNombreprestador(obj.getUsuario());
        prst.setFechaprestamo(date);
        
        prstd.Guardar(prst);
    }

    /**
     * @return the usuarioIniciado
     */
    public String getUsuarioIniciado() {
        return usuarioIniciado;
    }

    /**
     * @param usuarioIniciado the usuarioIniciado to set
     */
    public void setUsuarioIniciado(String usuarioIniciado) {
        this.usuarioIniciado = usuarioIniciado;
    }
    
}
