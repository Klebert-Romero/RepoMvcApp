package idat.edu.pe.mvc.modelo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUtil {
    private final String usuarioBD = "root";
    private final String passwordBD = "12345678";
    private final String urlConeccion = "jdbc:mysql://localhost:3306/carteleradb?zeroDateTimeBehavior=convertToNull";
    private final String driverClass = "com.mysql.jdbc.Driver";
    private Connection coneccion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    public JDBCUtil(){
        try{
            Class.forName(driverClass);
            coneccion = DriverManager.getConnection(urlConeccion, usuarioBD, passwordBD);
            if(coneccion != null)
                System.out.println("Conección Exitosa");
        }catch(ClassNotFoundException|SQLException ex){
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConeccion() {
        return coneccion;
    }
    
    public PreparedStatement obtenerPreparedStatement(String sql){
        try{
            sentencia = coneccion.prepareStatement(sql);
        }catch(SQLException ex){
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sentencia;
    }
    
    public ResultSet ejecutarConsulta(PreparedStatement statementSQL){
        sentencia = statementSQL;
        try {
            resultados = sentencia.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultados;
    }
    
    public void ejecutarActualizacion(PreparedStatement statementSQL){
        sentencia = statementSQL;
        try {
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cerrarObjetos(){
        try {
            if (resultados != null) resultados.close();
            if(sentencia != null) sentencia.close();
            if(coneccion != null) coneccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
