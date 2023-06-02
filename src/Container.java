package src;

import java.util.ArrayList;
import java.util.List;

//container to show all the people
public class Container {
    private List<Person> people;

    public Container(){

        this.people = new ArrayList<>();
    }

    public void addPerson(Person p1){
        people.add(p1);

    }

    public void printPeople(){
        for(Person p1: people){
            System.out.println(p1.toString());
        }
    }


}
