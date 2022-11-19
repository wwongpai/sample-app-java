package example.samplemongoapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NoteController {

  @Autowired
  private NoteRepository repository;
  
  // Home page
  @GetMapping("/")
  String home() {
    String welcome = "welcome to the main page";
    return welcome;
  }

  // Gets a single note
  @GetMapping("/notes/{id}")
  Note getNote(@PathVariable String id) {
    Note rn = repository.findById(id).orElse(null);
    return rn;
  }

  // Creates a note
  @PostMapping("/notes")
  Note newNote(@RequestBody String description) {
    return repository.save(new Note(description));
  }

  // Creates a note
  @PutMapping("/notes/{id}")
  Note updateNote(@RequestBody String description, @PathVariable String id) {
    Note updateNote = repository.findById(id).orElse(null);
    updateNote.setDescription(description); 
    return repository.save(updateNote);
  }  

  // Gets all notes
  @GetMapping("/notes")
  List<Note> allNotes() {
    return repository.findAll();
  }

  // Deletes a note
  @DeleteMapping("/notes/{id}")
  String deleteNote(@PathVariable String id) {
    repository.deleteById(id);
    return "deleted";
  }  

}