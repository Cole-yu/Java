package com.yfx.demo;

import java.sql.*;


public class Demo3 {
   
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        
        String URL="jdbc:mysql://127.0.0.1:3306/user_cmx?&serverTimezone=GMT&useSSL=false";  
        //useSSL=false���ϣ�����ᱨ���� javax.net.ssl.SSLException: closing indownloadbound before receiving peer's close_no ...
        // ����java.sql.SQLException: The server time zone value '???��������??��??'
        // ���������ԭ������Ϊ mysql���ص�ʱ�����������⣬��ʵ��ʱ��Ҫ��8Сʱ��
        // ��jdbc���ӵ�url�������serverTimezone=GMT���ɽ�����⣬�����Ҫʹ��gmt+8ʱ������Ҫд��GMT%2B8
        
        String USER="root";
        String PASSWORD="";

        //1.������������
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.������ݿ�����,����URLΪ   jdbc:mysql//��������ַ/���ݿ����������2�������ֱ��ǵ�½�û���������
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ飨ʹ��Statement�ࣩ
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from user");

        try {
            //4.�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
            while(rs.next()){
                System.out.println(rs.getString("name")+" / "+rs.getString("age"));
            }	            
    	}
    	catch (SQLException e){
    		 e.printStackTrace();
    	}
    	finally{
			System.out.println("��ѯ����,�ر���Դ");
    		//	�ر���Դ
            closeAll(rs, st, conn);	    		
    	}
    }
    
    /**
     * �ر����ݿ�����
     * 
     * @param rs
     * @param st
     * @param conn
     */
    private static void closeAll(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (conn == null) {
            return;
        }
        
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
}
