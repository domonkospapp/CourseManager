package com.domonkospapp.course.manager;

import java.time.LocalDate;

public class Enrolment extends CourseRegistration{
    Enrolment(String courseParticipant, String registrationDate) {
        super(courseParticipant, RegistrationStatus.ENROLLED, LocalDate.parse(registrationDate));
    }
}
