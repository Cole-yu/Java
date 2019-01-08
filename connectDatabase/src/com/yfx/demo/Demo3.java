package com.yfx.demo;

import java.sql.*;


public class Demo3 {
   
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        
        String URL="jdbc:mysql://127.0.0.1:3306/user_cmx?&serverTimezone=GMT&useSSL=false";  
        //useSSL=false加上，否则会报错误 javax.net.ssl.SSLException: closing indownloadbound before receiving peer's close_no ...
        // 报错java.sql.SQLException: The server time zone value '???ú±ê×??±??'
        // 出现这个的原因是因为 mysql返回的时间总是有问题，比实际时间要早8小时。
        // 在jdbc连接的url后面加上serverTimezone=GMT即可解决问题，如果需要使用gmt+8时区，需要写成GMT%2B8
        
        String USER="root";
        String PASSWORD="";

        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接,连接URL为   jdbc:mysql//服务器地址/数据库名，后面的2个参数分别是登陆用户名和密码
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from user");

        try {
            //4.处理数据库的返回结果(使用ResultSet类)
            while(rs.next()){
                System.out.println(rs.getString("name")+" / "+rs.getString("age"));
            }	            
    	}
    	catch (SQLException e){
    		 e.printStackTrace();
    	}
    	finally{
			System.out.println("查询结束,关闭资源");
    		//	关闭资源
            closeAll(rs, st, conn);	    		
    	}
    }
    
    /**
     * 关闭数据库连接
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
