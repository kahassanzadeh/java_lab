package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;

import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * this class is created for the file handling
 *
 * @author mohammadreza hassanzadeh
 * @since 17 Dec 2020
 * @version 1.0
 */
public class FileUtils {
    //String for the address of the files
    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    /**
     * get files of the directory
     *
     * @return file Collection
     */
    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }

    /**
     * method for reading from a file
     *
     * @param file file that we want to read From
     * @return String of the content
     */
    public static String fileReader(File file) {
        //TODO: Phase1: read content from file
        String content = "";
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String tempReader;
            while((tempReader = reader.readLine()) != null){
                content += tempReader;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    /**
     * this method will write to file
     * @param content String that we want to write
     */
    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = getProperFileName(content);

        BufferedWriter writer = null;
        try{
            File file = new File(NOTES_PATH + fileName + ".txt");
            if(!file.exists()){
                file.createNewFile();
            }
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);

        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(writer != null){
                    writer.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //TODO: Phase1: define method here for reading file with InputStream

    /**
     * this method will read File Stream
     *
     * @param file file that we want to read
     * @return string of content
     */
    public static String readFileStream(File file){
        String temp = "";
        try{
            FileInputStream fis = new FileInputStream(file);
            int tempNumber = 0;
            while((tempNumber = fis.read()) != -1){
                char tempChar = (char) tempNumber;
                temp += Character.toString(tempChar);
            }
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return temp;
    }
    //TODO: Phase1: define method here for writing file with OutputStream

    /**
     * this method will write with output Stream
     *
     * @param content String
     */
    public static void writeFileStream(String content){
        String fileName = getProperFileName(content);

        try{
            FileOutputStream fos = new FileOutputStream(NOTES_PATH + fileName);
            byte[] bt = content.getBytes();
            fos.write(bt);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //TODO: Phase2: proper methods for handling serialization

    /**
     * this method will read objects from file
     * @param file file
     * @return String
     */
    public static String readObject(File file){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return ois.readObject().toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * this method will write Object to files
     * @param content String
     */
    public static void writeObject(String content){
        String fileName = getProperFileName(content);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(new Note(fileName,content, LocalDateTime.now().toString()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * this method will initialize the name Address
     * @param content String content
     * @return address String
     */
    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
