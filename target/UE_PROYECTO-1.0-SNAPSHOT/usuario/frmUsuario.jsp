<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="UsuarioControlador" method="post">
    <div class="p-3 border-radius-xl bg-white js-active"   >
        <h5 class="font-weight-bolder mb-0">Usuarios</h5>
        <p class="mb-0 text-sm">Informaciones obligatorias</p>
        <div class="multisteps-form__content">
            <div class="row mt-3"> 
                <input type="hidden" name="action" value="${action}"/>
                <input name="usuario_nro" type="hidden" value="${usuario.usuario_nro}"  />
                <div class="col-12 col-sm-6">
                    <label>Persona</label>  
                    <select class="form-control" name="persona_nro">
                        <option hidden>Seleccione</option>
                        <c:forEach var="item" items="${persona}">
                            <option <c:if test="${usuario.persona_nro == item.persona_nro}">selected</c:if> value="${item.persona_nro}">${item.ci} ${item.nombre} ${item.paterno} ${item.materno}</option>
                        </c:forEach> 

                    </select>
                </div>
                <div class="col-12 col-sm-6">
                    <label>Usuario</label>
                    <input class="form-control" name="usuario" type="text" value="${usuario.usuario}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Contraseña</label>
                    <input class="form-control" name="contrasenia" type="password" value="${usuario.contraseña}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6 mt-3 mt-sm-0">
                    <label>Tipo Usuario</label>
                    <select class="form-control" name="tipo_usuario">
                        <option hidden>Seleccione</option>
                        <option <c:if test="${usuario.tipo_usuario == 'ADMINISTRADOR'}">selected</c:if> value="ADMINISTRADOR">ADMINISTRADOR</option>
                        <option <c:if test="${usuario.tipo_usuario == 'USUARIO'}">selected</c:if> value="USUARIO">USUARIO</option>
                        </select>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12 col-sm-6">
                        <label>Correo Electronico</label>
                        <input class="form-control" name="correo_electronico"  type="text" placeholder="" value="${usuario.correo_electronico}" />
                </div>
            </div>
            <div class="button-row d-flex mt-4">
                            <a href="UsuarioControlador" class="btn bg-gradient-danger mb-0 js-btn-next"><i class="fa-solid fa-xmark"></i> Cancelar</a>

                <button class="btn bg-gradient-dark ms-auto mb-0 js-btn-next" type="submit" title="Next"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
            </div>
        </div>
    </div>
</form>