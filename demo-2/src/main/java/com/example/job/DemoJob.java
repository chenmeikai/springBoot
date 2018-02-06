/**
 * 
 */
package com.example.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author meikai
 * quartz job
 */
public class DemoJob implements Job{

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("AAAA: The time is now " + dateFormat().format(new Date()));
    }
}
