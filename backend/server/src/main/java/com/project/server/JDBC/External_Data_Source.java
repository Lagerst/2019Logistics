package com.project.server.JDBC;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.aliyun.api.gateway.demo.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.project.server.searchOrder.infoEntity;
import com.project.server.searchOrder.infoRequest;
import com.project.server.searchOrder.orderListEntity;
import com.project.server.searchOrder.storageListEntity;

public class External_Data_Source {
    public static String stringToMD5(String plainText) {
    	//System.out.print(plainText+"\n");
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
    	//System.out.print(md5code+"\n");
        return md5code;
    }
    
	public static List<infoEntity> GetSource(String jsonstring){
		List<infoEntity> arrayList = new ArrayList<infoEntity>();
		  Gson gson = new Gson();
		  List<JsonElement> list=new ArrayList();
		  JsonParser jsonParser=new JsonParser();
		  JsonArray arrays = (JsonArray) ((JsonArray) jsonParser.parse(jsonstring).getAsJsonObject().get("data")).get(0).getAsJsonObject().get("data");
          for(int i=0; i<arrays.size(); i++){
              JsonElement jsonElementd = arrays.get(i);
              JsonObject jsondetail = jsonElementd.getAsJsonObject();
	  		  infoEntity temp = new infoEntity();
	  		  temp.setTimestamp(jsondetail.get("time").getAsString());
	  		  System.out.print(jsondetail.get("time").getAsString()+"\n");
	  		  temp.setContent(jsondetail.get("context").getAsString());
	  		  System.out.print(jsondetail.get("context").getAsString()+"\n");
	  		  arrayList.add(temp);
          }
		return arrayList;
	}
	public static List<infoEntity> Get(String number) {
		List<infoEntity> t=new ArrayList<infoEntity>();
		String host = "https://kop.kuaidihelp.com";
		String path = "/api";
		String method = "POST";
		Map<String, String> headers = new HashMap<String, String>();
		//根据API的要求，定义相对应的Content-Type
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		Map<String, String> querys = new HashMap<String, String>();
		Map<String, String> bodys = new HashMap<String, String>();
		String timestamp=String.valueOf(System.currentTimeMillis());
		String app_id="101307";
		String method_service="express.info.get";
		String token="e0079191a4d78b88a5aade1863c631446d3fa222";
		bodys.put("app_id", app_id);
		bodys.put("method", method_service);
		bodys.put("ts",  timestamp);
		bodys.put("sign", stringToMD5(app_id+method_service+timestamp+token));
		bodys.put("data","{ \"waybill_no\":\""+number+"\",\"exp_company_code\":\"zt\",\"result_sort\":\"0\"}");
		
		try {
			/**
			* 重要提示如下:
			* HttpUtils请从
			* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			* 下载
			*
			* 相应的依赖请参照
			* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			*/
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			t=GetSource(EntityUtils.toString(response.getEntity()));
			System.out.println(response.toString());
			//获取response的body
			System.out.println(EntityUtils.toString(response.getEntity()));
			} catch (Exception e) {
				//e.printStackTrace();
			}
		return t;
		}
	public static void main(String args[]) {
		//Get("75322073459674");
		String temp="{\"code\":0,\"msg\":\"查询成功\",\"data\":[{\"no\":\"75322073459674\",\"brand\":\"zt\",\"status\":\"signed\",\"data\":[{\"time\":\"2019-12-24 13:22:56\",\"context\":\"【成都市】  快件已在 【市区五部建设路】 签收, 签收人: 欣苑代收点, 如有疑问请电联:15928070989 \\/ 028-62612949, 您的快递已经妥投。风里来雨里去, 只为客官您满意。上有老下有小, 赏个好评好不好？【请在评价快递员处帮忙点亮五颗星星哦~】\",\"status\":\"signed\",\"shop_info\":{\"shop_name\":\"市区五部建设路\",\"shop_code\":\"28022\",\"shop_phone\":\"028-62612949、15928070989、15828694155\"}},{\"time\":\"2019-12-24 09:56:49\",\"context\":\"【成都市】  【市区五部建设路】 的欣苑（15928070989） 正在第1次派件, 请保持电话畅通,并耐心等待（95720为中通快递员外呼专属号码，请放心接听）\",\"status\":\"delivering\",\"shop_info\":{\"shop_name\":\"市区五部建设路\",\"shop_code\":\"28022\",\"shop_phone\":\"028-62612949、15928070989、15828694155\"}},{\"time\":\"2019-12-24 09:56:44\",\"context\":\"【成都市】  快件已经到达 【市区五部建设路】\",\"status\":\"sending\",\"shop_info\":{\"shop_name\":\"市区五部建设路\",\"shop_code\":\"28022\",\"shop_phone\":\"028-62612949、15928070989、15828694155\"}},{\"time\":\"2019-12-23 21:13:05\",\"context\":\"【成都市】  快件离开 【成都中转】 已发往 【市区五部建设路】\",\"status\":\"sending\",\"shop_info\":{\"shop_name\":\"成都中转\",\"shop_code\":\"02828\",\"shop_phone\":\"028-63201290\"}},{\"time\":\"2019-12-23 21:03:58\",\"context\":\"【成都市】  快件已经到达 【成都中转】\",\"status\":\"sending\",\"shop_info\":{\"shop_name\":\"成都中转\",\"shop_code\":\"02828\",\"shop_phone\":\"028-63201290\"}},{\"time\":\"2019-12-21 03:00:57\",\"context\":\"【哈尔滨市】  快件离开 【哈尔滨中转】 已发往 【成都中转】\",\"status\":\"sending\",\"shop_info\":{\"shop_name\":\"哈尔滨中转\",\"shop_code\":\"45100\",\"shop_phone\":\"0451-87844995、0451-81323145\"}},{\"time\":\"2019-12-20 16:48:19\",\"context\":\"【哈尔滨市】  快件已经到达 【哈尔滨中转】\",\"status\":\"sending\",\"shop_info\":{\"shop_name\":\"哈尔滨中转\",\"shop_code\":\"45100\",\"shop_phone\":\"0451-87844995、0451-81323145\"}},{\"time\":\"2019-12-20 16:34:13\",\"context\":\"【哈尔滨市】  【黑龙江市场部】（0451-58629670、0451-58629677、15004542749） 的 李先生（18646300298） 已揽收\",\"status\":\"collected\",\"shop_info\":{\"shop_name\":\"黑龙江市场部\",\"shop_code\":\"451001\",\"shop_phone\":\"0451-58629670、0451-58629677、15004542749\"}}],\"order\":\"desc\",\"res\":0}]}";
		System.out.print(GetSource(temp).size());
	}
}
