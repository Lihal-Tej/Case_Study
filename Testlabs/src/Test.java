import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {

	
	public static void main(String[] args) {
		
		String jsonDate = "{\"date\":\"04/02/2019\"}";
		System.out.println(jsonDate);
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		
		BeanDetails details = gson.fromJson(jsonDate, BeanDetails.class);
		System.out.println(details.getDate());
	}
	
	class BeanDetails{
		
		private Date date;

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
		
		
	}
}
