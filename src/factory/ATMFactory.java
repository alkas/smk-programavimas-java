package factory;

import model.ATM;

public class ATMFactory {

    /**
     *  Sukuria ATM objektą
     */
    public ATM createATM(String atmId, String address) {
        return new ATM(atmId, address);
    }
}
