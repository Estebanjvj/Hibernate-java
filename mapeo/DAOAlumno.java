

import java.util.List;
import java.util.Iterator; 
 

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.HibernateException; 
import java.util.Random;
import Modelos.*;


public class DAOAlumno {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	   public static void main(String[] args) {
			System.err.println("Iniciando" );
	      try{
	    	  	Configuration configuration = new Configuration();
				System.err.println("Leyendo configuracion." );
	    	    configuration.configure("hibernate.cfg.xml");
	    	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    	    factory = configuration.buildSessionFactory(serviceRegistry);
	      }catch (Throwable ex) { 
	         System.err.println("No se puede crear la Sesion" + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      DAOAlumno dao = new DAOAlumno();

	      /* Add few worker records in database */
	      /*
	      Integer dao1 = dao.addAlumno("Luis", "M", 18);
	      Integer dao2 = dao.addAlumno("Raul", "M", 20);
	      Integer dao3 = dao.addAlumno("Laura", "F", 19);
		  Integer dao4 = dao.addAlumno("Mary", "F", 20);
		  */
	      /* Lista los alumnos */
	      //dao.listAlumnos();

	      /* Actualiza */
	      //dao.updateAlumno(dao1, 5000);

	      /* Borra */
	      //dao.deleteAlumno(dao2);

	      /* Lista alumnos */
	      //dao.listAlumnos();

	      dao.queryUno(12);
		  dao.queryDos();
	   }
	   /* Crea nuevos alumnos */
	   public Integer addAlumno(String nombre, String sexo, int edad){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer daoID = null;
	      Random rnd = new Random();
	      int rd;
	      rd =  (int)(rnd.nextDouble() * 299 + 1); 
	      try{
	         tx = session.beginTransaction();
	         Alumno dao = new Alumno(rd, nombre, sexo, edad);
	         daoID = (Integer) session.save(dao); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return daoID;
	   }
	   /* Obtiene todos los alumnos */
	   public void listAlumnos( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List employees = session.createQuery("FROM Alumno").list(); 
	         for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	        	 Alumno dao = (Alumno) iterator.next(); 
	            System.out.print("Nombre:" + dao.getNombre()); 
	            System.out.print("  Sexo: " + dao.getSexo()); 
	            System.out.println("  Edad: " + dao.getEdad()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Actualiza la edad*/
	   public void updateAlumno(Integer AlumnoID, int edad ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Alumno dao = 
	                    (Alumno)session.get(Alumno.class, AlumnoID); 
	         dao.setEdad( edad );
			 session.update(dao); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Borra alumno */
	   public void deleteAlumno(Integer AlumnoID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Alumno dao = 
	                   (Alumno)session.get(Alumno.class, AlumnoID); 
	         session.delete(dao); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

	   /**
		* 	SELECT
		*		*
		*	FROM
		*		alumno
		*	INNER JOIN ciudad ON ciudad.idciudad = alumno.idciudad
		*	WHERE
		*		ciudad.idciudad = 12
	    */
	   public void queryUno(Integer CiudadID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
				 Ciudad dao = 
	                  (Ciudad)session.get(Ciudad.class, CiudadID); 
	            System.out.print("idCiudad:" + dao.getIdCiudad()); 
	            System.out.println("  Nombre: " + dao.getNombre());
	            List alumnos = dao.getAlumnos();
				System.out.println(alumnos.toString());
				System.out.println("Alumnos: "+alumnos.size()+"\n+-------------------------------------------------------------------+");
	            for (Iterator iterator = 
	                           alumnos.iterator(); iterator.hasNext();){
	        	 Alumno alumno = (Alumno) iterator.next(); 
				 System.out.print("IdAlumno: "+alumno.getIdAlumno());
				 System.out.print(" Nombre: "+alumno.getNombre());
				 System.out.print(" Edad: "+alumno.getEdad());
				 System.out.println(" Sexo: "+alumno.getSexo());
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

	   /** 
		* SELECT
		*		*
		*	FROM
		*		alumno
		*	INNER JOIN ciudad ON ciudad.idciudad = alumno.idciudad
		*	AND alumno.edad < 20
	   	*/
	   public void queryDos(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List employees = session.createQuery("FROM Alumno WHERE edad<20").list(); 
	         for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	        	Alumno dao = (Alumno) iterator.next(); 
				//if(dao.getEdad()<20){
					System.out.print("Nombre:" + dao.getNombre()); 
					System.out.print("  Sexo: " + dao.getSexo()); 
					System.out.print("  Edad: " + dao.getEdad());

					System.out.print(" idCiudad"+ dao.getCiudad().getIdCiudad());
					System.out.println(" Ciudad"+ dao.getCiudad().getNombre());
				//}
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
}
