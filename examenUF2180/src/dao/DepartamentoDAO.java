package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Centro;
import modelo.Departamento;

public class DepartamentoDAO {
	
	private ConexionBD conexion;
	
	public DepartamentoDAO() {
		this.conexion = new ConexionBD();
	}
	public  ArrayList<Departamento> obtenerDepartamentos() {
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Departamento> lista = new ArrayList<Departamento>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from departamentos");
			
			while (resultado.next()) {
				int cod_departamento = resultado.getInt("cod_departamento");
				int cod_centro = resultado.getInt("cod_centro");
				String tipo_dir = resultado.getString("tipo_dir");
				int presupuesto = resultado.getInt("presupuesto");
				String nombre = resultado.getString("nombre");
				
				Departamento departamento = new Departamento(cod_departamento, cod_centro, tipo_dir, presupuesto, nombre);
				lista.add(departamento);
			
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error al realizar la consulta sobre Departamentos "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error al liberar recursos "+e.getMessage());
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return lista;

	}
	
	public Departamento obtenerDepartamento(int cod_departamento) {
		
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Departamento d=null;
		
		try {
			consulta = con.prepareStatement("select * from departamentos"
					+ " where cod_departamento = ?");
			consulta.setInt(1, cod_departamento);
			resultado=consulta.executeQuery();
			
			if (resultado.next()) {
				int cod_centro = resultado.getInt("cod_centro");
				String tipo_dir = resultado.getString("tipo_dir");
				int presupuesto = resultado.getInt("presupuesto");
				String nombre = resultado.getString("nombre");
				
				d = new Departamento(cod_departamento, cod_centro, tipo_dir, presupuesto, nombre);
			}
					
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error al realizar la consulta sobre centros: " +e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al liberar recursos " +e.getMessage());
			} 
		}
		return d;
	}
	
    public int insertarDepartamento(Departamento departamento) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO Departamentos (cod_departamento ,cod_centro,tipo_dir ,presupuesto , nombre)"
					+ " VALUES (?,?,?,?,?) ");
			
			
			consulta.setInt(1, departamento.getCod_departamento() );
			consulta.setInt(2, departamento.getCod_centro() );
			consulta.setString(3, departamento.getTipo_dir());
			consulta.setInt(4, departamento.getPresupuesto() );
			consulta.setString(5, departamento.getNombre());


			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserci�n del departamento: " +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
	
	
	
}
