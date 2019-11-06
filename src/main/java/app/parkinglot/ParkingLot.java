package app.parkinglot;

import app.parkingrow.ParkingRow;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<ParkingRow> parkingRows;

    private float heightField;
    private float widthField;

    private float heightFieldUsed;

    private long numberParkingSpots;

    public ParkingLot(float heightField, float widthField) {
        this.parkingRows = new ArrayList<>();
        numberParkingSpots = 0;
        this.heightField = heightField;
        this.widthField = widthField;
    }

    public void addParkingRow(ParkingRow parkingRow){
        if(parkingRow.getHeigthRowTotal() + heightFieldUsed <= heightField){
            parkingRows.add(parkingRow);
            numberParkingSpots += parkingRow.getNumberParkingSpots();
            heightFieldUsed += parkingRow.getHeigthRowTotal();
        } else {
            throw new RuntimeException("The parking row is too height for the remaining field height not used.");
        }
    }

    public ArrayList<ParkingRow> getParkingRows() {
        return parkingRows;
    }

    public long getNumberParkingSpots() {
        return numberParkingSpots;
    }

    @Override
    public String toString() {
        return "Totale posti: " + getNumberParkingSpots() +".\t " + parkingRows;
    }
}
