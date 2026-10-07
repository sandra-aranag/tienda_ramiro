package dao;

import conexion.ConexionBD;
import modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de Cliente.
 *
 * Contiene el SQL y transforma filas de la tabla cliente
 * en objetos Cliente, y viceversa.
 */
public class ClienteDAO {

    public List<Cliente> listar() throws SQLException{
        List<Cliente> resultado = new ArrayList<>();

        String sql = """ 
                SELECT id, nombre, email
                FROM cliente 
                ORDER BY id 
                """;

        try(Connection con = ConexionBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){

            while(rs.next()){
                resultado.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getBoolean("activo")
                ));
            }



        }

        return resultado;

    }






}
