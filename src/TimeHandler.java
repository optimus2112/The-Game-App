import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class TimeHandler {
    String path;
    int s;
    int h;
    int m;
    int days;
    int weeks;
    long mil;

    public TimeHandler() {
        this.path = "C:\\Users\\eviat\\OneDrive - Amit Schools\\programing\\New folder\\res\\time.txt";

    }

    public void mainFunction() {

        while (true) {
            mil = System.currentTimeMillis() - Long.parseLong(getInfo(0));

            s = (int) (mil / 1000 % 60);
            h = (int) (mil / 1000 / 60 / 60 % 24);
            m = (int) (mil / 1000 / 60 % 60);
            days = (int) (mil / 1000 / 60 / 60 / 24 % 7);
            weeks = (int) (mil / 1000 / 60 / 60 / 24 / 7);
            if (getInfo(3).equals("true")) {
                buttonPressed();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(weeks + " : " + days + " : " + h + " : " + m + " : " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static String parse(long mil) {
        int s = (int) (mil / 1000 % 60);
        int h = (int) (mil / 1000 / 60 / 60 % 24);
        int m = (int) (mil / 1000 / 60 % 60);
        int days = (int) (mil / 1000 / 60 / 60 / 24 % 7);
        int weeks = (int) (mil / 1000 / 60 / 60 / 24 / 7);
        return weeks + " : " + days + " : " + h + " : " + m + " : " + s;

    }

    public void write(String data, int line) {
        try {
            File tmp = new File(path);
            List<String> lines = Files.readAllLines(tmp.toPath());
            lines.set(line, data);
            Files.write(tmp.toPath(), lines);
        } catch (IOException e) {

        }
    }

    public String getInfo(int lineInFile) {
        File tmp = new File(path);

        try {
            String line32 = Files.readAllLines(tmp.toPath()).get(lineInFile);
            return line32;
        } catch (IOException e) {
            return "";
        }
    }

    public void buttonPressed() {
        write(String.valueOf(mil), 2);
        write("false", 3);
        if (Long.parseLong(getInfo(2)) > Long.parseLong(getInfo(1))) {
            write(String.valueOf(mil), 1);
        }
        write(String.valueOf(System.currentTimeMillis()), 0);
    }

    public static void main(String[] args) {
        TimeHandler g = new TimeHandler();
        g.write(String.valueOf(System.currentTimeMillis()), 0);
        g.mainFunction();
    }
}