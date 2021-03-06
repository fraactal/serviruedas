
package Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Fractal
 */
public class Main {
    
    public static void main (String [] args){
        Conexion cn=new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            String sql="select * from clientes";
            //String sql="select * from clientes";

            // 
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                System.out.print(rs.getString("rut") + "|" + rs.getString("nombre") + "|" + 
                        rs.getString("direccion") + "|" + rs.getString("telefono")+ "|" + rs.getString("correo") + "\n");
                //per.setId(rs.getInt("Id"));
                //per.setDni(rs.getString("DNI"));              
            }
        }
        catch(Exception e){        
            System.out.println("");            
        }
    }
    
    public static String ConsultaProductos(){
        String consulta = "Select p.idproducto, p.nombre, p.descripcion, p.valorneto, p.stock, c.nombre as Categoria from producto p \n" +
                            " inner join categoriaproducto c on p.idcategoria = c.idcategoria"; 
        return consulta;
    } 
    
}