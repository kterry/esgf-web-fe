package org.esgf.srmcache.datacart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/srmdatacartproxy")
public class SRMCacheDatacartController {

    public static void main(String [] args) {
        
        final MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        
        String dataset_id = "ornl.ultrahighres.CESM1.t341f02.FAMIPr.v1|esg2-sdnl1.ccs.ornl.gov";
        
        mockRequest.addParameter("dataset_id", dataset_id );
        //mockRequest.addParameter("dataset_id", "ana4MIPs.NASA-GMAO.MERRA.atmos.mon.v20121221|esgdata1.nccs.nasa.gov");
        
        SRMCacheDatacartController controller = new SRMCacheDatacartController();
        
        String response = controller.getDoc(mockRequest);
        
        System.out.println(response);
        
    }
    
    public SRMCacheDatacartController() {
        
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/datacart")
    public @ResponseBody String getDoc(HttpServletRequest request) {
    
        String response = "";
        
        System.out.println("\tIN POST");
        
        String datasetId = request.getParameter("dataset_id");
        if(datasetId == null) {
            System.out.println("NULL");
            return "failure";
        }
        
        DatacartDataset dDataset = DatacartDataset.getDatacartDatasetFromSolr(datasetId);
        
        
        response = dDataset.toJSON();
        
        System.out.println("\n\n\n\t->" + response);
        
        return response;
        
    }
    
}
