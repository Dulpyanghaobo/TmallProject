package xyz.dulpyhb.tmall_ssm.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MybatisGenerator {
public static void main(String[] args) {
	String today = "2018-3-30";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	try {
		Date now = simpleDateFormat.parse(today);
		Date d = new Date();
		if(d.getTime()>now.getTime()+1000*60*60*24) {
			   System.err.println("——————未成成功运行——————");
	            System.err.println("——————未成成功运行——————");
	            System.err.println("本程序具有破坏作用，应该只运行一次，如果必须要再运行，需要修改today变量为今天，如:" + simpleDateFormat.format(new Date()));
			return;
		}
		if(false) return;
		List<String> warnings =new ArrayList<String>();
			boolean overwise = true;	
			InputStream inputStream = MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").openStream();
			ConfigurationParser configurationParser = new ConfigurationParser(warnings); 
			Configuration config =configurationParser.parseConfiguration(inputStream);
			inputStream.close();
			DefaultShellCallback defaultShellCallback = new DefaultShellCallback(overwise);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, defaultShellCallback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("生成代码只执行一次，覆盖上述代码mapper、pojo、xml");
	}catch (IOException e) {
			e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
