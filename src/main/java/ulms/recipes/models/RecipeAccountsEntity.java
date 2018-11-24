package ulms.recipes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ulms.login.models.AccountEntity;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "recipeaccounts")
@IdClass(RecipeAccountsIdentity.class)
public class RecipeAccountsEntity {
	@Id
	@NotNull
	@Column(name="recipe_id", nullable=false)
	private Long recipeId;
	
	@Id
	@NotNull
	@Column(name="account_id", nullable=false)
	private Long accountId;
	
	@ManyToOne
	@JoinColumn(name="recipe_id", insertable=false, updatable=false, referencedColumnName="id")
	private RecipeEntity recipe;
	
	@ManyToOne
	@JoinColumn(name="account_id", insertable=false, updatable=false, referencedColumnName="id")
	@JsonIgnore
	private AccountEntity account;
	
	public Long getRecipeId() {
		return this.recipeId;
	}
	
	public void setRecipeId(Long recipeId) {
		this.recipeId  = recipeId;
	}
	
	public Long getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
}
