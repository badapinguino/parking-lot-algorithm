package app;

import app.parkingrow.ParkingRow;

import java.util.ArrayList;

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
    }
    // TODO: poi da cambiare in modo che ritorni un array con i migliori 3 risultati
    public void execute(){
        ArrayList<ParkingRow> actualSolution = new ArrayList<ParkingRow>();
//        for(int i=0; ; i++){
            for (int angle : angles) {
                ParkingRow parkingRow = new ParkingRow(widthField, heightSpot, widthSpot, angle);
                while((heightFieldUsed+parkingRow.getHeigthRowTotal())<=heigthField){
                    heightFieldUsed += parkingRow.getHeigthRowTotal();
                    actualSolution.add(parkingRow);
                }
            }
//        }
        System.out.println(actualSolution);
    }
}
