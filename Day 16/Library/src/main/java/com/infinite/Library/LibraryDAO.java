package com.infinite.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
	public int issueOrNotBook(String userName, int bookId) throws ClassNotFoundException, SQLException{
		Connection connection = ConnectionHelper.getConnection();
		String sql = "select count(*)cnt from TranBook where UserName=?  and bookId=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, userName);
		pst.setInt(2, bookId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
		
	}
	public List<TransReturn> history(String user, int bookId) throws ClassNotFoundException, SQLException{
		Connection connecton = ConnectionHelper.getConnection();
		String sql = "select * from TransReturn where UserName=?";
		PreparedStatement pst = connecton.prepareStatement(sql);
		pst.setString(1, user);
		
		ResultSet rs=pst.executeQuery();
		TransReturn tranReturn = null;
		List<TransReturn> tranReturnList= new ArrayList<TransReturn>();
		while(rs.next()){
		tranReturn = new TransReturn();
		tranReturn.setBookId(rs.getInt("bookId"));
		tranReturn.setUserName(user);
		tranReturn.setFromdate(rs.getDate("FromDate"));
		tranReturnList.add(tranReturn);
		
	}
		return tranReturnList;
	
		
	
		
	}
	public TranBook serachTranBook(String user, int bookId) throws ClassNotFoundException, SQLException{
		Connection connecton = ConnectionHelper.getConnection();
		String sql = "select * from TranBook where userName=? and BookId=?";
		PreparedStatement pst = connecton.prepareStatement(sql);
		pst.setString(1, user);
		pst.setInt(2, bookId);
		ResultSet rs=pst.executeQuery();
		TranBook tranBook = null;
		if(rs.next()){
		tranBook = new TranBook();
		tranBook.setBookId(rs.getInt("bookId"));
		tranBook.setUserName(user);
		tranBook.setFromDate(rs.getDate("FromDate"));
	}
	return tranBook;
		
		
		
	}
	public String returnBooks(String user, int bookId) throws ClassNotFoundException, SQLException{
		Connection connection = ConnectionHelper.getConnection();
		TranBook tranbook = serachTranBook(user,bookId);
		String sql = "Insert into TransReturn(userName,BookId,FromDate) values(?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		 pst.setString(1, user);
		 pst.setInt(2, bookId);
		 pst.setDate(3, tranbook.getFromDate());
		 pst.executeUpdate();
		 sql="Update Books set TotalBooks=TotalBooks+1 where id=?";
		 pst = connection.prepareStatement(sql);
		 pst.setInt(1, bookId);
		 pst.executeUpdate();
		 sql="Delete from TranBook where UserName=? And BookId=?";
		 pst = connection.prepareStatement(sql);
		 pst.setString(1,user);
		 pst.setInt(2, bookId);
		 pst.executeUpdate();
		 return "Your Book"   +bookId  +   "Returned  Successfully";
	}
	public List<TranBook> issueBooks(String user) throws ClassNotFoundException, SQLException{
		Connection connection = ConnectionHelper.getConnection();
		String sql = "select * from TranBook where userName=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user);
		ResultSet rs = pst.executeQuery();
		TranBook tranBook = null;
		List<TranBook> tranBookList = new ArrayList<TranBook>();
		while(rs.next()){
			tranBook = new TranBook();
			tranBook.setBookId(rs.getInt("BookId"));
			tranBook.setUserName(user);
			tranBook.setFromDate(rs.getDate("FromDate"));
			tranBookList.add(tranBook);
		}
		return tranBookList;
		
		
		
	}
	
	
	    public String IssueBook(String userName, int bookId) throws ClassNotFoundException, SQLException{
	    	int count = issueOrNotBook(userName,bookId);
	    	if(count==0){
	    Connection connection = ConnectionHelper.getConnection();
	    String sql = "Insert into TranBook(UserName,BookId) values(?,?)";
	PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setString(1, userName);
	    pst.setInt(2, bookId);
	    pst.executeUpdate();
	    sql="update Books set TotalBooks=TotalBooks-1 where id=?";
	    pst = connection.prepareStatement(sql);
	    pst.setInt(1, bookId);
	    pst.executeUpdate();
	return "Book with Id" +bookId + "Issued successfully...";
	    	}else{
	    		return "Book Id" +bookId+   "  for user "+userName + "Already issued";
	    	}
	    }

	public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		String sql;
		boolean isValid=true;
		if(searchType.equals("id")) {
			sql = " SELECT * FROM Books WHERE Id = ? " ;
		} else if(searchType.equals("bookname")) {
			sql = " SELECT * FROM Books WHERE Name = ? " ;
		} else if(searchType.equals("authorname")) {
			sql = " SELECT * FROM Books WHERE Author = ? " ;
		} else if(searchType.equals("dept")) {
			sql = " SELECT * FROM Books WHERE Dept = ? " ;
		}
		else {
			isValid=false;
			sql = " SELECT * FROM Books" ;
		}
		Connection connection = ConnectionHelper.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		if (isValid==true) {
			pst.setString(1, searchValue);
		} 
		ResultSet rs = pst.executeQuery();
		Books books = null;
		List<Books> booksList = new ArrayList<Books>();
		while(rs.next()) {
			books = new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setNoOfBooks(rs.getInt("TotalBooks"));
			booksList.add(books);
		}
		return booksList;
	}
	public int authenticate(String user, String password) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionHelper.getConnection();
		String cmd="select count(*) cnt from libusers where UserName=?  and Password = ?";
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setString(1,user);
		pst.setString(2,password);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}
}