package br.com.vereda.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.vereda.dto.PedidoRequestDTO;
import br.com.vereda.dto.PedidoResponseDTO;
import br.com.vereda.services.PedidoService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Endpoints REST dos pedidos.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController{

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * {@code POST /pedidos} — cria um novo Pedido.
     *
     * @param dados os dados do Pedido a ser criado
     * @return 201 Created com o Pedido criado
     */
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criar(
            @RequestBody @Valid PedidoRequestDTO dados) {

        PedidoResponseDTO pedido = pedidoService.criarPedido(dados);
        return ResponseEntity.status(201).body(pedido);
    }

}
