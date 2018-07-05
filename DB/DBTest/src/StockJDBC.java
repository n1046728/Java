import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.zkoss.zul.ListModelList;


public class StockJDBC {
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://192.168.0.101:1433;databaseName=TESTDB";
	private String userid = "aa";
	private String passwd = "123456";
	
	public ListModelList<StockBean> readAll(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection con = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement("SELECT * FROM StkBasic ; ");
			rs = pstmt.executeQuery();
			ListModelList<StockBean> list = new ListModelList<>();
			while(rs.next()){
				StockBean stock = new StockBean();
				stock.setStkCode(rs.getString("STK_CODE"));
				stock.setStkName(rs.getString("STK_NAME"));
				stock.setType(rs.getString("TYPE"));
				stock.setExchange(rs.getString("EXCHANGE"));
				
				list.add(stock);
			}
			return list;
			
		}catch(ClassNotFoundException e){
			throw new RuntimeException("Driver not found ： "+ e.getMessage());
		}catch(SQLException ee){
			throw new RuntimeException("sql exception ： "+ee.getMessage());
		}finally{
			if(con !=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
			if(pstmt !=null){
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
			if(rs !=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
		}
	}
	public int insert(StockBean stkObj){
		int rowCount=0;
		Connection con=null;
		PreparedStatement pstmt =null;
		try{
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement("INSERT INTO StkBasic "
										+ "VALUES(?,?,?,?) ");
			pstmt.setString(1, stkObj.getStkCode());
			pstmt.setString(2, stkObj.getStkName());
			pstmt.setString(3, stkObj.getType());
			pstmt.setString(4, stkObj.getExchange());
			
			rowCount = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con !=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
			if(pstmt !=null){
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
		}
		//System.out.println("異動筆數 ： " +rowCount);
		return rowCount;
	}
	public StockBean queryByStkCode(String stockCode){
		StockBean stock = new StockBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement("SELECT * FROM StkBasic WHERE STK_CODE = ? ; ");
			pstmt.setString(1, stockCode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				stock.setStkCode(rs.getNString("STK_CODE"));
				stock.setStkName(rs.getString("STK_NAME"));
				stock.setType(rs.getString("TYPE"));
				stock.setExchange(rs.getString("EXCHANGE"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con !=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
			if(pstmt !=null){
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
			if(rs !=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
		}
		
		return stock;
	}
	public int update(StockBean stock){
		int rowCount=0;
		Connection con =null;
		PreparedStatement pstmt = null;
		try{
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement("UPDATE StkBasic SET STK_NAME = ? , TYPE= ? , EXCHANGE = ? WHERE STK_CODE = ? ; ");
			pstmt.setString(1, stock.getStkName());
			pstmt.setString(2, stock.getType());
			pstmt.setString(3, stock.getExchange());
			pstmt.setString(4, stock.getStkCode());
			
			rowCount = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		return rowCount;
	}
	public int delete(StockBean stock){
		int rowCount = 0;
		Connection con=null;
		PreparedStatement pstmt = null;
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement("DELETE StkBasic WHERE STK_CODE = ? ; ");
			pstmt.setString(1, stock.getStkCode());
			rowCount =  pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return rowCount;
	}
}
