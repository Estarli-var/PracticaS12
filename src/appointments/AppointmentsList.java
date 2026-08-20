/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;

import clinic.KeyDynamicsLists;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Student
 */
public class AppointmentsList implements KeyDynamicsLists<Appointment,String>{
    TreeSet<Appointment> appointment;
    
    public AppointmentsList() {
        this.appointment = new TreeSet();
    }
    
    @Override
    public Appointment get(String code) {
        for (Appointment appo : appointment) {
            if(appo.getCode().equals(code)){
                return appo;
            }
        }
        return null;
    }

    @Override
    public boolean remove(String id) {
        Appointment appo  = this.get(id);
        if(appo == null){
            return false;
        }
        return appointment.remove(appo);
    }

    @Override
    public boolean add(Appointment item) {
        return appointment.add(item);
    }

    @Override
    public Iterator getAll() {
        if(appointment.isEmpty()){
            return null;
        }
        return appointment.iterator();
    }

    @Override
    public int size() {
        return appointment.size();
    }

    @Override
    public boolean isEmpty() {
        return appointment.isEmpty();
    } 
}

