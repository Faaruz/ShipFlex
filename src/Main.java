import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

class Banner {
    //ANSI SHADOW ASCII ART
    //https://manytools.org/hacker-tools/ascii-banner/


    public void printBannerLogo(){
        String banner = "███████╗██╗  ██╗██╗██████╗ ███████╗██╗     ███████╗██╗  " +
                "██╗                                                        \n" +
                "██╔════╝██║  ██║██║██╔══██╗██╔════╝██║     ██╔════╝╚██╗██╔╝\n" +
                "███████╗███████║██║██████╔╝█████╗  ██║     █████╗   ╚███╔╝ \n" +
                "╚════██║██╔══██║██║██╔═══╝ ██╔══╝  ██║     ██╔══╝   ██╔██╗ \n" +
                "███████║██║  ██║██║██║     ██║     ███████╗███████╗██╔╝ ██╗\n" +
                "╚══════╝╚═╝  ╚═╝╚═╝╚═╝     ╚═╝     ╚══════╝╚══════╝╚═╝  ╚═╝\n" +
                "                                                           ";
        for(int i=0; i<banner.length(); i++){
            System.out.print(banner.charAt(i));

        }
    }

    public void printBannerOfferte(){
        String banner = " ██████╗ ███████╗███████╗███████╗██████╗ ████████╗███████╗\n" +
                "██╔═══██╗██╔════╝██╔════╝██╔════╝██╔══██╗╚══██╔══╝██╔════╝\n" +
                "██║   ██║█████╗  █████╗  █████╗  ██████╔╝   ██║   █████╗  \n" +
                "██║   ██║██╔══╝  ██╔══╝  ██╔══╝  ██╔══██╗   ██║   ██╔══╝  \n" +
                "╚██████╔╝██║     ██║     ███████╗██║  ██║   ██║   ███████╗\n" +
                " ╚═════╝ ╚═╝     ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝\n" +
                "                                                          ";
        for(int i=0; i<banner.length(); i++){
            System.out.print(banner.charAt(i));

        }
    }
}

class Opties {

    public double navigatiesysteem = 40000;
    public double motor = 70000;
    public double roer = 30000;
    public double brandstoftank = 60000;

    public double getNavigatiesysteem() {
        return navigatiesysteem;
    }

    public double getMotor() {
        return motor;
    }

    public double getRoer() {
        return roer;
    }

    public double getBrandstoftank() {
        return brandstoftank;
    }
}

class Home {
    public boolean admin;

    public void askAdmin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Inloggen als Admin (Y = Admin / N = Klant): ");
        String answer = scanner.nextLine();

        if(answer.equalsIgnoreCase("Y")){
            System.out.println("ADMIN LOGGED IN!");
            admin = true;
        } else {
            System.out.println("KLANT LOGGED IN!");
            admin = false;
        }
    }
}

class OfferteGenerator extends Banner {

