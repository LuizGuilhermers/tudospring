package AvaliacaoFormativaMarco.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AvaliacaoFormativaMarco.entities.Aluno;
import AvaliacaoFormativaMarco.repository.AlunoRepository;

@Service
public class AlunoService {
	
private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService (AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public Aluno savealuno (Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno getalunoById (Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElse(null);
	}

	public List<Aluno> getAllaluno(){
		return alunoRepository.findAll();
	}
	//Query Method
	public List<Aluno> buscarAlunosPorCidade (String cidade){
		return alunoRepository.findByCidade (cidade);
	}
	
	//Query Method
	public List<Aluno> buscarAlunosPorRenda (double renda){
		return alunoRepository.findByRenda (renda);
	}
	//Query Method
	public List<Aluno> buscarAlunosPorRa (String ra){
		return alunoRepository.findByRa (ra);
	}
	
	//Query Method
	public List<Aluno> buscaralunoPorCidadeAndRenda (String cidade, double renda){
		return alunoRepository.findByCidadeAndRenda (cidade, renda);
	}
	
	//@hery simples
	public List<Aluno> findByNome(String nome){
		return alunoRepository.findByNome(nome);
	}
	
	//@hery simples
	public List<Aluno> findByNomeCompletoLike(String nomeCompleto){
		return alunoRepository.findByNomeLike (nomeCompleto);
	}
	//@Qhery
	public List<Aluno> findByTurmaId(Long turmaId){
		return alunoRepository.findByTurmaId(turmaId);
	}
	
	public Aluno updatealuno(Long id, Aluno updatedaluno) {
		Optional<Aluno> existingaluno = alunoRepository.findById(id);

		if (existingaluno.isPresent()) {
			updatedaluno.setId(id);
			return alunoRepository.save(updatedaluno);
		}
		return null;
	}

		public boolean deletealuno(Long id) {
			Optional <Aluno> existingaluno = alunoRepository.findById(id);
			if (existingaluno.isPresent()) {
				alunoRepository.deleteById(id);
				return true;
			}
			return false;

		}

	


}