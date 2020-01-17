import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestFileWrite {
	
	String fileName,fileType;
	Blob fileBlob;
	
	public static void main(String[] args) {
		
		new TestFileWrite().getData();
		
	}

	
	public Connection getConnection() {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swapkart", "root", "P@55word");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return connection;
	}
	
	
	public void getData() {
		
		try {
			
			Connection  connection = getConnection();
			String sql = "SELECT * FROM testlabs.cand_resume where cand_id  =150;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				fileName = resultSet.getString("resume_name");
				fileType = resultSet.getString("file_type");
				fileBlob =  resultSet.getBlob("resume");
			}
			
			int blobLength = (int) fileBlob.length();  
			byte[] blobAsBytes = fileBlob.getBytes(1, blobLength);
			fileBlob.free();

			
			 File f = new File("C:\\Work\\eclipse-workspace\\test.pdf");
			    try (FileOutputStream fos = new FileOutputStream(f)) {
			        fos.write(blobAsBytes);
			    }
			    catch(Exception ex)
			    {
			        ex.printStackTrace();
			    }
			
			System.out.println("Done writing of "+fileName + "  of type "+fileType+"    "+f.getCanonicalPath());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	
}
