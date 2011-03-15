package org.esgf.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.esgf.domain.SearchSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/setting/*")
public class SearchSettingController {
    private final static Logger LOG = Logger.getLogger(SearchSettingController.class);
    private final static String ESGF_PROP_FILE = "esgf-fe.properties";
    private final Properties prop = new Properties();
    private final File f = new File(ESGF_PROP_FILE);


    public SearchSettingController() throws IOException {
        LOG.debug("SearchSettingController init ...");
        try {
            prop.load(new FileInputStream(ESGF_PROP_FILE));
            LOG.debug("Found old property file");
        } catch (FileNotFoundException e) {
            LOG.debug("Create new property file");
            prop.setProperty("googleScholar", "false");
            prop.setProperty("mendeley", "false");
            prop.setProperty("annotate", "false");
            prop.store(new FileOutputStream(f), null);
        }

        LOG.debug("property file: " + f.getAbsolutePath());
    }

    public void saveSetting(SearchSetting setting) throws IOException {
        prop.setProperty("annotate", setting.getAnnotate().toString());
        prop.setProperty("mendeley", setting.getMendeley().toString());
        prop.setProperty("googleScholar", setting.getGoogleScholar().toString());
        prop.store(new FileOutputStream(f), null);
    }

    @ModelAttribute("setting")
    public SearchSetting loadSetting() {

        SearchSetting setting = new SearchSetting();

        if (prop.containsKey("annotate")) {
            setting.setAnnotate(new Boolean(prop.getProperty("annotate")));
        } else {
            setting.setAnnotate(false);
        }

        if (prop.containsKey("googleScholar")) {
            setting.setGoogleScholar(new Boolean(prop.getProperty("googleScholar")));
        } else {
            setting.setGoogleScholar(false);
        }


        if (prop.containsKey("mendeley")) {
            setting.setMendeley(new Boolean(prop.getProperty("mendeley")));
        } else {
            setting.setMendeley(false);
        }

        return setting;

    }

    @RequestMapping("show")
    public String display(Model model) {
        LOG.debug("setup form ... ");
        return "admin/setting";

    }

    @RequestMapping(value="save", method = RequestMethod.POST)
    public @ResponseBody String processSubmit(
                @ModelAttribute("setting") SearchSetting setting,
                BindingResult results) throws IOException {

        LOG.debug("Saving setting ... ");
        // save java object to prop file format
        saveSetting(setting);
        return "Setting Saved";
    }

}