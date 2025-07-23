package org.example.session16copy;

import org.example.session16.Person;

public class Nurse extends Person {

    public Nurse(String name, String id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " perform nurse duties");
    }
}
