package idat.edu.pe.mvc.modelo.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class JDBCUtilTest {
    
    JDBCUtil jdbc;
    
    public JDBCUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jdbc = new JDBCUtil();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConnecionNoNula() {
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(jdbc.getConeccion());
    }
    
    
    
}
