package org.sector7.jobs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by sector7 on 12/31/15.
 */
public class MessageNotifier implements Job {

    final Logger logger = Logger.getLogger("JobLogger");

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {

        System.out.println("------------------------------- 001");
        logger.log(Level.INFO , "Job start");

    }
}
