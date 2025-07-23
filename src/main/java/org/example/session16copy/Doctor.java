package org.example.session16copy;

import org.example.session16.Person;

public class Doctor extends Person {

    public Doctor(String name, String id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " performs doctor duties");
    }
}
