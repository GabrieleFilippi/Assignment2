////////////////////////////////////////////////////////////////////
// [GABRIELE] [FILIPPI] [1187023]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayDiscount implements TakeAwayBill {
    public double getOrderPrice(List < MenuItem > itemsOrdered, User user) throws TakeAwayBillException {
        double total = 0.0;

        if (itemsOrdered == null) {
            throw new TakeAwayBillException("La lista è vuota");
        }

        if (itemsOrdered.contains(null)) {
            throw new TakeAwayBillException("Nella lista è presente un elemento vuoto");
        }

        for (MenuItem i: itemsOrdered) {
            total += i.getPrice();
            }
        }
        return total;
    }
}