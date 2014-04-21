import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Created by jeffrey on 2/11/14.
 * a Station represents an actual station in cafe mac and contains menu items
 */
public class Station {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    private Long id;
    private String name;
    private Meal meal;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "stations")
    private Set<Food> foods;

    public Station(){}

    /**
     * Creates a station
     * @param name the name of the Station e.g. South
     */
    public Station(String name, Meal meal){
        this.name = name;
        foods = new HashSet<Food>();
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Meal getMeal(){
        return meal;
    }

    public void addFood(Food food){
       foods.add(food);
    }

    public void setFoods(Set<Food> foods){
        this.foods = foods;
    }

    public Set<Food> getFoods(){
        return foods;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
