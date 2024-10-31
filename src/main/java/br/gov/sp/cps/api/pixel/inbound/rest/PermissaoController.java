package br.gov.sp.cps.api.pixel.inbound.rest;

import br.gov.sp.cps.api.pixel.core.domain.dto.command.IndicadorCommand;
import br.gov.sp.cps.api.pixel.core.domain.entity.Indicador;
import br.gov.sp.cps.api.pixel.core.domain.entity.Permissao;
import br.gov.sp.cps.api.pixel.core.usecase.PermissaoUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {

    private final PermissaoUC permissaoUC;


    public PermissaoController(PermissaoUC permissaoUC) {
        this.permissaoUC = permissaoUC;
    }

    @GetMapping
    public List<Permissao> listar() {
        return permissaoUC.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permissao> buscarPorId(@PathVariable int id) {
        Optional<Permissao> permissao = permissaoUC.buscarPorId(id);
        return permissao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
