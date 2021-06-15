package co.tropical.access;

import java.util.ArrayList;

import co.tropical.model.Tropical;

public interface TropicalAccess {
	
	// all reservation status
	public ArrayList<Tropical> tableAll();
	
	public boolean adLogin (String id, int pw);
	
	public void book (Tropical tropical);
	
	public void adChange (Tropical tropical);
	
	public void adCancel (String id);
	
	
	
	
	
	// a reservation status
	public ArrayList<Tropical> selectBook();
	
	public boolean gstLogin (String guest_id, int guest_pw);
	
	public void gstChange (Tropical tropical);
	
	public void gstCancel (String guest_id);
	
	

}
