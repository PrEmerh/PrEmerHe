package com.casosemergencias.batch;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class FieldLabelTableCreatorJob implements Job {
	final static Logger logger = Logger.getLogger(FieldLabelTableCreatorJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Carga de tabla de labels de campo iniciada con fecha " + new Date());
		FieldLabelTableCreatorBatch.fillHerokuFieldLabelTable();
		logger.info("Carga de tabla de labels de campo completada con fecha " + new Date());
	}

}