    Opties opties = new Opties();
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    Map<String, String> dictionary = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);

   public  File file = new File("src/content.json");
    public String content = FileUtils.readFileToString(file, "utf-8");

    double kosten;
    public String klantenGroep;

    OfferteGenerator() throws IOException {
    }


    public void generateOfferte() throws IOException {
        /**
         * Standaard vragen die worden gesteld in ELKE offerte.
         */
        System.out.println();
        System.out.println("ShipFLex Offerte generator (Admin):");

        System.out.println("Voornaam: ");
//        dictionary.put("Voornaam", scanner.nextLine());

        // Convert JSON string to JSONObject
        JSONObject json = new JSONObject(content);
        JSONStringer jsonStringer = new JSONStringer();


        json.put("Voornaam", scanner.nextLine());

        FileUtils.write(file, json.toString(4));


        System.out.println(json.toString(4));

        System.out.println("Achternaam: ");
        dictionary.put("Achternaam", scanner.nextLine());

        System.out.println("Bedrijf: ");
        dictionary.put("Bedrijf", scanner.nextLine());

        /**
         * Klanten Groep instellen voor eventuele kortingen op totaal prijs
         */
        System.out.println("Klanten Groep ( Voer getal in ) \n" +
                "1. Standaard Klant \n" +
                "2. VIP Klant (20% Korting totaal prijs)");
        String groep = scanner.nextLine();
        switch (groep) {
            case "1" -> {
                dictionary.put("KlantenGroep", "Standaard Klant");
                klantenGroep = "standaard";
            }


            case "2" -> {
                dictionary.put("KlantenGroep", "VIP Klant");
                klantenGroep = "vip";
            }

        }


        /**
         * Schip kosten berekenen
         */
        System.out.println("Soort Schip ( Voer getal in ) \n" +
                "1. Speedboot \n" +
                "2. Passagiersboot");
        String schip = scanner.nextLine();

        switch (schip) {
            case "1" -> {
                dictionary.put("Schip", "Speedboot");
                vipValues();

            }

            case "2" -> {
                dictionary.put("Schip", "Passagiersboot");
                vipValues();
            }
        }




        //DEBUGGING
        System.out.println(dictionary);

        /**
         * Offerte uitprinten
         */
        System.out.println("Offerte inzien? (Y/n)");
        String a = scanner.nextLine();
        if (a.equalsIgnoreCase("Y")){
            printOfferte();

        }


    }

    private void vipValues() {
        if(klantenGroep.equals("vip")){

            System.out.println("Navigatiesysteem:");
            System.out.println(formatter.format(opties.getNavigatiesysteem()) + " -20% VIP Korting (" +
                    (formatter.format(opties.getNavigatiesysteem() * 0.2) + ") = " + (formatter.format(opties.getNavigatiesysteem() * 0.8))));
            kosten += (opties.getNavigatiesysteem() * 0.8);

            System.out.println();

            System.out.println("Motor:");
            System.out.println(formatter.format(opties.getMotor()) + " -20% VIP Korting (" +
                    (formatter.format(opties.getMotor() * 0.2) + ") = " + (formatter.format(opties.getMotor() * 0.8))));
            kosten += (opties.getMotor() * 0.8);

            System.out.println();

            System.out.println("Roer:");
            System.out.println(formatter.format(opties.getRoer()) + " -20% VIP Korting (" +
                    (formatter.format(opties.getRoer() * 0.2) + ") = " + (formatter.format(opties.getRoer() * 0.8))));
            kosten += (opties.getRoer() * 0.8);

            System.out.println();

            System.out.println("Brandstoftank:");
            System.out.println(formatter.format(opties.getBrandstoftank()) + " -20% VIP Korting (" +
                    (formatter.format(opties.getBrandstoftank() * 0.2) + ") = " + (formatter.format(opties.getBrandstoftank() * 0.8))));
            kosten += (opties.getBrandstoftank() * 0.8);
        } else {
            defaultValues();
        }
    }

    private void defaultValues() {
        System.out.println(formatter.format(opties.getNavigatiesysteem()));
        System.out.println(formatter.format(opties.getMotor()));
        System.out.println(formatter.format((opties.getRoer())));
        System.out.println(formatter.format(opties.getBrandstoftank()));
        kosten += (opties.getNavigatiesysteem() + opties.getMotor() + opties.getRoer() + opties.getBrandstoftank());
    }

    public void printOfferte() {
        printBannerOfferte();
        System.out.println();
        System.out.println("1. Voornaam: " + dictionary.get("Voornaam"));
        System.out.println("2. Achternaam: " + dictionary.get("Achternaam"));
        System.out.println("3. Bedrijf: " + dictionary.get("Bedrijf"));
        System.out.println("4. Klanten Groep: " + dictionary.get("KlantenGroep"));
        System.out.println("5. Soort Schip: " + dictionary.get("Schip"));
        System.out.println("Totale Kosten: " + (formatter.format(kosten)));

        System.out.println("Terug naar menu? (Y/n): ");
        scanner.nextLine();

    }




}

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Banner banner = new Banner();
        Home home = new Home();
        OfferteGenerator generator = new OfferteGenerator();
        banner.printBannerLogo();
        home.askAdmin();
        generator.generateOfferte();
    }
}