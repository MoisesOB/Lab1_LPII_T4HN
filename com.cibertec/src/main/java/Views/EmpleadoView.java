package Views;

import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {
		//CREAR EMPLEADO
		//String empleado = new EmpleadoController().createEmpleado("Sánchez","Ana",26,"Femenino",4200);
		
		//ELIMINAR EMPLEADO
		//String empleado = new EmpleadoController().deleteEmpleado(1);
		
		//LEER EMPLEADO
		//String empleado = new EmpleadoController().deleteEmpleado(1);
		
		//ACTUALIZAR USUARIO
		String empleado = new EmpleadoController().updateEmpleado(2,"Moreno",1000);
		
		System.out.println(empleado);
	}

}
