package murach.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	
	private String value;
	
	public HttpUtil (String value) {
		this.value = value;
	}
	
	// Hàm lấy dữ liệu bỏ vào các class Model
	public <T> T toModel (Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/* Hàm đổi từ json -> String */
	public static HttpUtil of (BufferedReader reader) {
		
		StringBuilder sb = new StringBuilder();
		
		try {
			
			String line;
		    while ((line = reader.readLine()) != null) {
		        
		    	sb.append(line);
		        
		    }
			
		} catch (IOException e) {

		}
		
		return new HttpUtil(sb.toString());
	}
}
