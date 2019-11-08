package app.parkinglot;

import app.parkingrow.ParkingRow;

import java.util.ArrayList;

public class ParkingLot {
    // A parking lot contains a list of many parking rows, that can be of different types.
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

    // Method to add a parking row to the parking lot,
    // it increments the total number of parking spots and the heigth field used
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
        return "Totale posti: " + getNumberParkingSpots()
                + ".\tAltezza non sfruttata: " + (heightField - heightFieldUsed)
                + ".\t " + parkingRows;
    }
}
