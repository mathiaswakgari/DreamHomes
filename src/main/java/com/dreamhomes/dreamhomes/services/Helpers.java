package com.dreamhomes.dreamhomes.services;
import jakarta.servlet.http.Part;
import java.io.*;
public class Helpers {
    public File convertPartToFile(Part filePart){
        try{
            InputStream inputStream = filePart.getInputStream();
            String contentType = filePart.getContentType();
            File temp = File.createTempFile("temp", "." + contentType.substring(contentType.lastIndexOf('/')+ 1));
            OutputStream outputStream = new FileOutputStream(temp);

            try {
                byte[] buffer = new byte[inputStream.available()];
                int length;
                while ((length = inputStream.read(buffer)) > 0){
                    outputStream.write(buffer, 0, length);
                }
            }finally {
                inputStream.close();
                outputStream.close();
            }

            return temp;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
