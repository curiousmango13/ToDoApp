package ToDo_Maven.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Record {
	
	@Id
	static int id;
	static String task;
	
	public static int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	

	
}
