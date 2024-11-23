/*
2.2 VoucherCheck Class (6)
*/

package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import models.Voucher;


public class VoucherCheck {
    private List<String> redeemedVouchers;

    public VoucherCheck() {
        
        redeemedVouchers = new ArrayList<>();
        
        redeemedVoucher();
        
      
    }
    
    private void redeemedVoucher()
    {
        File file;
        JFileChooser fc = new JFileChooser();
        int valu = fc.showOpenDialog(null);
        if(valu==JFileChooser.APPROVE_OPTION)
        {
            file = fc.getSelectedFile();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine()) != null)
            {
                redeemedVouchers.add(line.trim());
            }
            //br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VoucherCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VoucherCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
    }

    public boolean checkVoucher(Voucher voucher) {
        return redeemedVouchers.contains(voucher.getVoucherCode());
    }
}
