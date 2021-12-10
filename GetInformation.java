import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GetInformation {

    private String name, email, phoneNum, gender, date, origin, destination, deparTime;
    private int age, price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparTime() {
        return deparTime;
    }

    public void setDeparTime(String deparTime) {
        this.deparTime = deparTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int totalPrice(int age, String gender) {
        int price = 1000;
        if (age <= 12) {
            price = (int) (price * 0.5);
        } else if (age >= 60) {
            price = (int) (price * 0.4);
        }

        if (gender.equals("Female")) {
            price = (int) (price * 0.75);
        }
        return price;
    }

    public static void main(String[] args) {
        try {
            File file = new File("BoardingPassTicket.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void createPass(int passNum, String Date, String Origin, String destination, String ETA, String depTime, String name, String email, String phoneNum, String gender, int age, int price) {

        java.io.File file = new java.io.File("/Users/alinaken/Desktop/GenSpark/Projects/BoardingPass/BoardingPassTicket.txt");

        String str = "ID #: " + passNum + "  Name: " + name + "  Gender: " + gender + "  Age: " + age + "  " + "Date: " + Date +
                "\n" + "Phone #: " + phoneNum + "  Email: " + email + "\n" + "Origin: " + Origin +
                "  Destination: " + destination + "\n" +
                "Departure Time: " + depTime + "  Arrival Time: " + ETA + "  Price: " + price;
        try {
            FileReader fr = new FileReader(file);
            int size = fr.read();
            Scanner scan1 = new Scanner(fr);

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (size > -1) {
                bw.newLine();
                bw.newLine();
            }
            bw.write(str);
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}


