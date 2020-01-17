import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.swapkart.model.Notification;

public class Test {
	
	
	List<Notification> notificationlist = new ArrayList<Notification>();
	
	
	public static void main(String[] args) {
		
		new Test().convertData();
	
		
	}
	
	public void convertData() {
		
		for(int i=0;i<10;i++) {
			
			Notification notification = new Notification();
			notification.setDateTime("Just Now");
			notification.setNotificationImage("https://gamipress.com/wp-content/uploads/2018/12/notifications.svg");
			notification.setNotificationDesc("This is the first API Call");
			notification.setNotificationTitle("Notify");
		
			notificationlist.add(notification);
		}
		showData();
		
	}
	
	public void showData() {
		
		Gson gson = new Gson();
		String json = gson.toJson(notificationlist);
		System.out.println(json);
	}

}
