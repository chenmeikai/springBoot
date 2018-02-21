/**   
 * Copyright © 2018 www.chenmeikai.com
 * @Package: GenCommentGenerator.java 
 * @author: Administrator   
 * @date: 2018年2月20日 下午11:17:57 
 */
package com.example.config.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**   
 * @ClassName:  GenCommentGenerator   
 * @Description:注释  
 * @author: cmk 
 * @date:   2018年2月20日 下午11:17:57    
 * @Copyright: 2018 www.chenmeikai.com 
 */
public class GenCommentGenerator extends DefaultCommentGenerator  {
	
	/**
	 * 给字段添加数据库备注
	 * @param field
	 * @param introspectedTable
	 * @param introspectedColumn
	 */
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
			field.addJavaDocLine("//" + introspectedColumn.getRemarks());
		}
	}
	
	/**
	 * getter方法注释
	 * @param method
	 * @param introspectedTable
	 * @param introspectedColumn
	 */
	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		StringBuilder sb = new StringBuilder();
		method.addJavaDocLine("/**");
		if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
			sb.append(" * 获取");
			sb.append(introspectedColumn.getRemarks());
			method.addJavaDocLine(sb.toString());
			method.addJavaDocLine(" *");
		}
		sb.setLength(0);
		sb.append(" * @return ");
		sb.append(introspectedColumn.getActualColumnName());
		if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
			sb.append(" - ");
			sb.append(introspectedColumn.getRemarks());
		}
		method.addJavaDocLine(sb.toString());
		method.addJavaDocLine(" */");
	}
	
	/**
	 * setter方法注释
	 * @param method
	 * @param introspectedTable
	 * @param introspectedColumn
	 */
	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		StringBuilder sb = new StringBuilder();
		method.addJavaDocLine("/**");
		if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
			sb.append(" * 设置");
			sb.append(introspectedColumn.getRemarks());
			method.addJavaDocLine(sb.toString());
			method.addJavaDocLine(" *");
		}
		Parameter parm = method.getParameters().get(0);
		sb.setLength(0);
		sb.append(" * @param ");
		sb.append(parm.getName());
		if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
			sb.append(" ");
			sb.append(introspectedColumn.getRemarks());
		}
		method.addJavaDocLine(sb.toString());
		method.addJavaDocLine(" */");

   }
	
}
