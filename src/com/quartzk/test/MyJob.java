package com.quartzk.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*
 * 需要执行的任务
 * 继承Job接口，实现excute方法
 */

public class MyJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println("测试Quartzk:   "+sdf.format(new Date()));
	}
	
	

}
