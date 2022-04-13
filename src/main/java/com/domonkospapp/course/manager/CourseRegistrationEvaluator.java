package com.domonkospapp.course.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseRegistrationEvaluator {

    public List<String> findAllParticipants(List<CourseRegistration> registrations) {
        Map<String, CourseRegistration> lastRegistrations = new HashMap<>();
        registrations.forEach(r -> {
            if(lastRegistrations.containsKey(r.getCourseParticipant())){
                if(r.getRegistrationDate().isAfter(lastRegistrations.get(r.getCourseParticipant()).getRegistrationDate())){
                    lastRegistrations.replace(r.getCourseParticipant(), r);
                }
            }else{
                lastRegistrations.put(r.getCourseParticipant(), r);
            }
        });
        return lastRegistrations.values().stream().filter(CourseRegistration::isEnrolled).map(CourseRegistration::getCourseParticipant).collect(Collectors.toList());
    }
}
