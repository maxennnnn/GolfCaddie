import java.util.*;

public class Puttning{
    
    
    Scanner sc = new Scanner(System.in);

    boolean prevShot = false;
    int putsMade, putLength, prevPutLength, putAim;
    //Double[][] allPuts = new Double[21][7];

    Vector<Vector<Double>> allPuts = new Vector<Vector<Double>>();
    ArrayList<Double> holePutOds = new ArrayList<Double>();
    ArrayList<Double> aimPut = new ArrayList<Double>();

    public void initiateValues(){
        for(int i = 0; i < 21; i++){
            holePutOds.add(1.0);
        }

        for(int i = 0; i < 21; i++){
            for(int j = 1; j < 8; j++){

            }
        }

    }

    public void userData(){
        System.out.println("Input put length (0-20): ");
        putLength = sc.nextInt();
        putsMade++;

        if(prevShot){
            populateStats(prevPutLength, putAim, putLength);
        }

        System.out.println("Input biggest hole miss (0=in, 1=short, 2=long, 3=side): "); //Om man kör med UI kan man skippa om bollen går i utan istället bara ta in om man skriver in en ny putt, annars är den i
        putAim = sc.nextInt();
        if(putAim != 1){
            prevShot = true;
            prevPutLength = putLength;
            userData();
        }
        else{
            prevShot = false;
            Double ods = allPuts.get(putLength).get(1);
            allPuts.set(putLength, new Vector<Double>(ods + 1));
            allPuts.set(prevPutLength, new Vector<Double>(allPuts.get(prevPutLength).get(7) + 1)); //Lägg till ett på tot
        }

    }

    public void populateStats(int prevPutLength, int putAim, int putLength){
        allPuts.set(prevPutLength, new Vector<Double>(allPuts.get(prevPutLength).get(7) + 1)); //Lägg till ett på tot
        allPuts.set(prevPutLength, new Vector<Double>(allPuts.get(prevPutLength).get(putAim) + 1)); //Lägg till ett på 

        for(int i = 4; i < 7; i++){
             
        }
    }

    public static void main(String[] args){
        Puttning putt = new Puttning();
        putt.initiateValues();
        putt.userData();
    }

}