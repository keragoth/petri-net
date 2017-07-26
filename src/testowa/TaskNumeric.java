/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.util.Date;
import org.jfree.data.gantt.Task;

/**
 *
 * @author Grzegorz
 */
public class TaskNumeric extends Task {

    public TaskNumeric(String description, long start, long end) {
        super(description, new Date(start), new Date(end));
    }

}
