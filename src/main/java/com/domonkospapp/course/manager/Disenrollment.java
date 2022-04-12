package com.domonkospapp.course.manager;

import java.time.LocalDate;

public class Disenrollment extends CourseRegistration{
    Disenrollment(String courseParticipant, String registrationDate) {
        super(courseParticipant, RegistrationStatus.CANCELED, LocalDate.parse(registrationDate));
    }
}
