package hw8;

import java.util.*;

public class publisherimplementation implements publisher {
	
	public publisherimplementation()
	{}
	
	private List<observer> subscribers = new ArrayList<observer>();

	@Override
	public void registerObserver(observer O) {
		// TODO Auto-generated method stub
		 subscribers.add(O);
		
		
		System.out.println("The observer is added");
		
		
	}

	@Override
	public void removeObserver(observer O) {
		// TODO Auto-generated method stub
		
		subscribers.remove(O);
		System.out.println("The observer is removed");
		
	}

	@Override
	public void notifyObservers(observer O) {
		// TODO Auto-generated method stub
		
		
		
		
	}
	
	public void notifyobserver(event e)
	{
		
		
		
	   	
		
	}
	
	private event generateevent(int i)
	{   
	    int data = (int)(Math.random() * 5000 + 1);	
		event e = new event(i, data);
		return e;
	}
		
	
	public void runsimulation()
	{
		publisherimplementation pub =new publisherimplementation();
		
		observer Odds= new subsciberOdds();
		observer Evens = new subscriberEvens();
		observer Threes = new subsciberThrees();
		
		pub.registerObserver(Odds);
		pub.registerObserver(Evens);
		pub.registerObserver(Threes);
		
		
		int odd_count=0;
		int three_count=0;
		boolean odd = false , three = false;
		for(int i=1;i<201;i++)
		{
			event event_random = pub.generateevent(i);
			
			
			if(pub.subscribers.contains(Odds))
			{	
			 odd = Odds.notifyobserver(event_random);
			}
			
			if(pub.subscribers.contains(Threes))
			{	
			 three = Threes.notifyobserver(event_random);
			}
			 
			boolean even = Evens.notifyobserver(event_random);
			
			
			
			if(odd && pub.subscribers.contains(Odds))
			{	
				if(odd_count>=20)
				{
					pub.removeObserver(Odds);
					System.out.println("The SubScriber Odds is removed because it is assigned to more than 20events \n");
					odd_count = 0;
					
				}else{
					odd_count= odd_count + 1;
					System.out.printf(" This event is %d Subscriber Odds ", odd_count," \n " );
					
				}
					
			}
			
			
			 if(three && pub.subscribers.contains(Threes))
			{
				 
				if(three_count>=6)
				{
					pub.removeObserver(Threes);
					System.out.println("The SubScriber Threes is removed because it is assigned to more than 6 events \n");
					three_count = 0;
				}else {
				
					three_count= three_count + 1;
					System.out.printf(" This event is %d Subscriber Three ", three_count, " \n ");
			    }
				
		    } 
			 
			 
			 
			 if(i==40 || i==80 || i==160 || i==120 || i==200)
			    {
					if(pub.subscribers.contains(Odds))
					{
						
			        }
					else
					{
						pub.registerObserver(Odds);
						System.out.printf("The SubScriber Odds is re-registred at the event number is %d ",i , " \n ");
					}
					
					if(pub.subscribers.contains(Threes))
					{
			    	
					}
					else
					{
						pub.registerObserver(Threes);
				    	System.out.printf("The SubScriber Threes is re-registred at the event number is %d",i , " \n ");
					}
			    	
			    }
		
		}
		
		
	}

}
