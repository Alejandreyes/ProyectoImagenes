/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTest;

import MB.MBObjeto;
import MB.MBUsuario;
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
 * @author rodrigorojo
 */
public class MBObjetoTest {
    
    MBObjeto mbo = new MBObjeto();
    MBUsuario mbu = new MBUsuario();
    
    public MBObjetoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mbu.setNombre("Rodrigo");
        mbu.setApellidos("Rojo");
        mbu.setContrasenia("123");
        mbu.setNombreusuario("RR");
        
        mbo.setNombreLibro("HarryPotter");
        mbo.setAutor("JKR");
        mbo.setAnio(1997);
        mbo.setEdicion(1);
        mbo.setGenero("Fantasia");
        mbo.setNumPaginas(100);
        mbo.setNombreUsuario("RR");
        mbo.setmBUsuario(mbu);
        
        
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testAltaObjeto(){
        mbo.altaObjeto();
        MBObjeto mbo1 = new MBObjeto();
        mbo1.setBuscarLibro("HarryPotter");
        mbo1.consultarObjeto();
        Assert.assertTrue(mbo.getNombreLibro().equals(mbo1.getNombreLibro()));
        mbo1.bajaObjeto();      
    }
    @Test
    public void testBajaObjeto(){
        mbo.altaObjeto();
        Assert.assertTrue(mbo.bajaObjeto().equals("index.xhtml"));  
    }
    @Test
    public void testConsultarObjeto(){
        mbo.altaObjeto();
        MBObjeto mbo1 = new MBObjeto();
        mbo1.setBuscarLibro("HarryPotter");
        mbo1.consultarObjeto();
        Assert.assertTrue(mbo.getNombreLibro().equals(mbo1.getNombreLibro()));
        mbo.bajaObjeto();  
    }
    @Test
    public void testCambiarObjeto(){
        mbo.altaObjeto();
        mbo.setAnio(2000);
        mbo.cambiarObjeto();
        MBObjeto mbo1 = new MBObjeto();
        mbo1.setBuscarLibro("HarryPotter");
        mbo1.consultarObjeto();
        Assert.assertTrue(Objects.equals(mbo.getAnio(), mbo1.getAnio()));
        mbo.bajaObjeto();
    }
    @Test
    public void testSolicitarPrestamo(){
        
    }
}
