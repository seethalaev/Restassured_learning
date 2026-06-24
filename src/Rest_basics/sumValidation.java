package Rest_basics;

import Base.Payload;
import io.restassured.path.json.JsonPath;

public class sumValidation {

	public static void main (String args[])
	{
	//@Test
	public void sumOfCourse()
	{
		JsonPath js=new JsonPath(Payload.CoursePrice());
		int count=js.getInt("cources.size()");
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("cources["+i+"].price");
			int copies=js.getInt("cources["+i+"].copies");
			int amount=price*copies;
			System.out.println(amount);
		}
	}
}}
