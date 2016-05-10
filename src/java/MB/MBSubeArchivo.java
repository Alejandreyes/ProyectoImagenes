
package MB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author CAEN
 */
@ManagedBean
@RequestScoped
public class MBSubeArchivo {

      //private final String destination="C:\\Users\\Stein\\Desktop\\";
 //private final String destination="C:/Users/Stein/Desktop/";
 
    public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
             FacesMessage message = new FacesMessage("Is NOT Succesful", event.getFile().getFileName() + " is not uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
 
    }  
 
    public void copyFile(String fileName, InputStream in) {
           try {
               ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
               String realPath=(String) servletContext.getRealPath("/");
               System.out.println(realPath);
               Path f=Paths.get(realPath);
               System.out.println(f.subpath(0, f.getNameCount() - 2));
               OutputStream out = new FileOutputStream(new File("C:/"+f.subpath(0, f.getNameCount() - 2)+"/" + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.flush();
                out.close();
              
                System.out.println("New file created!");
               // FacesMessage message = new FacesMessage("Succesful", fileName + " is uploaded.");
        //FacesContext.getCurrentInstance().addMessage(null, message);

           } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
    
    
}
