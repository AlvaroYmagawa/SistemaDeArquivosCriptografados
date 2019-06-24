package model.dataAcessObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.businessObject.RetrofitCore;
import model.valueObject.Archive;
import model.valueObject.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArchiveDAO {

    public static File read() {
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "arquivo", "txt");

        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "
                    + chooser.getSelectedFile().getName());
            return chooser.getSelectedFile();
        }
        return null;
    }

    public static List<Archive> read(String email, String token) {
        try {
            Retrofit retrofit = RetrofitCore.retrofit();
            archive_api api = retrofit.create(archive_api.class);

            Call<Archive> call = api.getArchive(RetrofitCore.getHeaders(email, token));

            List<Archive> list = (List<Archive>) call.execute().body();
            return list;
        } catch (IOException ex) {
            System.out.println("Erro - " + ex.getMessage());
            return null;
        }
    }
}
