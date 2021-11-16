package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    /*EAGER, because I'm going to explicitly do that. So we do want that loaded or
    to get it every time from the database. That is the default behavior*/
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    /*now we need to set up the inverse side of the relationship, so we don't want to do
    * any type of cascade here because obviosly if we delete an ingrediente, we don't
    * want that to cascade up and delete the recipe*/
    @ManyToOne
    /*a property for the Recipe that he belongs to*/
    private Recipe recipe;

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", recipe=" + recipe +
                '}';
    }
}
