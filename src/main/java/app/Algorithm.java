package app;

import app.parkinglot.ParkingLot;
import app.parkingrow.DoubleParkingRow;
import app.parkingrow.ParkingRow;
import app.parkingrow.SingleParkingRow;

import java.util.ArrayList;
import java.util.Comparator;

public class Algorithm {

    private float heigthField;
    private float widthField;
    private float heightSpot;
    private float widthSpot;
    private float heightFieldUsed;
    private int angles[] = {90, 75, 60, 45, 30, 0};

    public Algorithm(float heigthField, float widthField, float heigthSpot, float widthSpot){
        this.heigthField = heigthField;
        this.widthField = widthField;
        this.heightSpot = heigthSpot;
        this.widthSpot = widthSpot;
        heightFieldUsed = 0;
    }

    public ParkingLot executeOrderingByNumberParking(){
        heightFieldUsed = 0;
        // order the possible angles by the one that can provide a row with most spots.
        ArrayList<ParkingRow> parkingRows = new ArrayList<ParkingRow>();
        ArrayList<SingleParkingRow> singleParkingRows = new ArrayList<>();
        for (int angle : angles) {
            SingleParkingRow singleParkingRow = new SingleParkingRow(widthField, heightSpot, widthSpot, angle);
            parkingRows.add(singleParkingRow);
            singleParkingRows.add(singleParkingRow);
        }
        for (int angle : angles) {
            DoubleParkingRow doubleParkingRow = new DoubleParkingRow(widthField, heightSpot, widthSpot, angle);
            parkingRows.add(doubleParkingRow);
        }
        parkingRows.sort(Comparator.comparing(ParkingRow::getNumberParkingSpots).reversed());
        singleParkingRows.sort(Comparator.comparing(ParkingRow::getNumberParkingSpots).reversed());

        ParkingLot bestSolution = new ParkingLot(heigthField, widthField);

        // the first row must be a single row
        for (SingleParkingRow singleParkingRow : singleParkingRows){
            if(singleParkingRow.getHeigthRowTotal() <= heigthField){
                bestSolution.addParkingRow(singleParkingRow);
                heightFieldUsed += singleParkingRow.getHeigthRowTotal();
                break;
            }
        }

        for( ParkingRow parkRow : parkingRows){
            while((heightFieldUsed + parkRow.getHeigthRowTotal()) <= heigthField){
                heightFieldUsed += parkRow.getHeigthRowTotal();
                bestSolution.addParkingRow(parkRow);
            }
        }
        heightFieldUsed = 0;
        return bestSolution;



//        ArrayList<ParkingRow> actualSolution = new ArrayList<ParkingRow>();
//        for (int angle : angles) {
//            ParkingRow parkingRow = new ParkingRow(widthField, heightSpot, widthSpot, angle);
//            while((heightFieldUsed + parkingRow.getHeigthRowTotal()) <= heigthField){
//                heightFieldUsed += parkingRow.getHeigthRowTotal();
//                actualSolution.add(parkingRow);
//            }
//        }
//        System.out.println(actualSolution);
    }

    public ParkingLot executeFillByAngle(float angle, boolean doubleLine){
        heightFieldUsed = 0;
        ParkingLot thisLayoutSolution = new ParkingLot(heigthField, widthField);
        ParkingRow parkingRow;
        if(doubleLine){
            parkingRow = new DoubleParkingRow(widthField, heightSpot, widthSpot, angle);
            // the first row must be a single row
            SingleParkingRow firstSingleRow = new SingleParkingRow(widthField, heightSpot, widthSpot, angle);
            if(heightFieldUsed + firstSingleRow.getHeigthRowTotal()<=heigthField){
                thisLayoutSolution.addParkingRow(firstSingleRow);
                heightFieldUsed += firstSingleRow.getHeigthRowTotal();
            }
        }else{
            parkingRow = new SingleParkingRow(widthField, heightSpot, widthSpot, angle);
        }

        while((heightFieldUsed + parkingRow.getHeigthRowTotal()) <= heigthField){
            heightFieldUsed += parkingRow.getHeigthRowTotal();
            thisLayoutSolution.addParkingRow(parkingRow);
        }

        heightFieldUsed = 0;
        return thisLayoutSolution;
    }

    // It's the knapsack problem but the algorithm used here is different from the real knapsack problem one.
    // This is a greedy solution. It founds a local optimum not the global one
    // Execution time: O(4N) + the sorting algorithm which I don't know how much time it costs. Probably N(logN)
    public ParkingLot executeKnapsackGreedy(){
        heightFieldUsed = 0;
        // order the possible angles by the one that can provide a row with most spots.
        ArrayList<ParkingRow> parkingRows = new ArrayList<ParkingRow>();
        ArrayList<SingleParkingRow> singleParkingRows = new ArrayList<>();
        for (int angle : angles) {
            SingleParkingRow singleParkingRow = new SingleParkingRow(widthField, heightSpot, widthSpot, angle);
            parkingRows.add(singleParkingRow);
            singleParkingRows.add(singleParkingRow);
        }
        for (int angle : angles) {
            DoubleParkingRow doubleParkingRow = new DoubleParkingRow(widthField, heightSpot, widthSpot, angle);
            parkingRows.add(doubleParkingRow);
        }
        parkingRows.sort(Comparator.comparing(ParkingRow::getSpotsSpaceRatio).reversed());
        singleParkingRows.sort(Comparator.comparing(ParkingRow::getSpotsSpaceRatio).reversed());

        ParkingLot bestSolution = new ParkingLot(heigthField, widthField);

        // the first row must be a single row
        for (SingleParkingRow singleParkingRow : singleParkingRows){
            if(singleParkingRow.getHeigthRowTotal() <= heigthField){
                bestSolution.addParkingRow(singleParkingRow);
                heightFieldUsed += singleParkingRow.getHeigthRowTotal();
                break;
            }
        }

        for( ParkingRow parkRow : parkingRows){
            while((heightFieldUsed + parkRow.getHeigthRowTotal()) <= heigthField){
                heightFieldUsed += parkRow.getHeigthRowTotal();
                bestSolution.addParkingRow(parkRow);
            }
        }
        heightFieldUsed = 0;
        return bestSolution;
    }

    // greedy knapsack doesn't work so well, so we need to implement a real knapsack algorithm
//    public ParkingLot executeKnapsack(){
//
//    }
}
