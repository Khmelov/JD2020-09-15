package by.it.hutnik.jd01_15;

import java.io.*;
import java.util.ArrayList;

class TaskB {
    public static void main(String[] args) {
        StringBuilder strB = new StringBuilder();
        String delimiter = "";
        String path = getPath() + "TaskB.java";
        try (BufferedReader bReader = new BufferedReader(new FileReader(path))) {
            while (bReader.ready()) {
                strB.append(bReader.readLine()).append(delimiter).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        deleteSingleComment(strB);
        deleteMultiComment(strB);
        try (BufferedWriter bWriter = new BufferedWriter(
                new FileWriter(getPath() + "TaskB.txt"))) {
            bWriter.append(strB);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteSingleComment(StringBuilder lines) {
        for (int i = 0;i < lines.length();i++) {
            if (lines.charAt(i) == '/' && lines.charAt(i + 1) == '/') {
                for (int j = i; j < lines.length(); j++) {
                    if (lines.charAt(j) == '\n') {
                        lines.delete(i, j);
                        System.out.println(lines);
                        break;
                    }
                }
            }
        }
    }


    private static void deleteMultiComment(StringBuilder lines) {
        for (int i = 0;i < lines.length();i++) {
            if (lines.charAt(i) == '/' && lines.charAt(i + 1) == '*') {
                for (int j = i; j < lines.length(); j++) {
                    if (lines.charAt(j) == '*' && lines.charAt(j + 1) == '/') {
                        lines.delete(i, j + 2);
                        System.out.println(lines);
                        break;
                    }
                }
            }

        }

    }

    private static String getPath() {
        String pDir = System.getProperty("user.dir");
        String rPath = TaskB.class.getName()
                .replace(TaskB.class.getSimpleName(), "")
                .replace(".", File.separator);
        return pDir + File.separator + "src" + File.separator + rPath;
    }

}