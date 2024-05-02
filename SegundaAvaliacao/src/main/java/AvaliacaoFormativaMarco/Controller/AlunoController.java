package AvaliacaoFormativaMarco.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AvaliacaoFormativaMarco.Service.AlunoService;
import AvaliacaoFormativaMarco.entities.Aluno;



	@RestController
	@RequestMapping("/aluno")
	public class AlunoController {
		
	private final AlunoService alunoService;
		
		@Autowired
		public AlunoController (AlunoService alunoService) {
			this.alunoService = alunoService;
		}
		
	    @GetMapping("/{id}")
	    public ResponseEntity <Aluno> buscaalunoIdControlId(@PathVariable Long id){
	        Aluno aluno = alunoService.getalunoById(id);
	        if(aluno!= null) {
	            return ResponseEntity.ok(aluno);
	        }
	        else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @GetMapping("/")
	    public ResponseEntity<List<Aluno>> buscaTodosalunoControl() {
	        List<Aluno> aluno = alunoService.getAllaluno();
	 
	        return ResponseEntity.ok(aluno);
	    }
	    
	    //Query Method
	    @GetMapping ("/cidade/{cidade}")
	    public ResponseEntity<List<Aluno>> buscarAlunosPorCidade (@PathVariable String cidade){
	    	List<Aluno> alunos= alunoService.buscarAlunosPorCidade (cidade);
	    	return ResponseEntity.ok(alunos);
	    }
	    
	    //Query Method
	    @GetMapping ("/renda/{renda}")
	    public ResponseEntity<List<Aluno>> buscarAlunosPorRenda (@PathVariable double renda){
	    	List<Aluno> alunos= alunoService.buscarAlunosPorRenda (renda);
	    	return ResponseEntity.ok(alunos);
	    }
	    
	    //Query Method
	    @GetMapping ("/ra/{ra}")
	    public ResponseEntity<List<Aluno>> buscarAlunosPorRa (@PathVariable String ra){
	    	List<Aluno> alunos= alunoService.buscarAlunosPorRa (ra);
	    	return ResponseEntity.ok(alunos);
	    }
	      
	    //Query Method
	    @GetMapping ("/CidRen/{CidRen}")
	    public ResponseEntity<List<Aluno>> buscaralunosPorCidadeAndRenda (@PathVariable String cidade, double renda){
	    	List<Aluno> alunos= alunoService.buscaralunoPorCidadeAndRenda (cidade, renda);
	    	return ResponseEntity.ok(alunos);
	    }
		//Qhery simples
	    @GetMapping("/nome/(nome)")
		public List<Aluno> findAlunosByNome(@PathVariable String nome){
			return alunoService.findByNome(nome);
		}
	    
		//Qhery simples
	    @GetMapping("/nome-completo/(nome-completo)")
		public List<Aluno> findAlunosByNomeCompletoLike (@PathVariable String nomeCompleto){
			return alunoService.findByNomeCompletoLike (nomeCompleto);
		}
	    
	    //@Qhery
	    @GetMapping("/turma/{turmaId}")
	    public List<Aluno>findAlunoById(@PathVariable Long turmaId){
	    	return alunoService.findByTurmaId(turmaId);
	    }
	    
	    
	    @PostMapping("/")
	    public ResponseEntity<Aluno> criaraluno(@RequestBody Aluno aluno) {
	    	Aluno criaraluno = alunoService.savealuno(aluno);
	        return ResponseEntity.status(HttpStatus.CREATED).body(criaraluno);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Aluno> updatealuno(@PathVariable Long id, @RequestBody Aluno aluno) {
	    	Aluno updatedaluno = alunoService.updatealuno(id, aluno);
	        if (updatedaluno != null) {
	            return ResponseEntity.ok(updatedaluno);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deletealuno(@PathVariable Long id) {
	        boolean deleted = alunoService.deletealuno(id);
	        if (deleted) {
	        	 return ResponseEntity.ok().body("A aluno foi excluída com sucesso.");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	}


