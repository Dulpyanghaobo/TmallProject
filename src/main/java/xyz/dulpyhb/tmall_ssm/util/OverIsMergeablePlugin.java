
package xyz.dulpyhb.tmall_ssm.util;

import java.lang.reflect.Field;
/*
 * 逆向工程
 * 防止多次生成mapper文件
 * */
import java.util.List;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

public class OverIsMergeablePlugin extends PluginAdapter{

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
		try {
			Field field = sqlMap.getClass().getDeclaredField("isMergeable");
			field.setAccessible(true);
			field.setBoolean(sqlMap, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
