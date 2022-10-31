package pack1;


import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class InstaInfoProviderService {
	
	public static String getFollowerCount() {
		
		
		OkHttpClient client = new OkHttpClient();
		
		HttpUrl.Builder urlBuilder = HttpUrl.parse("https://instagram28.p.rapidapi.com/search_followers?user_id=25025320&query=fake").newBuilder();
		urlBuilder.addQueryParameter("user_id", "25025320");
		String url = urlBuilder.build().toString();

		Request request = new Request.Builder()
			.url(url)
			.get()
			.addHeader("X-RapidAPI-Key", "1317f39672mshceaec21bed1684cp170e34jsnd4f6d6902a8f")
			.addHeader("X-RapidAPI-Host", "instagram28.p.rapidapi.com")
			.build();
		okhttp3.Response response = null;

		try {
			 response = client.newCall(request).execute();
			ResponseBody respbody = response.body();
			 return respbody.contentType().toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = "NO Result";
		try {
			result= response != null ? response.body().string(): "Response Empty";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try{
            Gson gson = new GsonBuilder().create();
            Map<String,String> responseMap = gson.fromJson(result,new TypeToken<Map<String,String>>(){}.getType());            
             result = responseMap.toString();
		}
        catch(JsonSyntaxException ex)
        {
            throw new RuntimeException(result + " :" + ex);
        }
		return result;
	}

}
