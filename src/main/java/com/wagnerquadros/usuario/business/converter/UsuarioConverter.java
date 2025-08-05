package com.wagnerquadros.usuario.business.converter;

import com.wagnerquadros.usuario.business.dto.EnderecoDTO;
import com.wagnerquadros.usuario.business.dto.TelefoneDTO;
import com.wagnerquadros.usuario.business.dto.UsuarioDTO;
import com.wagnerquadros.usuario.infrastructure.entity.Endereco;
import com.wagnerquadros.usuario.infrastructure.entity.Telefone;
import com.wagnerquadros.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuario){
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> endereco) {
        return endereco.stream().map(this::paraEnderecoDTO).toList();
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco){
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .cep(endereco.getCep())
                .estado(endereco.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefone){
        return telefone.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone){
        return TelefoneDTO.builder()
                .id(telefone.getId())
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDTO, Usuario entity){
        return Usuario.builder()
                .id(entity.getId())
                .nome(usuarioDTO.getNome() != null? usuarioDTO.getNome() : entity.getNome())
                .senha(usuarioDTO.getSenha() != null? usuarioDTO.getSenha() : entity.getSenha())
                .email(usuarioDTO.getEmail() != null? usuarioDTO.getEmail() : entity.getEmail())
                .enderecos(entity.getEnderecos())
                .telefones(entity.getTelefones())
                .build();
    }

    public Endereco updateEndereco(EnderecoDTO enderecoDTO, Endereco entity){
        return Endereco.builder()
                .id(entity.getId())
                .rua(enderecoDTO.getRua() != null? enderecoDTO.getRua() : entity.getRua())
                .cidade(enderecoDTO.getCidade() != null? enderecoDTO.getCidade() : entity.getCidade())
                .complemento(enderecoDTO.getComplemento() != null? enderecoDTO.getComplemento() : entity.getComplemento())
                .numero(enderecoDTO.getNumero() != null? enderecoDTO.getNumero() : entity.getNumero())
                .estado(enderecoDTO.getEstado() != null? enderecoDTO.getEstado() : entity.getEstado())
                .cep(enderecoDTO.getCep() != null? enderecoDTO.getCep() : entity.getCep())
                .build();
    }

    public Telefone updateTelefone(TelefoneDTO telefoneDTO, Telefone entity){
        return Telefone.builder()
                .id(entity.getId())
                .ddd(telefoneDTO.getDdd() != null? telefoneDTO.getDdd() : entity.getDdd())
                .numero(telefoneDTO.getNumero() != null? telefoneDTO.getNumero() : entity.getNumero())
                .build();
    }

    public Endereco paraEnderecoEntity(EnderecoDTO enderecoDTO, Long usuarioId){
        return Endereco.builder()
                .usuario_id(usuarioId)
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public Telefone paraTelefoneEntity(TelefoneDTO telefoneDTO, Long usuarioId) {
        return Telefone.builder()
                .usuario_id(usuarioId)
                .ddd(telefoneDTO.getDdd())
                .numero(telefoneDTO.getNumero())
                .build();
    }
}
