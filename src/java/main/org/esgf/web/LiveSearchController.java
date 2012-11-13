/*****************************************************************************
 * Copyright � 2011 , UT-Battelle, LLC All rights reserved
 *
 * OPEN SOURCE LICENSE
 *
 * Subject to the conditions of this License, UT-Battelle, LLC (the
 * �Licensor�) hereby grants to any person (the �Licensee�) obtaining a copy
 * of this software and associated documentation files (the "Software"), a
 * perpetual, worldwide, non-exclusive, irrevocable copyright license to use,
 * copy, modify, merge, publish, distribute, and/or sublicense copies of the
 * Software.
 *
 * 1. Redistributions of Software must retain the above open source license
 * grant, copyright and license notices, this list of conditions, and the
 * disclaimer listed below.  Changes or modifications to, or derivative works
 * of the Software must be noted with comments and the contributor and
 * organization�s name.  If the Software is protected by a proprietary
 * trademark owned by Licensor or the Department of Energy, then derivative
 * works of the Software may not be distributed using the trademark without
 * the prior written approval of the trademark owner.
 *
 * 2. Neither the names of Licensor nor the Department of Energy may be used
 * to endorse or promote products derived from this Software without their
 * specific prior written permission.
 *
 * 3. The Software, with or without modification, must include the following
 * acknowledgment:
 *
 *    "This product includes software produced by UT-Battelle, LLC under
 *    Contract No. DE-AC05-00OR22725 with the Department of Energy.�
 *
 * 4. Licensee is authorized to commercialize its derivative works of the
 * Software.  All derivative works of the Software must include paragraphs 1,
 * 2, and 3 above, and the DISCLAIMER below.
 *
 *
 * DISCLAIMER
 *
 * UT-Battelle, LLC AND THE GOVERNMENT MAKE NO REPRESENTATIONS AND DISCLAIM
 * ALL WARRANTIES, BOTH EXPRESSED AND IMPLIED.  THERE ARE NO EXPRESS OR
 * IMPLIED WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE,
 * OR THAT THE USE OF THE SOFTWARE WILL NOT INFRINGE ANY PATENT, COPYRIGHT,
 * TRADEMARK, OR OTHER PROPRIETARY RIGHTS, OR THAT THE SOFTWARE WILL
 * ACCOMPLISH THE INTENDED RESULTS OR THAT THE SOFTWARE OR ITS USE WILL NOT
 * RESULT IN INJURY OR DAMAGE.  The user assumes responsibility for all
 * liabilities, penalties, fines, claims, causes of action, and costs and
 * expenses, caused by, resulting from or arising out of, in whole or in part
 * the use, storage or disposal of the SOFTWARE.
 *
 *
 ******************************************************************************/
package org.esgf.web;

/**
 *
 * @author Feiyi Wang (fwang2@ornl.gov)
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/live")

public class LiveSearchController {

    private final static Logger LOG = Logger.getLogger(LiveSearchController.class);

    private final static String MODEL_NAME = "Model_Name";
    private final static String DATACART_OPEN = "Datacart_Open";
    private final static String FACET_PARAM_LIST = "Facet_Params";
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        
        Map<String,Object> model = new HashMap<String,Object>();

        String datacartOpen = request.getParameter("datacart");
        if(datacartOpen == null) {
            datacartOpen = "false";
        } else if(!datacartOpen.equals("true")) {
            datacartOpen = "false";
        }
        
        String modelName = request.getParameter("model");
        if(modelName == null) {
            modelName = "null";
        } 
        

        //model.put(MODEL_NAME,modelName);
        model.put(DATACART_OPEN,datacartOpen);
        

        //List<String> facetParams = getFacetParamList(request);
        //model.put(FACET_PARAM_LIST, facetParams);
        
        
        /*
        String [] facet_params = (String []) facetParams.toArray(new String[0]);
        
        System.out.println("facet_params len: " + facet_params.length);
        */
        LOG.debug("Enter index with modelName " + modelName + " and datacart open " + datacartOpen);
        
        return new ModelAndView("live-search",model);
    }
    
    private static List<String> getFacetParamList(HttpServletRequest request) {
        
        List<String> facetParams = new ArrayList<String>();
        
        for(Object key : request.getParameterMap().keySet()) {
            String keyStr = (String)key;
            
            System.out.println("Param: " + keyStr);
        }
        
        
        return facetParams;
        
    }
    
}
