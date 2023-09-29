package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {
	
	//Crear Empleado
	public String createEmpleado(String apellidos,String nombres, int edad,String sexo, int salario){
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			Empleado empleado = new Empleado(apellidos,nombres,edad,sexo,salario);
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado creado";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Error al registrar un Empleado";
}
	
	//Eliminar usuario
		public String deleteEmpleado(int idempleado) {
				
				SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
				
				Session session = sessionFactory.openSession();
			
				try {
					
					session.beginTransaction();
					Empleado empleado =session.get(Empleado.class,idempleado);
					session.delete(empleado);
					session.getTransaction().commit();
					
					sessionFactory.close();
					
					return "Empleado eliminado correctamente";
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return "Error al eliminar Empleado";
			}
	
		//Actualizar usuario
		public String updateEmpleado(int idusuario,String apellidos, int salario) {

			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				session.beginTransaction();
				
				Empleado empleado = session.get(Empleado.class, idusuario);
				empleado.setApellidos(apellidos);
				empleado.setSalario(salario);
				session.update(empleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return "Empleado actualizado correctamente";
				
			}catch(Exception e){
				
				e.printStackTrace();
				
			}
			return "Error al actualizar registro";
		
		}
	
		//Leer usuario
		public String getEmpleado(int idempleado) {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				session.beginTransaction();
				
				Empleado empleado = session.get(Empleado.class, idempleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return empleado.toString();
				
			}catch (Exception e) {
				
			}
			return "Empleado no existe";
		}
		
		
		
		
		
		
}
