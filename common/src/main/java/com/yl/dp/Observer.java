package com.yl.dp;

import java.util.*;

/**
 *  参考链接:
 * @author Administrator
 *
 */

class WeatherEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String weatherEvent = "";
	
	public WeatherEvent(Object object, String weatherEvent) {
		// TODO Auto-generated constructor stub
		super(object);  // should check the EventObject's constructor, whether the format is right
		this.weatherEvent = weatherEvent;
	}

	public String getWeatherEvent() {
		return weatherEvent;
	}

	public void setWeatherEvent(String weatherEvent) {
		this.weatherEvent = weatherEvent;
	}

	
	
}

interface IWeatherListener extends EventListener{
	public void goingToDo(WeatherEvent event);
}

class reactOfMother2Weather implements IWeatherListener{
	public void goingToDo(WeatherEvent event){
		System.out.println(event.getWeatherEvent() + "  收被子啦");
	}
}

class reactOfGirl2Weather implements IWeatherListener{

	@Override
	public void goingToDo(WeatherEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.getWeatherEvent() + "  拿出小花伞啦啦");
		
	}
	
}

class WeatherForcast{
	private Set<EventListener> mListenerSet = null;
	
	public WeatherForcast(){
		mListenerSet = new HashSet<EventListener>();
	}
	
	public void addWeatherListener(EventListener listener){
		this.mListenerSet.add(listener);
	}
	
	public void notifyAllListener(){
		notifies();
	}
	
	private void notifies(){
		WeatherEvent weatherEvent = new WeatherEvent(this, "将要下雨");
		Iterator<EventListener> iterator = mListenerSet.iterator();
		while(iterator.hasNext() ){
			IWeatherListener iweatherListener = (IWeatherListener)iterator.next();
			iweatherListener.goingToDo(weatherEvent);
		}
	}
}

public class Observer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherForcast weatherForecast = new WeatherForcast();
		weatherForecast.addWeatherListener(new reactOfMother2Weather() );
		weatherForecast.addWeatherListener(new reactOfGirl2Weather() );
		weatherForecast.notifyAllListener();
	}

}
