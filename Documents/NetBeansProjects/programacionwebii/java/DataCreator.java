/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roman
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DataCreator {

    /**
     * Salva un listado de objetos sin sobre escribir.
     *
     * @param file    Destino a escribir
     * @param objects Objecto de instancia de clase con valores
     * @return Si escribió o no el objeto
     */
    public static boolean saveDataToFile(File file, List objects) {
        for (Object obj : objects) {
            saveDataToFile(file, obj);
        }
        return true;
    }

    /**
     * Para usar debo tener el archivo a escribir y paso el objeto a escribir en el y dejo que el API funcione.
     *
     * @param file   Destino a escribir
     * @param object Objecto de instancia de clase con valores
     * @return Si escribió o no el objeto
     */
    public static boolean saveDataToFile(File file, Object object) {
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            printWriter.println(Constants.stringify(object));
            printWriter.flush();
            printWriter.close();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    /**
     * Reemplaza toda la data por la lista entregada.
     *
     * @param file    Destino a escribir
     * @param objects Objecto de instancia de clase con valores
     * @return Si escribió o no el objeto
     */
    public static boolean replaceDataToFile(File file, List objects) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (Object obj : objects) {
                printWriter.println(Constants.stringify(obj));
            }
            printWriter.flush();
            printWriter.close();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    /**
     * Reemplaza toda la data por el objeto en si.
     *
     * @param file   Destino a escribir
     * @param object Objecto de instancia de clase con valores
     * @return Si escribió o no el objeto
     */
    public static boolean replaceDataToFile(File file, Object object) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(Constants.stringify(object));
            printWriter.flush();
            printWriter.close();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    /**
     * Lee el archivo completo con la data del tipo de clase.
     *
     * @param file   Archivo a leer
     * @param tClass Tipo de clase del objeto a leer
     * @param <T>    Clase del objeto
     * @return Listado del objeto
     */
    public static <T> List<T> readData(File file, Class<T> tClass) {
        try {
            List<T> data = new ArrayList<>();
            for (String line : Files.readAllLines(file.toPath())) {
                data.add(Constants.convert(line, tClass));
            }
            return data;
        } catch (IOException ignored) {
            return new ArrayList<>();
        }
    }
}