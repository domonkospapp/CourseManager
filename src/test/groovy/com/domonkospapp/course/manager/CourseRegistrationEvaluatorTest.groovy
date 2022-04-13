package com.domonkospapp.course.manager

import spock.lang.Specification

import static java.util.Arrays.asList

class CourseRegistrationEvaluatorTest extends Specification {
    private final CourseRegistrationEvaluator registrationEvaulator = new CourseRegistrationEvaluator()

    def "should find all participants"() {
        given:
        final List<CourseRegistration> registrations = asList(
                new Enrolment("Stefan", "2018-01-01"),
                new Enrolment("Isabella", "2018-02-03"),
                new Enrolment("Martin", "2017-01-02"),
        )

        when:
        final List<String> result = registrationEvaulator.findAllParticipants(registrations)

        then:
        result.containsAll(asList("Martin","Isabella", "Stefan"))
    }

    def "should find all participants with disenrollment"() {
        given:
        final List<CourseRegistration> registrations = asList(
                new Enrolment("Stefan", "2018-01-01"),
                new Enrolment("Isabella", "2018-02-03"),
                new Enrolment("Martin", "2017-01-02"),
                new Disenrollment("Stefan", "2016-12-13"),
                new Disenrollment("Isabella", "2018-02-04")
        )

        when:
        final List<String> result = registrationEvaulator.findAllParticipants(registrations)

        then:
        result.containsAll(asList("Martin", "Stefan"))
    }

    def "should find no participants"() {
        given:
        final List<CourseRegistration> registrations = asList(
                new Disenrollment("Stefan", "2018-01-01"),
                new Disenrollment("Isabella", "2018-02-03"),
                new Disenrollment("Stefan", "2016-12-13"),
                new Disenrollment("Isabella", "2018-02-04")
        )

        when:
        final List<String> result = registrationEvaulator.findAllParticipants(registrations)

        then:
        result.empty
    }
}
