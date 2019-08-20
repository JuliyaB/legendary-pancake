package Task7;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Task {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    static final Path path = Paths.get("C:/Users/jbondarenko/Desktop/Tasks7/");
    static Map<String, Integer> mapFiles=new TreeMap<>();
    
    public static void main(String[] args) {
        File file = null;
        Random random1 = new Random();
        int count1 = random1.nextInt(21);
        for (int i = 0; i < count1; i++) {
            file = new File("C:/Users/jbondarenko/Desktop/Tasks7/" + i + "/" + (i + 1) + "/" + (i + 2) + "/" + (i + 3) + "/" + (i + 4));
            file.mkdirs();
        }
        try {
            fileСreation();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            processDirectory();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry entry : mapFiles.entrySet()) {
            System.out.println("Файл: " + entry.getKey() + " Количество символов в файле: "
                    + entry.getValue());
        }
       /* List list = new ArrayList(mapFiles.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
        System.out.println(list);*/

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException
                {
                    Files.delete(path);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path directory, IOException ioException) throws IOException
                {
                    Files.delete(directory);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String randomString() {
        Random random = new Random();
        int len = random.nextInt(201);
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    static String randomName(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    static void fileСreation() throws IOException {
        try (Stream<Path> walk = Files.walk(path)) {
            walk.filter(Files::isDirectory)
                    .forEach(path -> {
                        try {
                            Random random = new Random();
                            int count = random.nextInt(21);
                            for(int i=0; i<count; i++) {
                                Files.write(Paths.get(path + "/" + randomName(5) + ".txt"), randomString().getBytes());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    });
        }
    }

    private static void processDirectory() throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        try (Stream<Path> walk = Files.walk(path)) {
            walk.filter(Files::isRegularFile)
                    .forEach(path -> {
                        service.execute(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Началась бработка файла " + path +" поток: "+ Thread.currentThread().getName());
                                try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
                                    String lines;
                                    int line = 0;
                                    while ((lines = reader.readLine()) != null) {
                                        line = lines.length();
                                    }
                                    mapFiles.put((path.toFile()).getName(), line);
                                    System.out.println("Обработка файла закончена " + path +" поток: "+ Thread.currentThread().getName());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    });
        }
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
