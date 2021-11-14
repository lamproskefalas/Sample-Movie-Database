package com.lkefalas.samplemoviedatabase.bootstrap;

import com.lkefalas.samplemoviedatabase.base.AbstractLogComponent;
import com.lkefalas.samplemoviedatabase.domain.*;
import com.lkefalas.samplemoviedatabase.exception.NotFoundException;
import com.lkefalas.samplemoviedatabase.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Profile("generate-content")
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
    private final ActorService actorService;
    private final RoleService roleService;
    private final GenreService genreService;
    private final ShowService showService;
    private final DirectorService directorService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Bootstrapping application");
        logger.info("Generating actors");
        generateActors();
        logger.info("Generating genres");
        generateGenres();
        logger.info("Generating directors");
        generateDirectors();
        logger.info("Generating shows");
        generateShows();
        logger.info("Generating roles");
        generateRoles();
        logger.info("Bootstrapping finished");

        logger.info(showService.findAll().toString());
    }

    private void generateDirectors() {
        directorService.create(Director.builder().firstName("Christopher").lastName("Nolan").build());
        directorService.create(Director.builder().firstName("Mary").lastName("Harron").build());
        directorService.create(Director.builder().firstName("Patty").lastName("Jenkins").build());
        directorService.create(Director.builder().firstName("Rawson").lastName("Thurber").build());
    }

    private void generateShows() throws NotFoundException {
        Genre action = genreService.findByName("Action");
        Genre adventure = genreService.findByName("Adventure");
        Genre comedy = genreService.findByName("Comedy");
        Genre crime = genreService.findByName("Crime");
        Genre drama = genreService.findByName("Drama");
        Genre fantasy = genreService.findByName("Fantasy");

        showService.create(Show.builder()
                .title("Batman Begins")
                .rating(BigDecimal.valueOf(8.2))
                .genres(Set.of(action,adventure))
                .director(directorService.findByFirstNameAndLastName("Christopher","Nolan"))
                .releaseYear(2005)
                .showType(ShowType.MOVIE)
                .build());

        showService.create(Show.builder()
                .title("American Psycho")
                .rating(BigDecimal.valueOf(7.6))
                .genres(Set.of(comedy,crime,drama))
                .director(directorService.findByFirstNameAndLastName("Mary","Harron"))
                .releaseYear(2000)
                .showType(ShowType.MOVIE)
                .build());

        showService.create(Show.builder()
                .title("Red Notice")
                .rating(BigDecimal.valueOf(6.8))
                .genres(Set.of(action,comedy,crime))
                .director(directorService.findByFirstNameAndLastName("Patty","Jenkins"))
                .releaseYear(2021)
                .showType(ShowType.MOVIE)
                .build());

        showService.create(Show.builder()
                .title("Wonder Woman 1984")
                .rating(BigDecimal.valueOf(5.4))
                .director(directorService.findByFirstNameAndLastName("Rawson","Thurber"))
                .genres(Set.of(action,adventure,fantasy))
                .releaseYear(2020)
                .showType(ShowType.MOVIE)
                .build());
    }

    private void generateGenres() {
        genreService.create(Genre.builder().name("Action").build());
        genreService.create(Genre.builder().name("Adventure").build());
        genreService.create(Genre.builder().name("Comedy").build());
        genreService.create(Genre.builder().name("Crime").build());
        genreService.create(Genre.builder().name("Drama").build());
        genreService.create(Genre.builder().name("Fantasy").build());
    }
    

    private void generateRoles() throws NotFoundException {
        Actor bale = actorService.findByFirstNameAndLastName("Christian","Bale");
        Actor gadot = actorService.findByFirstNameAndLastName("Gal","Gadot");

        Show batman = showService.findByTitle("Batman Begins");
        Show amPsycho = showService.findByTitle("American Psycho");
        Show ww = showService.findByTitle("Wonder Woman 1984");
        Show rn = showService.findByTitle("Red Notice");

        roleService.create(Role.builder().actor(bale).characterName("Batman").show(batman).build());
        roleService.create(Role.builder().actor(bale).characterName("Patrick Bateman").show(amPsycho).build());

        roleService.create(Role.builder().actor(gadot).characterName("Wonder Woman").show(ww).build());
        roleService.create(Role.builder().actor(gadot).characterName("The Bishop").show(rn).build());
    }

    private void generateActors() {
        actorService.create(Actor.builder().firstName("Christian").lastName("Bale").build());
        actorService.create(Actor.builder().firstName("Gal").lastName("Gadot").build());
    }
}
