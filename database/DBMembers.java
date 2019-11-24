package database;
import java.sql.*;

public class DBMembers {

	//load password
	public static String members_load(String id) {
		
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String password = "";
        
        try {
        	conn = DBconnect.connect();
        	 stmt = conn.createStatement();
        	 
        	String sql = "SELECT password From members WHERE id = "+"'"+id+"'";
        	rs = stmt.executeQuery(sql);
        	
        	while(rs.next()) {
        	password = rs.getString(1);
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( stmt != null && stmt.isClosed()){
                    stmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
        return password;
	}
	
	
//register
	public static void members_insert(String id, String password, String name, String phone) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnect.connect();
			
			String sql = "INSERT INTO members VALUES (?,?,?,?)";
			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
//			System.out.println("Success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
		
	}
	
	//ID exist check
	public static int IDcheck(String id) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        int success = -1; // 1:중복 0:중복x
        
        try {
        	conn = DBconnect.connect();
        	 stmt = conn.createStatement();
        	 
        	String sql = "select EXISTS (select * from members where id='"+id+"') as success";
        	rs = stmt.executeQuery(sql);
        	
        	while(rs.next()) {
        	success = Integer.parseInt(rs.getString(1));
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( stmt != null && stmt.isClosed()){
                    stmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
    return success;
	}
}