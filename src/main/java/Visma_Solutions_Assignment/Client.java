/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visma_Solutions_Assignment;

import java.time.LocalDateTime;

/**
 *
 * @author Maija
 */
public class Client {
    private int id;
    
    public Client(int pId) {
        setId(pId);
    }
    
    private void setId(int i) {
        id = i;
    }
    
    public boolean addShift(LocalDateTime date, String start, String end) {
        double duration = Validator.validateShift(date,start, end);
        
        if (duration < 0) { // Given parameters were not valid
            return false;
        } else { // Parameters were valid
            // Do something with the shift, send to server maybe
            return true;
        }
    }
    
    
}
