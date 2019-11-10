package tools;

import java.math.BigDecimal;

/**  
 * ����Java�ļ����Ͳ��ܹ���ȷ�ĶԸ������������㣬����������ṩ��  
 * ȷ�ĸ��������㣬�����Ӽ��˳�����������.
 * 
 */  

public class Arith
{
	private static final int DEF_DIV_SCALE = 2; //Ĭ�ϳ������㾫��
	private Arith(){} 
	
	/**  
	* �ṩ��ȷ�ļӷ����㡣  
	* v1 ������  
	* v2 ����  
	* ���������ĺ�  
	*/  
	public static double add(double v1,double v2)
	{   
		BigDecimal b1 = new BigDecimal(Double.toString(v1));   
		BigDecimal b2 = new BigDecimal(Double.toString(v2));   
		return b1.add(b2).doubleValue();   
	} 
	
	/**  
	* �ṩ��ȷ�ļ������㡣  
	* v1 ������  
	* v2 ����  
	* ���������Ĳ�  
	*/  
	public static double sub(double v1,double v2)
	{   
		BigDecimal b1 = new BigDecimal(Double.toString(v1));   
		BigDecimal b2 = new BigDecimal(Double.toString(v2));   
		return b1.subtract(b2).doubleValue();   
	}   
	
	/**  
	* �ṩ��ȷ�ĳ˷����㡣  
	* v1 ������  
	* v2 ����  
	* ���������Ļ�  
	*/  
	public static double mul(double v1,double v2)
	{   
		BigDecimal b1 = new BigDecimal(Double.toString(v1));   
		BigDecimal b2 = new BigDecimal(Double.toString(v2));   
		return b1.multiply(b2).doubleValue();   
	}   
	
	/**  
	* �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ��  С�����Ժ�2λ���Ժ�������������롣  
	* v1 ������  
	* v2 ����  
	* ������������  
	*/  
	public static double div(double v1,double v2)
	{   
		return div(v1,v2,DEF_DIV_SCALE);   
	}   
	
	/**  
	* �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ  �����ȣ��Ժ�������������롣  
	* v1 ������  
	* v2 ����  
	* scale ��ʾ��Ҫ��ȷ��С�����Ժ�λ��  
	* ������������  
	*/  
	public static double div(double v1,double v2,int scale)
	{   
		if(scale<0)
		{   
			throw new IllegalArgumentException(   
			"The scale must be a positive integer or zero");   
		}   
		BigDecimal b1 = new BigDecimal(Double.toString(v1));   
		BigDecimal b2 = new BigDecimal(Double.toString(v2));   
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue(); //BigDecimal.ROUND_HALF_UP ����ӽ��ġ��������룬����������������ֵľ�����ȣ���Ϊ�������������ģʽ�� 
	}   
	
	/**  
	* �ṩ��ȷ��С��λ�������봦��  
	* v ��Ҫ�������������  
	* scale С���������λ  
	* ���������Ľ��  
	*/  
	public static double round(double v,int scale)
	{   
		if(scale<0)
		{   
			throw new IllegalArgumentException("The scale must be a positive integer or zero");   
		}   
		BigDecimal b = new BigDecimal(Double.toString(v));   
		BigDecimal one = new BigDecimal("1");   
		return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();   
	}   
}
