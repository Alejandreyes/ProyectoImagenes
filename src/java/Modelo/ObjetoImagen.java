/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import MB.MBObjeto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Stein
 */
public class ObjetoImagen extends Objeto {

    private StreamedContent image1;
    private StreamedContent image2;
    private StreamedContent image3;

    public ObjetoImagen() {
        super();
    }
    public ObjetoImagen(Objeto o) {
        this.setAnio(o.getAnio());
        this.setAutor(o.getAutor());
        this.setEdicion(o.getEdicion());
        this.setEdicion(o.getEdicion());
        this.setGenero(o.getGenero());
        this.setNombrelibro(o.getNombrelibro());
        this.setNumpaginas(o.getNumpaginas());
        this.setSinopsis(o.getSinopsis());
        this.setUsuario(o.getUsuario());
        prepareImage((byte) 1);
        
        prepareImage((byte) 2);
        
        prepareImage((byte) 3);
    }
    public void prepareImage(byte i) {
        try {
            if (i == 1) {
                System.out.println("----------------------------------------Paso aqui");
                String path = "C:\\Users\\Stein\\Documents\\NetBeansProjects\\IngenieriaDeSoftware\\SegundaIteracion\\Proyecto\\Imagenes\\FotosLibros\\comodin.jpg";
                image1 = new DefaultStreamedContent(new FileInputStream(path), "image/png");
            } else {
                if (i == 2) {
                    String path = "C:\\Users\\Stein\\Documents\\NetBeansProjects\\IngenieriaDeSoftware\\SegundaIteracion\\Proyecto\\Imagenes\\FotosLibros\\comodin.jpg";
                    image2 = new DefaultStreamedContent(new FileInputStream(path), "image/png");
                } else {
                    if (i == 3) {
                        String path = "C:\\Users\\Stein\\Documents\\NetBeansProjects\\IngenieriaDeSoftware\\SegundaIteracion\\Proyecto\\Imagenes\\FotosLibros\\comodin.jpg";
                        image3 = new DefaultStreamedContent(new FileInputStream(path), "image/png");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MBObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StreamedContent getImage1() {
        return image1;
    }

    public void setImage1(StreamedContent image1) {
        this.image1 = image1;
    }

    public StreamedContent getImage2() {
        return image2;
    }

    public void setImage2(StreamedContent image2) {
        this.image2 = image2;
    }

    public StreamedContent getImage3(){
        return image3;
    }

    public void setImage3(StreamedContent image3) {
        this.image3 = image3;
    }

    public Objeto objeto() {
        Objeto temp = new Objeto();
        temp.setUsuario(super.getUsuario());
        temp.setAnio(super.getAnio());
        temp.setAutor(super.getAutor());
        temp.setEdicion(super.getEdicion());
        temp.setGenero(super.getGenero());
        temp.setNombrelibro(super.getNombrelibro());
        temp.setNumpaginas(super.getNumpaginas());
        temp.setSinopsis(super.getSinopsis());
        return temp;
    }

}
