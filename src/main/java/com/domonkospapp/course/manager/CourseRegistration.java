package com.domonkospapp.course.manager;

import java.time.LocalDate;

public abstract class CourseRegistration {
    private final String courseParticipant;
    private final RegistrationStatus registrationStatus;
    private final LocalDate registrationDate;

    public CourseRegistration(String courseParticipant, RegistrationStatus registrationStatus, LocalDate RegistrationDate) {
        this.courseParticipant = courseParticipant;
        this.registrationStatus = registrationStatus;
        this.registrationDate = RegistrationDate;
    }

    public String getCourseParticipant() {
        return courseParticipant;
    }

    public boolean isEnrolled() {
        return RegistrationStatus.ENROLLED == registrationStatus;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "CourseRegistration{" +
                "courseParticipant='" + courseParticipant + '\'' +
                ", registrationStatus=" + registrationStatus +
                ", registrationDate=" + registrationDate +
                '}';
    }


}
