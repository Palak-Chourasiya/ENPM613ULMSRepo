package ulms.recipes.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "recipesteps")
@IdClass(RecipeStepsIdentity.class)
public class RecipeStepsEntity {
	@Id
	@NotNull
	@Column(name="id", nullable=false)
	private Long id;

	@Id
	@NotNull
	@Column(name="recipe_id", nullable=false)
    private Long recipeId;
	
	@NotNull
	@Column(name="step_details", nullable=false)
	private String stepDetails;
	
	/*
	@Lob
	@Column(name="image", nullable=true)
	private byte[] image;
	*/
	
	@ManyToOne
	@JoinColumn(name="recipe_id", insertable=false, updatable=false, referencedColumnName="id")
	private RecipeEntity recipe;
}
