package conexionTest;

import static org.junit.Assert.fail;

import java.io.FileReader;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import Negocio.SuperAndes;



public class ConexionTest {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecuci�n
	 */
	private static Logger log = Logger.getLogger(ConexionTest.class.getName());
	
	/**
	 * Ruta al archivo de configuraci�n de los nombres de tablas de la base de datos: La unidad de persistencia existe y el esquema de la BD tambi�n
	 */
	private static final String CONFIG_TABLAS_A = "./Resource/config/TablasBD_A.json"; 
	private static final String CONFIG_TABLAS_ERR_DS = "./src/main/resources/config/TablasBD_ErrorDataStore.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
	/**
	 * La clase que se quiere probar
	 */
    private SuperAndes superAndes;
	
	
	   @Test
	    public void normalAccessTest ()
	  	{
	  	  	try
			{
				log.info ("Probando el acceso a la base de datos con datos v�lidos (BD, credenciales, esquema");
				superAndes = new SuperAndes (openConfig (CONFIG_TABLAS_A));
				log.info ("Conexi�n realizada correstamente");
				log.info ("Cerrando la conexi�n");
				
				superAndes.cerrarUnidadPersistencia ();
				log.info ("Conexi�n cerrada");
			}
			catch (Exception e)
			{
//				e.printStackTrace();
				log.info ("Prueba de acceso normal FALL� !!. La excepci�n generada es: " + e.getClass ().getName ());
				log.info ("La causa es: " + e.getCause ().toString ());

				String msg = "Prueba de acceso normal a la base de datos fall� !! Revise persistence.xml.\n";
				msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepci�n";
//				System.out.println (msg);
				fail (msg);
			}
	  	}
	   
	    @Test
	    public void baseDatosInaccesible ()
	    {
			try
			{
		    	log.info ("Probando el acceso a la base de datos con una base de datos que no existe");
		    	superAndes = new SuperAndes (openConfig (CONFIG_TABLAS_ERR_DS));
				fail ("Debería fallar. La base de datos no existe !!");
			}
			catch (Exception e)
			{
//				e.printStackTrace();
				log.info ("Prueba realizada exitosamente. La excepción generada es: " + e.getClass ().getName ());
				log.info ("La causa es: " + e.getCause ().toString ());

				String msg = "Prueba de base de datos inaccesible correcta.\n";
				msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
				System.out.println (msg);
			}
	    }
	   
	   /* ****************************************************************
		 * 			M�todos de configuraci�n
		 *****************************************************************/
	    /**
	     * Lee datos de configuraci�n para la aplicaci�n, a partir de un archivo JSON o con valores por defecto si hay errores.
	     * @param tipo - El tipo de configuraci�n deseada
	     * @param archConfig - Archivo Json que contiene la configuraci�n
	     * @return Un objeto JSON con la configuraci�n del tipo especificado
	     * 			NULL si hay un error en el archivo.
	     */
	    private JsonObject openConfig (String archConfig)
	    {
	    	JsonObject config = null;
			try 
			{
				Gson gson = new Gson( );
				FileReader file = new FileReader (archConfig);
				JsonReader reader = new JsonReader ( file );
				config = gson.fromJson(reader, JsonObject.class);
				log.info ("Se encontr� un archivo de configuraci�n de tablas v�lido");
			} 
			catch (Exception e)
			{
//				e.printStackTrace ();
				log.info ("NO se encontr� un archivo de configuraci�n v�lido");			
				JOptionPane.showMessageDialog(null, "No se encontr� un archivo de configuraci�n de tablas v�lido: ", "TipoBebidaTest", JOptionPane.ERROR_MESSAGE);
			}	
	        return config;
	    }	
	
	  	 
}
