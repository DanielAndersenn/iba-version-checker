package dk.iba.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dk.iba.data.Customer;
import dk.iba.data.Environment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

/**
 *
 * @author danand
 */
public class VersionChecker extends HttpServlet {
    
    //Session to attach attributes to
    HttpSession session;
    
    //Clientconfig for setting timeout
    ClientConfig config = new ClientConfig();
    
    //Customer list
    public List<Customer> customerList;
    
    static WebTarget r;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("Entered doGet() of VersionChecker!!!");
        
        config.property(ClientProperties.CONNECT_TIMEOUT, 500);
        config.property(ClientProperties.READ_TIMEOUT, 500);
 
        customerList = new ArrayList();
        
        session = request.getSession();
        initCustomerList();
        
        for(Customer cus : customerList) {
            populateCustomerEnvLists(cus);
        }
        
        System.out.println();

        session.setAttribute("customerList", customerList);
        request.getRequestDispatcher("WEB-INF/result.jsp").forward(request, response);
    }

    public void populateCustomerEnvLists(Customer cus) {
        ArrayList<String> envList = cus.getEnvList();
        Environment toAdd;
        
        for(String EnvToCheck : envList ) {
            toAdd = new Environment();
            if(EnvToCheck.length() == 25) {
                toAdd = addEnvironment(EnvToCheck, Environment.type.PROD);
                cus.addProdEnv(toAdd);
            } else if(EnvToCheck.contains("test")) {
                toAdd = addEnvironment(EnvToCheck, Environment.type.TEST);
                cus.addTestEnv(toAdd);
            } else if(EnvToCheck.contains("dev")) {
                toAdd = addEnvironment(EnvToCheck, Environment.type.DEV);
                cus.addDevEnv(toAdd);
            } 
                else {
                toAdd = addEnvironment(EnvToCheck, Environment.type.OTHER);
                cus.addOtherEnv(toAdd);
            }
        }
        System.out.println(cus.getcName() + " | sizeOf prodenv: " + cus.getProdEnv().size() + " | size of testEnv: " + cus.getTestEnv().size() + " | size of devEnv: "  + cus.getDevEnv().size() + " | size of otherEnv: " + cus.getOtherEnv().size());
    }
    
    public Environment addEnvironment(String url, Environment.type type) {
        Response re = null;
        
        //System.out.println("Url: " + url);
        r = ClientBuilder.newClient(config).target(url + "/info/version");
        Invocation.Builder invo;
        invo = r.request();
        Environment env = new Environment();
        
        try{
        re = invo.get();
        }catch(ProcessingException e) {
            env.setEnvName(urlToEnvName(url));
            env.setURL(url);
            env.setVersion("Not deployed");
            env.setType(type);
            return env;
        }
        
        String version = re.readEntity(String.class);
        
        //System.out.println(re.getStatus());
        if(re.getStatus() != 200) {
            env.setEnvName(urlToEnvName(url));
            env.setURL(url);
            env.setVersion("API call " + re.getStatus() + "'d");
            env.setType(type);
        }  else if (version.length() > 50) {
            env.setEnvName(urlToEnvName(url));
            env.setURL(url);
            env.setVersion("Version too old");
            env.setType(type);
        } else {
            env.setEnvName(urlToEnvName(url));
            env.setURL(url);
            env.setVersion(version);
            env.setType(type);
        }
        System.out.println(env.getEnvName());
        return env;
    }
    
    public String urlToEnvName(String url) {
        String[] urlSplit = url.split("\\.");    
        return urlSplit[0].substring(8);
    }
    

    public void initCustomerList() {
        Customer cus1 = new Customer("Mondux", new ArrayList<String>(Arrays.asList("https://102.ibapps.dk/102", "https://102test.ibapps.dk/102test", "https://113.ibapps.dk/113")));
        customerList.add(cus1);
        Customer cus2 = new Customer("Frida", new ArrayList<String>(Arrays.asList("https://104.ibapps.dk/104", "https://104test.ibapps.dk/104test", "https://104dev.ibapps.dk/104dev")));
        customerList.add(cus2);    
        Customer cus3 = new Customer("ASG", new ArrayList<String>(Arrays.asList("https://106.ibapps.dk/106", "https://106test.ibapps.dk/106test", "https://106dev.ibapps.dk/106dev")));  
        customerList.add(cus3);   
        Customer cus4 = new Customer("HGF", new ArrayList<String>(Arrays.asList("https://107.ibapps.dk/107", "https://107test.ibapps.dk/107test")));
        customerList.add(cus4);     
        Customer cus5 = new Customer("ProSam", new ArrayList<String>(Arrays.asList("https://110.ibapps.dk/110", "https://110test.ibapps.dk/110test")));
        customerList.add(cus5);
        Customer cus6 = new Customer("AON", new ArrayList<String>(Arrays.asList("https://111.ibapps.dk/111", "https://111test.ibapps.dk/111test", "https://111dev.ibapps.dk/111dev")));
        customerList.add(cus6);
        Customer cus7 = new Customer("AIG", new ArrayList<String>(Arrays.asList("https://112.ibapps.dk/112", "https://test.ibapps.dk:4112/112test")));
        customerList.add(cus7);
        Customer cus8 = new Customer("Qudos", new ArrayList<String>(Arrays.asList("https://114.ibapps.dk/114", "https://114test.ibapps.dk/114test", "https://114perf.ibapps.dk/114perf", "https://114prep.ibapps.dk/114prep", "https://114dev.ibapps.dk/114dev")));
        customerList.add(cus8);
        Customer cus9 = new Customer("MAG", new ArrayList<String>(Arrays.asList("https://115.ibapps.dk/115", "https://115test.ibapps.dk/115test")));
        customerList.add(cus9);
        Customer cus10 = new Customer("SBM", new ArrayList<String>(Arrays.asList("https://116.ibapps.dk/116", "https://116test.ibapps.dk/116test", "https://test.ibapps.dk:6116/116prep", "https://116dev.ibapps.dk/116dev")));
        customerList.add(cus10);
        Customer cus11 = new Customer("AXA", new ArrayList<String>(Arrays.asList("https://117.ibapps.dk/117", "https://117test.ibapps.dk/117test", "https://117dev.ibapps.dk/117dev")));
        customerList.add(cus11);
        Customer cus12 = new Customer("ASG Fleet", new ArrayList<String>(Arrays.asList("https://118.ibapps.dk/118", "https://118test.ibapps.dk/118test", "https://118dev.ibapps.dk/118dev")));
        customerList.add(cus12);
        Customer cus13 = new Customer("NEM", new ArrayList<String>(Arrays.asList("https://119.ibapps.dk/119", "https://119test.ibapps.dk/119test", "https://119mig.ibapps.dk/119mig", "https://119mig2.ibapps.dk/119mig2", "https://119per.ibapps.dk/119per", "https://119rea.ibapps.dk/119rea", "https://119dep.ibapps.dk/119dep", "https://119dev.ibapps.dk/119dev")));
        customerList.add(cus13);
        Customer cus14 = new Customer("Berkshire Hathaway", new ArrayList<String>(Arrays.asList("https://120.ibapps.dk/120", "https://test.ibapps.dk:4120/120test", "https://120dev.ibapps.dk/120dev")));
        customerList.add(cus14);
        Customer cus15 = new Customer("AmTrust", new ArrayList<String>(Arrays.asList("https://121.ibapps.dk/121", "https://test.ibapps.dk:4121/121test19", "https://121test.ibapps.dk/121test", "https://121mig.ibapps.dk/121mig", "https://121dev.ibapps.dk/121dev", "https://129dev.ibapps.dk/129dev", "https://129.ibapps.dk/129", "https://129test.ibapps.dk/129test")));
        customerList.add(cus15);
        Customer cus16 = new Customer("DFF", new ArrayList<String>(Arrays.asList("https://122.ibapps.dk/122", "https://122test.ibapps.dk/122test", "https://122dev.ibapps.dk/122dev")));
        customerList.add(cus16);
        Customer cus17 = new Customer("Gefion", new ArrayList<String>(Arrays.asList("https://123.ibapps.dk/123", "https://123test.ibapps.dk/123test", "https://123dev.ibapps.dk/123dev")));
        customerList.add(cus17);
        Customer cus18 = new Customer("AIG Finland", new ArrayList<String>(Arrays.asList("https://124.ibapps.dk/124", "https://124test.ibapps.dk/124test", "https://124dev.ibapps.dk/124dev")));
        customerList.add(cus18);
        Customer cus19 = new Customer("Volkswagen", new ArrayList<String>(Arrays.asList("https://125.ibapps.dk/125", "https://125test.ibapps.dk/125test", "https://125dev.ibapps.dk/125dev")));
        customerList.add(cus19);
        Customer cus20 = new Customer("MRDP", new ArrayList<String>(Arrays.asList("https://126.ibapps.dk/126", "https://126test.ibapps.dk/126test", "https://126mrdp.ibapps.dk/126mrdp", "https://126dev.ibapps.dk/126dev")));
        customerList.add(cus20);
        Customer cus21 = new Customer("MRDP US", new ArrayList<String>(Arrays.asList("https://127.ibapps.dk/127", "https://127test.ibapps.dk/127test", "https://127dev.ibapps.dk/127dev ")));
        customerList.add(cus21);
        Customer cus22 = new Customer("KDH(NEM)", new ArrayList<String>(Arrays.asList("https://128.ibapps.dk/128", "https://128test.ibapps.dk/128test")));
        customerList.add(cus22);
        Customer cus23 = new Customer("RiskPoint", new ArrayList<String>(Arrays.asList("https://130.ibapps.dk/130", "https://130test.ibapps.dk/130test", "https://130dev.ibapps.dk/130dev")));
        customerList.add(cus23);
        Customer cus24 = new Customer("IBA Internal", new ArrayList<String>(Arrays.asList("https://787demo.ibapps.dk/787demo", "https://788demo.ibapps.dk/788demo", "https://coredev1.ibapps.dk/coredev1", "https://coredev2.ibapps.dk/coredev2", "https://coredev3.ibapps.dk/coredev3", "https://coretest.ibapps.dk/coretest")));
        customerList.add(cus24);
        
        
    }

    
    
}
