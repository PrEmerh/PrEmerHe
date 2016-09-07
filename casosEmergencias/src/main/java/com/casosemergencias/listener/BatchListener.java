package com.casosemergencias.listener;

import static org.quartz.JobBuilder.newJob;

import java.text.ParseException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.casosemergencias.batch.FieldLabelTableCreatorJob;
import com.casosemergencias.batch.PicklistTableCreatorJob;

public class BatchListener implements ServletContextListener {

	static final Logger logger = Logger.getLogger(BatchListener.class);
	private Scheduler scheduler = null;
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			logger.info("Creando job de Quartz");
			JobDetail job = newJob(PicklistTableCreatorJob.class).withIdentity("picklistTableCreatorJob", "batch").build();
			
			logger.info("Creando trigger de Quartz");
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("picklistTableCreatorTrigger", "batch")
					.withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0 0 23 ? * *"))).build();
			
			logger.info("Creando scheduler de Quartz");
			Scheduler picklistTableCreatorScheduler = StdSchedulerFactory.getDefaultScheduler();
			picklistTableCreatorScheduler.start();
			picklistTableCreatorScheduler.scheduleJob(job, trigger);
			
			logger.info("Creando job de Quartz para labels de campo");
			job = newJob(FieldLabelTableCreatorJob.class).withIdentity("fieldLabelTableCreatorJob", "batch").build();
			
			logger.info("Creando trigger de Quartz");
			trigger = TriggerBuilder.newTrigger().withIdentity("fieldLabelTableCreatorTrigger", "batch")
					.withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0 0 23 ? * *"))).build();
			
			logger.info("Creando scheduler de Quartz");
			picklistTableCreatorScheduler = StdSchedulerFactory.getDefaultScheduler();
			picklistTableCreatorScheduler.start();
			picklistTableCreatorScheduler.scheduleJob(job, trigger);
			
		} catch (SchedulerException schedulerException) {
			logger.error("Error ejecutando job: ", schedulerException);
		} catch (ParseException parseException) {
			logger.error("Error ejecutando job: ", parseException);
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			if (scheduler != null && scheduler.isStarted()) {
				logger.info("Finalizando scheduler de Quartz");
				scheduler.shutdown();
			}
		} catch (SchedulerException schedulerException) {
			logger.error("Error finalizando el scheduler de Quartz: ", schedulerException);
		}
		
	}
}