/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

import WaitingRoms.WaitingRomsList;
import appointments.Appointment;
import appointments.AppointmentsList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;
import patients.PatientsList;

public class Clinic {

    private PatientsList patients;
    private AppointmentsList appointments;
    private WaitingRomsList waitingRoom;

    public Clinic() {
        this.patients = new PatientsList();
        this.appointments = new AppointmentsList();
        this.waitingRoom = new WaitingRomsList();
    }

    public boolean addPatient(Patient patient) {
        if (patient == null) return false;
        return patients.add(patient);
    }

    public Patient findPatient(String id) {
        if (id == null || id.trim().isEmpty()) return null;
        return patients.get(id); 
    }

    public boolean removePatient(String id) {
        if (id == null || id.trim().isEmpty()) return false;
        return patients.remove(id);
    }

    public Iterator<Patient> getPatients() {
        return patients.getAll();
    }

    public boolean scheduleAppointment(Appointment appointment) {
        if (appointment == null) return false;
        return appointments.add(appointment);
    }

    public Appointment findAppointment(String code) {
        if (code == null || code.trim().isEmpty()) return null;
        return appointments.get(code); 
    }

    public Iterator<Appointment> getAppointments() {
        return appointments.getAll();
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        Appointment appo = findAppointment(code);
        if (appo != null) {
            appo.reschedule(newDate, newTime); 
            return true;
        }
        return false;
    }

    public boolean cancelAppointment(String code) {
        if (code == null || code.trim().isEmpty()) return false;
        
        Appointment appo = findAppointment(code);
        if (appo != null) {
            appo.cancel(); 
        }
        
        return appointments.remove(code);
    }

    public boolean checkInPatient(String patientId) {
        Patient p = findPatient(patientId);
        if (p != null) {
            return waitingRoom.add(p);
        }
        return false;
    }

    public Patient getNextPatient() {
        return waitingRoom.get(); 
    }

    public Patient attendNextPatient() {
        Patient next = waitingRoom.get();
        if (next != null) {
            waitingRoom.remove();
        }
        return next;
    }

    public int getWaitingPatientCount() {
        return waitingRoom.size();
    }

    public boolean isPatientWaiting(String patientId) {
        Iterator<Patient> it = waitingRoom.getAll();
        if (it != null) {
            while (it.hasNext()) {
                Patient p = it.next();
                if (p != null && p.getId() != null && p.getId().equals(patientId)) { 
                    return true;
                }
            }
        }
        return false;
    }
}