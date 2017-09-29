package com.sobt.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeatherJobBean extends QuartzJobBean{
	
	private SaveWeatherTask saveWeatherTask;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		saveWeatherTask.Excute();
		
	}
	
	
	public void setSaveWeatherTask(SaveWeatherTask saveWeatherTask){
		this.saveWeatherTask = saveWeatherTask;
	}

}
