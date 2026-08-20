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
        return false;
    }

    public Patient findPatient(String id) {
        return null;
    }

    public boolean removePatient(String id) {
        return false;
    }

    public Iterator<Patient> getPatients() {
        return null;
    }

    public boolean scheduleAppointment(Appointment appointment) {
        return false;
    }

    public Appointment findAppointment(String code) {
        return null;
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        return false;
    }

    public boolean cancelAppointment(String code) {
        return false;
    }

    public Iterator<Appointment> getAppointments() {
        return null;
    }

    public boolean checkInPatient(String patientId) {
        return false;
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
