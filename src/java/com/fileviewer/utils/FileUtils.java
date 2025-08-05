/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.fileviewer.utils;

import java.io.*;
public class FileUtils {


    public static boolean isValidId(String id) {
        if (id == null || id.trim().isEmpty()) return false;
        if (id.contains("..") || id.contains("/") || id.contains("\\")) return false;
        return id.matches("^[a-zA-Z0-9]+$");
    }

    public static String getCanonicalPath(String basePath, String fileName) throws IOException {
        File file = new File(basePath, fileName);
        String filePath = file.getCanonicalPath();
        String baseCanonical = new File(basePath).getCanonicalPath();
        if (!filePath.startsWith(baseCanonical)) {
            throw new SecurityException("Access denied");
        }
        return filePath;
    }

    public static String readFile(String fullPath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("<br>");
            }
        }
        return content.toString();
    }
}

