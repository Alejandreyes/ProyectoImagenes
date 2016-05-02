/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTest;
import MB.MBUsuario;
import Controlador.dao.UsuarioDao;
import Modelo.Usuario;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juancarlos
 */
public class MBUsuarioTest {
    
    MBUsuario mbu = new MBUsuario();
    
    public MBUsuarioTest (){
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mbu.setNombre("Juan Carlos");
        mbu.setApellidos("Lopez Lopez");
        mbu.setContrasenia("jc");
        mbu.setNombreusuario("JCLL");
        mbu.setCorreo("jcll@gmail.com");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testsignUp(){
        mbu.signUp();
        MBUsuario mbu1 = new MBUsuario();
        mbu1.setNombreusuario("JCLL");
        mbu1.setContrasenia("jc");
        mbu1.valida();
        Assert.assertTrue(mbu.getNombre().equals(mbu1.getNombre()));
        Assert.assertTrue(mbu.getApellidos().equals(mbu1.getApellidos()));
        Assert.assertTrue(mbu.getContrasenia().equals(mbu1.getContrasenia()));
        Assert.assertTrue(mbu.getNombreusuario().equals(mbu1.getNombreusuario()));
        Assert.assertTrue(mbu.getCorreo().equals(mbu1.getCorreo()));
        UsuarioDao ud = new UsuarioDao();
        Usuario usr = ud.Buscar("JCLL");
        ud.Eliminar(usr);
    }
    
    public void testvalida() {
        mbu.signUp();
        MBUsuario mbu1 = new MBUsuario();
        mbu1.setNombreusuario("JCLL");
        mbu1.setContrasenia("jc");
        mbu1.valida();
        Assert.assertTrue(mbu.getNombre().equals(mbu1.getNombre()));
        Assert.assertTrue(mbu.getApellidos().equals(mbu1.getApellidos()));
        Assert.assertTrue(mbu.getContrasenia().equals(mbu1.getContrasenia()));
        Assert.assertTrue(mbu.getNombreusuario().equals(mbu1.getNombreusuario()));
        Assert.assertTrue(mbu.getCorreo().equals(mbu1.getCorreo()));
        UsuarioDao ud = new UsuarioDao();
        Usuario usr = ud.Buscar("JCLL");
        ud.Eliminar(usr);
    }
    
    public void testsalir () {
        mbu.signUp();
        MBUsuario mbu1 = new MBUsuario();
        mbu1.setNombreusuario("JCLL");
        mbu1.setContrasenia("jc");
        mbu1.valida();
        mbu1.salir();
        Assert.assertTrue(mbu1.getNombre() == null);
        Assert.assertTrue(mbu1.getApellidos() == null);
        Assert.assertTrue(mbu1.getContrasenia() == null);
        Assert.assertTrue(mbu1.getNombreusuario() == null);
        Assert.assertTrue(mbu1.getCorreo() == null);
        UsuarioDao ud = new UsuarioDao();
        Usuario usr = ud.Buscar("JCLL");
        ud.Eliminar(usr);
    }

    
}
