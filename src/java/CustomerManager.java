
import Contracts.CustomerContract;
import DTO.FerryDTO;
import ETO.FerryETO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cluster C - Daniel & Tea
 */
public class CustomerManager {

    @EJB
    private CustomerContract cc;

    public CustomerManager() {
    }
    
    public List<FerryDTO> GetListOfFerries() throws FerryETO {
        
        try {
            return cc.GetListOfFerries();
        } catch (FerryETO ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cc.GetListOfFerries();
    }

}
