package app;

import app.parkingrow.DoubleParkingRow;
import app.parkingrow.ParkingRow;
import app.parkingspot.ParkingSpot;

public class Main {
    public static void main(String args[]){
        System.out.println("Hello algorithm");
        stampaParkingSpots();
        System.out.println("\n\n");
        stampaParkingRows();
        System.out.println("\n\n");
        stampaDoubleParkingRows();
        System.out.println("\n\n");
        Algorithm algorithm = new Algorithm(31.40f, 30.4f, 5, 2.5f);
        algorithm.execute();
    }

    public static void stampaParkingSpots(){
        ParkingSpot parkingSpot90 = new ParkingSpot(5, 2.5f, 90);
        ParkingSpot parkingSpot45 = new ParkingSpot(5, 2.5f, 45);
        ParkingSpot parkingSpot0 = new ParkingSpot(5, 2.5f, 0);
        ParkingSpot parkingSpot75 = new ParkingSpot(5, 2.5f, 75);
        ParkingSpot parkingSpot60 = new ParkingSpot(5, 2.5f, 60);
        ParkingSpot parkingSpot30 = new ParkingSpot(5, 2.5f, 30);

        System.out.println(
                "90°\twidth: " + parkingSpot90.getParkingEntranceWidth()
                        + "\twidthAcross: " + parkingSpot90.getWidth()
                        + "\tunusedWidth: " + parkingSpot90.getUnusedW()
                        + "\tlength: " + parkingSpot90.getUsedL()
        );
        System.out.println(
                "75°\twidth: " + parkingSpot75.getParkingEntranceWidth()
                        + "\twidthAcross: " + parkingSpot75.getWidth()
                        + "\tunusedWidth: " + parkingSpot75.getUnusedW()
                        + "\tlength: " + parkingSpot75.getUsedL()
        );
        System.out.println(
                "60°\twidth: " + parkingSpot60.getParkingEntranceWidth()
                        + "\twidthAcross: " + parkingSpot60.getWidth()
                        + "\tunusedWidth: " + parkingSpot60.getUnusedW()
                        + "\tlength: " + parkingSpot60.getUsedL()
        );
        System.out.println(
                "45°\twidth: " + parkingSpot45.getParkingEntranceWidth()
                        + "\twidthAcross: " + parkingSpot45.getWidth()
                        + "\tunusedWidth: " + parkingSpot45.getUnusedW()
                        + "\tlength: " + parkingSpot45.getUsedL()
        );
        System.out.println(
                "30°\twidth: " + parkingSpot30.getParkingEntranceWidth()
                        + "\twidthAcross: " + parkingSpot30.getWidth()
                        + "\tunusedWidth: " + parkingSpot30.getUnusedW()
                        + "\tlength: " + parkingSpot30.getUsedL()
        );
        System.out.println(
                "0°\twidth: " + parkingSpot0.getParkingEntranceWidth()
                        + "\twidthAcross: " + parkingSpot0.getWidth()
                        + "\tunusedWidth: " + parkingSpot0.getUnusedW()
                        + "\tlength: " + parkingSpot0.getUsedL()
        );
    }

