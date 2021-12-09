import java.util.*;
import java.io.*;

public class GenerateBoardingPass {
    public static void main(String[] args) {
        Set<String> departureTimes = new HashSet<>();
        Set<String> arrivalTimes = new HashSet<>();
        GetInformation g = new GetInformation();
        CreateFile f = new CreateFile();
        int boardingPassNumber, ticketPrice, amPmRand, arrivalTimeRand;
        int choice = 0;
        int age = 0;
        String departureDate, origin, destination, arrivalTime, name, email, phoneNumber, gender, prefix, amPm, confirmation;
        String departureTime = "";
        boolean complete = false;
        Random r = new Random();
        Scanner keyboard = new Scanner(System.in);

        while (!complete) {
            System.out.println("Welcome to the Pyramid Academy Airport Booking Portal. Please tell us your name: (ex. John Smith)");
            name = keyboard.nextLine();
            g.setName(name);

            System.out.println("And could you please specify your gender? (Male/Female)");
            gender = keyboard.nextLine();
            g.setGender(gender);

            if (gender.equalsIgnoreCase("Male")) {
                prefix = "Mr.";
            } else {
                prefix = "Miss";
            }

            System.out.println("And could you also provide us your age? ");

            try {
                age = keyboard.nextInt();
                keyboard.nextLine();
                g.setAge(age);
                if (age < 18) {
                    System.out.println("We're sorry, but you'll need to be at least 18 years old to book a flight with us."
                    + "Have a nice day!");
                    complete = true;
                } else {
                    System.out.printf("We're happy to have you today, %s %s! Just a few more moments and you'll be all booked.\n", prefix, name);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid age.");
                complete = true;
            }

            System.out.println("What's a good phone number to use in case we need to contact you? (ex. 555-555-5555)");
            phoneNumber = keyboard.nextLine();
            g.setPhoneNum(phoneNumber);

            System.out.println("We'll also need a valid email address. Don't worry, we promise not to spam you.");
            email = keyboard.nextLine();
            g.setEmail(email);

            System.out.println("So far so good! Now, where will you be flying to?");
            destination = keyboard.nextLine();
            g.setDestination(destination);

            System.out.println("When do you plan on departing? (ex. 01-01-1999)");
            departureDate = keyboard.nextLine();
            g.setDate(departureDate);

            System.out.println("And where will you be departing from?");
            origin = keyboard.nextLine();
            g.setOrigin(origin);

            while (departureTimes.size() < 5) {
                amPmRand = r.nextInt(2) + 1;
                if (amPmRand == 1) {
                    amPm = "a.m.";
                } else {
                    amPm = "p.m.";
                }
                departureTime = String.valueOf(r.nextInt(12) + 1) + ":00" + amPm;
                departureTimes.add(departureTime);
            }

            List<String> departureTimesList = new ArrayList<>(departureTimes);

            System.out.printf("For flights departing from %s on %s, these are the flight times that we currently have available.\n"
            + "Please use selections 1-5 to select your preferred time. \n", origin, departureDate);
            System.out.println(departureTimesList);

            try {
                choice = keyboard.nextInt();
                keyboard.nextLine();
                departureTime = departureTimesList.get(choice - 1);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid selection.");
                complete = true;
            }

            while (arrivalTimes.size() < 5) {
                amPmRand = r.nextInt(2) + 1;
                if (amPmRand == 1) {
                    amPm = "a.m.";
                } else {
                    amPm = "p.m.";
                }
                arrivalTime = String.valueOf(r.nextInt(12) + 1) + ":00" + amPm;
                arrivalTimes.add(arrivalTime);
            }

            List<String> arrivalTimesList = new ArrayList<>(arrivalTimes);
            arrivalTimeRand = r.nextInt(5);
            arrivalTime = arrivalTimesList.get(arrivalTimeRand);


            System.out.printf("Okay, for the flight you've specified, the estimated arrival time to %s will be %s\n", destination, arrivalTime);
            System.out.printf("Just to review, we're about to confirm a flight booking for %s %s, departing from %s at %s on %s and arriving in %s at %s \n"
            + "Everything look good? (Y/N)\n", prefix, name, origin, departureTime, departureDate, destination, arrivalTime);
            confirmation = keyboard.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                boardingPassNumber = r.nextInt(999999999) + 1;
                ticketPrice = g.totalPrice(age, gender);
                System.out.printf("Your boarding pass number is %d, and your ticket price comes to a total of $%d.", boardingPassNumber, ticketPrice);
                System.out.println("Just a moment while we finish generating your boarding pass.");
                f.createPass(boardingPassNumber, departureDate, origin, destination, arrivalTime, departureTime, name, email, phoneNumber, gender, age, ticketPrice);

            } else {
                System.out.println("Oops, sorry about that. Let's start over fresh.");
                complete = true;
            }



        }




    }
}
