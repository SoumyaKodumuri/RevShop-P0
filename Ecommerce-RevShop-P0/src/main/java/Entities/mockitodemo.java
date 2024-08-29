package Entities;
/*

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertNotNull;
	import static org.junit.jupiter.api.Assertions.assertTrue;
	import static org.junit.jupiter.api.Assertions.fail;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import java.lang.reflect.Field;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.MockitoAnnotations;
	import org.mockito.junit.MockitoJUnitRunner;

	import dao.ProductDAOClass;
	import dao.exception.ProductException;
	import dto.ProductResponse;

	public class mockitodemo {
	    
	    @Mock
	    private ProductDAOClass productDao;
	    
	    @InjectMocks
	    private ProductService productService;
	    
	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    
	    @Test
	    void testMockInjection() {
	        assertNotNull(productService);
	        assertNotNull(productDao);
	        // Use reflection to check if productDao is injected into productService
	        // This assumes productDao is a field in ProductService
	        try {
	            Field productDaoField = ProductService.class.getDeclaredField("productDao");
	            productDaoField.setAccessible(true);
	            Object injectedProductDao = productDaoField.get(productService);
	            assertNotNull(injectedProductDao);
	            assertTrue(Mockito.mockingDetails(injectedProductDao).isMock());
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            fail("Failed to verify mock injection: " + e.getMessage());
	        }
	    }
	    
	    @Test
	    void testGetProductById() throws ProductException {
	        
	        //arrange
	        ProductResponse mockResponse = new ProductResponse(1L, "Test Product", "TP", 100);
	        when(productDao.getProductById(mockResponse.getId())).thenReturn(mockResponse);
	        
	        //act
	        ProductResponse response = productService.getProductById(mockResponse.getId());
	        
	        //assert
	        
	        assertEquals(mockResponse,response);
	        verify(productDao, times(1)).getProductById(1L);
	        
	    }
	    
	    

	}
}
*/