/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.triage.rekart;

import edu.blackburn.cs.cs212sp16.er.*;

/**
 *
 * @author arthur.levan/braydon.rekart
 */
public class Runner {

    public static void main(String[] args) {
        // Creating new patients.
        // BEGINNING TEST CODE.
        Patient a = Patient.newPatient();
        Patient b = Patient.newPatient();
        Patient c = Patient.newPatient();
        // Creating new triage stack.
        TriageStack stack = new TriageStack();
        // Creating new triage queue.
        TriageQueue queue = new TriageQueue();
        double hp = 0;
        int count = 0;
        // Pushing patients to the stack
        stack.push(a);
        stack.push(b);
        stack.push(c);
        System.out.println(c);
        System.out.println(stack.pop());
        do {
            hp = a.getHealth();
            System.out.println(hp);
            count++;
        } while (hp != 0);
        System.out.println("Ticked: " + count + " times.");
        System.out.println("Patient A Priority: " + a.getPriority());

        // Queue.
        Patient p1 = Patient.newPatient();
        double hp1;
        Patient p2 = Patient.newPatient();
        double hp2;
        Patient p3 = Patient.newPatient();
        double hp3;

        System.out.println("Queue:");

        queue.enqueue(p1);
        queue.enqueue(p2);
        queue.enqueue(p3);

        do {
            hp1 = p1.getHealth();
            hp2 = p2.getHealth();
            hp3 = p3.getHealth();
            count++;
            queue.health();
            System.out.println("P1's HP: " + hp1);
            System.out.println("P2's Priority: " + p1.getPriority());

            System.out.println("P2's HP: " + hp2);
            System.out.println("P2's Priority: " + p2.getPriority());

            System.out.println("P3's HP: " + hp3);
            System.out.println("P3's Priority: " + p3.getPriority());

            System.out.println("Ticked " + count + " times.");
        } while (hp1 + hp2 + hp3 != 0);
        queue.dequeue();
        System.out.println(queue.priority());
        System.out.println(queue.length());

        Doctor Breen = new Doctor(queue, stack);
        Breen.heal();
        System.out.println(queue.length());
        System.out.println(Breen.getHealed());
        System.out.println(Breen.getHealth());
        // ENDING TEST CODE.
        System.out.println("TEST CODE ENDED.");
        System.out.println("BEGINNING ACTUAL CODE:");
        runER();
    }

    public static void runER() {
        TriageStack stackER = new TriageStack();
        TriageQueue queueER = new TriageQueue();
        Doctor House = new Doctor(queueER, stackER);
        double doctorHealth = House.getHealth();
        for (int i = 0; i < 50000; i++) {
            Patient p1 = Patient.newPatient();
            Patient p2 = Patient.newPatient();

            if (p1.getPriority() <= 5) {
                queueER.enqueue(p1);
            } else {
                stackER.push(p1);
            }
            
            if (p2.getPriority() <= 5) {
                queueER.enqueue(p2);
            } else {
                stackER.push(p2);
            }

            if (i >= 10) {
                House.heal();
                doctorHealth = doctorHealth + stackER.pop().getHealth();
                doctorHealth = doctorHealth + queueER.dequeue().getHealth();
                stackER.pop();
                queueER.dequeue();
            }
        }
        // toString is not overridden nor is there a string for Dr's name.
        System.out.println("Doctor: " + House);
        System.out.println("Amount of healed patients: " + House.getHealed());
        System.out.println("Total health healed: " + doctorHealth);
        //^^^ house.gethealth <-> doctorHealth
    }
}
