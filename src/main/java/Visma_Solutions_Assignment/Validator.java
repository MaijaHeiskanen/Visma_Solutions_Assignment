/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visma_Solutions_Assignment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Maija
 */
public class Validator {
    
    // Returns the duration if the given times are valid, otherwise returns -1
    public static double validateShift(LocalDateTime date, String pStart, String pEnd) {
        LocalTime start = parseString(pStart);
        LocalTime end = parseString(pEnd);
        
        if (isBetween(start, end)) {
            return checkLength(start, end);
        } else {
            return -1;
        }
    }
    
    // Parses the string to be LocalTime
    private static LocalTime parseString(String string) {
        return LocalTime.parse(string);
    }
    
    private static boolean isBetween(LocalTime start, LocalTime end) {
        LocalTime min = LocalTime.parse("00:00");
        LocalTime max = LocalTime.parse("23:59");
        
        return ((start.isAfter(min) || start.equals(min)) && start.isBefore(max)) && (end.isAfter(min) && (end.isBefore(max) || end.equals(max)));
    }
    
    private static double checkLength(LocalTime start, LocalTime end) {
        Duration difference;
        difference = Duration.between(start, end);
        double duration = difference.getSeconds()/3600;
        
        if (difference.isNegative() || (duration > 16)) {
            return -1;
        } else {
            return duration;
        }
    }
    
    
    
}
