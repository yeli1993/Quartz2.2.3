package com.quartzk.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*
 * ��Ҫִ�е�����
 * �̳�Job�ӿڣ�ʵ��excute����
 */

public class MyJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println("����Quartzk:   "+sdf.format(new Date()));
	}
	
	

}
