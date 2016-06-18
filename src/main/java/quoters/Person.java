package quoters;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class Person {
    private String name;
    private String family;

    public Person(String имя, String фамилия) {
        this.name = имя;
        this.family = фамилия;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}
