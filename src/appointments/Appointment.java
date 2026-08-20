/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;

import java.time.LocalDate;
import java.time.LocalTime;
import patients.Patient;

/**
 *
 * @author jprod
 */
public class Appointment implements Comparable<Appointment> {
    //implememtar Comparable<Appointment>
    private final String code;
    private final Patient patient;
    private LocalDate date;
    private LocalTime time;
    private final String reason;
    private AppointmentStatus status;

    public String getCode() {
        return code;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public Appointment(String code, Patient patient, LocalDate date, LocalTime time, String reason) {
        this.code = code;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = AppointmentStatus.SCHEDULED;
    }
    
    public void reschedule(LocalDate newDate, LocalTime newTime){
        this.date = newDate;
        this.time = newTime;
    }

    public void cancel(){
        this.status = AppointmentStatus.CANCELLED;
    }

    public boolean isPending(){
        return this.status == AppointmentStatus.SCHEDULED;
    }

    public boolean isToday(){
        return this.date.equals(LocalDate.now());
    }

    @Override
    public int compareTo(Appointment other) {

        int result = this.date.compareTo(other.date);

        if (result == 0) {
            result = this.time.compareTo(other.time);
        }

        if (result == 0) {
            result = this.code.compareTo(other.code);
        }

        return result;
    }
}
