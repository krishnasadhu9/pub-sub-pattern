package hw8;

public class subscriberEvens implements observer {

	@Override
	public boolean notifyobserver(event E) {
		// TODO Auto-generated method stub
		
		int eventdata = E.getEventData();
		if(eventdata%2 == 0)
		{
			System.out.printf("Event Number - %d          Event Data - %d \n",E.getEventNumber(),  eventdata);
			System.out.println("This Event is assigned to Subscriber Evens \n");
			return true;
			
		}
		return false;
		
	}
	
	

}
