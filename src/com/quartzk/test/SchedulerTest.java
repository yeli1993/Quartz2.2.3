package com.quartzk.test;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/*
 * �����������
 * ����trigger����
 */

public class SchedulerTest {
	
	 // ���嶨ʱ�����ִ���߼� cronExpressionÿ5��ִ��һ��
	  private final static String CRON_EXPRESSION = "0/5 * * * * ?";  
	  // �����������ƣ��Զ��壩  
	  private final static String JOB_NAME = "JOB_NAME";  
	  // ��������������  
	  private final static String GROUP_NAME = "GROUP_NAME";  
	  // ���崥��������  
	  private final static String TRIGGER_NAME = "TRIGGER_NAME"; 
	
	public static void main(String[] args) {
		//get Scheduler
		SchedulerFactory schedulerfactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = schedulerfactory.getScheduler();
			
			//����JobDetailʵ������Jobʵ���࣬��ָ��Job���ƣ����������ƣ�����
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity(JOB_NAME, GROUP_NAME).build();
			
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(TRIGGER_NAME, GROUP_NAME)
					.withSchedule(CronScheduleBuilder.cronSchedule(CRON_EXPRESSION)).build();    
	        scheduler.scheduleJob(jobDetail, trigger);    
			
			//��������
			scheduler.start();
			/*try {
				Thread.sleep(60L * 1000L);
				scheduler.shutdown(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}
}
	