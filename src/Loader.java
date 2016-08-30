import java.io.*;

public class Loader {

    public static void main(String[] args)
    {
        try {
            System.out.println("Введите пожалуйста абсолютный путь к папке!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String path = reader.readLine().trim();
            File file = new File(path);
            print(file,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(File  file, String sign)
    {
        if (file.isDirectory() && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length >0) {
                for (File list : listFiles) {
                    if (list.isDirectory()) {
                        System.out.println(sign + list.getName());
                        print(list, (sign + "\t"));
                    } else {
                        System.out.println(sign + list.getName() + " -> " + list.length());
                        continue;
                    }
                }
            }
        }
    }
}
