package web.eventos361.repository.queries.evento;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import web.eventos361.filter.EventoFilter;
import web.eventos361.model.Evento;

public interface EventoQueries {

    Page<Evento> pesquisar(EventoFilter filtro, Pageable pageable);
    
    List<Evento> findAllWithParticipantes();

}
