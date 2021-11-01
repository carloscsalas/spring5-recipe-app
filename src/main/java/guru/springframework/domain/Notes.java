package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*we don't need to specify a cascade because this instance we are
    * going to allow the Recipe to own this. We don't want if we delete the Notes object,
    * we don't want to go back and delete the Recipe object*/
    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

}
