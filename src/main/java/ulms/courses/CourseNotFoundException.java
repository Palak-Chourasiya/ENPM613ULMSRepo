package ulms.courses;

import ulms.entity.exceptions.EntityNotFoundException;

	/**
	 * Exception thrown when requesting a non existent (or no-longer existent) course.
	 */
	@SuppressWarnings("serial")
	public class CourseNotFoundException extends EntityNotFoundException {

	    public CourseNotFoundException(long id) {
	        super("Could not find course with id " + id);

	    }
	}

	    

