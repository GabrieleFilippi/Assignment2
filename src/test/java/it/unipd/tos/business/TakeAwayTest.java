////////////////////////////////////////////////////////////////////
// [GABRIELE] [FILIPPI] [1187023]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayTest {
	
	TakeAwayDiscount bill;
	User user;
	double total;
	List<MenuItem> list;
	private static final double Diff = 1e-3;
	
	@Before
	public void setup() {
		bill = new TakeAwayDiscount();
		total = 0.00;
		list = new ArrayList<MenuItem>();
		user = new User("Gabriele","Filippi",21);
	}
	
	@Test
	public void sumTest() throws TakeAwayBillException {

        list.add(new MenuItem(MenuItem.type.Budino, "Asdrubale", 8.00));
        list.add(new MenuItem(MenuItem.type.Gelato, "Panna", 6.00));
        list.add(new MenuItem(MenuItem.type.Bevanda, "Coca", 2.50));

        total = bill.getOrderPrice(list,user);

        assertEquals(16.50,total,Diff);
    }
	
	@Test(expected = TakeAwayBillException.class) 
    public void listNulltTest() throws TakeAwayBillException {
        list = null;
        total = bill.getOrderPrice(list,user);
    }
	
	@Test(expected = TakeAwayBillException.class) 
    public void nullInListTest() throws TakeAwayBillException {
        list.add(new MenuItem(MenuItem.type.Budino,"Pino",3.50));
		list.add(null);
        total = bill.getOrderPrice(list,user);
    }
}