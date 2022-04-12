package com.domonkospapp.course.manager

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class EnrolmentTest extends Specification {
    def "should init fields"() {
        given:
        def enrolment = new Enrolment("dave", "2017-01-02")

        when:
        String enrollerName = enrolment.courseParticipant
        LocalDate enrolledAt = enrolment.registrationDate
        boolean isEnrolled = enrolment.isEnrolled()

        then:
        enrollerName == "dave"
        enrolledAt.year == 2017
        enrolledAt.month == Month.JANUARY
        enrolledAt.dayOfMonth == 2
        isEnrolled
    }
}
