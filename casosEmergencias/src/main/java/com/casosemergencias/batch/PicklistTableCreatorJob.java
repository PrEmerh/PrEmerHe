package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PicklistTableCreatorJob implements Job {
	final static Logger logger = Logger.getLogger(PicklistTableCreatorJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Carga de tabla de picklists iniciada con fecha " + new Date());
		PicklistTableCreatorBatch.fillHerokuPicklistTable();
		logger.info("Carga de tabla de picklists completada con fecha " + new Date());
	}
}