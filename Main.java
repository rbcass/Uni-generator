
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        Person p1 = new Person();
        Uni u1 = new Uni();


        System.out.println(p1);
        System.out.println(u1.setUni());
        System.out.println(u1.getRanking("University College London (UCL)"));
    }




}
