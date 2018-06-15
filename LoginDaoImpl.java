package com.impls.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.common.ConnectionUtils;
import com.dao.dao.LoginDao;
import com.jdbc.jdbc.User;

public class LoginDaoImpl implements LoginDao{
    Connection con=null;
    PreparedStatement pstm=null;
    ResultSet rs=null;

    public int login(User user) {
        //连接数据库
        con=ConnectionUtils.getConnection();
        int flag=0;
        try {
            //发送sql文
            String sql="select t_name,t_pass from t_user where t_name=?";
            pstm=con.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            rs=pstm.executeQuery();
            //处理结果集
            while(rs.next()){
                String temp=rs.getString("t_pass");
                if(temp.equals(user.getPassword())){
                    flag=2; //用户名和密码都正确
                }else{
                    flag=1;//密码错误
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //资源释放（逆序释放）
            ConnectionUtils.close(rs, pstm, con);   
        }   
        return flag;
    }
}
