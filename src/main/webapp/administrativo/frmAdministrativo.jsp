<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="AdministrativoControlador" method="post">
    <div class="p-3 border-radius-xl bg-white js-active"   >
        <h5 class="font-weight-bolder mb-0">Administrativo</h5>
        <p class="mb-0 text-sm">Informaciones obligatorias</p>
        <div class="multisteps-form__content">
            <div class="row mt-3"> 
                <input type="hidden" name="action" value="${action}"/>
                <input name="administrativo_nro" type="hidden" value="${administrativo.administrativo_nro}"  />
                <div class="col-12 col-sm-6">
                    <label>Administrativo</label>  
                    <select class="form-control" name="persona_nro">
                        <option hidden>Seleccione</option>
                        <c:forEach var="item" items="${persona}">
                            <option <c:if test="${administrativo.persona_nro == item.persona_nro}">selected</c:if> value="${item.persona_nro}">${item.ci} ${item.nombre} ${item.paterno} ${item.materno}</option>
                        </c:forEach> 

                    </select>
                </div>
                <div class="col-12 col-sm-6">
                    <label>Cargo</label>
                    <input class="form-control" name="cargo" type="text" value="${administrativo.cargo}" placeholder="" />
                </div>
            </div>
            <div class="button-row d-flex mt-4">
                <a href="AdministrativoControlador" class="btn bg-gradient-danger mb-0 js-btn-next"><i class="fa-solid fa-xmark"></i> Cancelar</a>
                <button class="btn bg-gradient-dark ms-auto mb-0 js-btn-next" type="submit" title="Next"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
            </div>
        </div>
    </div>
</form>