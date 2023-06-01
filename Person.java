import java.io.*;
import java.util.*;

public class Person {

    private String fName;
    private String Lname;

    private int age;

    private String university;

    private Hashtable<String,Integer> rankings;

    public Person(){

        this.fName = setfName();
        this.Lname = setLname();
        this.age = (int)(Math.random() * 13) + 18;

        //
        this.university = setUni();
        this.rankings = new Hashtable<>();
        populateRankings();


    }


    //RANDOMISE FIRST NAME FROM LIST
    public String setfName() {

        try {
            File nameOne = new File("firstName.txt");
            FileReader reader = new FileReader("firstName.txt");
            Scanner scan = new Scanner(nameOne);
            BufferedReader b1 = new BufferedReader(reader);


            List<String> nms = new ArrayList<>();


            while (scan.hasNextLine()) {
//                System.out.println(names);
                String names = scan.nextLine();
                nms.add(names);
//                System.out.println(nms);



            } scan.close();
            Random random = new Random();
            int randomInx = random.nextInt(nms.size());


            return nms.get(randomInx);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //RANDOMISE SURNAME FROM LOOP

        public String setLname(){

            try{
                FileReader reader2 = new FileReader("lastName.txt");
                BufferedReader b2 = new BufferedReader(reader2);
                String Lname;
                List<String>lastName = new ArrayList<>();

                while((Lname = b2.readLine()) != null){
                    lastName.add(Lname);

                    if(lastName.isEmpty()){

                       return null;

                    }
                }
                Random random = new Random();
                int awooga = random.nextInt(lastName.toArray().length);


                return lastName.get(awooga);

            }


            catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }

        //RANDOMISE AND SET UNI
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

    //GENERATE UNI RANKINGS!
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

    //GET RANKING!
    public Integer getRanking(String University){
        return rankings.get(university);
    }



    public int getAge() {
        return age;
    }

    public String getfName() {
        return fName;
    }

    public String getLname(){
        return Lname;
    }


    public String toString(){
         return "Name: " + this.fName + " " + this.Lname + "\n" +
                 "Age: " + this.age + "\n" +
                 "University: " + this.university + "\n" +
                 "Ranking: " + getRanking(this.university);
    }
}
