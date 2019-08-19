package Task7;

import java.io.*;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task{
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static void main(String[] args) {
        File file = null;
        for (int i = 0; i < 5; i++) {
            file = new File("C:/Users/jbondarenko/Desktop/Tasks7/" + i + "/" + (i + 1) + "/" + (i + 2) + "/" + (i + 3) + "/" + (i + 4));
            file.mkdirs();
        }
        directory();

       /* File directory = new File("C:/Users/jbondarenko/Desktop/Tasks7");
        if (directory.exists() && directory.isDirectory()) {
            processDirectory(directory);
        }*/
        processDirectory();
    }

    static String randomString() {
        Random random = new Random();
        int len = random.nextInt(201);
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    static void directory() {
        try (Stream<Path> walk = Files.walk(Paths.get("C:/Users/jbondarenko/Desktop/Tasks7/"))) {
            walk.filter(Files::isDirectory)
                    .forEach(path -> {
                try {
                    Files.write(Paths.get(path+"name.txt"), randomString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//https://www.mkyong.com/java/java-how-to-list-all-files-in-a-directory/
    //https://ru.stackoverflow.com/questions/465935/%D0%9A%D0%B0%D0%BA-%D0%BE%D0%B1%D0%BE%D0%B9%D1%82%D0%B8-%D0%B2%D1%81%D0%B5-%D1%84%D0%B0%D0%B9%D0%BB%D1%8B-%D0%B2-%D0%BF%D0%B0%D0%BF%D0%BA%D0%B5-%D0%B8-%D0%BF%D0%BE%D0%B4%D0%BF%D0%B0%D0%BF%D0%BA%D0%B0%D1%85-%D0%B8-%D0%BF%D1%80%D0%BE%D1%87%D0%B8%D1%82%D0%B0%D1%82%D1%8C-%D1%82%D0%B5%D0%BA%D1%81%D1%82%D0%BE%D0%B2%D1%8B%D0%B5-%D1%84%D0%B0%D0%B9%D0%BB%D1%8B-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2
    private static void processDirectory() {
        // Получаем список доступных файлов в указанной директории.

        try {
            Files.walk(Paths.get("C:/Users/jbondarenko/Desktop/Tasks7"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Нет доступных файлов для обработки.");
            return;
        } else {
            System.out.println("Количество файлов для обработки: " + files.length);
        }

        // Непосредственно многопоточная обработка файлов.
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (final File f : files) {
            if (!f.isFile()) {
                continue;
            }

            service.execute(new Runnable() {
                @Override
                public void run() {
                    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                        String lines;
                        int line=0;
                        while ((lines=reader.readLine()) != null) {
                            line=lines.length();
                        }
                        System.out.println("Поток: " + Thread.currentThread().getName() + ". Файл: " + f.getName() + ". Количество символов: " + line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // Новые задачи более не принимаем, выполняем только оставшиеся.
        service.shutdown();
        // Ждем завершения выполнения потоков не более 10 минут.
        try {
            service.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}
