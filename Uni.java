import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Uni  {

    private String university;
    private Hashtable<String,Integer> rankings;

    public Uni(){

        this.university = setUni();
        this.rankings = new Hashtable<>();
        populateRankings();

    }

    public String setUni(){
        try{
            //import
            File file = new File("List.txt");
            Scanner scan = new Scanner(file);
//            FileReader reader = new FileReader(file);

            //to ArrayList
            List<String> list = new ArrayList<>();

            //add to list
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                list.add(data);



            }scan.close();

            //to array
            String[] lArray = list.toArray(new String[0]);

            //print single string
            String poo = String.join(", ", list);
//            System.out.println(poo);

            //Random pick!
            Random random = new Random();
            int randomInx = random.nextInt(lArray.length);

            String OURPICK = lArray[randomInx];
//            System.out.println(OURPICK);

            return OURPICK;

//            for(String data: lArray) {
//                System.out.println(list);
//
////                Random random = new Random();
////                int randomInx = random.nextInt(lArray.length);
////
////                String OURPICK = lArray[randomInx];
//
//
//            }


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    return null;}

    public void populateRankings(){

        try {

            File file2 = new File("List.txt");
            Scanner scn = new Scanner(file2);
            Random r = new Random();

            while (scn.hasNextLine()) {
                String uni = scn.nextLine();
                int ranking = r.nextInt(50) + 1;
                rankings.put(uni, ranking);
            }
            scn.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public Integer getRanking(String University){
        return rankings.get(university);
    }

}
