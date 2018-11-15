package example.json;

import java.util.*;
import org.apache.log4j.Logger;
import com.dahantc.api.sms.json.JSONHttpClient;
import com.dahantc.api.sms.json.SmsData;

public class HttpJsonExample {
	private static final Logger LOG = Logger.getLogger(HttpJsonExample.class);
	private static String account = "dh*****";		// 用户名（必填）
	private static String password = "******";		// 密码（必填）
	private static String phone = "157****6112"; 	// 手机号码（必填,多条以英文逗号隔开,国际短信要+国别号）
	private static String content = "您好！你有一个快递,请注意查收。";		// 短信内容（必填）
	public static String sign = ""; 		// 短信签名（必填，格式如【大汉三通】）
	public static String subcode = "****"; 		// 子号码（选填）
	public static String msgid = UUID.randomUUID().toString().replace("-", ""); 	// 短信id，（可选，不传我们生成一个返回）
	public static String sendtime = "201701010101"; 	// 定时发送时间（可选）

	public static void main(String[] args) {
		try {
			JSONHttpClient jsonHttpClient = new JSONHttpClient("http://www.dh3t.com");
			jsonHttpClient.setRetryCount(1);
			String sendhRes = jsonHttpClient.sendSms(account, password, phone, content, sign, subcode);
			LOG.info("提交单条普通短信响应：" + sendhRes);

			List<SmsData> list = new ArrayList<SmsData>();
			list.add(new SmsData("15711616131", content, msgid, sign,subcode, sendtime));
			String sendBatchRes = jsonHttpClient.sendBatchSms(account,password, list);
			LOG.info("提交批量短信响应：" + sendBatchRes);
			
			String reportRes = jsonHttpClient.getReport(account, password);
			LOG.info("获取状态报告响应：" + reportRes);
			
			String smsRes = jsonHttpClient.getSms(account, password);
			LOG.info("获取上行短信响应：" + smsRes);
			 
			String balanceRe = jsonHttpClient.getBalance(account, password);
			LOG.info("获取余额响应：" + balanceRe);

		} catch (Exception e) {
			LOG.error("应用异常", e);
		}
	}
}
