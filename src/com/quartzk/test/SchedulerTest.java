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
 * 调用任务的类
 * 定义trigger规则
 */

public class SchedulerTest {
	
	 // 定义定时任务的执行逻辑 cronExpression每5秒执行一次
	  private final static String CRON_EXPRESSION = "0/5 * * * * ?";  
	  // 定义任务名称（自定义）  
	  private final static String JOB_NAME = "JOB_NAME";  
	  // 定义任务组名称  
	  private final static String GROUP_NAME = "GROUP_NAME";  
	  // 定义触发器名称  
	  private final static String TRIGGER_NAME = "TRIGGER_NAME"; 
	
	public static void main(String[] args) {
		//get Scheduler
		SchedulerFactory schedulerfactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = schedulerfactory.getScheduler();
			
			//创建JobDetail实例，绑定Job实现类，并指明Job名称，所在组名称，类名
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity(JOB_NAME, GROUP_NAME).build();
			
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(TRIGGER_NAME, GROUP_NAME)
					.withSchedule(CronScheduleBuilder.cronSchedule(CRON_EXPRESSION)).build();    
	        scheduler.scheduleJob(jobDetail, trigger);    
			
			//启动调度
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
	