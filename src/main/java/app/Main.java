package app;

import app.parkinglot.ParkingLot;
import app.parkingrow.DoubleParkingRow;
import app.parkingrow.ParkingRow;
import app.parkingrow.SingleParkingRow;
import app.parkingspot.ParkingSpot;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        System.out.println("Hello algorithm!");
        stampaParkingSpots();
        System.out.println("\n\n");
        stampaParkingRows();
        System.out.println("\n\n");
        stampaDoubleParkingRows();
        System.out.println("\n\n");
        Algorithm algorithm = new Algorithm(31.40f, 30.4f, 5, 2.5f);
        ParkingLot orderedByNumberOfParking = algorithm.executeOrderingByNumberParking();
        System.out.println(orderedByNumberOfParking);
        System.out.println("\n\n");
        ParkingLot layoutParking60 = algorithm.executeFillByAngle(60, true);
        System.out.println(layoutParking60);
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
        SingleParkingRow singleParkingRow90 = new SingleParkingRow(20, 5, 2.5f, 90);
        System.out.println(
                "90°\taltezzaTotale: " + singleParkingRow90.getHeigthRowTotal()
                + "\tlength: " + singleParkingRow90.getParkingSpot().getUsedL()
                + "\tmanLength: " + singleParkingRow90.getManLength()
                + "\t\tTotale posti: " + singleParkingRow90.getNumberParkingSpots()
        );
        SingleParkingRow singleParkingRow75 = new SingleParkingRow(20, 5, 2.5f, 75);
        System.out.println(
                "75°\taltezzaTotale: " + singleParkingRow75.getHeigthRowTotal()
                        + "\tlength: " + singleParkingRow75.getParkingSpot().getUsedL()
                        + "\tmanLength: " + singleParkingRow75.getManLength()
                        + "\t\tTotale posti: " + singleParkingRow75.getNumberParkingSpots()
        );
        SingleParkingRow singleParkingRow60 = new SingleParkingRow(20, 5, 2.5f, 60);
        System.out.println(
                "60°\taltezzaTotale: " + singleParkingRow60.getHeigthRowTotal()
                        + "\tlength: " + singleParkingRow60.getParkingSpot().getUsedL()
                        + "\tmanLength: " + singleParkingRow60.getManLength()
                        + "\t\tTotale posti: " + singleParkingRow60.getNumberParkingSpots()
        );
        SingleParkingRow singleParkingRow45 = new SingleParkingRow(20, 5, 2.5f, 45);
        System.out.println(
                "45°\taltezzaTotale: " + singleParkingRow45.getHeigthRowTotal()
                        + "\tlength: " + singleParkingRow45.getParkingSpot().getUsedL()
                        + "\tmanLength: " + singleParkingRow45.getManLength()
                        + "\t\tTotale posti: " + singleParkingRow45.getNumberParkingSpots()
        );
        SingleParkingRow singleParkingRow30 = new SingleParkingRow(20, 5, 2.5f, 30);
        System.out.println(
                "30°\taltezzaTotale: " + singleParkingRow30.getHeigthRowTotal()
                        + "\tlength: " + singleParkingRow30.getParkingSpot().getUsedL()
                        + "\tmanLength: " + singleParkingRow30.getManLength()
                        + "\t\tTotale posti: " + singleParkingRow30.getNumberParkingSpots()
        );
        SingleParkingRow singleParkingRow0 = new SingleParkingRow(20, 5, 2.5f, 0);
        System.out.println(
                "0°\taltezzaTotale: " + singleParkingRow0.getHeigthRowTotal()
                        + "\tlength: " + singleParkingRow0.getParkingSpot().getUsedL()
                        + "\tmanLength: " + singleParkingRow0.getManLength()
                        + "\t\tTotale posti: " + singleParkingRow0.getNumberParkingSpots()
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
