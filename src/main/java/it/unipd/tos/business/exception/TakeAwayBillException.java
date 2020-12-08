////////////////////////////////////////////////////////////////////
// [GABRIELE] [FILIPPI] [1187023]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception {

    private String message;

    public TakeAwayBillException(String error) {
        this.message = error;
    }

    public String getMessage() {
        return this.message;
    }
}