package com.eriksena.usuario.business;

import com.eriksena.usuario.business.converter.UsuarioConverter;
import com.eriksena.usuario.business.dtos.UsuarioDTO;
import com.eriksena.usuario.infrastructure.entity.Usuario;
import com.eriksena.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }
}
