/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iba.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danand
 */
public class Customer implements Serializable{
    
    private String cName;
    
    private ArrayList<String> envList;
    
    private ArrayList<Environment> prodEnv;
    private ArrayList<Environment> testEnv;
    private ArrayList<Environment> devEnv;
    private ArrayList<Environment> perfEnv;
    private ArrayList<Environment> migEnv;
    private ArrayList<Environment> prepEnv;
    private ArrayList<Environment> otherEnv;
    
    public Customer(String cName, ArrayList<String> envList) {
        this.cName = cName;
        this.envList = envList;
        prodEnv = new ArrayList();
        testEnv = new ArrayList();
        devEnv = new ArrayList();
        perfEnv = new ArrayList();
        migEnv = new ArrayList();
        prepEnv = new ArrayList();
        otherEnv = new ArrayList();
    }
    
    public void addProdEnv(Environment prodEnv) {
        this.prodEnv.add(prodEnv);
    }
    
    public void addTestEnv(Environment testEnv) {
        this.testEnv.add(testEnv);
    }
    
    public void addDevEnv(Environment devEnv) {
        this.devEnv.add(devEnv);
    }
    
    public void addPerfEnv(Environment perfEnv) {
        this.perfEnv.add(perfEnv);
    }
    
    public void addMigEnv(Environment migEnv) {
        this.migEnv.add(migEnv);
    }
    
    public void addPrepEnv(Environment prepEnv) {
        this.prepEnv.add(prepEnv);
    }
    
    public void addOtherEnv(Environment otherEnv) {
        this.otherEnv.add(otherEnv);
    }
    
    public ArrayList<String> getEnvList() {
        return this.envList;
    }

    public String getcName() {
        return cName;
    }

    public ArrayList<Environment> getProdEnv() {
        return prodEnv;
    }

    public ArrayList<Environment> getTestEnv() {
        return testEnv;
    }

    public ArrayList<Environment> getDevEnv() {
        return devEnv;
    }

    public ArrayList<Environment> getPerfEnv() {
        return perfEnv;
    }

    public ArrayList<Environment> getMigEnv() {
        return migEnv;
    }
    
    public ArrayList<Environment> getPrepEnv() {
        return prepEnv;
    }

    public ArrayList<Environment> getOtherEnv() {
        return otherEnv;
    }
    
    @Override
    public String toString() {
        return "cName = " + this.cName + " | Size of envList: " + envList.size() + " | Size of prodEnv: " + prodEnv.size() + " | Size of testEnv: " + testEnv.size() + " | Size of devEnv: " + devEnv.size() + " | Size of perfEnv: " + perfEnv.size() + " | Size of migEnv: " + migEnv.size() + " | Size of otherEnv: " + otherEnv.size();
    }
    
}
