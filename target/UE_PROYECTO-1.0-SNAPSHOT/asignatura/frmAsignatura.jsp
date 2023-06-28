<form action="AsignaturaControlador" method="post">
    <div class="p-3 border-radius-xl bg-white js-active"   >
        <h5 class="font-weight-bolder mb-0">Asignaturas</h5>
        <p class="mb-0 text-sm">Informaciones obligatorias</p>
        <div class="multisteps-form__content">
            <div class="row mt-3"> 
                <input type="hidden" name="action" value="${action}"/>
                <input name="asignatura_nro" type="hidden" value="${asignatura.asignatura_nro}"  />
                <div class="col-12 col-sm-6">
                    <label>Titulo</label>
                    <input class="form-control" name="descripcion" type="text" value="${asignatura.descripcion}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Sigla</label>
                    <input class="form-control" name="sigla" type="text" value="${asignatura.sigla}" placeholder="" />
                </div>
            </div>
            <div class="button-row d-flex mt-4">
                <button class="btn bg-gradient-dark ms-auto mb-0 js-btn-next" type="submit" title="Next"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
            </div>
        </div>
    </div>
</form>