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

/**
 *
 * @author Student
 */
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
        return patients.add(patient);
    }

    public Patient findPatient(String id) {
        return patients.get(id);
    }

    public boolean removePatient(String id) {
        return patients.remove(id);
    }

    public Iterator<Patient> getPatients() {
        return patients.getAll();
    }

    public boolean scheduleAppointment(Appointment appointment) {
        return appointments.add(appointment);
    }

    public Appointment findAppointment(String code) {
        return appointments.get(code);
    }
    
    public Iterator<Appointment> getAppointments() {
    return appointments.getAll();
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        Appointment appo = findAppointment(code);
        if (appo != null) {
            appo.setDate(newDate);
            appo.setTime(newTime);
            return true;
        }
        return false;
    }

    public boolean cancelAppointment(String code) {
        return appointments.remove(code);
    }

    public boolean checkInPatient(String patientId) {
        Patient p= findPatient(patientId);
    }

    public Patient getNextPatient() {
        return null;
    }

    public Patient attendNextPatient() {
        return null;
    }

    public int getWaitingPatientCount() {
        return 0;
    }

    public boolean isPatientWaiting(String patientId) {
        return false;
    }
}
