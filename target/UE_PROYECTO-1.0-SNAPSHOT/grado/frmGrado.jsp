<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="GradoControlador" method="post">
    <div class="p-3 border-radius-xl bg-white js-active"   >
        <h5 class="font-weight-bolder mb-0">Grados</h5>
        <p class="mb-0 text-sm">Informaciones obligatorias</p>
        <div class="multisteps-form__content">
            <div class="row mt-3"> 
                <input type="hidden" name="action" value="${action}"/>
                <input name="grado_nro" type="hidden" value="${grado.grado_nro}"  />
                    <div class="col-12 col-sm-6">
                    <label>Grado</label>
                    <input class="form-control" name="descripcion" type="text" value="${grado.descripcion}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Nivel</label>
                    <input class="form-control" name="nivel" type="text" value="${grado.nivel}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Persona</label>  
                    <select class="form-control" name="paralelo_nro">
                        <option hidden>Seleccione</option>
                        <c:forEach var="item" items="${paralelo}">
                            <option <c:if test="${grado.paralelo_nro == item.paralelo_nro}">selected</c:if> value="${item.paralelo_nro}">${item.paralelo}</option>
                        </c:forEach> 

                    </select>
                </div>

            </div>
            <div class="button-row d-flex mt-4">
                <a href="GradoControlador" class="btn bg-gradient-danger mb-0 js-btn-next"><i class="fa-solid fa-xmark"></i> Cancelar</a>

                <button class="btn bg-gradient-dark ms-auto mb-0 js-btn-next" type="submit" title="Next"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
            </div>
        </div>
    </div>
</form>