    public static void stampaParkingRows(){
        ParkingRow parkingRow90 = new ParkingRow(20, 5, 2.5f, 90);
        System.out.println(
                "90°\taltezzaTotale: " + parkingRow90.getHeigthRowTotal()
                + "\tlength: " + parkingRow90.getParkingSpot().getUsedL()
                + "\tmanLength: " + parkingRow90.getManLength()
                + "\t\tTotale posti: " + parkingRow90.getNumberParkingSpots()
        );
        ParkingRow parkingRow75 = new ParkingRow(20, 5, 2.5f, 75);
        System.out.println(
                "75°\taltezzaTotale: " + parkingRow75.getHeigthRowTotal()
                        + "\tlength: " + parkingRow75.getParkingSpot().getUsedL()
                        + "\tmanLength: " + parkingRow75.getManLength()
                        + "\t\tTotale posti: " + parkingRow75.getNumberParkingSpots()
        );
        ParkingRow parkingRow60 = new ParkingRow(20, 5, 2.5f, 60);
        System.out.println(
                "60°\taltezzaTotale: " + parkingRow60.getHeigthRowTotal()
                        + "\tlength: " + parkingRow60.getParkingSpot().getUsedL()
                        + "\tmanLength: " + parkingRow60.getManLength()
                        + "\t\tTotale posti: " + parkingRow60.getNumberParkingSpots()
        );
        ParkingRow parkingRow45 = new ParkingRow(20, 5, 2.5f, 45);
        System.out.println(
                "45°\taltezzaTotale: " + parkingRow45.getHeigthRowTotal()
                        + "\tlength: " + parkingRow45.getParkingSpot().getUsedL()
                        + "\tmanLength: " + parkingRow45.getManLength()
                        + "\t\tTotale posti: " + parkingRow45.getNumberParkingSpots()
        );
        ParkingRow parkingRow30 = new ParkingRow(20, 5, 2.5f, 30);
        System.out.println(
                "30°\taltezzaTotale: " + parkingRow30.getHeigthRowTotal()
                        + "\tlength: " + parkingRow30.getParkingSpot().getUsedL()
                        + "\tmanLength: " + parkingRow30.getManLength()
                        + "\t\tTotale posti: " + parkingRow30.getNumberParkingSpots()
        );
        ParkingRow parkingRow0 = new ParkingRow(20, 5, 2.5f, 0);
        System.out.println(
                "0°\taltezzaTotale: " + parkingRow0.getHeigthRowTotal()
                        + "\tlength: " + parkingRow0.getParkingSpot().getUsedL()
                        + "\tmanLength: " + parkingRow0.getManLength()
                        + "\t\tTotale posti: " + parkingRow0.getNumberParkingSpots()
        );
    }

    public static void stampaDoubleParkingRows(){
        DoubleParkingRow doubleParkingRow90 = new DoubleParkingRow(20, 5, 2.5f, 90);
        System.out.println(
                "Double 90°\taltezzaTotale: " + doubleParkingRow90.getHeigthRowTotal()
                        + "\tlength: " + doubleParkingRow90.getParkingSpot().getUsedL()
                        + "\tmanLength: " + doubleParkingRow90.getManLength()
                        + "\t\tTotale posti: " + doubleParkingRow90.getNumberParkingSpots()
        );
        DoubleParkingRow doubleParkingRow75 = new DoubleParkingRow(20, 5, 2.5f, 75);
        System.out.println(
                "Double 75°\taltezzaTotale: " + doubleParkingRow75.getHeigthRowTotal()
                        + "\tlength: " + doubleParkingRow75.getParkingSpot().getUsedL()
                        + "\tmanLength: " + doubleParkingRow75.getManLength()
                        + "\t\tTotale posti: " + doubleParkingRow75.getNumberParkingSpots()
        );
        DoubleParkingRow doubleParkingRow60 = new DoubleParkingRow(20, 5, 2.5f, 60);
        System.out.println(
                "Double 60°\taltezzaTotale: " + doubleParkingRow60.getHeigthRowTotal()
                        + "\tlength: " + doubleParkingRow60.getParkingSpot().getUsedL()
                        + "\tmanLength: " + doubleParkingRow60.getManLength()
                        + "\t\tTotale posti: " + doubleParkingRow60.getNumberParkingSpots()
        );
        DoubleParkingRow doubleParkingRow45 = new DoubleParkingRow(20, 5, 2.5f, 45);
        System.out.println(
                "Double 45°\taltezzaTotale: " + doubleParkingRow45.getHeigthRowTotal()
                        + "\tlength: " + doubleParkingRow45.getParkingSpot().getUsedL()
                        + "\tmanLength: " + doubleParkingRow45.getManLength()
                        + "\t\tTotale posti: " + doubleParkingRow45.getNumberParkingSpots()
        );
        DoubleParkingRow doubleParkingRow30 = new DoubleParkingRow(20, 5, 2.5f, 30);
        System.out.println(
                "Double 30°\taltezzaTotale: " + doubleParkingRow30.getHeigthRowTotal()
                        + "\tlength: " + doubleParkingRow30.getParkingSpot().getUsedL()
                        + "\tmanLength: " + doubleParkingRow30.getManLength()
                        + "\t\tTotale posti: " + doubleParkingRow30.getNumberParkingSpots()
        );
        DoubleParkingRow doubleParkingRow0 = new DoubleParkingRow(20, 5, 2.5f, 0);
        System.out.println(
                "Double 0°\taltezzaTotale: " + doubleParkingRow0.getHeigthRowTotal()
                        + "\tlength: " + doubleParkingRow0.getParkingSpot().getUsedL()
                        + "\tmanLength: " + doubleParkingRow0.getManLength()
                        + "\t\tTotale posti: " + doubleParkingRow0.getNumberParkingSpots()
        );
    }
}
