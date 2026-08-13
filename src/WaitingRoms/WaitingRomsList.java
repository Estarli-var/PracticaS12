/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WaitingRoms;

import clinic.SequentialDynamicsList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import medicalrecords.MedicalRecord;
import patients.Patient;

/**
 *
 * @author Student
 */
public class WaitingRomsList implements SequentialDynamicsList<Patient> {
    Queue<Patient> waitingList;
    
    
        public WaitingRomsList() {
        this.waitingList = new LinkedList();
    }

    
    @Override
    public Patient get() {
       return waitingList.peek();
    }


    
    
    @Override
    public boolean remove() {
       return waitingList.poll()!=null;
    }

    @Override
    public boolean add(Patient item) {
        try{
       return waitingList.add(item);
        }catch(IllegalStateException e){
            return false;
        }
        }

    @Override
    public Iterator getAll() {
        return waitingList.iterator();
    }

    @Override
    public int size() {
        return waitingList.size();
    }

    @Override
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

   

}
