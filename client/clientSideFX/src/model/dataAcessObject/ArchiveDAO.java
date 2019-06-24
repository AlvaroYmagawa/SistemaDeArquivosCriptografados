package model.dataAcessObject;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ArchiveDAO {
    
    public static File read(){
         JFileChooser chooser = new JFileChooser();
            
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "arquivo", "txt");
            
            chooser.setFileFilter(filter);
            
            int returnVal = chooser.showOpenDialog(null);
            
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " +
                        chooser.getSelectedFile().getName());
                return chooser.getSelectedFile();
            }
        return null;
    }
}
