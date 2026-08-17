/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

import appointments.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;

/**
 *
 * @author Student
 */

public class clinicController {
    private Clinic clinic;
    private iViews view;
    private static clinicController controller;
    
    public static clinicController getInstance(iViews view){
        if (controller==null) 
            controller=new clinicController(view);
        return controller;
    }
    
    public void setView(iViews view){
        this.view = view;
    }
    
    private clinicController(iViews view){
        this.clinic=new Clinic();
        this.view=view;
    }
    
    public void addPatient(Patient patient){
        
    }

    public void findPatient(String id){
        
    }

    public void removePatient(String id){
        
    }

    public Iterator<Patient> getPatients(){
        
    }

    public boolean scheduleAppointment(Appointment appointment){
        boolean status = clinic.scheduleAppointment(appointment);
        if (status) {
            view.showMessage("Cita agendada correctamente");
        }else{
            view.showError("No se pudo agendar la cita");
        }
        return status;
    }

    public Appointment findAppointment(String code){
        Appointment appo = clinic.findAppointment(code);
        if(appo==null){
            view.showError("No se encuentra citas con el codigo ingresado");
        }
        view.clear();
        return appo;
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime){
        boolean status = clinic.rescheduleAppointment(code, newDate, newTime);
       if(status){
           view.showMessage("La cita se ha reagendado correctamente");
       }else{
           view.showError("No se pudo reagendar la cita");
       }
       return status;
    }

    public boolean cancelAppointment(String code){
        return false;
    }

    public Iterator<Appointment> getAppointments(){
        return null;
    }

    public boolean checkInPatient(String patientId){
        return false;
    }

    public Patient getNextPatient(){
        return null;
    }

    public Patient attendNextPatient(){
        return null;
    }

    public int getWaitingPatientCount(){
        return 0;
    }

    public boolean isPatientWaiting(String patientId){
        return false;
    }
    
}
