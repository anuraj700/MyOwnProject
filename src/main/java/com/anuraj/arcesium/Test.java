package com.anuraj.arcesium;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;



class BaseData{
    private String date;
    private String security;
    public void setDate(String date){
        this.date = date;
    }
    public void setSecurity(String security){
        this.security= security;
    }
    public String getDate(){
        return this.date;
    }
    public String getSecurity(){
        return this.security;
    }
}
class HoldingData extends BaseData{
    
    private String portfolio;
    private double quantity;

    public void setPortfolio(String p){
        this.portfolio =p;
    }
    public void setQuantity(double q){
        this.quantity = q;
    }
    public String getPortfolio(){
        return this.portfolio;
    }
    public double getQuantity(){
        return this.quantity;
    }
}

class PricingData extends BaseData{
    
    private double price;

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double d){
        this.price =d;
    }
}
class BaseResponse{
    private int totalRecords;
    private int page;
    private String nextPage;
    private int recordsPerPage;
    public void setTotalRecords(int totalRecords){
        this.totalRecords = totalRecords;
    }
    public int getTotalRecords(){
        return this.totalRecords;
    }
    public void setPage(int page){
        this.page = page;
    }
    public int getPage(){
        return this.page;
    }
    public void setNextPage(String nextPage){
        this.nextPage = nextPage;
    }
    public String getNextPage(){
        return this.nextPage;
    }
    public void setRecordsPerPage(int rcp){
        this.recordsPerPage = rcp;
    }
    public int getRecordsPerPage(){
        return this.recordsPerPage;
    }
}
class HoldingResponse extends BaseResponse{
    private List<HoldingData> data;

    public List<HoldingData> getData(){
        return this.data;
    }

    public void setHoldingData(List<HoldingData> data){
        this.data = data;
    }
}

class PricingResponse extends BaseResponse{
    List<PricingData> data;

    public List<PricingData> getData(){
        return this.data;
    }

    public void setData(List<PricingData> d){
        this.data=d;
    }
}
class Result {

    /*
     * Complete the 'calculateHoldingValue' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING date (in yyyymmdd format) as parameter.
     */
	
	private static String HOLDURL ="https://api.myjson.com/bins/1eleys";
	private static String HOLDURLPAGE ="https://api.myjson.com/bins/10ysxg";
	private static String PRICEURL ="https://api.myjson.com/bins/vf9ac";
	private static String PRICEURLPAGE ="https://api.myjson.com/bins/6ycbo";
	

    public static double calculateHoldingValue(String date) {

        HoldingResponse holdingResponse =(HoldingResponse) getHttpResponse(HOLDURL, HoldingResponse.class);
        PricingResponse pricingResponse = (PricingResponse) getHttpResponse(PRICEURL, PricingResponse.class);
        //System.out.println("first "+holdingResponse.getTotalRecords());
        //System.out.println("second "+pricingResponse.getTotalRecords());
    	//HoldingResponse holdingResponse = new HoldingResponse();
    	//PricingResponse pricingResponse = new PricingResponse();
        Double result = new Double(0d);
        try{
/*
        
        URL url = new URL("https://api.myjson.com/bins/1eleys");
        HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("ACCEPT", "application/json");

        if(httpConn.getResponseCode() !=200){
            throw new RuntimeException("Failed"+httpConn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        Gson gson = new Gson();
        holdingResponse = gson.fromJson(br,HoldingResonse.class);
        httpConn.disconnect();
        URL url2 = new URL("https://api.myjson.com/bins/vf9ac");
        HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
        conn2.setRequestMethod("GET");
        conn2.setRequestProperty("Accept", "application/json");
        if(conn2.getResponseCode() != 200){
            throw new RuntimeException("failed"+conn2.getResponseCode());
        }
        BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
        Gson gson2 = new Gson();
        pricingResponse = gson.fromJson(br2,PricingResponse.class);
        conn2.disconnect();
      */
        if(holdingResponse != null && pricingResponse != null) {
        	result = computeValue(date, holdingResponse, pricingResponse, result);
        }
       /* Map<String,Double> holdingDay = getHoldingForDay(date, holdingResponse.getData());
        Map<String,Double> pricingDay = getPricingForDay(date, pricingResponse.getData());

        for(Map.Entry<String,Double> entry: holdingDay.entrySet()){
            result= result + entry.getValue() * pricingDay.get(entry.getKey());
        }
		*/
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.doubleValue();
    }
    
 public static Double computeValue(String date, HoldingResponse holdingResponse,PricingResponse pricingResponse,Double result) {
	 Map<String,Double> holdingDay = getHoldingForDay(date, holdingResponse.getData());
     Map<String,Double> pricingDay = getPricingForDay(date, pricingResponse.getData());

     for(Map.Entry<String,Double> entry: holdingDay.entrySet()){
         result= result + entry.getValue() * pricingDay.get(entry.getKey());
     }
     return result;
 }

public static Object getHttpResponse(String url1,Class<? extends BaseResponse> obj){
	try {
		URL url = new URL(url1);
        HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("ACCEPT", "application/json");

        if(httpConn.getResponseCode() !=200){
            throw new RuntimeException("Failed"+httpConn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        Gson gson = new Gson();
        return gson.fromJson(br,obj);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}


public static Map<String,Double> getHoldingForDay(String date, List<HoldingData> data){
    Map<String,Double> result = new HashMap<>();
    for(HoldingData obj : data){
        if(obj.getDate().equals(date)){
            result.put(obj.getSecurity(),obj.getQuantity());
        }
    }
    return result;
}

public static Map<String,Double> getPricingForDay(String date, List<PricingData> data){
    Map<String,Double> result = new HashMap<>();
    for(PricingData obj : data){
        if(obj.getDate().equals(date)){
            result.put(obj.getSecurity(), obj.getPrice());
        }
    }
    return result;
}

}

public class Test {
	 public static void main(String[] args) throws IOException {
//	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//	        String date = bufferedReader.readLine();
		// for date:20190506 result is:17178.0
		// for date: 20190509 result is:30102.2984

		 	String date = "20190506";
	        double result = Result.calculateHoldingValue(date);
	        System.out.println("for date:" +date +" result is:"+result);
	        date = "20190509";
	        result = Result.calculateHoldingValue(date);
	        System.out.println("for date: " +date +" result is:"+result);
	        //Result.getHttpResponse(null,null);
//	        bufferedWriter.write(String.valueOf(result));
//	        bufferedWriter.newLine();
//
//	        bufferedReader.close();
//	        bufferedWriter.close();
	    }
}