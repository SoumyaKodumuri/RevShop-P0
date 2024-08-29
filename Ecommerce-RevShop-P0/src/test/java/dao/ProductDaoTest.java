package dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import DAO.ProductDAOClass;
import dto.productResponse;
import utils.ConnectionFactory;

class ProductDaoTest {
	@Mock
	private ConnectionFactory connectionFactory;
	
	@Mock
	private Connection connection;
	
	@Mock
	private PreparedStatement preparedStatement;
	
	@Mock
	private ResultSet resultSet;
	
	@InjectMocks
	private ProductDAOClass productDao;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		when(connectionFactory.getConnection()).thenReturn(Mockito.mock(connection));
		
	}
	
	@Test
	public void testGetProductById_Success() throws SQLException {
		int productId= 1;
		
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	    when(preparedStatement.executeQuery()).thenReturn(resultSet);
	    
	    when(resultSet.next()).thenReturn(true);
	    when(resultSet.getInt("productId")).thenReturn(productId);
	    when(resultSet.getString("productName")).thenReturn("Boat Smart Watch");
	    when(resultSet.getInt("categoryId")).thenReturn(28);
	    when(resultSet.getFloat("price")).thenReturn(999.90f);
	    when(resultSet.getString("productDescription")).thenReturn("Black-BoatWatch water Resistance");
	    when(resultSet.getInt("sellerId")).thenReturn(2);
	    when(resultSet.getInt("productQuantity")).thenReturn(2);
	    when(resultSet.getString("user_Review")).thenReturn("Good");
	    
	    productResponse result= productDao.getProductById(productId);
	    
	    assertTrue(result !=null);
	    assertEquals("Boat Smart Watch", result.getProductName());
	    assertEquals(28, result.getCategoryId());
	    assertEquals(999.90f, result.getPrice());
	    assertEquals("Black-BoatWatch water Resistance", result.getProductDescription());
	    assertEquals(2, result.getSellerId());
	    assertEquals(2, result.getProductQuantity());
	    assertEquals("Good", result.getUserReview());   
	
	}
}
