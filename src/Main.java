import Enums.State;
import Products.Computer;
import Products.Printers;
import Products.Product;
import Products.Scanner;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static int readFlag = 0;

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        loadData(products);
        if(readFlag !=0) return;
        menu(products);
    }

    public static void menu(ArrayList<Product> products) {
        boolean running = true;
        int option;

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (running) {
            System.out.println("\n-1 - Quit \n0 - Print all \n1 - Print Printers " +
                    "\n2 - Print Scanners \n3 - Print Computers \n4 - Modify state" +
                    "\n5 - Set Printer mode \n6 - Set scanner mode \n7 - Set computer OS \n8 - Print Sold");
            option = scanner.nextInt();
            switch (option) {
                case -1 -> running = false;
                case 0 -> printAll(products);
                case 1 -> printPrinters(products);
                case 2 -> printScanners(products);
                case 3 -> printComputers(products);
                case 4 -> modifyState(products, scanner);
                case 5 -> modifyPrinterState(products, scanner);
                case 6 -> modifyScannerState(products, scanner);
                case 7 -> modifyComputerState(products, scanner);
                case 8 -> printSoldProducts(products);
                default -> System.out.println("Wrong choice, try again!");
            }
        }

    }


    public static void modifyState(ArrayList<Product> products, java.util.Scanner scanner) {
        printAll(products);

        System.out.println("Pick an object ID to modify");
        int index = scanner.nextInt();

        System.out.println("\n! Modify state to ! \n1 - Purchased \n2 - Exposed \n3 - Sold");
        int newState = scanner.nextInt();

        switch (newState) {
            case 1 -> products.get(index).setState("PURCHASED");
            case 2 -> products.get(index).setState("EXPOSED");
            case 3 -> products.get(index).setState("SOLD");
            default -> System.out.println("Wrong state, choice invalidated!");
        }
    }

    public static void modifyPrinterState(ArrayList<Product> product, java.util.Scanner scanner) {
        printPrinters(product);

        System.out.println("\nPick a printer id from those above!");
        int index = scanner.nextInt();
        if(index < product.size() && product.get(index) instanceof Printers) {
            System.out.println("\n! Modify printer mode to ! \n1 - COLOUR \n2 - GREYSCALE");
            int newMode = scanner.nextInt();

            switch (newMode) {
                case 1 -> product.get(index).setMode("COLOUR");
                case 2 -> product.get(index).setMode("GREYSCALE");
                default -> System.out.println("Wrong state, choice invalidated!");
            }
        }
        else {
            System.out.println("Wrong selection, product is not a printer!");
        }
    }

    public static void modifyComputerState(ArrayList<Product> product, java.util.Scanner scanner) {
        printComputers(product);

        System.out.println("\nPick a printer id from those above!");
        int index = scanner.nextInt();
        if(index < product.size() && product.get(index) instanceof Computer) {
            System.out.println("\n! Modify printer mode to ! \n1 - Windows \n2 - Linux");
            int newMode = scanner.nextInt();

            switch (newMode) {
                case 1 -> product.get(index).setMode("Windows");
                case 2 -> product.get(index).setMode("Linux");
                default -> System.out.println("Wrong state, choice invalidated!");
            }
        }
        else {
            System.out.println("Wrong selection, product is not a printer!");
        }
    }

    public static void modifyScannerState(ArrayList<Product> product, java.util.Scanner scanner) {
        printScanners(product);

        System.out.println("\nPick a scanner id from those above!");
        int index = scanner.nextInt();

        if(index < product.size() && product.get(index) instanceof Scanner) {
            System.out.println("\n! Modify printer mode to ! \n1 - A3 \n2 - A4");
            int newMode = scanner.nextInt();

            switch(newMode) {
                case 1 -> product.get(index).setMode("A3");
                case 2 -> product.get(index).setMode("A4");
                default -> System.out.println("Wrong state, choice invalidated!");
            }
        }
        else{
            System.out.println("Wrong selection, product is not a scanner!");
        }
    }

    public static void printAll(ArrayList<Product> products) {
        for(Product product : products) System.out.format("\n\n%s", product);
    }

    public static void printSoldProducts(ArrayList<Product> products) {
        for(Product product : products) {
            if(product.getState() == State.SOLD) System.out.format("\n\n%s", product);
        }
    }

    public static void printPrinters(ArrayList<Product> products) {
        for (Product product : products) {
            if (product instanceof Printers) System.out.format("\n\n%s", product);
        }
    }
    public static void printScanners(ArrayList<Product> products) {
        for (Product product : products) {
            if (product instanceof Scanner) System.out.format("\n\n%s", product);
        }
    }
    public static void printComputers(ArrayList<Product> products) {
        for (Product product : products) {
            if (product instanceof Computer) System.out.format("\n\n%s", product);
        }
    }
    public static void loadData(ArrayList<Product> products){
        readData(products);
    }
    private static void readData(ArrayList<Product> products) {
        File file = new File("in.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.trim().split(" +");
                int productType = Integer.parseInt(data[0]);
                Product toInsert = null;

                switch (productType) {
                    case 1 -> toInsert = readPrinter(data);
                    case 2 -> toInsert = readScanner(data);
                    case 3 -> toInsert = readComputer(data);
                    default -> {
                    }
                }
                products.add(toInsert);
            }
        } catch (Exception e) {
            System.out.println("Could not read data from file");
            readFlag = -1;
        }
    }
    private static Product readPrinter(String[] data){
        double price = Double.parseDouble(data[4]);
        double resolution = Double.parseDouble(data[6]);

        int pagesPerMinute = Integer.parseInt(data[5]);
        int pagesPerCartridge  = Integer.parseInt(data[7]);

        return new Printers(data[1], data[2], data[3], price, pagesPerMinute, resolution, pagesPerCartridge, data[8]);
    }
    private static Product readScanner(String[] data){
        double price = Double.parseDouble(data[4]);

        int pagesPerMinute = Integer.parseInt(data[5]);
        int pagesPerToner = Integer.parseInt(data[6]);

        return new Scanner(data[1], data[2], data[3], price, pagesPerMinute, pagesPerToner, data[7]);
    }
    private static Product readComputer(String[] data) {
        double price = Double.parseDouble(data[4]);
        double clock = Double.parseDouble(data[5]);
        double storage = Double.parseDouble(data[6]);

        return new Computer(data[1], data[2], data[3], price, clock, storage, data[7]);
    }
}