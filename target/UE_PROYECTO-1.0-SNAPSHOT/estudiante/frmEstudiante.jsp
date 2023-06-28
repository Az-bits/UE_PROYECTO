<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="EstudianteControlador" method="post">
    <div class="p-3 border-radius-xl bg-white js-active"   >
        <h5 class="font-weight-bolder mb-0">Estudiante</h5>
        <p class="mb-0 text-sm">Informaciones obligatorias</p>
        <div class="multisteps-form__content">
            <div class="row mt-3"> 
                <input type="hidden" name="action" value="${action}"/>
                <input name="estudiante_nro" type="hidden" value="${estudiante.estudiante_nro}"  />
                <div class="col-12 col-sm-6">
                    <label>RUDE</label>
                    <input class="form-control" name="rude" type="text" value="${estudiante.rude}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Estudiante</label>  
                    <select class="form-control" name="persona_nro">
                        <option hidden>Seleccione</option>
                        <c:forEach var="item" items="${persona}">
                            <option <c:if test="${estudiante.persona_nro == item.persona_nro}">selected</c:if> value="${item.persona_nro}">${item.ci} ${item.nombre} ${item.paterno} ${item.materno}</option>
                        </c:forEach> 
                    </select>
                </div>
                <div class="col-12 col-sm-6">
                    <label>Tutor</label>  
                    <select class="form-control" name="tutor_nro">
                        <option hidden>Seleccione</option>
                        <c:forEach var="item" items="${tutor}">
                            <option <c:if test="${estudiante.tutor_nro == item.tutor_nro}">selected</c:if> value="${item.tutor_nro}">${item.tutor}</option>
                        </c:forEach> 
                    </select>
                </div>
            </div>
            <div class="d-flex mt-4">
                <a href="EstudianteControlador" class="btn bg-gradient-danger mb-0 js-btn-next"><i class="fa-solid fa-xmark"></i> Cancelar</a>
                <button class="btn bg-gradient-dark ms-auto mb-0 js-btn-next" type="submit" title="Next"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
            </div>

        </div>
    </div>
</form>