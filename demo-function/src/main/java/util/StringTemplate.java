package util;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串模版替换方法
 * 可用户定义模版 然后使用map映射进行替换
 */
public class StringTemplate {
    public static void main(String[] args) {
//        simpleMethod1();
        simpleMethod2();
    }

    public static void simpleMethod1(){
        String phoneNo = "13812341234";
        String smsTemplate = "亲爱的用户：#{[username]} \n您的验证码:#{[code]}，#{[gender]}正在登录管理后台，5分钟内输入有效。";
        Map<String, Object> params = new HashMap<>();
        params.put("code", 1234);;
        params.put("username", "xxx");;
        ExpressionParser parser = new SpelExpressionParser();
        TemplateParserContext parserContext = new TemplateParserContext();
        String content = parser.parseExpression(smsTemplate,parserContext).getValue(params, String.class);

        System.out.println(content);
    }

    public static void simpleMethod2(){
        Map valuesMap = new HashMap();
        valuesMap.put("code", 1234);
        valuesMap.put("username", "小明");
//        String templateString = "验证码:${code:-0000},您正在登录管理后台，5分钟内输入有效。";
        String templateString = "亲爱的用户：${username:-xxx} \n您的验证码:${code:-0000}，${gender:-}正在登录管理后台，5分钟内输入有效。";
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        String content= sub.replace(templateString);
        System.out.println(content);
    }

}
