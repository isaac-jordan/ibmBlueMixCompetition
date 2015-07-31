package com.ibm.cloudoe.samples;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/ex1")
public class Ex1 {
	
	//static HashMap<Integer, Integer> factorials = new HashMap<>();

	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String getInformation(@FormParam("text") String text) {
		long startTime = System.currentTimeMillis();
		String lines[] = text.split("\\n");
		System.out.println(Arrays.toString(lines));
		StringBuilder r = new StringBuilder();
		for(int i=0; i<lines.length-1; i++) {
			r.append("<p>" + factorial(Integer.parseInt(lines[i])) + "</p>");
		}
		long endTime = System.currentTimeMillis();
	    r.append("<h4>Total execution time: " + (endTime-startTime) + "ms</h4>"); 
		return r.toString();
	}
	
	private BigInteger factorial(int n) {
		BigInteger result = BigInteger.ONE;
		while (n > 1) {
			result = result.multiply(new BigInteger(Integer.toString(n)));
			n--;
		}
		return result;
	}
}