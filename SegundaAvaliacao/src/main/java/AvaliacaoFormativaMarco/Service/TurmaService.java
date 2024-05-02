package AvaliacaoFormativaMarco.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import AvaliacaoFormativaMarco.entities.Turma;
import AvaliacaoFormativaMarco.repository.TurmaRepository;

@Service
public class TurmaService {
	
private final TurmaRepository turmaRepository;
	
	@Autowired
	public TurmaService (TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	public Turma saveturma (Turma turma) {
		return turmaRepository.save(turma);
	}

	public Turma getturmaById (Long id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		return turma.orElse(null);
	}

	public List<Turma> getAllturma(){
		return turmaRepository.findAll();
	}
	//Query Method
	public List<Turma> buscarTurmaPorNome (String nome){
		return turmaRepository.findByNome (nome);
	}
	
	//Query Method
	public List<Turma> buscarTurmaPorDescricao (String descricao){
		return turmaRepository.findByDescricao (descricao);
	}
	
	//Query Method
	public List<Turma> buscarTurmaPorNomeAndDescricao (String nome, String descricao){
		return turmaRepository.findByNomeAndDescricao (nome, descricao);
	}
	
	
	public Turma updateturma(Long id, Turma updatedturma) {
		Optional<Turma> existingturma = turmaRepository.findById(id);

		if (existingturma.isPresent()) {
			updatedturma.setId(id);
			return turmaRepository.save(updatedturma);
		}
		return null;
	}

		public boolean deleteturma(Long id) {
			Optional <Turma> existingturma = turmaRepository.findById(id);
			if (existingturma.isPresent()) {
				turmaRepository.deleteById(id);
				return true;
			}
			return false;

		}
}