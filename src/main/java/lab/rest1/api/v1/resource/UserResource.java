package lab.rest1.api.v1.resource;

import io.swagger.annotations.*;
import lab.rest1.api.v1.model.UserDTO;
import lab.rest1.domain.User;
import lab.rest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ===============
 * API de usuários
 * ===============
 * @author bruno.carneiro
 */
@Api(value = "/api/v1/users", description = "API de usuários")
@RestController
@RequestMapping(UserResource.API_V1_USERS)
public class UserResource {

    public static final String API_V1_USERS = "/api/v1/users";

    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    /**
     * ========================
     * /api/v1/users/{id} (GET)
     * ========================
     */
    @ApiOperation(value = "Busca usuário pelo ID",
            notes = "Informe o ID do usuário para efetuar a busca",
            response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Usuário não encontrado."),
            @ApiResponse(code = 500, message = "Erro ao executar o serviço."),
            @ApiResponse(code = 200, message = "Serviço executado com sucesso.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(
            @ApiParam(value = "ID do usuário a ser consultado", required = true)
            @PathVariable("id") Long id) {

        User user = userService.findById(id);
        return new ResponseEntity<UserDTO>(user.convert(), HttpStatus.OK);
    }

    /**
     * ====================
     * /api/v1/users/ (GET)
     * ====================
     */
    @ApiOperation(value = "Lista usuários cadastrados",
            response = UserDTO.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Nenhum usuário encontrado."),
            @ApiResponse(code = 500, message = "Erro ao executar o serviço."),
            @ApiResponse(code = 200, message = "Serviço executado com sucesso.")
    })
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> usersDTO = new ArrayList<>();
        userService.list().forEach(user -> {
            usersDTO.add(user.convert());
        });
        return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
    }

    /**
     * =====================
     * /api/v1/users/ (POST)
     * =====================
     */
    @ApiOperation(value = "Cadastra usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro ao cadastrar usuário."),
            @ApiResponse(code = 200, message = "Serviço executado com sucesso.")
    })
    @PostMapping("/")
    public ResponseEntity<UserDTO> save(
            @ApiParam(value = "Usuário a ser cadastrado", required = true)
            @RequestBody UserDTO userDTO) {

        userService.save(userDTO.convert());
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }

    /**
     * ====================
     * /api/v1/users/ (PUT)
     * ====================
     */
    @ApiOperation(value = "Altera usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro ao executar o serviço."),
            @ApiResponse(code = 200, message = "Serviço executado com sucesso.")
    })
    @PutMapping("/")
    public ResponseEntity<UserDTO> update(
            @ApiParam(value = "Usuário a ser alterado", required = true)
            @RequestBody UserDTO userDTO) {

        userService.save(userDTO.convert());
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }

    /**
     * =======================
     * /api/v1/users/ (DELETE)
     * =======================
     */
    @ApiOperation(value = "Remove usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro ao executar o serviço."),
            @ApiResponse(code = 200, message = "Serviço executado com sucesso.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(
            @ApiParam(value = "ID do usuário a ser removido", required = true)
            @PathVariable("id") Long id) {

        User user = userService.findById(id);
        UserDTO userReturn = user.convert();
        userService.delete(user);
        return new ResponseEntity<UserDTO>(userReturn, HttpStatus.OK);
    }
}
