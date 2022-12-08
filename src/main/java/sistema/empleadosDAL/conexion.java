/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Claudia
 */
public class conexion {
    
    String strConexionBD="jdbc:sqlite:C:/Users/Claudia/Documents/Septimo Semestre/P_Cliente_Servidor/Java/sistema/sistema.s3db";
    Connection conn = null;
    
    public conexion (){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionBD);
            
            System.out.print("Conexion establecida");
        } catch (Exception e) {
            
            System.out.print("Error de conexion" + e);
        }
    }
    
    public int EjecutarSentenciaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (Exception e) {
            
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet ConsultarRegistros(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            
            System.out.println(e);
            return null;
        }
    }
}
 