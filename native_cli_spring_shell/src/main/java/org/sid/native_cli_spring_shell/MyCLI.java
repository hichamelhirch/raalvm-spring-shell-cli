package org.sid.native_cli_spring_shell;

import lombok.RequiredArgsConstructor;
import org.sid.native_cli_spring_shell.entities.Book;
import org.sid.native_cli_spring_shell.repository.BookRepository;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Optional;
import java.util.Random;

@ShellComponent
@RequiredArgsConstructor
public class MyCLI {
    private final BookRepository bookRepository;

    @ShellMethod(key = "hello")
    public String test(){
        return "Hello World" ;
    }
    @ShellMethod(key = "password")
    public String PasswordAleatoire(@ShellOption(defaultValue = "hicham") String name) {
        String mot = "AZERTYUIOPQSDFGHJKLMWXCVBN";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(mot.length());
            stringBuilder.append(mot.charAt(index));
        }

        return stringBuilder.toString()+"\t" + name;
    }
   @ShellMethod(key = "addBook")
    public String addBook(@ShellOption(defaultValue = "Java ") String name,@ShellOption(defaultValue = "20") double price ){
      Book book= bookRepository.save(Book.builder()
                        .name(name)
                        .price(price)
                .build());
        return book.toString();
    }

    @ShellMethod(key = "findBook")
    public String findBbook(Long id){
        Optional<Book> optionalBook=bookRepository.findById(id);
        if (optionalBook.isPresent()) return optionalBook.get().toString();
        else return "Book not found" + id;
    }
}
