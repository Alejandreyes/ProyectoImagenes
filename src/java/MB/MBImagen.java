/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Stein
 */
@ManagedBean
@RequestScoped
public class MBImagen {

    private StreamedContent graphicImage;

    /**
     * Creates a new instance of MBImagen
     */
    public MBImagen() {
    }

    /**
     * Creates a new instance of MyBean
     */
    public void prepararImagen() throws FileNotFoundException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String realPath = (String) servletContext.getRealPath("/");
            System.out.println(realPath);
            Path f = Paths.get(realPath);
            System.out.println(f.subpath(0, f.getNameCount() - 2));

            realPath = f.getRoot().toString() + f.subpath(0, f.getNameCount() - 2) + "/anime-ore-desmotivaciones.jpg";
            graphicImage = new DefaultStreamedContent(new FileInputStream(realPath));
        } catch (Exception e) {
            String path = "C:\\Users\\Stein\\Desktop\\Fatezero.jpg";
            graphicImage = new DefaultStreamedContent(new FileInputStream(path));
        }
    }

    public StreamedContent getGraphicImage() {
        try {
            prepararImagen();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MBImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return graphicImage;
    }

    public void setGraphicImage(StreamedContent graphicImage) {
        this.graphicImage = graphicImage;
    }

    public void prepararImagen(Object o) throws FileNotFoundException {
        try{
            //System.out.println(o.toString());
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String realPath = (String) servletContext.getRealPath("/");
            
        Path f = Paths.get(realPath);
          realPath = f.getRoot().toString() + f.subpath(0, f.getNameCount() - 2) + "\\";
        realPath =realPath+"Fatezero.jpg";
        System.err.println(realPath);
        
        graphicImage = new DefaultStreamedContent(new FileInputStream(realPath));
        }catch(Exception e ){
            String path = "C:\\Users\\Stein\\Desktop\\Fatezero.jpg";
            graphicImage = new DefaultStreamedContent(new FileInputStream(path));
        }
    }

    public StreamedContent imagen(Object o) {
        try {
            System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Paso");
            prepararImagen(o);
            System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Ok");
        } catch (FileNotFoundException ex) {
            System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++ No paso");
        }
          System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Termino");
        return graphicImage;

    }

}
