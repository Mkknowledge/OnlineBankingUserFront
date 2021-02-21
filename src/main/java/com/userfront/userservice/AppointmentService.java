package com.userfront.userservice;

import java.util.List;
import java.util.Optional;

import com.userfront.domain.Appointment;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

    List<Appointment> findAll();

    Optional<Appointment> findAppointment(Long id);
    
    Appointment findAppointment1(Long id);

    void confirmAppointment(Long id);
}
