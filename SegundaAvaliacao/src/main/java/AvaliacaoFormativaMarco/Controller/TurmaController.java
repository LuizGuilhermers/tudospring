package AvaliacaoFormativaMarco.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AvaliacaoFormativaMarco.Service.TurmaService;
import AvaliacaoFormativaMarco.entities.Turma;



@RestController
@RequestMapping("/turma")
@CrossOrigin(origins = "*")
public class TurmaController {
	
private final TurmaService turmaService;
	
	@Autowired
	public TurmaController (TurmaService turmaService) {
		this.turmaService = turmaService;
	}
	
    @GetMapping("/{id}")
    public ResponseEntity <Turma> buscaturmaIdControlId(@PathVariable Long id){
        Turma turma = turmaService.getturmaById(id);
        if(turma!= null) {
            return ResponseEntity.ok(turma);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Turma>> buscaTodosturmaControl() {
        List<Turma> turma = turmaService.getAllturma();
 
        return ResponseEntity.ok(turma);
    }
      
    //Query Method
    @GetMapping ("/nome/{nome}")
    public ResponseEntity<List<Turma>> buscarturmasPornome (@PathVariable String nome){
    	List<Turma> turmas= turmaService.buscarTurmaPorNome (nome);
    	return ResponseEntity.ok(turmas);
    }
    
    //Query Method
    @GetMapping ("/descricao/{descricao}")
    public ResponseEntity<List<Turma>> buscarturmasPordescricao (@PathVariable String descricao){
    	List<Turma> turmas= turmaService.buscarTurmaPorDescricao (descricao);
    	return ResponseEntity.ok(turmas);
    }
      
    @PostMapping("/")
    public ResponseEntity<Turma> criarturma(@RequestBody Turma turma) {
    	Turma criarturma = turmaService.saveturma(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarturma);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateturma(@PathVariable Long id, @RequestBody Turma turma) {
    	Turma updatedturma = turmaService.updateturma(id, turma);
        if (updatedturma != null) {
            return ResponseEntity.ok(updatedturma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteturma(@PathVariable Long id) {
        boolean deleted = turmaService.deleteturma(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("A turma foi excluída com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


