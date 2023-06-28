<form action="TurnoControlador" method="post">
    <div class="p-3 border-radius-xl bg-white js-active"   >
        <h5 class="font-weight-bolder mb-0">Turnos</h5>
        <p class="mb-0 text-sm">Informaciones obligatorias</p>
        <div class="multisteps-form__content">
            <div class="row mt-3"> 
                <input type="hidden" name="action" value="${action}"/>
                <input name="turno_nro" type="hidden" value="${turno.turno_nro}"  />
                <div class="col-12 col-sm-6">
                    <label>Turno</label>
                    <input class="form-control" name="turno" type="text" value="${turno.turno}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Entrada</label>
                    <input class="form-control" name="entrada" type="time" value="${turno.entrada}" placeholder="" />
                </div>
                <div class="col-12 col-sm-6">
                    <label>Salida</label>
                    <input class="form-control" name="salida" type="time" value="${turno.salida}" placeholder="" />
                </div>
            </div>
            <div class="button-row d-flex mt-4">
                <button class="btn bg-gradient-dark ms-auto mb-0 js-btn-next" type="submit" title="Next"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
            </div>
        </div>
    </div>
</form>