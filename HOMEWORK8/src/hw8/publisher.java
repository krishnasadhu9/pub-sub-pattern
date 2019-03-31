package hw8;
import java.util.*;

public interface publisher {
	
	public void registerObserver(observer O);
	public void removeObserver(observer O);
	public void notifyObservers(observer O);

	
}
