package foodOrderSystem;
import javax.swing.*;
import java.lang.*;
import java.util.Arrays;


public class delivery {
	private String deliveryId;
	private String name;
	private char type; //P:partime - full time
	private int join_d;
	private int date; // performing date
	private String oderId;
	private boolean status;

	private order order;

	
	public delivery (String delID, String name1, char type1, int date) {
		deliveryId = delID;
		name = name1;
		type = type1;
		join_d = date;
	}

	public boolean getStatus(boolean status) {
		return status;

	}
	public boolean UpdateDeliveryStatus() {
		return status = true;
		//Done
	}

	public void doDelivery (int workdate, boolean status1) {
	    date = workdate;
	    status = status1;

	    //adding current date into and change status
        UpdateDeliveryStatus();
    }

    public void checkOrder() {
	    order.checkOrder();
	    //check order for devivery guy
    }




}
