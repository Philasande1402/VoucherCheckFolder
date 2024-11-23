/*
(2.1) Voucher Class: (4)


*/

package models;

import java.util.Date;
import java.util.Calendar;

public class Voucher {
    private String voucherCode;
    private Date expiryDate;

    public Voucher(String voucherCode) {
        
        this.voucherCode=voucherCode;
        
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, 3);
        this.expiryDate = calendar.getTime();
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
