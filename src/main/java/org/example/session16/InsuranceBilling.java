package org.example.session16;

public class InsuranceBilling implements Builling{
    @Override
    public void generateBill(Patient patient) {
        System.out.println("There is a bill generated for patient: " + patient.getName());
    }
}
