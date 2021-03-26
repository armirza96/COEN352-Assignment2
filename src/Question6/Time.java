package Question6;

import java.util.Hashtable;

public class Time implements Comparable<Time> {
	
	int hour = 0;
	int minute = 0;
	int second = 0;
	
	Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	/** sort time objects by ascending order **/
	@Override
	public int compareTo(Time time) {
		// this keeps track of wht order the object should be assigned
		// -1 means the value is greater than the current object
		// 0 means value is equal to current time
		// 1 means the value is less than the current object
		int order = 0;
		
		// these if statements can be simplified but I just cant seem to do so
		// so if u got an idea plase let me know!
		if(time.hour == this.hour) {
			if(time.minute == this.minute) {
				 if(time.second == this.second) {
					order = 0;
				} else if(time.minute < this.minute) {
					order = 1;
				} else {
					order = -1;
				}
			} else if(time.minute < this.minute) {
				order = 1;
			} else {
				order = -1;
			}
		} else if(time.hour < this.hour) {
			order = 1;
		} else {
			order = -1;
		}
		
		return order;
	}
	
	public String toString() {
		return String.format("%d:%d:%d", hour, minute, second);
	}
	
}
