package com.domonkospapp.course.manager

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class DisenrollmentTest extends Specification {
    def "should init fields"() {
        given:
        def enrolment = new Disenrollment("carl", "2022-11-22")

        when:
        String enrollerName = enrolment.courseParticipant
        LocalDate enrolledAt = enrolment.registrationDate
        boolean isEnrolled = enrolment.isEnrolled()

        then:
        enrollerName == "carl"
        enrolledAt.year == 2022
        enrolledAt.month == Month.NOVEMBER
        enrolledAt.dayOfMonth == 22
        !isEnrolled
    }
}
