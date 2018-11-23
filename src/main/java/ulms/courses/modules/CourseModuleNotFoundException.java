package ulms.courses.modules;

import ulms.entity.exceptions.EntityNotFoundException;

	/**
	 * Exception thrown when requesting a non existent (or no-longer existent) course.
	 */
	@SuppressWarnings("serial")
	public class CourseModuleNotFoundException extends EntityNotFoundException {

	    public CourseModuleNotFoundException(long id) {
	        super("Could not find course with id " + id);

	    }
	}

	    

