package com.sathish.ds.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CertificateIndex {

    HashMap<String,Object> customerMap = new HashMap<>();


    public void processIndex(String customer_Id,String issuerFullName,String serialNumber) {
        HashMap<String, Object> customerHashMap = getOrInsertCustomerId(customer_Id);
        HashMap<String, Object> issuerFullNameHashMap = getOrInsertIssuerFullName(customerHashMap, issuerFullName);
        getOrInsertSerialNumber(issuerFullNameHashMap, serialNumber);

    }
    public HashMap getOrInsertCustomerId(String customer_Id){
        customerMap.putIfAbsent(customer_Id,new HashMap<String,Object>());
        return (HashMap) customerMap.get(customer_Id);
    }
    public HashMap getOrInsertIssuerFullName(HashMap customerHashMap, String issuerFullName){
        customerHashMap.putIfAbsent(issuerFullName,new HashMap<String,Object>());
        return (HashMap) customerHashMap.get(issuerFullName);
    }
    public ArrayList getOrInsertSerialNumber(HashMap issuerFullNameHashMap, String serialNumber){
        ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(1,2,3));
        issuerFullNameHashMap.putIfAbsent(serialNumber,arrayList);
        return (ArrayList) issuerFullNameHashMap.get(serialNumber);
    }

    public void checkIfDataIsPresent(String customer_Id,String issuerFullName,String serialNumber){
        if(customerMap.containsKey(customer_Id)){
            HashMap issuerHashMap = (HashMap) customerMap.get(customer_Id);
            if(issuerHashMap.containsKey(issuerFullName)){
                HashMap serialHashMap = (HashMap) issuerHashMap.get(issuerFullName);
                if(serialHashMap.containsKey(serialNumber)){
                    ArrayList list = (ArrayList) serialHashMap.get(serialNumber);
                    list.forEach(u-> System.out.println(u));
                    return;
                }
            }
        }
            System.out.println("false");
    }
    public static void main(String[] args) {
        CertificateIndex testClass = new CertificateIndex();
        testClass.processIndex("1","abc","101010");
        testClass.processIndex("1","abc","10232456987");
        testClass.processIndex("1","xyz","10232456987");
        testClass.processIndex("1","abc","101010");
        testClass.processIndex("2","abc","101010");
        testClass.checkIfDataIsPresent("1","abc","101010");
        testClass.checkIfDataIsPresent("1","asdsadbc","101010");
        System.out.println(testClass.customerMap);
    }

}
