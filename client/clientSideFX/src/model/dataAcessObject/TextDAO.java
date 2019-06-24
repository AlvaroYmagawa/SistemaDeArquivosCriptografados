/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ld_si
 */
public class TextDAO {
    /**
     *
     * @param content
     * @param dir
     * @param file
     * @param append
     * @throws IOException
     */
    public static void writeText(
            String content,
            String dir,
            String file,
            Boolean append)
            throws IOException {
        File arq = new File(dir, file);
        FileWriter wr = new FileWriter(arq, append);
        BufferedWriter bw = new BufferedWriter(wr);
        wr.flush();
        bw.write(content);
        bw.close();
        wr.close();
        bw.close();
    }

    /**
     *
     * @param dirFile
     * @return ArrayList
     * @throws FileNotFoundException
     */
    public static String readText(
            File file)
            throws FileNotFoundException, IOException {
        String content = "";
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while (line != null) {
            content += line;
            line = br.readLine();
        }

        fr.close();
        br.close();
        System.out.println("Lido: "+content);
        return content;
    }
}
