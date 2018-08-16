/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iba.data;

import java.io.Serializable;

/**
 *
 * @author danand
 */
public class Environment implements Serializable{
    
    private String envName;
    private String version;
    private String envURL;
    Environment.type type;
    
    public Environment() {
        
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public void setEnvURL(String envURL) {
        this.envURL = envURL;
    }

    public String getVersion() {
        return version;
    }

    public String getEnvName() {
        return envName;
    }

    public String getEnvURL() {
        return envURL;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getURL() {
        return envURL;
    }
    
    public void setURL(String envURL) {
        this.envURL = envURL;
    }
    
    public Environment.type getType() {
        return type;
    }
    
    public void setType(Environment.type type) {
        this.type = type;
    }
    
    public enum type{DEV, TEST, PROD, OTHER}
    

    
    
}
