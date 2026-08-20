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

public class clinicController {
    
    private Clinic clinic;
    private iViews view;
    private static clinicController controller;
    
    public static clinicController getInstance(iViews view) {
        if (controller == null) {
            controller = new clinicController(view);
        } else {
            controller.setView(view); 
        }
        return controller;
    }
    
    public void setView(iViews view) {
        this.view = view;
    }
    
    private clinicController(iViews view) {
        this.clinic = new Clinic();
        this.view = view;
    }
    

    public void addPatient(Patient patient) {
        if (clinic.addPatient(patient)) {
            view.showMessage("Paciente agregado correctamente.");
        } else {
            view.showError("No se pudo agregar el paciente.");
        }
    }

    public Patient findPatient(String id) {
        Patient patient = clinic.findPatient(id);
        if (patient == null) {
            view.showError("No se encontró el paciente con el ID ingresado.");
        } else {
            view.showData(patient);
        }
        return patient;
    }

    public void removePatient(String id) {
        if (clinic.removePatient(id)) {
            view.showMessage("Paciente eliminado correctamente.");
        } else {
            view.showError("No se pudo eliminar el paciente.");
        }
    }

    public Iterator<Patient> getPatients() {
        return clinic.getPatients();
    }


    public boolean scheduleAppointment(Appointment appointment) {
        boolean status = clinic.scheduleAppointment(appointment);
        if (status) {
            view.showMessage("Cita agendada correctamente.");
        } else {
            view.showError("No se pudo agendar la cita.");
        }
        return status;
    }

    public Appointment findAppointment(String code) {
        Appointment appo = clinic.findAppointment(code);
        if (appo == null) {
            view.showError("No se encontraron citas con el código ingresado.");
        } else {
            view.showData(appo);
        }
        return appo;
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        boolean status = clinic.rescheduleAppointment(code, newDate, newTime);
        if (status) {
            view.showMessage("La cita se ha reagendado correctamente.");
        } else {
            view.showError("No se pudo reagendar la cita.");
        }
        return status;
    }

    public boolean cancelAppointment(String code) {
        boolean status = clinic.cancelAppointment(code);
        if (status) {
            view.showMessage("Cita cancelada correctamente.");
        } else {
            view.showError("No se pudo cancelar la cita.");
        }
        return status;
    }

    public Iterator<Appointment> getAppointments() {
        return clinic.getAppointments();
    }

    public boolean checkInPatient(String patientId) {
        boolean status = clinic.checkInPatient(patientId);
        if (status) {
            view.showMessage("Paciente ingresado a la sala de espera.");
        } else {
            view.showError("No se encontró el paciente o no se pudo registrar el ingreso.");
        }
        return status;
    }

    public Patient getNextPatient() {
        Patient p = clinic.getNextPatient();
        if (p == null) {
            view.showError("No hay pacientes en la sala de espera.");
        } else {
            view.showData(p);
        }
        return p;
    }

    public Patient attendNextPatient() {
        Patient p = clinic.attendNextPatient();
        if (p != null) {
            view.showMessage("Atendiendo a: " + p.toString());
        } else {
            view.showError("No hay pacientes en espera para atender.");
        }
        return p;
    }

    public int getWaitingPatientCount() {
        return clinic.getWaitingPatientCount(); 
    }

    public boolean isPatientWaiting(String patientId) {
        return clinic.isPatientWaiting(patientId); 
    }
}
